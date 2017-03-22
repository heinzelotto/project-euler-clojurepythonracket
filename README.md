# project-euler-clojurepythonracket
Solutions to Project Euler problems in three languages

Problems `3n+k` are solved using `k =`

1. Clojure
2. Python
3. Racket

(exceptions were made when worthwhile)

Recent status: 16/582

### Notable optimizations

008.clj -- optimization by preprocessing the problem to skip sections where no solution will be found anyway. This doubles speed, but code gets less readable

012.rkt -- uses number of divisors formula, the fact that two successive numbers are coprime.

015 -- This can be solved by hand. each path consists of 2\*20 pieces, of which 20 point right (and 20 point down) thus the answer is 40 choose 20
