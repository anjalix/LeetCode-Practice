class Solution {
    public int prefixCount(String[] words, String pref) {
        int prefLength = pref.length();
        int cnt = 0;
        for(String word : words) {            
            int wordLength = word.length();
            if(wordLength >= prefLength && word.substring(0,prefLength).equals(pref))
             cnt++;
        }
        return cnt;
    }
}


/*
class Solution {
    
    //Trie Based Approach
    
    static class Node{
        Node links[] = new Node[26];
        boolean flag = false;
        int cnt = 0;
        
        boolean containsKey(char ch) {
            return (links[ch-'a'] != null);
        }
        
        Node get(char ch) {
            return links[ch-'a'];
        }
        
        void put(char ch, Node node) {
            links[ch-'a'] = node;
        }
        
        void setEnd() {
            flag = true;
        }
        
        boolean isEnd() {
            return flag;
        }
    }
    
    private static Node root;

    static class Trie {
        
    public Trie() {
        root = new Node();
    }
    
    public static void insert(String word) {
        Node node = root;
        for(int i =0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(!node.containsKey(c)) {
                node.put(c, new Node());
            }
            node = node.get(c);
            node.cnt++;
        }
        node.setEnd();
    }
    
    public static boolean search(String word) {
        Node node = root;
        
        for(int i = 0; i< word.length(); i++) {
            char c = word.charAt(i);
            if(!node.containsKey(c))
                return false;
            node = node.get(c);
        }
        return (node.isEnd());
    }
    
        public static boolean startsWith(String word) {
            Node node = root;

            for(int i = 0; i< word.length(); i++) {
                char c = word.charAt(i);
                if(!node.containsKey(c))
                    return false;
                node = node.get(c);
            }
                return true;
        }
        
        public static int countsStartsWith(String word) {
            Node node = root;

            for(int i = 0; i< word.length(); i++) {
                char c = word.charAt(i);
                if(!node.containsKey(c))
                    return 0;
                node = node.get(c);
            }
                return node.cnt;
        }
        
    }

    public static int prefixCount(String[] words, String pref) {
        Trie trie = new Trie();
        for(String word : words) {
            trie.insert(word);
        }
        return trie.countsStartsWith(pref);
    }
}

*/