Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
Each row must have the numbers 1-9 occuring just once.
Each column must have the numbers 1-9 occuring just once.
And the numbers 1-9 must occur just once in each of the 9 sub-boxes of the grid.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        //rule 1 column
         
        for (int i=0; i<board[0].length;i++){
         HashSet<Character> test = new HashSet<Character>();
          for (int j=0; j<board.length; j++){
              if(board[j][i]!='.' && test.contains(board[j][i])){
                  return false;}
                 else{ test.add(board[j][i]);}
              
           }
        }
       //rule 2 row
       
       for (int i=0; i<board.length;i++){
          HashSet<Character> test = new HashSet<Character>();
          for (int j=0; j<board[0].length; j++){
              if(board[i][j]!='.' && test.contains(board[i][j])){
                  return false;}
                 else { test.add(board[i][j]);}
              
           }
        }
        //9 subbox

        for(int i=0; i<board[0].length;i++){
            
            int col_offset = (i/3)*3;
         for(int j=0; j<board.length; j++){
             int row_offset = (j/3)*3;
             HashSet<Character> test = new HashSet<Character>();
             for(int z=col_offset; z<col_offset+3; z++){
                 
                 for(int t=row_offset; t<row_offset+3; t++){
                     if(board[z][t]!='.' && test.contains(board[z][t])){
                     return false;}
                    else{ test.add(board[z][t]);}
                 
             }
         }   
        }
        
        }
        return true;    
    }
}
