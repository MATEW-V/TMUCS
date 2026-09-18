(defun EVALUATE-MEMBERSHIP (SCORE HASREF)
    (if (< SCORE 70)
        'DENIED
        (if HASREF
            'PREMIUM
            'REGULAR)))