(ns hx-comp.styles.borders)

(defn borders
  [colors]
  {:border-50-1 (str "1px solid " (:gray-scale-50 colors))
   :border-50-2 (str "2px solid " (:gray-scale-50 colors))
   :border-100-1 (str "1px solid " (:gray-scale-100 colors))
   :border-100-2 (str "2px solid " (:gray-scale-100 colors))
   :border-200-1 (str "1px solid " (:gray-scale-200 colors))
   :border-200-2 (str "2px solid " (:gray-scale-200 colors))

   :border-black-1 (str "1px solid " (:true-black colors))
   :border-black-2 (str "2px solid " (:true-black colors))

   :border-primary-100-1 (str "1px solid " (:primary-100 colors))
   :border-primary-200-1 (str "1px solid " (:primary-200 colors))
   :border-primary-300-1 (str "1px solid " (:primary-300 colors))
   :border-primary-400-1 (str "1px solid " (:primary-400 colors))
   :border-primary-500-1 (str "1px solid " (:primary-500 colors))
   :border-primary-600-1 (str "1px solid " (:primary-600 colors))
   :border-primary-700-1 (str "1px solid " (:primary-700 colors))

   :border-primary-100-2 (str "2px solid " (:primary-100 colors))
   :border-primary-200-2 (str "2px solid " (:primary-200 colors))
   :border-primary-300-2 (str "2px solid " (:primary-300 colors))
   :border-primary-400-2 (str "2px solid " (:primary-400 colors))
   :border-primary-500-2 (str "2px solid " (:primary-500 colors))
   :border-primary-600-2 (str "2px solid " (:primary-600 colors))
   :border-primary-700-2 (str "2px solid " (:primary-700 colors))})
