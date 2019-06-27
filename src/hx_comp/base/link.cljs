(ns hx-comp.base.link
  (:require
   [hx.react :as hx :refer [defnc]]

   [hx-comp.core :refer [gs styles->classes add-class create-font-styles]])
  (:require-macros
   [devcards.core :refer [defcard]]))

(def base-link-styles
  {:white-space :nowrap
   :text-decoration :none
   :cursor :pointer
   :outline :none
   :position :relative
   :transition "color 0.2s ease"

   "&:disabled"
   {:color (gs [:colors :gray-scale-300])
    :cursor :default}})

(def button-reset-styles
  {:background :none
   :border :none})

(def classes
  (styles->classes
   {:primary-link
    (merge
     base-link-styles
     (create-font-styles {:style :caption-30
                          :color :primary-500
                          :family :primary})
     {"&:hover"
      {:color (gs [:colors :primary-700])}})

    :secondary-link
    (merge
     base-link-styles
     (create-font-styles {:style :caption-30
                          :color :primary-500
                          :family :secondary})
     {"&:hover"
      {:color (gs [:colors :primary-700])}})

    :primary-button-link
    (merge
     base-link-styles
     button-reset-styles
     (create-font-styles {:style :body-20
                          :color :primary-500
                          :family :primary}))

    :secondary-button-link
    (merge
     base-link-styles
     button-reset-styles
     (create-font-styles {:style :body-20
                          :color :primary-500
                          :family :secondary}))}))

(defnc PrimaryLink [options]
  [:a (add-class options :primary-link classes)])
(defnc SecondaryLink [options]
  [:a (add-class options :secondary-link classes)])

(defnc PrimaryButtonLink [options]
  [:button (add-class options :primary-button-link classes)])
(defnc SecondaryButtonLink [options]
  [:button (add-class options :secondary-button-link classes)])

(defcard PrimaryLink
  (hx/f [PrimaryLink {:href "/"} "Link"]))
(defcard SecondaryLink
  (hx/f [SecondaryLink {:href "/"} "Link"]))
(defcard PrimaryButtonLink
  (hx/f [PrimaryButtonLink {:on-click #()} "Button Link"]))
(defcard SecondaryButtonLink
  (hx/f [SecondaryButtonLink {:on-click #()} "Button Link"]))
