(defun FILTER-STACK (pred stk)
  (let ((res nil)
        (stkarr (aref stk 0)))
    (dotimes (i (length stkarr) res)
      (let ((elem (aref stkarr i)))
        (if (funcall pred elem)
            (push elem res))))))
  
;(load "/home/matew/GITHUB/TMUCS/cps305/lab6/q3.lisp")