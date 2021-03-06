/**
 * CrosswordSolver.java
 *
 * @author David Roazen
 *
 * A program that uses a recursive backtracking strategy to solve
 * a crossword puzzle. The actual recursive method is called
 * fillPuzzle().
 */

import java.awt.Point;

public class CrosswordSolver {

    // INSTANCE VARIABLES:
    
    // The current state of the crossword puzzle, including
    // blank squares, solid squares, and any letters we've added:
    private char[][] puzzle;
    
    // A collection of CrosswordSpace objects, each of which
    // represents a "slot" in the puzzle (like "1 Across" or
    // "2 Down"):
    private CrosswordSpace[] slots;
    
    // The words we're trying to put in the crossword puzzle.
    // Each word is encapsulated within a CrosswordWord object,
    // which also keeps track of whether or not the word has
    // already been used:
    private CrosswordWord[] words;
    
    // This array keeps track of how many words are currently
    // using each letter in the puzzle -- this is needed so
    // that we can know which letters to actually remove from
    // the puzzle when we remove a word:
    private int[][] letterUsage;
    
    // Counts the number of backtracks the algorithm performs:
    private int numBacktracks;
    
    
    // CONSTANTS: characters used for blank and solid squares
    //            in the puzzle:
    public static final char BLANK = ' ';
    public static final char FILLED = '#';
    
    
    /**
     * CrosswordSolver()
     * 
     * The constructor simply stores references to the puzzle
     * array, slots array, and words array in the instance
     * variables.
     */
    public CrosswordSolver ( char[][] puzzle, CrosswordSpace[] slots,
                             CrosswordWord[] words ) {
        this.puzzle = puzzle;
        this.slots = slots;
        this.words = words;                  
    }
    
    /**
     * reinitialize()
     *
     * Resets the solver to prepare for a fresh call to solve()
     * by zeroing out the letterUsage array and numBacktracks
     * variable.
     */
    private void reinitialize() {
        letterUsage = new int[puzzle.length][puzzle[0].length]; 
        numBacktracks = 0;     
    }
    
    /**
     * solve()
     *
     * A public "wrapper" method for the actual recursive method,
     * fillPuzzle(). Resets the state of the solver by calling
     * reinitialize(), then makes the first call to fillPuzzle(),
     * passing in 0 to tell it to start at the first slot (slot
     * number 0). Once the recursion is finished, checks the
     * return value to determine whether or not a solution was
     * found.
     */
    public void solve() {
        reinitialize();
        
        if ( fillPuzzle(0) ) {
            System.out.println("Solution found!");
            System.out.println("Backtracks: " + numBacktracks);
        }
        else {
            System.out.println("No solution found!");
        }
    }
    
    /**
     * fillPuzzle()
     *
     * Our recursive backtracking algorithm for solving the crossword
     * puzzle. For each slot in the slots array, tries to find an
     * UNUSED word from the words array that fits. If no such word
     * is found, or all the words it's tried lead to backtracks,
     * returns false to backtrack to the previous call and tell it
     * to choose a different word. If we've filled every slot, we
     * print the solution and return true, which causes every other
     * call to also return true, bringing us back to the solve()
     * wrapper method.
     */
    private boolean fillPuzzle ( int slot ) {
    
        // If we've filled every slot, slot will be equal to
        // the length of the slots array. In that case, we are
        // done, so we print the solution and return true to
        // tell all the previous calls to also return true:
    
        if ( slot == slots.length ) {
            printPuzzle();
            return true;
        }
             
        // Consider each word from the words array as a potential
        // fit for the current slot:
           
        for ( CrosswordWord word : words ) {
        
            // If the word is UNUSED and fits in the slot given
            // its length and the letters already there from other
            // words, we place the word in the slot (marking it
            // USED in the process), and make a recursive call to
            // fill the next slot. If that call backtracks (returns
            // false), we remove the word from the slot and choose
            // a different one:
            
            if ( wordFitsInSlot(word, slots[slot]) ) {
                putWordInSlot(word, slots[slot]);
                
                if ( fillPuzzle(slot + 1) ) {
                    return true;
                }
                
                removeWordFromSlot(word, slots[slot]);
            }
        }
        
        // If we get here, we've tried every word in the words
        // array for this slot, and all have either not fit or 
        // lead to backtracks, so we need to backtrack as well by 
        // returning false to tell the previous call to choose a 
        // different word:
        
        numBacktracks++;
        return false;
    }

    /**
     * wordFitsInSlot()
     *
     * Returns true if the word passed to it fits into the slot
     * passed to it AND is unused, otherwise returns false.
     */
    private boolean wordFitsInSlot ( CrosswordWord w, CrosswordSpace slot ) {
    
        // If the length of the word doesn't match the length of the
        // slot, or the word is already used, we can't put this word
        // here and so we return false:
        
        if ( w.getWord().length() != slot.getLength() || w.isUsed() ) {
            return false;
        }
        
        // Otherwise we examine each position in the slot. If
        // there are letters in the slot already, and those letters
        // DON'T match the letters at the corresponding positions
        // in our word, the word won't fit and we return false:
        
        Point position = new Point(slot.getStart());
        
        for ( int i = 0; i < slot.getLength(); i++ ) {
            
            if ( puzzle[position.x][position.y] != BLANK &&
                 puzzle[position.x][position.y] != w.getWord().charAt(i) ) {
                return false;    
            }
            
            // Advance to the next position in the slot:
            
            position.x += slot.getDirection().x;
            position.y += slot.getDirection().y;
        }
        
        // If we get here, it means the word is unused, the right
        // length for the current slot, and its letters match any
        // letters already in the slot:
        
        return true;
    }
    
    /**
     * putWordInSlot()
     *
     * Puts each letter from the word it's passed into the slot 
     * it's passed, and marks the word USED. Also increments the
     * positions in the letterUsage array corresponding to the
     * slot to indicate that one more word is now using these
     * letters.
     */
    private void putWordInSlot ( CrosswordWord w, CrosswordSpace slot ) {
        Point position = new Point(slot.getStart());
             
        for ( int i = 0; i < slot.getLength(); i++ ) {         
        
            // Put each letter from the word into this slot of
            // the puzzle:
            
            puzzle[position.x][position.y] = w.getWord().charAt(i);
            
            // Record the fact that one more word is now using the
            // letter at this position:
            
            letterUsage[position.x][position.y]++;
            
            // Advance to the next position in the slot:
            
            position.x += slot.getDirection().x;
            position.y += slot.getDirection().y;
        }
        
        // Mark the word as USED:
        
        w.setUsed(true);
    }
    
    /**
     * removeWordFromSlot()
     *
     * Clears each position in the slot it's passed, but ONLY
     * those positions containing letters NOT used by any other
     * words according to the letterUsage array. Also marks
     * the word that used to be in the slot as UNUSED.
     */
    private void removeWordFromSlot ( CrosswordWord w, CrosswordSpace slot ) {
        Point position = new Point(slot.getStart());
        
        for ( int i = 0; i < slot.getLength(); i++ ) { 
        
            // One fewer word is now using the letter at this position:
            
            letterUsage[position.x][position.y]--;
                       
            // If no words are now using this letter, clear it:
            
            if ( letterUsage[position.x][position.y] == 0 ) {                                      
                puzzle[position.x][position.y] = BLANK;
            }
            
            // Advance to the next position in the slot:
            
            position.x += slot.getDirection().x;
            position.y += slot.getDirection().y;
        }
        
        // Mark the word as UNUSED -- ie., available to be placed 
        // elsewhere in the puzzle:
            
        w.setUsed(false);
    }
    
    /**
     * printPuzzle()
     *
     * Outputs the current state of the crossword puzzle.
     */  
    public void printPuzzle() {
        printPuzzleBorder();
        
        for ( int row = 0; row < puzzle.length; row++ ) {
            System.out.print("|");
            for ( int col = 0; col < puzzle[row].length; col++ ) {
                System.out.print(puzzle[row][col] + "|");
            }
            System.out.println();
        }
              
        printPuzzleBorder();
        
        System.out.println();
    }
    
    /**
     * printPuzzleBorder()
     *
     * Helper method for printPuzzle() that prints the border at
     * the top and bottom of the puzzle output.
     */
    private void printPuzzleBorder() {
        for ( int i = 0; i < puzzle[0].length * 2 + 1; i++ ) {
            System.out.print("-");
        }
        System.out.println();    
    }
    
    /**
     * main()
     *
     * Creates a crossword puzzle and passes it in to our solver
     * to solve!
     */
    public static void main ( String[] args ) {
    
        // The crossword puzzle itself before any words have been
        // put into it:
        
        char[][] smallPuzzle = {
           { BLANK, BLANK, BLANK, FILLED, BLANK, BLANK, BLANK, BLANK, BLANK },
           { BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, FILLED, BLANK },
           { BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK },
           { BLANK, BLANK, BLANK, BLANK, BLANK, FILLED, BLANK, BLANK, BLANK },
           { FILLED, BLANK, BLANK, BLANK, FILLED, BLANK, BLANK, BLANK, FILLED },
           { BLANK, BLANK, BLANK, FILLED, BLANK, BLANK, BLANK, BLANK, BLANK },
           { BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK },
           { BLANK, FILLED, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK, BLANK },
           { BLANK, BLANK, BLANK, BLANK, BLANK, FILLED, BLANK, BLANK, BLANK }
        };
        
        // A collection of objects describing the location, direction,
        // and length of each slot in the crossword puzzle:
        
        CrosswordSpace[] slots = {
            new CrosswordSpace(new Point(0, 0), new Point(1, 0), 4),
            new CrosswordSpace(new Point(0, 6), new Point(1, 0), 9),
            new CrosswordSpace(new Point(0, 4), new Point(0, 1), 5),
            new CrosswordSpace(new Point(4, 1), new Point(0, 1), 3),
            new CrosswordSpace(new Point(3, 6), new Point(0, 1), 3),
            new CrosswordSpace(new Point(0, 4), new Point(1, 0), 4),
            new CrosswordSpace(new Point(0, 5), new Point(1, 0), 3),
            new CrosswordSpace(new Point(1, 0), new Point(0, 1), 7),
            new CrosswordSpace(new Point(1, 3), new Point(1, 0), 4),
            new CrosswordSpace(new Point(2, 7), new Point(1, 0), 7),
            new CrosswordSpace(new Point(5, 4), new Point(0, 1), 5),
            new CrosswordSpace(new Point(7, 2), new Point(0, 1), 7),
            new CrosswordSpace(new Point(5, 8), new Point(1, 0), 4),
            new CrosswordSpace(new Point(5, 0), new Point(0, 1), 3),
            new CrosswordSpace(new Point(0, 2), new Point(1, 0), 9),
            new CrosswordSpace(new Point(3, 0), new Point(0, 1), 5),
            new CrosswordSpace(new Point(4, 5), new Point(0, 1), 3),
            new CrosswordSpace(new Point(5, 4), new Point(1, 0), 4),
            new CrosswordSpace(new Point(2, 0), new Point(0, 1), 9),
            new CrosswordSpace(new Point(0, 1), new Point(1, 0), 7),
            new CrosswordSpace(new Point(6, 3), new Point(1, 0), 3),
            new CrosswordSpace(new Point(8, 6), new Point(0, 1), 3),
            new CrosswordSpace(new Point(4, 5), new Point(1, 0), 4),
            new CrosswordSpace(new Point(0, 8), new Point(1, 0), 4),
            new CrosswordSpace(new Point(5, 0), new Point(1, 0), 4),
            new CrosswordSpace(new Point(0, 0), new Point(0, 1), 3),
            new CrosswordSpace(new Point(8, 0), new Point(0, 1), 5),
            new CrosswordSpace(new Point(6, 0), new Point(0, 1), 9)
        };
        
        // The words we will try to fit into the crossword puzzle:
        
        CrosswordWord[] words = {
            new CrosswordWord("AEROSPACE"),
            new CrosswordWord("ALCHEMY"),
            new CrosswordWord("AYATOLLAH"),
            new CrosswordWord("BAA"),
            new CrosswordWord("BALD"),
            new CrosswordWord("BEFIT"),
            new CrosswordWord("BEST"),
            new CrosswordWord("BMP"),
            new CrosswordWord("BOMB"),
            new CrosswordWord("COMPOTE"),
            new CrosswordWord("DWEEB"),
            new CrosswordWord("ELEGIAC"),
            new CrosswordWord("EST"),
            new CrosswordWord("GIST"),
            new CrosswordWord("GOLIATH"),
            new CrosswordWord("HAL"),
            new CrosswordWord("HELP"),
            new CrosswordWord("NEED"),
            new CrosswordWord("POD"),
            new CrosswordWord("SCAPAFLOW"),
            new CrosswordWord("SCRIMMAGE"),
            new CrosswordWord("THEY"),
            new CrosswordWord("THOSE"),
            new CrosswordWord("TIME"),
            new CrosswordWord("TOE"),
            new CrosswordWord("TYSON"),
            new CrosswordWord("WHY"),
            new CrosswordWord("YAM")
        };
        
        // Pass all of the above into a new CrosswordSolver object:
        
        CrosswordSolver s = new CrosswordSolver(smallPuzzle, slots, words);
        
        // Print out the initial state of the puzzle:
        
        System.out.println("The puzzle looks like:");
        s.printPuzzle();
        
        // And solve it!
        
        s.solve();
    }
}

// HELPER CLASSES:

/**
 * CrosswordSpace
 *
 * A helper class to represent a slot in the Crossword puzzle. Contains
 * instance variables describing the start location, direction, and
 * length of the slot:
 */
class CrosswordSpace {
    private Point start;
    private Point direction;
    private int length;
        
    public CrosswordSpace ( Point start, Point direction, int length ) {
        this.start = start;
        this.direction = direction;
        this.length = length;
    }
    
    public Point getStart() {
        return start;
    }
    
    public Point getDirection() {
        return direction;
    }
    
    public int getLength() {
        return length;
    }
}

/**
 * CrosswordWord
 *
 * Another helper class to represent a word that we're trying to place
 * into the puzzle. Stores the text of the word itself plus a flag
 * indicating whether or not the word is in use:
 */
class CrosswordWord {
    private String word;
    private boolean used;
        
    public CrosswordWord ( String word ) {
        this.word = word;
        used = false;
    }
    
    public String getWord() {
        return word;
    }
    
    public boolean isUsed() {
        return used;
    }
    
    public void setUsed ( boolean isUsed ) {
        used = isUsed;
    }
}
