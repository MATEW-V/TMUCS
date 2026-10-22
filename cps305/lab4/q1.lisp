(defun VECTOR-MAGNITUDE (lst)
    (let ((sum 0))
        (dolist (n lst (sqrt sum))
            (setf sum (+ sum (expt n 2))))))

