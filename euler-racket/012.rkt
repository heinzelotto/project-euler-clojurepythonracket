#lang racket
(require "euler.rkt")

(require racket/stream)

;; requires function count-divisors



;; the 2n-th triangle number is n*(2n+1)
;; 2n and 2n+1 don't have divisors in common, and so n and 2n+1 don't either

;; the 2n+1-th triangle number is (2n+1)*(n+1)
;; same here for the coprimality
(define (count-divisors-triangle-number n)
  (if (even? n)
      (* (count-divisors (/ n 2)) (count-divisors (add1 n)))
      (* (count-divisors n) (count-divisors (/ (add1 n) 2)))))

(define (nth-triangle-number n)
  (/ (* n (add1 n)) 2))

(define (smallest-triangle-with-min-divisors min-count)
  (stream-first (stream-filter (λ (n) (> (count-divisors-triangle-number n) min-count))
                               (in-naturals))))

(define (euler-12-solution)
  (nth-triangle-number (smallest-triangle-with-min-divisors 500)))

;; the result is not a large number. another feasible solution:
;; 1. for each triangle number N
;; 2. check all i from 1 through sqrt(N)
;; 3. add 2 (for the factors i and N/i) if i divides N
;; this seems to be faster
