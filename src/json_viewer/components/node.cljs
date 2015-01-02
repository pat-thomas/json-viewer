(ns json-viewer.components.node
  (:require [om.core           :as om  :include-macros true]
            [om.dom            :as dom :include-macros true]
            [cognitect.transit :as transit])
  (:require-macros [om-utils.core :refer [defcomponent]]))

(defn parse-json
  [raw-json]
  (let [r (transit/reader :json)]
    (transit/read r raw-json)))

(defn calc-new-node-path
  [node-path k]
  (println node-path)
  (conj node-path k))

(defcomponent json-node
  (render
   (dom/div #js {:className   "js-node"
                 :onMouseOver (fn [e]
                                (om/transact! data :node-path #(calc-new-node-path % (:node-text opts))))}
            (:node-text opts))))

(defn build-nodes
  [raw-json data opts]
  (let [clj-ds      (parse-json raw-json)
        keys-in-map (map (fn [k]
                           (name k))
                         (keys clj-ds))]
    (apply dom/div
           #js {:id "node-container"}
           (map
            (fn [node-text]
              (om/build json-node
                        data
                        {:opts {:node-text node-text}}))
            keys-in-map))))
