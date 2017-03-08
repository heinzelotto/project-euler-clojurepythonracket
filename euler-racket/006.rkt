#lang racket

(require math/base)

(define (sq n)
  (* n n))


; we know explicit formulae for this
(define (sq-sum-range-smart n)
  (sq (/ (* n (+ n 1)) 2)))

(define (sum-sq-range-smart n)
  (/ (* n (+ n 1) (+ (* n 2) 1)) 6))

; We also know this result from young Gauss
(define (sum-range-100-gauss-anecdotal)
  5050)

(define (solution-euler-6-dumb)
  (- (sq (sum (range 101))) (sum (map sq (range 101)))))

(define (solution-euler-6-smart)
  (- (sq-sum-range-smart 100) (sum-sq-range-smart 100)))


; however, both are instantaneous.......
(time (solution-euler-6-smart))
(time (solution-euler-6-dumb))
