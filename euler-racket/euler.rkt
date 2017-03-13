#lang racket

(require racket/stream)

(provide divisible-by?
         factorize
         factorize-with-exponents
         count-divisors)

(define (divisible-by? n d)
  (zero? (modulo n d)))

(define (first-factor n [start 2])
  (let ([factors (stream-filter (λ (k) (divisible-by? n k)) (in-range start (sqrt (+ n 1))))])
    (if (stream-empty? factors)
        n
        (stream-first factors))))

(define (factorize n)
  (letrec ([factorize-helper (λ (k start)
                               (let ([ff (first-factor k start)])
                                 (if (= k ff)
                                     `(,ff)
                                     (cons ff (factorize-helper (/ k ff) ff)))))])
    (factorize-helper n 2)))

(define (factorize-with-exponents n)
  (let ([h (make-hash)])
    (for ([k (factorize n)])
      (hash-update! h k add1 0))
    h))

(define (count-divisors n)
  (foldl * 1 (map add1 (hash-values (factorize-with-exponents n)))))
