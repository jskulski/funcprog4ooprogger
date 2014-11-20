(def square (fn [x] (* x x)))

(def add-squares (fn [numbers]
                   (apply +  (map square numbers))))

(square 1)
(square 2)
(square 4)
(add-squares '(1 2 3))
(add-squares '(1 2 3 4))

(eval (cons + [ 1 2 3 ]))


(def bizFactorial (fn [x] (apply * (range 1 x))))

(bizFactorial 5)
(bizFactorial 21)


(defn pickFirstThreeEven [list] (take 3 (filter even? list)))

;; Pick the first three even numbers from a list
(pickFirstThreeEven '(8 99 92 4 3 9 2 38 12 99))


;; How many elements in a vector are redundant (copies)?
(defn redundant [list] (- (count list)
                          (count (distinct list))))


(redundant [2 3 4 5 4 4 4 23 3 9 4 3 23132])


;;
;; (tails '(1 2 3 4))
;; ((1 2 3 4) (2 3 4) (3 4) (4) ())
;;

;; third attempt

(def tails
     (fn [seq]
       (map drop
            (range (inc (count seq)))
            (repeat (inc (count seq)) seq))))


(range (inc (count '(1 2 3 4))))
(repeat (inc (count '(1 2 3 4))) '(1 2 3 4))

(map drop '(0 1 2 3 4) (list (list 1 2 3 4) (list 1 2 3 4)))


(tails '(1 2 3 4))



;; second attempt
;;
;; (defn
;;   tails [list]
;;   (def counts (range 0 (count list)))
;;   (vector (counts ))

;; [(drop 0 [1 2 3])
;;  (drop 1 [1 2 3])
;;  (drop 2 [1 2 3])
;;  (drop 3 [1 2 3])]

;; first attempt
;; (defn tails [list] (cons
;;                     (take-last (- (count list) 1) list)
;;                     (tails (rest list))))
;; (take-last 4 '(1 2 3 4))
;; (tails '(1 2 3 4))



