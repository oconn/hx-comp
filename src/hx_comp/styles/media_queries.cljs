(ns hx-comp.styles.media-queries
  (:refer-clojure :exclude [print]))

(def desktop "@media (min-width: 801px)")
(def tablet "@media (min-width: 461px) and (max-width: 800px)")
(def tablet-below "@media (max-width: 800px)")
(def phone "@media (max-width: 460px)")
(def print "@media print")
(def hover "@media (hover: hover)")
(def ie (str "@media all and (-ms-high-contrast: none), "
             "(-ms-high-contrast: active)"))
(def touch-screen "@media (pointer: coarse) and (hover: none)")


(def queries
  {:desktop desktop
   :tablet tablet
   :tablet-below tablet-below
   :phone phone
   :print print
   :hover hover
   :ie ie
   :touch-screen touch-screen})
