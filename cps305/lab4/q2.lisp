(defun CREATE-CUBE-ARRAY (s)
    (let ((arr (make-array s)))
        (dotimes (i s arr)
            (setf (aref arr i) (* i i i)))))

;(load "lab4-assign-v3/q2.lisp")