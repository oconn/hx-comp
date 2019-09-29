(ns hx-comp.styles.shadows)

(defn shadows
  [colors]
  {:shadow-10 "2px 2px 9px 0px rgba(50, 50, 50, 0.25)"
   :shadow-20 "2px 2px 9px 0px rgba(50, 50, 50, 0.50)"
   :shadow-30 "2px 2px 9px 0px rgba(50, 50, 50, 0.75)"

   :tab-shadow "-1px -3px 6px -2px rgba(50, 50, 50, 0.2)"
   :inset-tab-shadow "inset 1px -1px 3px rgba(50, 50, 50, 0.50)"

   :outline {"&:focus"
             {:box-shadow (str "0 0 3pt 1pt " (:primary-300 colors))}}})
