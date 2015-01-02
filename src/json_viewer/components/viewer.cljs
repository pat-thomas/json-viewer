(ns json-viewer.components.viewer
  (:require [om.core :as om  :include-macros true]
            [om.dom  :as dom :include-macros true])
  (:require-macros [om-utils.core :refer [defcomponent]]))

(defcomponent viewer
  (render
   (when-let [json (:json data)]
     (dom/div nil json))))
