(ns json-viewer.components.input-box
  (:require [om.core :as om  :include-macros true]
            [om.dom  :as dom :include-macros true])
  (:require-macros [om-utils.core :refer [defcomponent]]))

(defn submit-fn
  [e data]
  (println (:json data)))

(defcomponent input-box-submit-button
  (render
   (dom/button #js {:onClick #(submit-fn % data)} "Inspect JSON.")))

(defn update-json
  [e data]
  (om/transact! data :json (fn [_]
                             (.. e -target -value))))

(defcomponent input-box
  (render
   (dom/textarea #js {:placeholder "text goes here"
                      :onChange    #(update-json % data)})))
