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
  [data {:keys [node-text]}]
  (-> data
      :json
      parse-json
      (get node-text)
      println))

(defcomponent json-node
  (render
   (dom/div #js {:className   "js-node"
                 :onMouseOver #(display-child-nodes data opts)}
            (:node-text opts))))

(defn build-nodes
  [data raw-json]
  (->> raw-json
       parse-json
       keys
       (map name)
       (map (fn [node-text]
              (om/build json-node data {:opts {:node-text node-text}})))
       (apply dom/div #js {:id "node-container"})))
