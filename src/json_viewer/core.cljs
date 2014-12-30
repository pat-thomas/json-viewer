(ns json-viewer.core
  (:require [om.core                    :as om] 
            [json-viewer.state          :as state]
            [json-viewer.components.app :as app]))

(defn init
  []
  (om/root
   app/container
   state/app-state
   {:target (. js/document (getElementById "json-viewer-app"))
    :opts   {}}))

(init)
