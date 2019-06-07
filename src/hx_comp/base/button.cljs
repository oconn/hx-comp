(ns hx-comp.base.button
  (:require
   [devcards.core :as dc :include-macros true]

   [hx.react :as hx :refer [defnc]]
   [hx-comp.core :refer [gs
                         styles->classes
                         add-class
                         create-font-styles]]))

(def base-button-styles
  (merge
   (create-font-styles {:style :caption-30
                        :color :primary-500
                        :family :primary})
   {:padding [(gs [:spacing :p8])
              (gs [:spacing :p20])]
    :white-space :nowrap
    :text-decoration :none
    :cursor :pointer
    :outline :none
    :position :relative
    :transition (str "background-color 0.2s ease, "
                     "color 0.2s ease, "
                     "border-color 0.2s ease")
    :border (gs [:borders :border-primary-500-2])

    "&:disabled"
    {:background-color (gs [:colors :gray-scale-50])
     :color (gs [:colors :gray-scale-300])
     :border (gs [:borders :border-100-2])
     :cursor :default}}))

(def primary-button-styles
  (merge
   base-button-styles
   {:background-color (gs [:colors :primary-500])
    :color (gs [:colors :true-white])

    "&:hover"
    {:background-color (gs [:colors :primary-600])
     :border-color (gs [:colors :primary-600])}}))

(def primary-link-button-styles
  (merge
   primary-button-styles
   ;; TODO Devcards overrides this value
   {:color (str (gs [:colors :true-white]) " !important")
    :padding [(gs [:spacing :p12])
              (gs [:spacing :p20])]}))

(def secondary-button-styles
  (merge
   base-button-styles
   {:background-color (gs [:colors :true-white])

    "&:hover"
    {:background-color (gs [:colors :primary-500])
     :color (gs [:colors :true-white])}}))

(def secondary-link-button-styles
  (merge
   secondary-button-styles
   {:padding [(gs [:spacing :p12])
              (gs [:spacing :p20])]}))

(def classes
  (styles->classes
   {:primary-button primary-button-styles
    :primary-button-alt (assoc primary-button-styles
                               :font-family (gs [:font-family :secondary]))
    :primary-link-button primary-link-button-styles
    :primary-link-button-alt (assoc primary-link-button-styles
                                    :font-family (gs [:font-family :secondary]))
    :secondary-button secondary-button-styles
    :secondary-button-alt (assoc secondary-button-styles
                                 :font-family (gs [:font-family :secondary]))
    :secondary-link-button secondary-link-button-styles
    :secondary-link-button-alt (assoc secondary-link-button-styles
                                      :font-family
                                      (gs [:font-family :secondary]))}))

(defnc PrimaryButton [options]
  [:button (add-class options :primary-button classes)])
(defnc PrimaryButtonAlt [options]
  [:button (add-class options :primary-button-alt classes)])
(defnc SecondaryButton [options]
  [:button (add-class options :secondary-button classes)])
(defnc SecondaryButtonAlt [options]
  [:button (add-class options :secondary-button-alt classes)])

(defnc PrimaryLinkButton [options]
  [:a (add-class options :primary-button classes)])
(defnc PrimaryLinkButtonAlt [options]
  [:a (add-class options :primary-button classes)])
(defnc SecondaryLinkButton [options]
  [:a (add-class options :secondary-link-button classes)])
(defnc SecondaryLinkButtonAlt [options]
  [:a (add-class options :secondary-link-button-alt classes)])

(dc/defcard PrimaryButton
  (hx/f [PrimaryButton {} "Button"]))
(dc/defcard PrimaryButtonAlt
  (hx/f [PrimaryButtonAlt {} "Button"]))
(dc/defcard SecondaryButton
  (hx/f [SecondaryButton {} "Button"]))
(dc/defcard SecondaryButtonAlt
  (hx/f [SecondaryButtonAlt {} "Button"]))
