(defun COUNT-TOTAL-NODES (tree &OPTIONAL (nodes 0))
  (if (null tree)
      nodes
      (if (consp (car tree))
          (COUNT-TOTAL-NODES (append (car tree) (cdr tree)) nodes)
          (COUNT-TOTAL-NODES (cdr tree) (incf nodes)))))
