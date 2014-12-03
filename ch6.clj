(load-file "/Users/jskulski/Code/jskulski/funcprogforooprogger/sources/class.clj")

(eval 'Point)
(eval Point)

(def point (make Point 4 3))


(def class-from-instance
  (fn [instance]
    (assert (map? instance))
    (eval (:__class_symbol__ instance))))


(eval (class-from-instance point))


;;; parent / children

(def Point
  {
   :__own_symbol__ 'Point
   :__superclass_symbol__ 'Anything
   :__instance_methods__
   {
    :add-instance-values (fn [this x y]
                           (assoc this :x x :y y))
    :shift (fn [this xinc yinc]
             (make Point (+ (:x this) xinc)
                         (+ (:y this) yinc)))
    :add (fn [this other]
           (send-to this :shift (:x other)
                                (:y other)))}})

(def RedPoint
  {
   :__own_symbol__ 'RedPoint
   :__superclass_symbol__ 'Point
   :__instance_methods__
   {
    :color 'Red
   }})



(def Anything
  {
  :__own_symbol__ 'Anything
  :__instance_methods__
  {
   :add-instance-values identity

   :class_name :__class_symbol__
   :class (fn [this] (class-from-instance this))

   }})


(def class-symbol-above
  (fn [class-symbol]
    (:__superclass_symbol__ (eval class-symbol))))

(class-symbol-above 'Point)


(cons 'Anything nil)

(cons 'RedPoint (cons 'Point (cons 'Anything nil)))

(reverse (cons 'RedPoint (cons 'Point (cons 'Anything nil))))

(def lineage
  (fn [class-symbol]
    (if (nil? class-symbol)
      nil
      (cons class-symbol
            (lineage (class-symbol-above class-symbol))))))

(def lineage-tail-1
  (fn [class-symbol result]
    (if (nil? class-symbol)
      result
      (recur (class-symbol-above class-symbol)
             (cons class-symbol result)))))
(def lineage-tail
  (fn [class-symbol]
    (lineage-tail-1 class-symbol [])))

(lineage 'RedPoint)
(lineage-tail 'RedPoint)



;;; method-cache
(def method-cache
  (fn [class]
    class
    ))


(method-cache RedPoint)

