(ns taboo-game.core
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require [clojure.browser.repl :as repl]
            [cljs-http.client :as http]
            [cljs.core.async :refer [<!]]
            [enfocus.core :as ef]
            [enfocus.events :as ev]
            [enfocus.effects :as ee]
            [taboo-game.utils :as utils]
            ))


(defn ^:export init []
      (let [card (utils/choose-card)]
           (ef/do-> (ef/at "#card-title" (ef/content (:word card)))
                    (ef/at "#taboo-words" (ef/content (utils/list-words (:taboo-words card)))))
           (ef/at "#win" (ev/listen
                           :click
                           (ef/do-> #(js/alert "You won!")
                                    #(js/window.location.reload)))))

      )