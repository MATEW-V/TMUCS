def passwordChange(pass1,pass2):
    if len(pass1) < 8:
        return False
    elif pass1.islower() or pass1.isupper():
        return False
    elif any(char.isdigit() for char in pass1) == False:
        return False
    else:
        return True

print("Enter your password: ")
pass1 = input()
print("Re-enter your password: ")
pass2 = input()
if pass1!=pass2:
    print("Passwords do not match")
elif passwordChange(pass1,pass2):
    print("Password changed successfully")
else:
    print("Password not complex enough")
