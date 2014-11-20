
(def niceMake (fn [class & args]
                (let [seeded {:__class_symbol__ (:__own_symbol__ class)}]
                  seeded)))

(niceMake Point)


(def make (fn [class & args]
            (let [allocated {}
                  seeded (assoc allocated :__class_symbol__ (:__own_symbol__ class))
                  constructor (:add-instance-values
                               (:__instance_methods__ class))]
              (apply constructor seeded args))))

(def Point
  {
   :__own_symbol__ 'Point
   :__instance_methods__
   {
    :add-instance-values
      (fn [this x y]
        (assoc this :x x :y y))
    :class :__class_symbol__
    :shift (fn [this xinc yinc]
             (make Point (+ (:x this) xinc)
                         (+ (:y this) yinc)))}})


(def point (make Point 3 9))

(:__class_symbol__ point)
(eval (:__class_symbol__ point))

(def send-to
  (fn [instance message & args]
    (let [class (eval (:__class_symbol__ instance))
         method (message (:__instance_methods__ class))]
    (apply method instance args))))

(send-to (make Point 1 2) :shift -2 -3)


