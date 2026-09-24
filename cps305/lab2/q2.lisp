#|
Write a tail-recursive function called COUNT-NEGATIVES 
that takes a list of numbers as its argument and returns 
the count of strictly negative numbers (< 0) in the list. 
Maintain tail-recursion by using an auxiliary helper 
function with LABELS or an optional parameter. 
|#

(defun COUNT-NEGATIVES(x &optional (acc 0))
  (if (null x)
      acc
      (if (> 0 (car x))
           (COUNT-NEGATIVES (cdr x) (+ 1 acc))
           (COUNT-NEGATIVES (cdr x) acc)
           )))
