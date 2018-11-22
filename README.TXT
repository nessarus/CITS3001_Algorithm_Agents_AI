------------------------------------------------------------------------
Knapsack, Mancala, Wordchess
------------------------------------------------------------------------
Knapsack, Mancala, Wordchess are various projects attempting solve problems 
in order to demonstrate core concepts in search algorithms and AI.

------------------------------------------------------------------------
Project: Knapsack
------------------------------------------------------------------------
KnapsackImp.java implements Knapsack. Knapsack is an interface for the 
the 0-1 knapsack problem. KnapsackImp is an attempt to demonstrate 
optimisations in search algorithms, namely dynamic programming. 

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
Project: WordChess
------------------------------------------------------------------------
WordChessImp implements WordChess. WordChess is an interface for solving
the word puzzle "word chess". WordChess is an attempt to demonstrate 
a uniformed search algorithm, breath first search. 

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
Project: Mancala
------------------------------------------------------------------------
MancalaImp is an implimentation of MancalaAgent. 
MancalaImp constructs a computer player AI to play the game Mancala.
It uses minimax and alpha-beta pruning game-playing techniques to search 
for good moves.

References: http://teaching.csse.uwa.edu.au/units/CITS3001/lectures/lectures/07GamePlaying.pdf

HOW TO START THIS PROJECT:
Compile and run. The program will play a random move player vs MancalaImp.
------------------------------------------------------------------------

------------------------------------------------------------------------
CITS3001 Algorithms, Agents and Artificial Intelligence
------------------------------------------------------------------------
Knapsack, Mancala, Wordchess are student projects from the course CITS3001 
Algorithms, Agents and Artificial Intelligence in the University of Western Australia.

References: 
Unit Co-ordinator: Tim French
website: http://teaching.csse.uwa.edu.au/units/CITS3001/
------------------------------------------------------------------------
