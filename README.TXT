------------------------------------------------------------------------
CITS3001 Algorithms, Agents and Artificial Intelligence
------------------------------------------------------------------------
CITS3001 reinforces key concepts from CITS2200 Data Structures and Algorithms 
and extends them to the context of autonomous programs, or agents. We introduce 
ideas such as decision-making, goal-directed behaviour, heuristic search, action 
selection, performance (self-)evaluation, expected return, and learning. These 
concepts are explored in the context of artificial intelligence or 'intelligent 
agents'.

References: 
Unit Co-ordinator: Tim French
website: http://teaching.csse.uwa.edu.au/units/CITS3001/
------------------------------------------------------------------------

------------------------------------------------------------------------
Lab 2: Optimisation Algorithms
------------------------------------------------------------------------
KnapsackImp.java implements Knapsack. Knapsack is an interface for the 
the 0-1 knapsack problem.
The value returned should be the maximum value of a combination of products 
with the given value and weight that can fit in a knapsack with the given 
capacity.
The products are not divisible so each must be wholly included, or entirely 
left out.
The returned value should be the maximum value it is possible to include 
in the knapsack. The arrays are assumed to be of equal size, and all 
non-negative values. 

HOW TO START THIS PROJECT:
See KnapsackMain for example of a Knapsack problem being solved. 
------------------------------------------------------------------------

------------------------------------------------------------------------
Lab 4: Uniformed Search Algorithms
------------------------------------------------------------------------
WordChessImp implements WordChess. WordChess is an interface for solving
the word puzzle "word chess".

Starting from an English word w, and changing only one letter at a time,
derive a second word w'. All intermediate stages must also be valid English
words.
So given e.g. SICK and WELL, one solution would be:
SICK, SILK, SILL, SELL, WELL

HOW TO START THIS PROJECT:
1. Compile wordchess using a java complier.
2. Put dictionary.txt as an argument.
3. Type in start word and end word. 
------------------------------------------------------------------------

------------------------------------------------------------------------
Lab 6: Game-playing
------------------------------------------------------------------------
MancalaImp is an implimentation of MancalaAgent. 
MancalaImp constructs a computer player AI to play the game Mancala.
It uses minimax and alpha-beta pruning to search for good moves.
References: http://teaching.csse.uwa.edu.au/units/CITS3001/lectures/lectures/07GamePlaying.pdf

HOW TO START THIS PROJECT:
Compile and run. The program will play a random move player vs MancalaImp.
------------------------------------------------------------------------
