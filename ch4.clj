(def make (fn [className & args] (apply className args)))

(def Point
  (fn [x y]
    {
     ;; instance values
     :x x
     :y y

     ;; metadata
     :__class_symbol__ 'Point
     :__methods__ {
                   :class :__class_symbol__
                   :x (fn [this] (:x this))
                   :y (fn [this] (:y this))
                   :shift (fn [this xinc yinc]
                            (make Point
                                  (+ (:x this) xinc)
                                  (+ (:y this) yinc)))}}))


(def point (make Point 4 4))

(def send-to
  (fn [object message & args]
    (apply (message (:__methods__ object)) object args)))




(:__methods__ point)

(send-to point :shift 4 3)



(apply + 1 [ 2 3 ])
(apply + 4 [ 2 3 1])
(apply + 1 2 [3])


