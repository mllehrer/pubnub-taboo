(defproject taboo-game "1.0.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://taboo-game.herokuapp.com"
  :license {:name "FIXME: choose"
            :url "http://example.com/FIXME"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.8.51"]
                 [compojure "1.4.0"]
                 [ring/ring-jetty-adapter "1.2.2"]
                 [ring/ring-devel "1.2.2"]
                 [ring-basic-authentication "1.0.5"]
                 [environ "0.5.0"]
                 [com.cemerick/drawbridge "0.0.6"]
                 [cljs-http "0.1.40"]
                 [org.clojure/core.async "0.2.374"]
                 [enfocus "2.1.1"]
                 [cheshire "2.2.2"]]
  :min-lein-version "2.0.0"
  :plugins [[environ/environ.lein "0.2.1"]
            [lein-heroku "0.5.3"]
            [lein-ring "0.9.7"]
            [lein-cljsbuild "1.1.3"]]
  :cljsbuild {
              :builds [{
                        :source-paths ["src-cljs"]
                        :compiler {
                                   :output-to "resources/public/main.js"
                                   :optimizations :whitespace
                                   :pretty-print true
                                   }
                        }]
              }
  :hooks [environ.leiningen.hooks]
  :uberjar-name "taboo-game-standalone.jar"
  :profiles {:production {:env {:production true}}})
