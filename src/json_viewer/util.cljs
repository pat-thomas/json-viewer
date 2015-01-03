(ns json-viewer.util
  (:require [cognitect.transit :as transit]))

(defn parse-json
  [raw-json]
  (let [r (transit/reader :json)]
    (transit/read r raw-json)))
