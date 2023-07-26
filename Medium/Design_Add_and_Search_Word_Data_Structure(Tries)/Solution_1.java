// We uses tries to solve this question
import java.util.*;
public class Solution_1 {
    class WordDictionary {
        TrieNode root;

        public WordDictionary() {
            root = new TrieNode('\0');
        }

        public void addWord(String word) {
            TrieNode currNode = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!currNode.children.containsKey(ch)) {
                    currNode.children.put(ch, new TrieNode(ch));
                }
                currNode = currNode.children.get(ch);
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
            return searchHelper(word, root);
            // Let n be the length of the word and m be the number of keys in the map
            // Time Complexity: O(n) for "well-defined" words without dots and O(n*26^m) for
            // undefined words with dots
            // Space Compexity: O(1) for the search of "well-defined" words without dots,
            // and up to O(m) for the "undefined" words, to keep the recursion stack

        }

        public boolean searchHelper(String word, TrieNode node) {
            TrieNode currNode = node;
            for (int i = 0; i < word.length(); i++) {
                char currChar = word.charAt(i);
                if (!currNode.children.containsKey(currChar)) {
                    if (currChar == '.') {
                        for (TrieNode child : currNode.children.values()) {
                            if (searchHelper(word.substring(i + 1), child)) {
                                return true;
                            }
                        }
                    }
                    return false;
                } else {
                    currNode = currNode.children.get(currChar);
                }
            }
            return currNode.isEndOfWord;
        }
    }

    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEndOfWord;
        char ch;

        public TrieNode(char ch) {
            children = new HashMap<>();
            this.ch = ch;
        }

    }
    /**
     * Your WordDictionary object will be instantiated and called as such:
     * WordDictionary obj = new WordDictionary();
     * obj.addWord(word);
     * boolean param_2 = obj.search(word);
     */
}
