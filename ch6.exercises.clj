
;; head recursion factorial

(def factorial
  (fn [n]
    (if (or
         (= n 1)
         (zero? n))
      1
      (* n (factorial (- n 1))))))


(factorial 0)
(factorial 1)
(factorial 2)
(factorial 5)
(factorial 10)

;; tail recrusion factorial

(def factorial-tail-1
  (fn [n fact]
    (if (= n 1)
      fact
      (recur (dec n)
             (* n fact)))))

(def factorial-tail
  (fn [n]
    (factorial-tail-1 n 1)))


(factorial-tail 0)
(factorial-tail 1)
(factorial-tail 3)
(factorial-tail 5)
(factorial-tail 6)
(factorial-tail 10)


;; ex3

(def add-nums
  (fn [list sum]
    (if (empty? list)
      sum
      (recur (rest list)
             (+ (first list) sum)))))

(add-nums [ 1 2 3 4] 0)


;; ex4


(def mult-nums
  (fn [list mult]
    (if (empty? list)
      mult
      (recur (rest list)
             (* (first list) mult)))))


(mult-nums [ 1 2 3 4 5 ] 1)


(def apply-func-to-nums
  (fn [func list so-far]
    (if (empty? list)
      so-far
      (recur func
             (rest list)
             (func (first list) so-far)))))

(apply-func-to-nums * [ 1 2 3 4 5] 1)
(apply-func-to-nums + [ 1 2 3 4 5] 0)


;; ex5

(def make-map-zero
  (fn [key so-far]
    (assoc so-far key 0)))

(def make-map-index
  (fn [key so-far]
    (assoc
      so-far
      key
      (count so-far))))


(apply-func-to-nums make-map-zero [:a :b :c] {})
(apply-func-to-nums make-map-index [:a :b :c] {})


;; Do we need to reverse? i thought dictionary isn't ordered
{:a 1 :b 2}
(reverse {:a 1 :b 2})
(= {:a 1 :b 2} (reverse {:a 1 :b 2}))



;; ex6
;;; i am become reduce

(reduce + 0 [ 1 2 3 4 ])

;;;;





