(ns json-viewer.components.viewer
  (:require [om.core :as om  :include-macros true]
            [om.dom  :as dom :include-macros true])
  (:require-macros [om-utils.core :refer [defcomponent]]))

(defcomponent viewer
  (render
   (when-let [json (:json data)]
     (let [parsed-json (try (JSON/stringify (JSON/parse json))
                            (catch js/Error ex
                              "Invalid JSON"))]
       (dom/div nil parsed-json)))))
