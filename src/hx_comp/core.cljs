(ns hx-comp.core
  (:require
   [goog.color :as color]
   [goog.object :as gobj]
   [jss]
   [jss-preset-default]

   [hx-comp.styles.borders :as borders]
   [hx-comp.styles.media-queries :as media-queries]
   [hx-comp.styles.radius :as radius]
   [hx-comp.styles.resets :as resets]
   [hx-comp.styles.shadows :as shadows]
   [hx-comp.styles.spacing :as spacing]
   [hx-comp.styles.typography :as typography]))

;; TODO Allow for an arbitrary list of colors to be added at build time
(goog-define primary-color "#76ae47")
(goog-define secondary-color "#5d82d2")

(goog-define primary-font "'Open Sans', sans-serif")
(goog-define secondary-font "'Roboto Mono', monospace")

(js-invoke jss "setup" (jss-preset-default))

(def ^{:private true} global-styles (atom {}))

(defn- adjust-color
  [adjustment-fn color-value factor]
  (-> color-value
      (color/hexToRgb)
      (adjustment-fn factor)
      (color/rgbArrayToHex)))

(def ^{:private true} lighten (partial adjust-color color/lighten))
(def ^{:private true} darken (partial adjust-color color/darken))

(defn styles->classes
  [styles]
  (-> jss
      (js-invoke "createStyleSheet" (clj->js styles))
      (js-invoke "attach")
      (gobj/get "classes")
      (js->clj :keywordize-keys true)))

(defn create-color-scale
  [{:keys [color-name color-value]}]
  (if (color/isValidColor color-value)
    (letfn [(scale->name [scale]
              (keyword (str color-name "-" scale)))]
      {(scale->name "50") (lighten color-value 0.5)
       (scale->name "100") (lighten color-value 0.4)
       (scale->name "200") (lighten color-value 0.3)
       (scale->name "300") (lighten color-value 0.2)
       (scale->name "400") (lighten color-value 0.1)
       (scale->name "500") color-value
       (scale->name "600") (darken color-value 0.1)
       (scale->name "700") (darken color-value 0.2)
       (scale->name "800") (darken color-value 0.3)
       (scale->name "900") (darken color-value 0.4)
       (scale->name "1000") (darken color-value 0.5)})
    (do
      (js/console.error (str "Color not valid: '" color-value "'"))
      {})))

(def colors (merge
             {:true-white "#FFFFFF"
              :true-black "#FFFFFF"}
             (create-color-scale {:color-name "primary"
                                  :color-value primary-color})
             (create-color-scale {:color-name "secondary"
                                  :color-value secondary-color})
             (create-color-scale {:color-name "gray-scale"
                                  :color-value "#717171"})))

(reset! global-styles {:borders (borders/borders colors)
                       :colors colors
                       :font-family (typography/font-families
                                     {:primary-font primary-font
                                      :secondary-font secondary-font})
                       :font-height typography/line-height
                       :font-size typography/size
                       :font-weight typography/weight
                       :queries media-queries/queries
                       :radius radius/radius
                       :shadows shadows/shadows
                       :spacing spacing/spacing})

(styles->classes
 {"@global" resets/resets})

(defn gs
  "Pulls a styles from global-styles. If no style exists in the style
  map, and error will bre returned."
  [lens]
  (let [style (get-in @global-styles
                      lens
                      (js/Error. #js {:message "Style not found"
                                      :data lens}))]
    (if (= (type style) js/Error)
      (js/console.error style lens)
      style)))

(defn create-font-styles
  [{:keys [style color family]}]
  {:-webkit-text-size-adjust :none
   :font-size (gs [:font-size style])
   :font-weight (gs [:font-weight style])
   :line-height (gs [:font-height style])
   :color (gs [:colors color])
   :font-family (gs [:font-family family])

   (gs [:queries :tablet])
   {:font-size
    (gs [:font-size (-> style name (keyword "tablet"))])}

   (gs [:queries :phone])
   {:font-size
    (gs [:font-size (-> style name (keyword "mobile"))])}})

(defn- update-class-value
  [class-name c]
  (cond
    (nil? c)
    [class-name]

    (vector? c)
    (conj c class-name)

    (string? c)
    (str c " " class-name)

    :else
    (js/console.error
     (str "Invalid class definition: '" class-name "'"))))

(defn add-class
  "Adds a class to an elements options hash"
  [options class-key class-map]
  (let [class-name (gobj/get (clj->js class-map) (name class-key))]
    (when-not (some? class-name)
      (js/console.error (str "Class not found: '" class-key "'")))
    (update options :class (partial update-class-value class-name))))
