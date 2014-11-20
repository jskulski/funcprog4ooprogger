
(def method-from-class (fn [method class]
  (method (:__instance_methods__ class))))

(def class-from-instance (fn [instance]
                           (eval (:__class_symbol__ instance))))

(def apply-message-to
  (fn [class instance message args]
    (apply
     (message (:__instance_methods__ class))
              instance args)))

(class-from-instance point)
(def make
      "fn [class & args]"
     (fn [class & args]
       (let [seeded {:__class_symbol__ (:__own_symbol__ class)}]
            (apply-message-to class seeded :add-instance-values args))))

(make Point 1 3)

(def send-to
     (fn [instance message & args]
       (let [class (class-from-instance instance)]
         (apply-message-to class instance message args)
         )))

(send-to point :shift 3 -3)

(def Point
{
  :__own_symbol__ 'Point
  :__instance_methods__
  {
    :add-instance-values (fn [this x y]
                           (assoc this :x x :y y))
    :class :__class_symbol__
    :origin (fn [this] (make Point 0 0))
    :shift (fn [this xinc yinc]
             (make Point (+ (:x this) xinc)
                         (+ (:y this) yinc)))
    :add (fn [this other]
           (send-to this :shift (:x other)
                                (:y other)))
   }
 })


(+ 1 2)

(+ 1 (+ 1 1))
(+ 1 2)



(+ 5
   (* 49 2)
   (+ 1 2 3 4 5)
  )

(def crazy (fn [x y]
             (+ x
                (* x x)
                (* y x))))


(crazy 4 3)



(apply-message-to Point point :shift [1 2])


;; exercise 2

(def point (make Point 4 2))


;; exercise 3

;;;; WHHHAHT IS GOING ON HERE
(def point (make Point 3 4))
(send-to point :origin)

(def Point "the original definition of Point")
(def a-point {:_class_NOT_symbol Point})
(def Point "new definitio")
(pr a-point)

;; For exercise 4
(def Holder
{
  :__own_symbol__ 'Holder
  :__instance_methods__
  {
   :add-instance-values (fn [this held]
                          (assoc this :held held))
   :woop (make Holder "new thing else")
  }
})


(:not-there {:a 1, :b 2})

(def holder (make Holder "held string"))

(if (nil? true) "woop" "bloop")

(def message-or-method
  (fn [message instance]
    (let [class (class-from-instance instance)
          method (or (method-from-class message class)
                     message)]
      method)))

(def apply-message-to-or-get
  (fn [class instance message & args]
    (let [method (message-or-method message instance)]
      (apply method instance args))))


(testIfThere :held holder)

(if (:held (:__instance_methods__ Holder))
           (:held (:__instance_methods__ Holder))
           (:held holder))

(apply-message-to-or-get Holder holder :held)
(apply-message-to-or-get Holder holder :woop)
(apply-message-to Holder holder :woop )


(def method-from-message
  (fn [message class]
    (message (:__instance_methods__ class))))

(method-from-message :woop Holder)


(def apply-message-to
     (fn [class instance message args]
       (let [method (or (method-from-message message class)
                        message)]
       (apply method instance args))))
