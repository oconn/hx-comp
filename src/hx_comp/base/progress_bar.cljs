(ns hx-comp.base.progress-bar
  (:require
   [hx.react :as hx :refer [defnc]]
   [hx-comp.core :refer [gs styles->classes add-class]]))

(def classes
  (styles->classes
   {:outer-container
    {:width "100%"
     :height (gs [:spacing :p8])
     :border-radius (gs [:radius :r20])
     :overflow :hidden
     :background-color (gs [:colors :gray-scale-50])}

    :inner-container
    {:background-color (gs [:colors :primary-500])
     :height "100%"
     :tranistion "width 0.2s ease-in"}}))

(defnc ProgressBar
  [{:keys [percent-filled]
    :or {percent-filled 0}}]
  [:div (add-class {} :outer-container classes)
   [:div (add-class {:style {:width (str percent-filled "%")}}
                    :inner-container classes)]])
