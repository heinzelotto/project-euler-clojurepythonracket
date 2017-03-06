(defn palindrome?
  "Whether n is a palindrome"
  [n]
  (let [nseq (seq (str n))]
    (= nseq (reverse nseq))))
  

(defn largest-palindrome-solution
  "Non-greedy test of all 999x999 products"
  []
  (apply max
         (filter palindrome?
                 (for [m (range 100 1000)
                       n (range 100 1000)]
                   (* m n)))))

; many ways to improve upon this brute force
; it would be smarter to skip all smaller tuples of factors once a palindrome has been found. This notion of 'once' seems to imply an order of evaluation like in procedural programming. I don't know how to do this functionally
