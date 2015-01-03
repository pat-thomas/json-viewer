(ns json-viewer.components.input-box
  (:require [om.core :as om  :include-macros true]
            [om.dom  :as dom :include-macros true])
  (:require-macros [om-utils.core :refer [defcomponent]]))

(defn update-json
  [e data]
  (om/transact! data :json #(.. e -target -value)))

(defcomponent input-box
  (render
   (dom/textarea #js {:placeholder "Enter JSON here"
                      :onChange    #(update-json % data)})))
