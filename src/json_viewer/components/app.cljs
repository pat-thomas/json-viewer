(ns json-viewer.components.app
  (:require [om.core                          :as om  :include-macros true]
            [om.dom                           :as dom :include-macros true]
            [json-viewer.components.input-box :as input-box]
            [json-viewer.components.viewer    :as viewer])
  (:require-macros [om-utils.core :refer [defcomponent]]))

(defcomponent container
  (render
   (dom/div nil
            (om/build input-box/input-box data)
            (om/build viewer/toggle-error-message-button data) 
            (om/build viewer/viewer data))))
