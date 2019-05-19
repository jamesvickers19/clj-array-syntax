(ns clj-array-syntax.core)


(defn- parse-index-expr [bracket-notation]
 (-> bracket-notation
   (str)
   (.replace "[" "")
   (.replace "]" "")
   (read-string)))

; Supports array access syntax, e.g.
; an-array[0][1][2]
; At some point, re-write to make a master macro
; that can do access or update?
(defmacro array-get
  [& body]
  (let [array-name (first body)
        index-exprs (map parse-index-expr (rest body))]
    `(aget ~array-name ~@index-exprs)))


(macroexpand '(array-get arr[ 0 ][ 1 ][(inc 1)]))
; => (clojure.core/aget arr 0 1 (inc 1))

(def a (double-array [1.0 2.0 3.0]))
(array-get a[(inc 1)])
; => 3.0     (which is a[2])


; next: array-set macro
; - support any update operator, such as =, *=, -=, +=




; next: combine functionality of
; array-get and array-set into one macro




; next: choose which get/set methods to use based on array type
