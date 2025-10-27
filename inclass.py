car = {"brand": "x", "model":"y", "year":"z"}

car.update({"color":"blue"})

car["year"]="2025"

del car["model"]

print(car)

animals=["cat","dog","cat","bird","dog","cat","fish"]

def animcount(list):
    count=0
    animdict={"cat":0,"dog":0,"bird":0,"fish":0}
    for i in list:
        if i == animdict[i]:
            animdict.update({i:count})
            count+=1
    return(animdict) #ts sucks fix it
print(animcount(animals))
