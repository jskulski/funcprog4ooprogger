(def point {:x 1, :y 2, :__class_symbol__ 'Point})

(def Point
     (fn [x y]
       {:x x,
        :y y
        :__class_symbol__ 'Point}))

(def x :x)
(def y :y)
(def class-of :__class_symbol__)

(def shift
     (fn [this xinc yinc]
       (Point (+ (x this) xinc)
              (+ (y this) yinc))))

(def Triangle
     (fn [point1 point2 point3]
       {:point1 point1, :point2 point2, :point3 point3
        :__class_symbol__ 'Triangle}))


(def right-triangle (Triangle (Point 0 0)
                              (Point 0 1)
                              (Point 1 0)))

(def equal-right-triangle (Triangle (Point 0 0)
                                    (Point 0 1)
                                    (Point 1 0)))

(def different-triangle (Triangle (Point 0 0)
                                  (Point 0 10)
                                  (Point 10 0)))



;;; exercises begin

(def add (fn [point1 point2]
           (Point (+ (x point1) (x point2))
                  (+ (y point1) (y point2)))))

(add (Point 10 2) (Point 4 5))


;;; new  / make

(def make (fn [className & args] (apply className args)))

(make Point 4 29)

(make Triangle
      (Point 0 0)
      (Point 0 1)
      (Point 1 0))


;; equal-triangles?
(def equal-triangles?
  (fn [triangle1 triangle2]
    (and
     (equal-points? (:point1 triangle1) (:point1 triangle2))
     (equal-points? (:point2 triangle1) (:point2 triangle2))
     (equal-points? (:point3 triangle1) (:point3 triangle2)))))

;; (def equal-triangles2?
;;   (fn [triangle1 triangle2]
;;     (and
;;      (map equal-points? '(:point1 :point2 :point3) (triangle1 triangle2)))))
;;
;; don't quite understand map/apply that sort of thing


(:point1 right-triangle)

(apply equal-triangles? (map :point2 [right-triangle different-triangle]))

(map [:point1 :point2 :point3] [right-triangle different-triangle])



(equal-triangles? right-triangle right-triangle)
(equal-triangles? right-triangle equal-right-triangle)
(equal-triangles? right-triangle different-triangle)

;; (equal-triangles2? right-triangle right-triangle)
;; (equal-triangles2? right-triangle equal-right-triangle)
;; (equal-triangles2? right-triangle different-triangle)

(def equal-points?
  (fn [point1 point2]
    (and (= (x point1) (x point2))
         (= (y point1) (y point2)))))

(equal-points? (Point 3 3) (Point 3 3))
(equal-points? (Point 3 3) (Point 3 4))

;;; dooooh
(def equal-triangles-simple? =)

(equal-triangles-simple? right-triangle equal-right-triangle)









