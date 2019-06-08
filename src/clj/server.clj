(ns clj.server
  (:require [ring.util.response :refer [not-found file-response]]
            [ring.middleware.content-type :refer [content-type-response]]
            [ring.middleware.file :refer [file-request]]
            [ring.middleware.not-modified :refer [not-modified-response]]))

(defonce resource-dir "resources/public")

(defn handler [req]
  (let [is-file (some-> req
                        :uri
                        (clojure.string/split #"/")
                        last
                        (clojure.string/includes? "."))]
    (if is-file
      (if-let [res (file-request req resource-dir)]
        (-> res
            (not-modified-response req)
            (content-type-response req))
        (not-found "Not Found"))
      (assoc-in (file-response resource-dir)
                [:headers "Content-Type"]
                "text/html;charset=utf8"))))
