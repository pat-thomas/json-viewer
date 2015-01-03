(ns json-viewer.components.viewer
  (:require [om.core                     :as om  :include-macros true]
            [om.dom                      :as dom :include-macros true]
            [json-viewer.components.node :as node])
  (:require-macros [om-utils.core :refer [defcomponent]]))

(defcomponent toggle-error-message-button
  (render
   (dom/button #js {:onClick #(om/transact! data :error-message-enabled not)}
               "Toggle error message.")))

(defcomponent viewer
  (render
   (when-let [json (:json data)]
     (dom/div nil
              (try (node/build-nodes data json)
                   (catch js/Error e
                     "Invalid JSON."))))))
