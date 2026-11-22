(defstruct (tree-node (:conc-name nil))
  key
  (lc nil)
  (rc nil))

(defun BTREE-SUM-EVEN-KEYS (root)
  (if (null root)
      0
      (+ (if (evenp (key root)) 
             (key root) 0)
         (BTREE-SUM-EVEN-KEYS (lc root))
         (BTREE-SUM-EVEN-KEYS (rc root)))))