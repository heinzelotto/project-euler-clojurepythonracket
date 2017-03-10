#lang racket

(define (sq n)
  (* n n))

(define (ptriplet? a b c)
  (zero? (- (sq c) (+ (sq a) (sq b)))))

(define (triplets-with-sum n)
  (filter (λ (arg) (ptriplet? (first arg) (second arg) (third arg)))
          (for*/list ([b+a (range (/ n 2) 999)]
                 [a (range 1 (/ b+a 2))])
            `(,a ,(- b+a a) ,(- n b+a)))))

; for a + b + c = 1000 with a² + b² = c² to hold we have to have a + b > 500, since sum of squares will be smaller than square of sums (see previous problem :))
(define (euler-9-solution)
  (map (λ (k) (foldl * 1 k))
       (triplets-with-sum 1000)))
