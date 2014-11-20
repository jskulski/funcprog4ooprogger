(def Point
  (fn [x y]
    {:x x
     :y y
     :__class_symbol__ 'Point }))

(def point (Point 3 4))
(def x (fn [this] (get this :x)))
(def y :y)

(def class-of :__class_symbol__)


(def shift (fn [this xinc yinc]
             (Point (+ (x this) xinc)
                    (+ (y this) yinc))))


(class-of point)
(x point)
(y point)

(shift point 4 40)
