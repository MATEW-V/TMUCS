#|
Write a recursive function called KEEP-NEGATIVES 
that takes a list of numbers and returns a new list 
containing only the strictly negative numbers (< 0), 
preserving their original order. 
|#

(defun KEEP-NEGATIVES(x)
  (cond
    ((null x) nil)
    ((<= 0 (car x)) (KEEP-NEGATIVES (cdr x)))
    (t (cons (car x) (KEEP-NEGATIVES (cdr x))))
    )
)