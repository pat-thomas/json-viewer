(ns json-viewer.state)

(def app-state
  (atom {:error-message-enabled true
         :node-path             []
         ;;NB> The following is dummy data and should not be checked in.
         :json                  "{\"a\":1,\"b\":\"bar\"}"}))
