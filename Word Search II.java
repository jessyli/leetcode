Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

For example,
Given words = ["oath","pea","eat","rain"] and board =

[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
Return ["eat","oath"].
Note:
You may assume that all inputs are consist of lowercase letters a-z.

click to show hint.

You would need to optimize your backtracking to pass the larger test. Could you stop backtracking earlier?

If the current candidate does not exist in all words' prefix, you could stop backtracking immediately. What kind of data structure could answer such query efficiently? Does a hash table work? Why or why not? How about a Trie? If you would like to learn how to implement a basic trie, please work on this problem: Implement Trie (Prefix Tree) first.

public class Solution {
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
    public TrieNode root;

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

 
    
    
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> res = new HashSet<String>();
        Trie trie = new Trie();
        for(String temp: words){
            trie.insert(temp);
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dfs(board, visited, i, j, "", trie, res);
            }
        }
        return new ArrayList<String>(res);
        
    }
    
    public void dfs(char[][] board, boolean[][] visited, int x, int y, String str, Trie trie, Set<String> res){
        if(x<0 || x>=board.length || y<0 || y>=board[0].length) return;
        if(visited[x][y]) return;
        str+=board[x][y];
        if(!trie.startsWith(str)) return;
        if(trie.search(str) && !res.contains(str)){
            res.add(str);
        }
        visited[x][y]=true;
        dfs(board, visited, x-1, y, str, trie, res);
        dfs(board, visited, x+1, y, str, trie, res);
        dfs(board, visited, x, y-1, str, trie, res);
        dfs(board, visited, x, y+1, str, trie, res);
        visited[x][y] = false;
    }
}
