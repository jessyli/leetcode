public class Solution {
    public void gameOfLife(int[][] board) {
        //state 2: die to die;
        //state 3: live to die;
        //state 4: live to live;
        //state 5: die to live;
        if(board.length==0&&board[0].length==0){
            return;
        }
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int live = getlivenum(i, j, board, m, n);
                if(live<2 && board[i][j]==1){
                    board[i][j]=3;
                }
                else if((live==2 || live==3) && board[i][j]==1){
                    board[i][j]=4;
                }
                else if(live>3 && board[i][j]==1){
                    board[i][j]=3;
                }
                else if(board[i][j]==0 && live==3){
                    board[i][j]=5;
                }
                else{
                    board[i][j] = 2;
                }
                
            }
        }
         for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]==2 || board[i][j]==3){
                    board[i][j]=0;
                }
                else{
                    board[i][j]=1;
                }
                
            }
         }
        
    }
    
    public int getlivenum(int i, int j, int[][] board, int m, int n){
        int live = 0;
        for(int a=-1; a<2; a++){
            for(int b=-1; b<2; b++){
                int newi = i+a;
                int newj = j+b;
                
                if(newi==i&&newj==j){
                    continue;
                }
                if(newi>=0 && newj>=0 && newi<m && newj<n){
                    System.out.println(newi);
                    System.out.println(newj);
                    if(board[newi][newj]==1 || board[newi][newj]==3 || board[newi][newj]==4){
                        live++;
                    }
                }
            }
        }
        return live;
    }
}
