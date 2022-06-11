/* Solution 2
Trie Based DFS Search
*/


class Solution {
    private static Trie root;
    private int row;
    private int col;
    private List<String> ans;
    
    public Solution() {
        root = new Trie();
    }
    
    class Trie {
        Trie[] link = new Trie[26];
        boolean end_here = false;
        
        public boolean containsLink(char ch) {
            return (link[ch-'a'] != null);
        }
        
        public void setLink(char ch, Trie trie) {
            link[ch-'a'] = trie;
        }
        
        public Trie getLink(char ch) {
            return link[ch-'a'];
        }
        
        public void setEnd(){
            end_here = true;
        }
        
        public boolean containsWord(){
            return (end_here == true);
        }
                
    }
    
    public void insertWord(String word) {
        Trie node = root;
        char c;
        for(int i = 0; i<word.length(); i++) {
            c = word.charAt(i);
            if(!node.containsLink(c))
                node.setLink(c, new Trie());
            node = node.getLink(c);
        }
        node.setEnd();
    }
    
    public boolean dfs(char[][] board, int i , int j, Trie node, String word) {
        if(node.containsWord()) {
            if(!ans.contains(word))
                ans.add(word);
         if(i>=0 && j>=0 && i<row && j<col && board[i][j]!='*' && !node.containsLink(board[i][j]))
             return true;             
        }
        
        if(i<0 || j<0 || i>= row || j>=col || board[i][j]=='*' || !node.containsLink(board[i][j]))
            return false;

        
        node = node.getLink(board[i][j]);
        char temp = board[i][j];
        board[i][j] = '*';
        word = word + temp;
        boolean found = dfs(board, i+1, j, node, word);
            found = dfs(board, i-1, j, node, word) || found;
            found = dfs(board, i, j-1, node, word) || found;
            found = dfs(board, i, j+1, node, word) || found;
        board[i][j] = temp;
        
        return found;
    }
    
    
    
    public List<String> findWords(char[][] board, String[] words) {
        ans = new ArrayList<String>();
        row  = board.length;
        col = board[0].length;
        
        for(String word : words) {
            insertWord(word);
        }
        Trie node = root;
        
        for(int i = 0; i<row ;i++) {
            for(int j = 0; j <col ;j++) {
                if(node.containsLink(board[i][j]))
                    dfs(board, i , j , node, "");                    
            }
        }
         return ans;
        }
    }

/*
Solution - 1
Brute Force DFS Technique
Time Limit Exceed for bigger test cases


class Solution {
    
    int row;
    int col;   
        public boolean findWord(char[][] board, String word) {
            for(int i = 0; i<row; i++) {
                for(int j = 0; j<col; j++) {
                    if(board[i][j] == word.charAt(0) && dfs(i,j,0,word,board))
                        return true;
                }
            }
            return false;
    }
    
    
    public boolean dfs(int i , int j, int count, String word, char[][] board) {
        if(count == word.length())
            return true;
        if(i < 0 || j <0 || i >= row || j>=col || word.charAt(count) != board[i][j])
            return false;
        char temp = board[i][j];
        board[i][j] = '*';
        boolean found = (dfs(i+1,j,count+1,word,board) || dfs(i-1,j,count+1,word,board) ||
            dfs(i,j+1,count+1,word,board) || dfs(i,j-1,count+1,word,board));
        board[i][j] = temp;
        return found;       
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        row = board.length;
        col = board[0].length;
        List<String> ans = new ArrayList<String>();
        for(String word: words) {
            if(findWord(board,word))
                ans.add(word);
        }
            return ans;
    }
}


*/