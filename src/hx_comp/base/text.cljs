(ns hx-comp.base.text
  (:require
   [hx.react :as hx :refer [defnc]]
   [hx-comp.core :refer [styles->classes
                         gs
                         add-class
                         create-font-styles]]))

(def text-styles
  (reduce
   (fn [acc font]
     (merge acc {(or (:alias font)
                     (:style font))
                 (create-font-styles font)}))
   {:text-container
    {:max-width "650px"
     :margin :auto
     :padding [(gs [:spacing :p20])
               (gs [:spacing :p12])]}}
   [{:style :display-20 :color :gray-scale-800 :family :primary}
    {:style :display-10 :color :gray-scale-800 :family :primary}
    {:style :title-40   :color :gray-scale-800 :family :primary}
    {:style :title-30   :color :gray-scale-800 :family :primary}
    {:style :title-20   :color :gray-scale-800 :family :primary}
    {:style :title-10   :color :gray-scale-800 :family :primary}
    {:style :body-30    :color :gray-scale-800 :family :primary}
    {:style :body-20    :color :gray-scale-700 :family :primary}
    {:style :body-10    :color :gray-scale-600 :family :primary}
    {:style :caption-30 :color :gray-scale-600 :family :primary}
    {:style :caption-20 :color :gray-scale-600 :family :primary}
    {:style :caption-10 :color :gray-scale-600 :family :primary}

    {:alias :display-20-alt
     :style :display-20 :color :gray-scale-800 :family :secondary}
    {:alias :display-10-alt
     :style :display-10 :color :gray-scale-800 :family :secondary}
    {:alias :title-40-alt
     :style :title-40   :color :gray-scale-800 :family :secondary}
    {:alias :title-30-alt
     :style :title-30   :color :gray-scale-800 :family :secondary}
    {:alias :title-20-alt
     :style :title-20   :color :gray-scale-800 :family :secondary}
    {:alias :title-10-alt
     :style :title-10   :color :gray-scale-800 :family :secondary}
    {:alias :body-30-alt
     :style :body-30    :color :gray-scale-800 :family :secondary}
    {:alias :body-20-alt
     :style :body-20    :color :gray-scale-700 :family :secondary}
    {:alias :body-10-alt
     :style :body-10    :color :gray-scale-600 :family :secondary}
    {:alias :caption-30-alt
     :style :caption-30 :color :gray-scale-600 :family :secondary}
    {:alias :caption-20-alt
     :style :caption-20 :color :gray-scale-600 :family :secondary}
    {:alias :caption-10-alt
     :style :caption-10 :color :gray-scale-600 :family :secondary}]))

(def classes (styles->classes text-styles))

(defn- transform-options [options font-name]
  (-> options
      (add-class font-name classes)
      (dissoc :tag)))

(defnc Display20 [{:keys [tag] :as options :or {tag :h1}}]
  [tag (transform-options options :display-20)])
(defnc Display10 [{:keys [tag] :as options :or {tag :h2}}]
  [tag (transform-options options :display-10)])
(defnc Title40 [{:keys [tag] :as options :or {tag :h3}}]
  [tag (transform-options options :title-40)])
(defnc Title30 [{:keys [tag] :as options :or {tag :h4}}]
  [tag (transform-options options :title-30)])
(defnc Title20 [{:keys [tag] :as options :or {tag :h5}}]
  [tag (transform-options options :title-20)])
(defnc Title10 [{:keys [tag] :as options :or {tag :h6}}]
  [tag (transform-options options :title-10)])
(defnc Body30 [{:keys [tag] :as options :or {tag :p}}]
  [tag (transform-options options :body-30)])
(defnc Body20 [{:keys [tag] :as options :or {tag :p}}]
  [tag (transform-options options :body-20)])
(defnc Body10 [{:keys [tag] :as options :or {tag :p}}]
  [tag (transform-options options :body-10)])
(defnc Caption30 [{:keys [tag] :as options :or {tag :p}}]
  [tag (transform-options options :caption-30)])
(defnc Caption20 [{:keys [tag] :as options :or {tag :p}}]
  [tag (transform-options options :caption-20)])
(defnc Caption10 [{:keys [tag] :as options :or {tag :p}}]
  [tag (transform-options options :caption-10)])

(defnc Display20Alt [{:keys [tag] :as options :or {tag :h1}}]
  [tag (transform-options options :display-20-alt)])
(defnc Display10Alt [{:keys [tag] :as options :or {tag :h2}}]
  [tag (transform-options options :display-10-alt)])
(defnc Title40Alt [{:keys [tag] :as options :or {tag :h3}}]
  [tag (transform-options options :title-40-alt)])
(defnc Title30Alt [{:keys [tag] :as options :or {tag :h4}}]
  [tag (transform-options options :title-30-alt)])
(defnc Title20Alt [{:keys [tag] :as options :or {tag :h5}}]
  [tag (transform-options options :title-20-alt)])
(defnc Title10Alt [{:keys [tag] :as options :or {tag :h6}}]
  [tag (transform-options options :title-10-alt)])
(defnc Body30Alt [{:keys [tag] :as options :or {tag :p}}]
  [tag (transform-options options :body-30-alt)])
(defnc Body20Alt [{:keys [tag] :as options :or {tag :p}}]
  [tag (transform-options options :body-20-alt)])
(defnc Body10Alt [{:keys [tag] :as options :or {tag :p}}]
  [tag (transform-options options :body-10-alt)])
(defnc Caption30Alt [{:keys [tag] :as options :or {tag :p}}]
  [tag (transform-options options :caption-30-alt)])
(defnc Caption20Alt [{:keys [tag] :as options :or {tag :p}}]
  [tag (transform-options options :caption-20-alt)])
(defnc Caption10Alt [{:keys [tag] :as options :or {tag :p}}]
  [tag (transform-options options :caption-10-alt)])

(defnc TextContainer
  [{:keys [children]}]
  [:div (add-class {} :text-container classes)
   children])

(defonce test-sentance
  (str "Typography is the process of using type to print onto a page, "
       "or the general look of letters and words on a page."))

;; (defcard Display20 (hx/f [Display20 test-sentance]))
;; (defcard Display10 (hx/f [Display10 test-sentance]))
;; (defcard Title40 (hx/f [Title40 test-sentance]))
;; (defcard Title30 (hx/f [Title30 test-sentance]))
;; (defcard Title20 (hx/f [Title20 test-sentance]))
;; (defcard Title10 (hx/f [Title10 test-sentance]))
;; (defcard Body30 (hx/f [Body30 test-sentance]))
;; (defcard Body20 (hx/f [Body20 test-sentance]))
;; (defcard Body10 (hx/f [Body10 test-sentance]))
;; (defcard Caption30 (hx/f [Caption30 test-sentance]))
;; (defcard Caption20 (hx/f [Caption20 test-sentance]))
;; (defcard Caption10 (hx/f [Caption10 test-sentance]))

;; (defcard Display20Alt (hx/f [Display20Alt test-sentance]))
;; (defcard Display10Alt (hx/f [Display10Alt test-sentance]))
;; (defcard Title40Alt (hx/f [Title40Alt test-sentance]))
;; (defcard Title30Alt (hx/f [Title30Alt test-sentance]))
;; (defcard Title20Alt (hx/f [Title20Alt test-sentance]))
;; (defcard Title10Alt (hx/f [Title10Alt test-sentance]))
;; (defcard Body30Alt (hx/f [Body30Alt test-sentance]))
;; (defcard Body20Alt (hx/f [Body20Alt test-sentance]))
;; (defcard Body10Alt (hx/f [Body10Alt test-sentance]))
;; (defcard Caption30Alt (hx/f [Caption30Alt test-sentance]))
;; (defcard Caption20Alt (hx/f [Caption20Alt test-sentance]))
;; (defcard Caption10Alt (hx/f [Caption10Alt test-sentance]))
