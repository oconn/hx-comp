(ns hx-comp.base.card
  (:require
   [hx.react :refer [defnc]]

   [hx-comp.core :refer [styles->classes gs add-class]]
   [hx-comp.base.text :as text]))

(def classes
  (styles->classes
   {:simple-card-container
    {:width "100%"
     :box-shadow (gs [:shadows :shadow-20])
     :border-radius (gs [:radius :r4])
     :overflow :hidden
     :margin-bottom (gs [:spacing :p20])}

    :simple-card-title
    {:margin [(gs [:spacing :p16])
              (gs [:spacing :p0])]}

    :simple-card-header-container
    {:display :flex
     :justify-content :space-between
     :align-items :center
     :width "100"
     :border-bottom (gs [:borders :border-50-1])
     :padding [(gs [:spacing :p0])
               (gs [:spacing :p20])]}

    :simple-card-body-container
    {:width "100%"
     :padding (gs [:spacing :p20])}}))

(defnc SimpleCard
  [{:keys [title
           title-color
           title-family
           title-background
           body-padding
           sub-title
           sub-title-color
           sub-title-family
           children]}]
  [:div (add-class {} :simple-card-container classes)
   [:div (cond-> (add-class {} :simple-card-header-container classes)
           (some? title-background)
           (assoc-in [:style :background-color]
                     (gs [:colors title-background])))
    [text/Title40 (cond-> (add-class {} :simple-card-title classes)
                    (some? title-color)
                    (assoc-in [:style :color]
                              (gs [:colors title-color]))

                    (some? title-family)
                    (assoc-in [:style :font-family]
                              (gs [:font-family title-family])))
     title]

    (when (some? sub-title)
      [text/Caption30 (cond-> {}
                        (some? sub-title-color)
                        (assoc-in [:style :color]
                                  (gs [:colors sub-title-color]))

                        (some? sub-title-family)
                        (assoc-in [:style :font-family]
                                  (gs [:font-family sub-title-family])))
       sub-title])]

   [:div (cond-> (add-class {} :simple-card-body-container classes)
           (some? body-padding)
           (assoc-in [:style :padding] body-padding))
    children]])
