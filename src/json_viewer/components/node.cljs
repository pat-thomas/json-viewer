(ns json-viewer.components.node
  (:require [om.core           :as om  :include-macros true]
            [om.dom            :as dom :include-macros true]
            [cognitect.transit :as transit])
  (:require-macros [om-utils.core :refer [defcomponent]]))

(defn parse-json
  [raw-json]
  (let [r (transit/reader :json)]
    (transit/read r raw-json)))

(defn display-child-nodes
  [])

(defcomponent json-node
  (render
   (dom/div #js {:className   "js-node"
                 :onMouseOver display-child-nodes}
            (:node-text opts))))

(defn build-nodes
  [data raw-json]
  (let [clj-ds      (parse-json raw-json)
        keys-in-map (map (fn [k]
                           (name k))
                         (keys clj-ds))]
    (apply dom/div
           #js {:id "node-container"}
           (map #(om/build json-node data {:opts {:node-text %}})
                keys-in-map))))
