(require '(clojure.core [reducers :as r]))

(defn divisible-by? [d n]
  (zero? (mod n d)))

(defn multiples-sum-solution
  "returns sum of multiples of 3 or of 5 that are lower than 1000"
  []
  (r/fold + (filter #(or (divisible-by? 3 %1) (divisible-by? 5 %1))
                  (range 1000))))
