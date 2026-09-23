#|
Write a recursive function called PAIRWISE-DIFFERENCE that takes 
two lists of numbers of equal length and returns a new list where 
each element is the result of subtracting the element in the second 
list from the corresponding element in the first list. 
|#

(defun PAIRWISE-DIFFERENCE (a b)
    (if (null a) 
        NIL ;true
        (cons (- (first a) (first b)) ;false
            (PAIRWISE-DIFFERENCE(rest a) (rest b)
        ))))

;(load "~/cps305/lab2-assign-v3/q1.lisp")
;(PAIRWISE-DIFFERENCE (LIST 10 20 30) (LIST 1 2 3)) 