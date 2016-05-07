(ns taboo-game.utils
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require [clojure.browser.repl :as repl]
            [cljs-http.client :as http]
            [cljs.core.async :refer [<!]]
            [enfocus.core :as ef]
            [enfocus.events :as ev]
            [enfocus.effects :as ee]))

(def card-deck {1 {:word "Fish" :taboo-words '("salmon" "trout" "tuna" "sushi" "gills")}
                2 {:word "Canada" :taboo-words '("hockey" "canuck" "poutine" "Montreal" "Toronto")}
                3 {:word "Beach" :taboo-words '("seashore" "sand" "waves" "shells" "water")}
                4 {:word "Invisible" :taboo-words '("ghost" "unseen" "appear" "transparent" "man")}
                5 {:word "Pen" :taboo-words '("write" "ball-point" "felt-tip" "pal" "ink")}
                6 {:word "Headache" :taboo-words '("pain" "throb" "aspirin" "migraine" "temple")}
                7 {:word "Dictionary" :taboo-words '("book" "words" "definitions" "Webster's" "meaning")}
                8 {:word "Purple" :taboo-words '("color" "blue" "violet" "heart" "lavender")}
                9 {:word "Exercise" :taboo-words '("gym" "jogging" "aerobics" "workout" "spinning")}
                10 {:word "Watch" :taboo-words '("look" "time" "wrist" "clock" "wears")}})

(defn choose-card []
      (card-deck (rand-int 9)))

(defn list-words [coll]
      (clojure.string/join "<br>" coll))