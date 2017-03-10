# project-euler-clojurepythonracket
Solutions to Project Euler problems in three languages

Problems `3n+k` are solved using `k =`

1. Clojure
2. Python
3. Racket

(exceptions were made when worthwhile)

Recent status: 8/582

### Notable optimizations

008.clj -- optimization by preprocessing the problem to skip sections where no solution will be found anyway. This doubles speed, but code gets less readable
