class Solution {
    
    private static Trie root;
    
    public Solution() {
        root = new Trie();
    }
    
    public void insert(String word) {
        Trie trie = root;
        int n = word.length();
        
        for(int i = 0; i<n; i++) {
            if(!trie.containsKey(word.charAt(i))) {
                trie.put(word.charAt(i), new Trie());
            }
            trie = trie.get(word.charAt(i));
            trie.addWordToList(word);
            trie.getList();
        }
        trie.setEnd();
    }

    
    public static boolean startsWith(String prefix) {
        int plen = prefix.length();
        for(int i = 0; i<plen; i++) {
            if(!root.containsKey(prefix.charAt(i)))
                return false;
            root = root.get(prefix.charAt(i));
        }
        return true;
    }
    
    public class Trie{
        Trie links[] = new Trie[26];
        List<String> list = new ArrayList<>();
        boolean flag = false;
        
        public boolean containsKey(char ch) {
            return (links[ch-'a'] != null);
        }
        
        public Trie get(char ch) {
            return links[ch-'a'];
        }
        
        public void put(char ch, Trie trie) {
            links[ch-'a'] = trie;
        }
        
        public void setEnd() {
            flag = true;
        }
        
        public boolean isEnd() {
            return flag;
        }
        
        public List<String> getList() {
            return list;
        }         
            
        public void addWordToList(String word) {
            if(list == null)
                list = new ArrayList<String>();
            list.add(word);
            Collections.sort(list);
            if(list.size() > 3) {
                list.remove(3);
            }
        }        
    }
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> ans = new ArrayList<List<String>>();
        for(String product : products) {
            insert(product);
        }
        Trie node = root;
        char ch;
        
        int len = searchWord.length();
        for(int i = 0; i<len; i++) {
            ch = searchWord.charAt(i);
            if(!node.containsKey(ch))
            {
                for(int j = i; j<len; j++)
                    ans.add(new ArrayList<>());
                return ans;
            }
            node = node.get(ch);
            List<String> list = node.getList();
            ans.add(list);
        }
        return ans;
    }
}