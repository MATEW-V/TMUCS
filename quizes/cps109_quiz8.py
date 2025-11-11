def next_item(iter):
    try:
        return next(iter)
    except:
        return None
    