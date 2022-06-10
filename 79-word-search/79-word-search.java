class Solution {
    int row,col;
    
    public boolean exist(char[][] board, String word) {
        row = board.length;
        col = board[0].length;
        
        for(int i = 0; i<row;i++) {
            for(int j = 0;j<col;j++) {
                if(board[i][j] == word.charAt(0) && dfs(i,j, 0 , word, board))
                    return true;
            }
        }
        return false;
    }
    
    public boolean dfs(int i, int j, int count, String word, char[][] board) {
        if(count == word.length())
            return true;

        if(i<0 || j<0 || i>=row || j>=col || word.charAt(count) != board[i][j]) // Edge Cases
            return false;
            
        char temp = board[i][j];
        board[i][j] = '*';
        boolean found = (dfs(i+1, j, count+1, word, board) || dfs(i-1, j, count+1, word, board) ||
                         dfs(i, j-1, count+1, word, board) || dfs(i, j+1, count+1, word, board));
        board[i][j] = temp;
        return found;
    }
}