Implement a trie with insert, search, and startsWith methods.

class TrieNode {
    // Initialize your data structure here.
        char c;
        HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        boolean isLeaf;
        public TrieNode(){
            
        }
    public TrieNode(char input) {
        this.c = input;
        
    }
     
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        HashMap<Character, TrieNode> child = root.children;
        for(int i=0; i<word.length(); i++){
            char t = word.charAt(i);
            TrieNode tn;
            if(child.containsKey(t)){
                tn = child.get(t);
            }
            else{
                tn = new TrieNode(t);
                child.put(t, tn);
            }
            child = tn.children;
            if(i == word.length()-1){
                tn.isLeaf = true;
            }
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        HashMap<Character, TrieNode> child = root.children;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            TrieNode tn;
            if(child.containsKey(c)){
                tn = child.get(c);
            }
            else{
                return false;
            }
            child = tn.children;
            if(i==word.length()-1 && tn.isLeaf == true){
                return true;
            }
        }
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        HashMap<Character, TrieNode> child = root.children;
        for(int i=0; i<prefix.length(); i++){
            char c = prefix.charAt(i);
            TrieNode tn;
            if(child.containsKey(c)){
                tn = child.get(c);
            }
            else{
                return false;
            }
            child = tn.children;
            
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
