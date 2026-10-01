; (load "cps305/prac.lisp")

(defun my-function (x y)
  (+ x y))

;lab 0 prac
(defun CELSIUS-TO-FAHRENHEIT (c)
  (+ 32 (* (/ 9 5) c))
  )

(defun HYPOTENUSE-SQUARED (a b)
  (+ (* a a) (* b b))
  )

(defun IN-RANGE-P (val low high)
  (if (and (>= val low) (<= val high))
      T
      nil)
)

(defun ABSOLUTE-DIFFERENCE (f q)
  (- (max f q) (min f q))
  )

;lab 1 prac
(defun EVALUATE-SCORE (n)
  
  )