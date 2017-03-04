#lang racket

(define (prime-test-range n)
  (range 2 (+ (sqrt n) 1)))

(define (divisible-by? n d)
  (zero? (modulo n d)))

(define (largest-prime-factor n)
  (let ([divisor-list (filter (λ (d) (divisible-by? n d)) (prime-test-range n))])
    (if (empty? divisor-list)
        n
        (largest-prime-factor (/ n (first divisor-list))))))

(largest-prime-factor 600851475143)