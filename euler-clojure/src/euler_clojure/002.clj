(defn fibonaccis
  "Calculate a list of the first k fibonacci numbers, at most up to the value N"
  [k n]
  (case k
    1 [1]
    2 [2 1]
    (let [fbs (fibonaccis (dec k) n)
          f (reduce + (take 2 fbs))]
      (if (>= f n)
        fbs
        (cons f fbs)))))

(defn fibonacci-solution
  "determine sum of even fibonaccis less than 4000000"
  []
  (println
   (reduce + (filter even? (fibonaccis 50 4000000)))))

