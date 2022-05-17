class Solution {
    public boolean isValidSudoku(char[][] board) {
        int x,y;

        for(int i = 0;i<9;i++){
            
        boolean[] columnCheck = new boolean[9];
        boolean[] rowCheck = new boolean[9];
        boolean[] gridCheck = new boolean[9];
            
            for(int j = 0;j<9;j++){
                //Column Check
                if(board[i][j]!='.') {
                    if(columnCheck[board[i][j]-'1'])
                        return false;
                    else 
                        columnCheck[board[i][j]-'1'] = true;
                    }
                //Row Check
                if(board[j][i]!='.') {
                    if(rowCheck[board[j][i]-'1'])
                        return false;
                    else 
                        rowCheck[board[j][i]-'1'] = true;
                }
                //Grid Check
                x = i/3*3 + j/3; 
                y = i%3*3 + j%3;  
                   if(board[x][y]!='.') { 
                    if(gridCheck[board[x][y]-'1'])
                        return false;
                    else 
                        gridCheck[board[x][y]-'1'] = true;
                }
            }
        }
        return true;
    }
}