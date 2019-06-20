(ns hx-comp.base.container
  (:require
   [hx.react :as hx :refer [defnc]]
   [hx-comp.core :refer [gs styles->classes add-class]])
  (:require-macros
   [devcards.core :refer [defcard]]))

(def classes
  (styles->classes
   {:container
    {:padding (gs [:spacing :p20])
     :max-width "1600px"
     :margin :auto
     :height "100%"}}))

(defnc Container
  [{:keys [children] :as options}]
  [:div (add-class {} :container classes)
   children])

(defcard Container
  (hx/f [Container {}
         [:div
          [:h1 "Title"]
          [:p "Body"]]]))
