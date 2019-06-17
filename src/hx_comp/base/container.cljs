(ns hx-comp.base.container
  (:require
   [hx.react :as hx :refer [defnc]]
   [hx-comp.core :refer [gs styles->classes add-class]])
  (:require-macros
   [devcards.core :as dc]))

(def classes
  (styles->classes
   {:container
    {:padding (gs [:spacing :p20])
     :max-width "1600px"
     :margin :auto}}))

(defnc Container
  [{:keys [children] :as options}]
  [:div (add-class {} :container classes)
   children])

(dc/defcard Container
  (hx/f [Container {}
         [:div
          [:h1 "Title"]
          [:p "Body"]]]))
