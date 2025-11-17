#comments paragrapgh

import os #need clearing terminal functions for presentability
def clear_terminal(): #clear cmd
    """Clears the terminal screen."""
    #windows
    if os.name == 'nt':
        _ = os.system('cls')
    #macOS and Linux
    else:
        _ = os.system('clear')

def display_menu():
    print('''    Welcome to my Sudoku Game on Terminal. 
    I recommend making the terminal larger.
    If unsure on how to play, please search up the rules.''')
    print('''    Select a difficulty or command (Num or CMD itself):
        1. Easy
        2. Medium
        3. Hard
        4. Times
        5. Exit''')

def show_main_screen():
    clear_terminal()
    display_menu()

def play_sudoku(difficulty):
    clear_terminal()
    print(f"=== {difficulty.upper()} SUDOKU ===")
    #SUDOKU TEMPLATES / data from Sudoku.com. Randomly Generated but still possible. Taken from "Medium", "Expert", "Extreme"
    #0 == blank space, each list is a row, each elem in said list is column
    board=[] 
    ans=[]
    possmoves={'A1','A2','A3','A4','A5','A6','A7','A8','A9',
               'B1','B2','B3','B4','B5','B6','B7','B8','B9',
               'C1','C2','C3','C4','C5','C6','C7','C8','C9',
               'D1','D2','D3','D4','D5','D6','D7','D8','D9',
               'E1','E2','E3','E4','E5','E6','E7','E8','E9',
               'F1','F2','F3','F4','F5','F6','F7','F8','F9',
               'G1','G2','G3','G4','G5','G6','G7','G8','G9',
               'H1','H2','H3','H4','H5','H6','H7','H8','H9',
               'I1','I2','I3','I4','I5','I6','I7','I8','I9'}
    if difficulty == "easy":
        board=[
        [0,0,6,0,0,0,3,0,0],
        [0,0,1,9,0,3,7,6,0],
        [4,7,3,0,0,0,8,0,0],
        [0,6,0,7,2,0,9,3,0],
        [3,4,0,5,0,0,0,7,8],
        [1,0,0,3,8,0,2,4,0],
        [0,8,0,2,0,1,4,0,0],
        [7,3,0,0,0,0,1,0,0],
        [0,1,9,4,0,7,5,0,0]]
        ans=[
        [9,2,6,1,7,8,3,5,4],
        [8,5,1,9,4,3,7,6,2],
        [4,7,3,6,5,2,8,1,9],
        [5,6,8,7,2,4,9,3,1],
        [3,4,2,5,1,9,6,7,8],
        [1,9,7,3,8,6,2,4,5],
        [6,8,5,2,3,1,4,9,7],
        [7,3,4,8,9,5,1,2,6],
        [2,1,9,4,6,7,5,8,3]]
    elif difficulty == "medium":
        board=[
        [0,0,6,4,0,0,3,0,8],
        [1,0,0,0,6,3,0,0,0],
        [3,4,0,9,2,8,0,0,1],
        [0,0,0,3,0,0,0,0,5],
        [0,0,5,2,0,4,0,9,0],
        [4,0,0,0,0,7,0,0,0],
        [8,7,0,5,4,0,0,1,0],
        [0,9,0,0,0,1,0,0,0],
        [0,0,0,0,0,0,0,8,4]]
        ans=[
        [9,2,6,4,1,5,3,7,8],
        [1,5,8,7,6,3,4,2,9],
        [3,4,7,9,2,8,5,6,1],
        [2,8,1,3,9,6,7,4,5],
        [7,3,5,2,8,4,1,9,6],
        [4,6,9,1,5,7,8,3,2],
        [8,7,2,5,4,9,6,1,3],
        [6,9,4,8,3,1,2,5,7],
        [5,1,3,6,7,2,9,8,4]]
    else: #hard, couldve elifed but it works
        board=[
        [6,0,9,7,5,1,0,0,0],
        [0,0,0,0,0,3,0,0,4],
        [0,0,0,0,0,0,0,0,0],
        [2,0,0,0,0,0,0,0,0],
        [0,0,8,0,6,7,0,0,0],
        [0,0,0,0,0,9,1,5,6],
        [1,5,0,2,0,0,4,0,0],
        [0,0,0,0,0,0,0,0,5],
        [7,0,0,0,0,0,0,6,0]]
        ans=[
        [6,4,9,7,5,1,2,8,3],
        [8,2,1,6,9,3,5,7,4],
        [0,0,0,0,0,0,0,0,0],
        [2,0,0,0,0,0,0,0,0],
        [0,0,8,0,6,7,0,0,0],
        [0,0,0,0,0,9,1,5,6],
        [1,5,0,2,0,0,4,0,0],
        [0,0,0,0,0,0,0,0,5],
        [7,0,0,0,0,0,0,6,0]]
    print("Game started! Fill in the 0s as if they were blank.")
    print("The game ends when the Sudoku table is complete.")

    while True:
        print("    A B C | D E F | G H I")
        line='-------------------------'
        x=''
        for i in range(len(board)):
            x="".join(str(board[i])).replace(",","").replace("[","").replace("]","")
            if i%3==0 and i>0:
                print(line)
            print(str(i+1)+" | "+x)

        # example display
        #     A B C | D E F | G H I
        # 1 | x x x | x x x | x x x
        # 2 | x x x | x x x | x x x
        # 3 | x x x | x x x | x x x
        # -------------------------
        # 4 | x x x | x x x | x x x etc
    
        command = input("Enter move(ex. A6 3) or 'quit' to go menu: ").strip().upper().replace(" ","")
        if command == "QUIT":
            break
        elif len(command)==3 and command[0]+command[1] in possmoves and command[2]!='0' and command[2].isdigit():
            clear_terminal()
            xdir=ord(command[0]) - 65  #ord() gives unicode values, A-Z in caps is 65 - 90 so offset 64
            ydir=int(command[1]) - 1#num row 
            uguess=int(command[2]) # elem in said row
            print(xdir,ydir,uguess) #input from user, check if matches
            check=ans[ydir][xdir]
            if check==uguess:
                print("correct")
                board[ydir][xdir]=uguess
            elif board==ans:
                print("win")
            else:
                print("incorrect")
        else:
            clear_terminal()
            print('invalid move or command')
        #ADD HINT / Solve next move or print useful strategies maybe
    print(f"Returning to main menu from {difficulty} mode...")

def main():
    show_main_screen()
    while True:
        user_input = input().strip().lower()
        match user_input:
            case "exit" | "5":
                print("Goodbye.")
                break
            case "easy" | "1":
                play_sudoku("easy")
                show_main_screen()  # Show menu only after quitting the game
            case "medium" | "2":
                play_sudoku("medium")
                show_main_screen()
            case "hard" | "3":
                play_sudoku("hard")
                show_main_screen()
            case "times" | "4":
                print("work in prog") #"read and write times of how long each one took"
            case _:
                print("Invalid Command. Try again")
                input("Press Enter to continue...")
                show_main_screen()

if __name__ == "__main__":
    main()