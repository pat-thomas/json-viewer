(ns json-viewer.components.viewer
  (:require [om.core :as om  :include-macros true]
            [om.dom  :as dom :include-macros true])
  (:require-macros [om-utils.core :refer [defcomponent]]))

(defcomponent viewer
  (render
   (dom/div nil "some stuff will show up here")))
