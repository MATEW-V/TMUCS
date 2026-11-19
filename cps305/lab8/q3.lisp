(defstruct (tree-node (:conc-name nil))
  key
  (lc nil)
  (rc nil))

(defun BTREE-COLLECT-INORDER (root &optional res)
  (if (null root)
      res
      (BTREE-COLLECT-INORDER (lc root)
        (cons (key root)
              (BTREE-COLLECT-INORDER (rc root) res)))))

;(load "cps305/lab8/q3.lisp")     