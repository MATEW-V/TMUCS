(defun create-stack (max-cap)
  (vector (make-array max-cap) -1 max-cap))

(defun peek-element (stk)
  (let ((top-idx (aref stk 1))
        (arr (aref stk 0)))
    (if (= top-idx -1) 
        (error "empty")
        (aref arr top-idx))))