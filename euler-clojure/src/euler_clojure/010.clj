(require '(clojure.core [reducers :as r]))

(defn divisible-by? [n d]
  (zero? (mod n d)))

(def certainty 15)

;; this is faster, using number theory
(defn prime-mr? [n]
  (.isProbablePrime (BigInteger/valueOf n) certainty))

; this needs two specialities: 1. tail recursion with loop and recur; 2. the call to (doall ) to 
(defn prime-sieve-slow [number-range]
  (reverse
   (loop [xs-done '() xs number-range]
     (if (empty? xs)
       xs-done
       (let [factor (first xs)]
         (recur (cons factor xs-done) (doall (remove #(divisible-by? % factor) xs))))))))

(defn prime-list [number-range]
  (doall (filter prime-mr? number-range)))

(defn euler-10-solution []
  "calculates the sum of all primes smaller than 2.000.000"
  (r/reduce + (prime-list (range 2 2000000))))

;(time (euler-11-solution))

