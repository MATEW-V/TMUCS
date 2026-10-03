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
  (cond 
    ((< n 50) 'FAIL)
    ((and (>= n 50) (<= n 89)) 'PASS)
    ((>= n 90) 'EXCELLENT))
  )

(defun CALCULATE-DELIVERY-FEE (d b)
  (cond
    ((and (<= d 5) b) 3)
    ((and (<= d 5) (not b)) 5)
    ((and (> d 5) b) 8)
    ((and (> d 5) (not b)) 10)
    )
  )

(defun IN-BOUNDS-P (val low high)
  (if (and (> val low) (< val high))
      T
      nil)
)

(defun COMPUTE-PAYMENT (h r q)
  (cond 
    ((eq q 'STANDARD) (* h r))
    ((eq q 'OVERTIME) (* h r 1.5))
    ((eq q 'BONUS) (+ (* h r) 50))
    (t 0))
  )

(defun PROCESS-TRANSACTION (b a q)
  (cond 
    ((eq q 'DEPOSIT) (+ b a))
    ((eq q 'WITHDRAW) 
      (if (>= b a) 
          (- b a)
          (+ b 0)))
    (t b)
    ))

;lab 2 prac 
(defun LIST-SUM (lst &OPTIONAL (res 0)) 
  (if (null lst)
      res
      (LIST-SUM (cdr lst) (+ res (car lst))))
  )

(defun COUNT-ODD-NUMBERS (lst &OPTIONAL (acc 0))
  (if (null lst)
      acc
      (if (oddp (car lst))
          (COUNT-ODD-NUMBERS (cdr lst) (incf acc))
          (COUNT-ODD-NUMBERS (cdr lst) acc)))
  )

(defun KEEP-EVENS (x)
  (if (null x)
      nil
      (if (oddp (car x))
          (KEEP-EVENS (cdr x))
          (cons (car x) (KEEP-EVENS(cdr x)))))
  )

(defun PAIRWISE-SUM (l1 l2)
  (if (null l1)
      nil
      (cons (+ (car l2)(car l1)) (PAIRWISE-SUM (cdr l1) (cdr l2))))
  )

(defun COUNT-ATOMS (x &OPTIONAL (acc 0)) ;hastag genius remeber ts its gonan be on the practicum i bet
  (if (equalp (car x) nil)
      acc
      (if (consp (car x))
           (COUNT-ATOMS (append (car x) (cdr x)) acc)
           (COUNT-ATOMS (cdr x) (incf acc))))
  )

;lab3 prac

; (load "cps305/prac.lisp")