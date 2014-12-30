(ns json-viewer.components.app
  (:require [om.core :as om  :include-macros true]
            [om.dom  :as dom :include-macros true])
  (:require-macros [om-utils.core :refer [defcomponent]]))

(defcomponent container
  (render
   (dom/h1 nil "hello")))
