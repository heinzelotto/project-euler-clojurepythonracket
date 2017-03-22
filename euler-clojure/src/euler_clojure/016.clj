(defn euler-16-solution []
  (reduce + (map #(Character/digit % 10)
                 (seq (str (.shiftLeft (BigInteger/ONE) 1000))))))
