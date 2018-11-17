package mancala;
import java.io.*;
import java.util.*;

/**
 * Lab6: game-playing, MancalaImp is an implimentation of MancalaAgent.
 * Uses Minimax (and alpha-beta pruning, as appropriate) to construct a computer 
 * player for the game Mancala:
 * Resources: http://teaching.csse.uwa.edu.au/units/CITS3001/lectures/lectures/07GamePlaying.pdf
 *
 * @author Joshua Ng
 * @version 14/9/2018
 */
public class MancalaImp implements MancalaAgent
{
    private int MAX_DEPTH;
    private int[] actions;
    private int playerStore;
    private int enemyStore;
    
    /**
     * Constructor for objects of class MancalaImp
     */
    public MancalaImp()
    {
        MAX_DEPTH = 10;
        playerStore = 6;
        enemyStore = 13;
    }
    
    public class State {
        int[] board;
        int depth;
        boolean playerturn;
        int bestmove;
        
        public State(int[] b, int d, boolean t) 
        {
            board = b;
            depth = d;
            playerturn = t;
        }
        
        public void setMove(int a)
        {
            this.bestmove = a;
        }
    }
    
    public int move(int[] board)
    {
        actions = new int[]{0, 1, 2, 3, 4, 5};
        State s1 = new State(board, 0, true);
        maxvalue(s1, -10000, 10000);
        return s1.bestmove;
    }
    
    public int maxvalue(State s, int alpha, int beta)
    {
        int move = 0;
        if(terminal(s))
        {
            return utility(s);
        } else {
            int v = -10000;
            for(int a : actions) {
                if(s.board[a] == 0 ) {
                    continue;
                }
                v = Math.max(v, minvalue(result(s, a), alpha, beta));
                if(v >= beta) {
                    s.setMove(a);
                    return v;
                }
                alpha = Math.max(alpha, v);
                move = a;
            }
            s.setMove(move);
            return v;
        }
    }

    public int minvalue(State s, int alpha, int beta)
    {
        int move = 0;
        if(terminal(s))
        {
            return utility(s);
        } else {
            int w = 10000;
            for(int a : actions) {
                if(s.board[a] == 0 ) {
                    continue;
                }
                w = Math.min(w, maxvalue(result(s, a), alpha, beta));
                if(w <= alpha) {
                    s.setMove(a);
                    return w;
                }
                beta = Math.min(beta, w);
            }
            s.setMove(move);
            return w;
        }
    }
    
    public State result(State s, int a) {
        int[] board2 = s.board.clone();
        int seeds = board2[a];
        int destination = a+1;
        boolean turn = s.playerturn;
        if(s.playerturn) {
            for(int i = a; i<seeds; i++) {
                if(i == enemyStore) {
                    seeds++;
                } else {
                    board2[(i+1)%board2.length]++;
                }
                destination = (i+1)%board2.length;
            }
            if(destination != playerStore) {
                turn = !turn;
            }
            if(board2[destination] == 1 && destination < playerStore) {
                board2[playerStore] += board2[enemyStore-destination-1];
                board2[enemyStore-destination-1] = 0;
            }
        } else {
            for(int i = a; i<seeds; i++) {
                if(i == playerStore) {
                    seeds++;
                } else {
                    board2[(i+1)%board2.length]++;
                }
                destination = (i+1)%board2.length;
            }
            if(destination != enemyStore) {
                turn = !turn;
            }
            if(board2[destination] == 1 && destination > playerStore 
                && destination < enemyStore) {
                board2[enemyStore] += board2[enemyStore-destination-1];
                board2[enemyStore-destination-1] = 0;
            }
        }
        
        return new State(board2, s.depth+1, turn);
    }
    
    public boolean terminal(State s) {
        return s.depth == MAX_DEPTH;
    }
    
    public int utility(State s) {
        if(s.playerturn) {
            int sum = 0;
            for(int i=0; i<playerStore+1; i++) {
                sum = sum + s.board[i] - s.board[enemyStore-i];
            }
            return sum;
        } else {
            int sum = 0;
            for(int i=0; i<playerStore+1; i++) {
                sum = sum + s.board[enemyStore-i] + s.board[i] ;
            }
            return sum;
        }
    }
    
    public String name()
    {
        return "Josh";
    }
    
    public void reset()
    {
        return;
    }
}
