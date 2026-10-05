(defun GENERATE-SQUARES (n)
  (let (res)
    (dotimes (i n (reverse res))
      (push (* (+ 1 i) (+ 1 i)) res))))

(defun FIBONACCI-ITERATIVE (x)
  (do ((curr 0 (+ prev curr))
       (prev 1 curr)
       (count 0 (+ 1 count)))
((equalp count x) curr)))

(defun FIND-FIRST (lst n f)
  (dolist (i lst)
    (if (funcall f i n)
        (return i))))

(defun RUNNING-SUM (a)
  (let* ((sum 0) 
         res)
    (dolist (n a (reverse res))
      (push (+ sum n) res)
      (setf sum (+ sum n)))))

(defun PAIRWISE-MAX (a b)
  (do ((res)
       (ra a (cdr ra))
       (rb b (cdr rb)))
((null rb) (reverse res))
    (push (max (car ra) (car rb)) res)))

(defun LIST-SUM (x &OPTIONAL (sum 0))
  (if (null x)
      sum
      (LIST-SUM (cdr x) (setf sum (+ sum (car x))))))

(defun COUNT-ODD-NUMBERS (lst &OPTIONAL (count 0))
  (if (null lst)
      count
      (if (oddp (car lst))
          (COUNT-ODD-NUMBERS (cdr lst) (incf count))
          (COUNT-ODD-NUMBERS (cdr lst) count))))

(defun KEEP-EVENS (lst &OPTIONAL res)
  (if (null lst)
      (reverse res)
      (if (evenp (car lst))
          (KEEP-EVENS (cdr lst) (push (car lst) res))
          (KEEP-EVENS (cdr lst) res))))

(defun PAIRWISE-SUM (q f &OPTIONAL res)
  (if (null q)
      (reverse res)
      (PAIRWISE-SUM (cdr q) (cdr f) (push (+ (car q) (car f)) res))))

(defun COUNT-ATOMS (lst &OPTIONAL (count 0))
  (if (null lst)
      count
      (if (consp (car lst))
          (COUNT-ATOMS (append (cdr lst) (car lst)) count)
          (COUNT-ATOMS (cdr lst) (incf count)))))
;(load "cps305/lastmin.lisp")