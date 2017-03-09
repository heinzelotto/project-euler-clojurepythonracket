(require '(clojure.core [reducers :as r]))

(defn divisible-by? [n d]
  (zero? (mod n d)))

(declare primes-lessthan)

(defn prime? [n]
; this would have been better, but is too much mutual recursion between primes-lessthan and primes and prime? -> causes stack overflow
; (not-any? (fn [d] (divisible-by? n d)) (primes-lessthan n)))
  (not-any? (fn [d] (divisible-by? n d)) (range 2 n)))

(defn not-divisible-by-list? [n factor-list]
  "true if n is not divisible by at least one of the factors in factor-list"
  (not-any? #(divisible-by? n %) factor-list))

(defn positive-numbers
  ([] (positive-numbers 1))
  ([n] (lazy-seq (cons n (positive-numbers (inc n))))))

(defn primes
  ([] (primes 2 ()))
  ([p previous-primes-list]
   (let [next-prime (first (filter #(not-divisible-by-list? % (filter (fn [k] (<= (* k k) %)) previous-primes-list)) (positive-numbers p)))]
;     (println next-prime)
;     (println (filter (fn [k] (<= (* k k) next-prime)) previous-primes-list))
     (lazy-seq (cons next-prime (primes (inc next-prime) (cons next-prime previous-primes-list)))))))

(defn bigprime-solution-7 []
  (nth (primes) (- 10001 1)))
