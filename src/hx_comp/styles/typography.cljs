(ns hx-comp.styles.typography
  "Default typography settings

  https://material.io/guidelines/style/typography.html#typography-styles")

(def line-height
  {:display-20 "1.2em"
   :display-10 "1.0em"
   :title-40 "1.2em"
   :title-30 "1.2em"
   :title-20 "1.2em"
   :title-10 "1.2em"
   :body-30 "1.8em"
   :body-20 "1.8em"
   :body-10 "1.8em"
   :caption-30 "1.5em"
   :caption-20 "1.5em"
   :caption-10 "1.2em"})

(def display-20-size 48)
(def display-10-size 38)
(def title-40-size 28)
(def title-30-size 24)
(def title-20-size 20)
(def title-10-size 18)
(def body-30-size 18)
(def body-20-size 18)
(def body-10-size 16)
(def caption-30-size 15)
(def caption-20-size 14)
(def caption-10-size 13)

(defn ->rounded-px
  [display-value percent-change]
  (str (.toFixed (* display-value percent-change) 1) "px"))

(def size
  {:display-20 (->rounded-px display-20-size 1)
   :display-20/tablet (->rounded-px display-20-size 0.75)
   :display-20/mobile (->rounded-px display-20-size 0.58)

   :display-10 (->rounded-px display-10-size 1)
   :display-10/tablet (->rounded-px display-10-size 0.75)
   :display-10/mobile (->rounded-px display-10-size 0.58)

   :title-40 (->rounded-px title-40-size 1)
   :title-40/tablet (->rounded-px title-40-size 0.90)
   :title-40/mobile (->rounded-px title-40-size 0.82)

   :title-30 (->rounded-px title-30-size 1)
   :title-30/tablet (->rounded-px title-30-size 0.90)
   :title-30/mobile (->rounded-px title-30-size 0.82)

   :title-20 (->rounded-px title-20-size 1)
   :title-20/tablet (->rounded-px title-20-size 0.90)
   :title-20/mobile (->rounded-px title-20-size 0.82)

   :title-10 (->rounded-px title-10-size 1)
   :title-10/tablet (->rounded-px title-10-size 0.90)
   :title-10/mobile (->rounded-px title-10-size 0.82)

   :body-30 (->rounded-px body-30-size 1)
   :body-30/tablet (->rounded-px body-30-size 0.90)
   :body-30/mobile (->rounded-px body-30-size 0.82)

   :body-20 (->rounded-px body-20-size 1)
   :body-20/tablet (->rounded-px body-20-size 0.90)
   :body-20/mobile (->rounded-px body-20-size 0.82)

   :body-10 (->rounded-px body-10-size 1)
   :body-10/tablet (->rounded-px body-10-size 0.90)
   :body-10/mobile (->rounded-px body-10-size 0.82)

   :caption-30 (->rounded-px caption-30-size 1)
   :caption-30/tablet (->rounded-px caption-30-size 0.90)
   :caption-30/mobile (->rounded-px caption-30-size 0.82)

   :caption-20 (->rounded-px caption-20-size 1)
   :caption-20/tablet (->rounded-px caption-20-size 0.90)
   :caption-20/mobile (->rounded-px caption-20-size 0.82)

   :caption-10 (->rounded-px caption-10-size 1)
   :caption-10/tablet (->rounded-px caption-10-size 0.90)
   :caption-10/mobile (->rounded-px caption-10-size 0.82)})

(def weight
  {:display-20 300
   :display-10 300
   :title-40 700
   :title-30 700
   :title-20 700
   :title-10 700
   :body-30 700
   :body-20 400
   :body-10 300
   :caption-30 700
   :caption-20 400
   :caption-10 400})

(def margin
  {:display-20 "1em"
   :display-10 "1em"
   :title-40 "1em"
   :title-30 "1em"
   :title-20 "1em"
   :title-10 "1em"
   :body-30 "1em"
   :body-20 "1em"
   :body-10 "1em"
   :caption-30 "0.2em"
   :caption-20 "0.2em"
   :caption-10 "0.2em"})

(def font-families
  {:primary "'Open Sans', sans-serif"
   :secondary "'Roboto Mono', monospace"})
