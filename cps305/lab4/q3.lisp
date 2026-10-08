(defun COLLECT-MULTIPLES-OF-THREE-DYNAMIC (lst)
    (let ((arr (make-array 0 :adjustable t :fill-pointer 0)))
        (dolist (i lst arr)
            (if (= (mod i 3) 0)
                (VECTOR-PUSH-EXTEND i arr)))))

;(load "lab4-assign-v3/q3.lisp")