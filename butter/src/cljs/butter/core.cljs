(ns butter.core
  (:require [reagent.core :as reagent]
            [cljsjs.react]))

(def login-info (reagent/atom {:username "root" :password ""}))

(defn custom-input [param type value]
    [:span
        [:input {:type type
                 :value value
                 :on-change #(swap! login-info assoc param (.-target.value %))}]
    ]
    )

(defn login-form []
    [:div 
        [custom-input :username "text" "root"]
        [custom-input :password "password" ""]
    ]
    )

(defn server-connection []
    [:div
        [:h1 "MySql server log in"]
        [login-form]
        ])

(defn main-page
  []
  [:div
    [server-connection]]
  )

(defn mount-root
  []
  (reagent/render [main-page] (.getElementById js/document "app")))

(defn init!
  []
  (mount-root))
