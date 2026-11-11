(defun IS-FULL-P (stk)
  (let ((top-idx (aref stk 1))
        (max-size (aref stk 2)))
    (= top-idx (1- max-size))))