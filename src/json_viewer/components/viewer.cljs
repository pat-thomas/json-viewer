(ns json-viewer.components.viewer
  (:require [om.core                     :as om  :include-macros true]
            [om.dom                      :as dom :include-macros true]
            [json-viewer.components.node :as node])
  (:require-macros [om-utils.core :refer [defcomponent]]))

(defcomponent toggle-error-message-button
  (render
   (dom/button #js {:onClick #(om/transact! data :error-message-enabled not)}
               "Toggle error message.")))

(defcomponent debugger
  (render
   (dom/div #js {:id "debugger"}
            (dom/label nil (str "Node path: "
                                (map str (:node-path data)))))))

(defcomponent viewer
  (render
   (when-let [json (:json data)]
     (dom/div nil
              (try (node/build-nodes json data opts)
                   (catch js/Error e
                     "Invalid JSON."))))))
