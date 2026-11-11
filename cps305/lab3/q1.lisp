#|
Write a function called GENERATE-ODDS that takes a non-negative integer n
as an argument. The function should use a DOTIMES loop to generate a list 
containing the first n positive odd integers (starting from 1 up to 2n-1) . 
If is 0, return an empty list (). 
|#

(defun GENERATE-ODDS (x)
  (let (res)
    (dotimes (i x (reverse res))
      (push (+ (* 2 i) 1) res))))