(defun PAIRWISE-SUM (x y)
    (do ((res)
         (rx x (cdr rx))
         (ry y (cdr ry)))
  ((or (null ry) (null rx)) (nreverse res))
      (push (+ (car rx) (car ry)) res))
  )

;(load "cps305/lab3/q3.lisp")