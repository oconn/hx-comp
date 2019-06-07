(ns hx-comp.base.link
  (:require
   [devcards.core :as dc :include-macros true]

   [hx.react :as hx :refer [defnc]]
   [hx-comp.core :refer [gs
                         styles->classes
                         add-class
                         create-font-styles]]))

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

(def classes
  (styles->classes
   {:primary-link
    (merge
     base-link-styles
     (create-font-styles {:style :caption-30
                          :color :primary-500
                          :family :primary})
     {"&:hover"
      {:color (gs [:colors :primary-700])}})}))

(defnc PrimaryLink [options]
  [:a (add-class options :primary-link classes)])

(dc/defcard PrimaryLink
  (hx/f [PrimaryLink {:href "/"} "Link"]))
