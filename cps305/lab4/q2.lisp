(defun CREATE-CUBE-ARRAY (s)
    (let ((arr (make-array s)))
        (dotimes (i s arr)
            (setf (aref arr i) (* i i i)))))

