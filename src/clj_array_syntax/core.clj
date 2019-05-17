(ns clj-array-syntax.core)


(defn parse-index-expr [bracket-notation]
 (re-find #"\[(.+)\]" "[0]"))

(parse-index-expr "[0]")

(defmacro array-op
 [& forms]
 (let [arr-name (first forms)]
   (println "arr-name: " arr-name)
   (doall (map println forms))
   'forms))

(macroexpand '(array-op an-array[0][1] = 5.0))
; => (aget an-array 0 1)

(macroexpand '(array-op a[0] = 1.0))

(macroexpand '(array-op a[0][1][2]))
