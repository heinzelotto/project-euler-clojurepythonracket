;; weekday of jan 1 of year 1900+n relative to jan 1 1900 (monday)
(defn first-day-offset-since-1900 [n]
  (mod (+ n (int (/ (dec n) 4))) 7))

(def MONTHS_LENGTHS_NONLEAP
  [31 28 31 30 31 30 31 31 30 31 30 31])

(def MONTHS_LENGTHS_LEAP
  [31 29 31 30 31 30 31 31 30 31 30 31])

(defn accumulate [xs]
  (for [i (range 12)]
    (reduce + (take i xs))))

(def MONTHS_BEGINNINGS_NONLEAP
  (accumulate MONTHS_LENGTHS_NONLEAP))

(def MONTHS_BEGINNINGS_LEAP
  (accumulate MONTHS_LENGTHS_LEAP))

;; jan 1 1900 was a monday (1, since we take 0 = SUN)
(def JAN1_1900 1)

(defn leap? [n]
  (or (zero? (mod n 400))
      (and (not (zero? (mod n 100)))
           (zero? (mod n 4)))))

(defn weekdays-on-month-beginnings-in-twentieth-century []
  (map #(mod % 7)
       (mapcat (fn [n] (let [offset (+ JAN1_1900 (first-day-offset-since-1900 n))
                             leap (leap? n)]
                         (map #(+ offset  %)
                              (if (leap? n)
                                MONTHS_BEGINNINGS_LEAP
                                MONTHS_BEGINNINGS_NONLEAP))))
               (range 1 101))))

(defn euler-19-solution []
  (count (filter zero?
                 (weekdays-on-month-beginnings-in-twentieth-century))))
