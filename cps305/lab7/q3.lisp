(defun TREE-SUM-EVEN-NODES (tree &OPTIONAL (sum 0))
  (if (null tree)
      sum
      (if (consp (car tree))
          (TREE-SUM-EVEN-NODES (append (car tree) (cdr tree)) sum)
          (if (evenp (car tree))
              (TREE-SUM-EVEN-NODES (cdr tree) (setf sum (+ sum (car tree))))
              (TREE-SUM-EVEN-NODES (cdr tree) sum)))))

;(load "/home/matew/GITHUB/TMUCS/cps305/lab7/q3.lisp")