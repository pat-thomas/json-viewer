(ns json-viewer.components.viewer
  (:require [om.core :as om  :include-macros true]
            [om.dom  :as dom :include-macros true])
  (:require-macros [om-utils.core :refer [defcomponent]]))

(defcomponent toggle-error-message-button
  (render
   (dom/button #js {:onClick #(om/transact! data :error-message-enabled not)}
               "Toggle error message.")))

(defcomponent viewer
  (render
   (when-let [json (:json data)]
     (let [parsed-json (try (JSON/stringify (JSON/parse json))
                            (catch js/Error ex
                              (if (:error-message-enabled data)
                                "Invalid JSON"
                                json)))]
       (dom/div nil parsed-json)))))
