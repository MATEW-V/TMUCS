(defun COUNT-EXPENSIVE-ITEMS (price-ht min-price)
  (let ((count 0))
    (maphash (lambda (item price) 
               (declare (ignore item))
               (when (> price min-price)
                 (incf count)))
             price-ht)
    count))

