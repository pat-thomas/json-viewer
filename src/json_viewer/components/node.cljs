(ns json-viewer.components.node
  (:require [om.core          :as om  :include-macros true]
            [om.dom           :as dom :include-macros true]
            [json-viewer.util :as util])
  (:require-macros [om-utils.core :refer [defcomponent]]))

(defn display-child-nodes
  [data {:keys [node-text]}]
  (-> data
      :json
      util/parse-json
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
       util/parse-json
       keys
       (map name)
       (map (fn [node-text]
              (om/build json-node data {:opts {:node-text node-text}})))
       (apply dom/div #js {:id "node-container"})))
