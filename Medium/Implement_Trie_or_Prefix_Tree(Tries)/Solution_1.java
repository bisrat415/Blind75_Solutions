// This solution implements the Trie data structure (specifically the insert, searchWord and startsWith methods)
public class Solution_1 {

    // This is the Trie class that implements insert, search and startsWith
    class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode('\0');
        }

        public void insert(String word) {
            TrieNode currNode = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int index = ch - 'a';
                if (currNode.children[index] == null) {
                    currNode.children[index] = new TrieNode(ch);
                }
                currNode = currNode.children[index];
            }
            currNode.isEndOfWord = true;
            // Let n be the length of the word
            // Time Complexity: O(n) - we are visiting each character once and all other
            // operations in the method are constant time
            // Space Complexity: O(n) - in the worst case (when new inserted keys don't
            // share a prefix with the already existing keys in the trie) we have to create
            // new nodes for each character
        }

        public boolean search(String word) {
            TrieNode currNode = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int index = ch - 'a';
                if (currNode.children[index] == null) {
                    return false;
                }
                currNode = currNode.children[index];
            }
            return currNode.isEndOfWord;
            // Let n be the length of the word
            // Time Complexity: O(n) - we are visiting each character once and all other
            // operations in the method are constant time
            // Space Complexity: O(1) because we are only using constant extra space
        }

        public boolean startsWith(String prefix) {
            TrieNode currNode = root;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                int index = ch - 'a';
                if (currNode.children[index] == null) {
                    return false;
                }
                currNode = currNode.children[index];
            }
            return true;
            // Let n be the length of prefix
            // Time Complexity: O(n) - we are visiting each character once and all other
            // operations in the method are constant time
            // Space Complexity: O(1) because we are only using constant extra space
        }
    }

    // This is the TrieNode class that represents a node in a Trie
    class TrieNode {
        public TrieNode[] children;
        public boolean isEndOfWord; // is this character the end of a word
        public char value;

        public TrieNode(char value) {
            children = new TrieNode[26];
            this.value = value;
        }
    }

}
