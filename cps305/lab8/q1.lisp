(defstruct (tree-node (:conc-name nil))
  key
  (lc nil)
  (rc nil))

(defun BTREE-COUNT-NODES (root)
  (if (null root)
      0
      (+ 1
         (BTREE-COUNT-NODES (lc root))
         (BTREE-COUNT-NODES (rc root)))))