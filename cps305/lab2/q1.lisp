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