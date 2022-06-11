class Trie {
    
    class Node {
         Node[] links = new Node[26];
         boolean flag;
        
        public  boolean containsLink(char ch) {
            return (!(links[ch-'a'] == null));
        }
        
        public  void setLink(char ch, Node node) {
            links[ch-'a'] = node;
        }
        
        public  Node getLink(char ch) {
            return links[ch-'a'];
        }
        
        public  void setEnd() {
            flag = true;
        }
        
        public  boolean containsWord() {
            return (flag == true);
        }
        
        
    }

    private Node root;
    
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;
        for(int i = 0 ; i<word.length(); i++) {
            char c = word.charAt(i);
            if(!node.containsLink(c))
                node.setLink(c, new Node());
            node = node.getLink(c);
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        Node node = root;
        for(int i = 0 ; i<word.length(); i++) {
            char c = word.charAt(i);
            if(!node.containsLink(c))
                return false;
            node = node.getLink(c);
        }
        return node.containsWord();
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;
        for(int i = 0 ; i<prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(!node.containsLink(c))
                return false;
            node = node.getLink(c);
        }
        return true; 
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */