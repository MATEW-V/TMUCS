#|
Write a function called RUNNING-PRODUCT that takes a list of 
numbers lst as an argument. The function must use a DOLIST loop
to return a new list of the same length where each element is 
the cumulative product of all numbers up to that index in the 
input list. If lst is empty, return (). 
|#

(defun RUNNING-PRODUCT (x)
  (let* (
         (res)
         (acc 1))
    (dolist (num x (nreverse res))
      (setf acc (* acc num)) 
      (push acc res)))
)

;(load "cps305/lab3/q2.lisp")