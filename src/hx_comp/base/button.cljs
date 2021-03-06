(ns hx-comp.base.button
  (:require
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
   (gs [:shadows :outline])
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
    {:background-color (gs [:colors :gray-scale-25])
     :color (gs [:colors :gray-scale-300])
     :border (gs [:borders :border-50-2])
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
   {:color (gs [:colors :true-white])
    :padding [(gs [:spacing :p12])
              (gs [:spacing :p20])]}))

(def secondary-button-styles
  (merge
   base-button-styles
   {:background-color (gs [:colors :true-white])

    "&:hover"
    {:background-color (gs [:colors :primary-600])
     :border-color (gs [:colors :primary-600])
     :color (gs [:colors :true-white])}}))

(def secondary-link-button-styles
  (merge
   secondary-button-styles
   {:padding [(gs [:spacing :p12])
              (gs [:spacing :p20])]}))

(def primary-warning-button-styles
  (merge
   base-button-styles
   {:background-color (gs [:colors :error-500])
    :color (gs [:colors :true-white])
    :border (str "2px solid " (gs [:colors :error-500]))

    "&:hover"
    {:background-color (gs [:colors :error-600])
     :border-color (gs [:colors :error-600])}}))

(def secondary-warning-button-styles
  (merge
   base-button-styles
   {:background-color (gs [:colors :true-white])
    :border (str "2px solid " (gs [:colors :error-500]))
    :color (gs [:colors :error-500])

    "&:hover"
    {:background-color (gs [:colors :error-600])
     :border-color (gs [:colors :error-600])
     :color (gs [:colors :true-white])}}))

(def classes
  (styles->classes
   {:primary-button primary-button-styles

    :primary-button-alt
    (assoc primary-button-styles
           :font-family (gs [:font-family :secondary]))

    :primary-warning-button
    primary-warning-button-styles

    :primary-warning-button-alt
    (assoc primary-warning-button-styles
           :font-family (gs [:font-family :secondary]))

    :primary-link-button
    primary-link-button-styles

    :primary-link-button-alt
    (assoc primary-link-button-styles
           :font-family (gs [:font-family :secondary]))

    :secondary-button
    secondary-button-styles

    :secondary-button-alt
    (assoc secondary-button-styles
           :font-family (gs [:font-family :secondary]))

    :secondary-warning-button
    secondary-warning-button-styles

    :secondary-warning-button-alt
    (assoc secondary-warning-button-styles
           :font-family (gs [:font-family :secondary]))

    :secondary-link-button
    secondary-link-button-styles

    :secondary-link-button-alt
    (assoc secondary-link-button-styles
           :font-family
           (gs [:font-family :secondary]))}))

(defnc PrimaryButton [options]
  [:button (add-class options :primary-button classes)])
(defnc PrimaryButtonAlt [options]
  [:button (add-class options :primary-button-alt classes)])
(defnc PrimaryWarningButton [options]
  [:button (add-class options :primary-warning-button classes)])
(defnc PrimaryWarningButtonAlt [options]
  [:button (add-class options :primary-warning-button-alt classes)])
(defnc SecondaryButton [options]
  [:button (add-class options :secondary-button classes)])
(defnc SecondaryButtonAlt [options]
  [:button (add-class options :secondary-button-alt classes)])
(defnc SecondaryWarningButton [options]
  [:button (add-class options :secondary-warning-button classes)])
(defnc SecondaryWarningButtonAlt [options]
  [:button (add-class options :secondary-warning-button-alt classes)])

(defnc PrimaryLinkButton [options]
  [:a (add-class options :primary-button classes)])
(defnc PrimaryLinkButtonAlt [options]
  [:a (add-class options :primary-button-alt classes)])
(defnc SecondaryLinkButton [options]
  [:a (add-class options :secondary-link-button classes)])
(defnc SecondaryLinkButtonAlt [options]
  [:a (add-class options :secondary-link-button-alt classes)])
