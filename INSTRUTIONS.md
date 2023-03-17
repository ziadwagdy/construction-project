# Guessing Game

    From the main menu the user chooses :
    
    Number 1 to Play the Guessing Numbers
        --> TODO except high score 
    
    Number 2 to Play the Guessing Alphabets
         --> TODO except high score 

    Number 3 to get the High score.
         --> TODO not done yet

    Number. 4 to display credits.
         --> TODO NOT YET 

    Number 5 to exit the game. 
        

    After choosing option 1, or 2 :- 

    --> How to be played: 
        first -#1 choosing level-,
            --> Random char or num is generated.
            --> tries are set to 0. 
            --> user chooses difficulity level 
            --> 
                1-> Easy 
                2-> Medium
                3-> Hard 
                4-> return to the main menu
                ...-> any other number : choose level again
        
        second, -level-,
            Easy, 
                -> user can play for 5 chances
                if the user enters a wrong guess: 
                    -> decrease chances and display number of chances 
                    -> display wrong guess with a hint (lower or higher)
                    -> increase number of tries; 
                else if user enters a correct guess
                    -> Display you won message  
                    -> Display number of tries. 
                    #-> TODO (Missing) increase high score. 
                    -> Return to choose difficulty level. 
            Medium, 
                -> user can play for 4 chances
                if the user enters a wrong guess: 
                    -> decrease chances and display number of chances 
                    -> display wrong guess without a hint
                    -> increase number of tries; 
                else if user enters a correct guess
                    -> Display you won message  
                    -> Display number of tries. 
                    #-> TODO (Missing) increase high score. 
                    -> Return to choose difficulty level. 
            Hard, 
                -> user can play for 3 chances
                if the user enters a wrong guess: 
                    -> decrease chances and display number of chances 
                    -> display wrong guess without a hint
                    -> increase number of tries; 
                else if user enters a correct guess
                    -> Display you won message  
                    -> Display number of tries. 
                    #-> TODO (Missing) increase high score. 
                    -> Return to choose difficulty level. 