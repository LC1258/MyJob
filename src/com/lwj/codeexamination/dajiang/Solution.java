package com.lwj.codeexamination.dajiang;
import java.util.*;

class TrieNode {
  HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
  String word = null;
  public TrieNode() {}
}

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    in.nextLine();
    char[][] aa = new char[n][n];
    for (int i = 0; i < n; i++) {
      String str = in.nextLine();
      for (int j = 0; j < str.length(); j++) {
        aa[i][j] = str.charAt(j);
      }
    }
    int m = Integer.parseInt(in.nextLine());
    String[] words = new String[m];
    for (int i = 0; i < m; i++) {
      words[i] = in.nextLine();
    }
    List<String> res = new Solution().findWords(aa, words);
    Collections.sort(res);
    if(res.size() <= 0) {
      System.out.println("");
    } else {
      for (int i = 0; i < res.size(); i++) {
        System.out.println(res.get(i));
      }
    }
  }
  char[][] board = null;
  ArrayList<String> result = new ArrayList<String>();

  public List<String> findWords(char[][] board, String[] words) {
    TrieNode root = new TrieNode();
    for (String word : words) {
      TrieNode node = root;

      for (Character letter : word.toCharArray()) {
        if (node.children.containsKey(letter)) {
          node = node.children.get(letter);
        } else {
          TrieNode newNode = new TrieNode();
          node.children.put(letter, newNode);
          node = newNode;
        }
      }
      node.word = word;
    }

    this.board = board;
    for (int row = 0; row < board.length; ++row) {
      for (int col = 0; col < board[row].length; ++col) {
        if (root.children.containsKey(board[row][col])) {
          dfs(row, col, root);
        }
      }
    }

    return this.result;
  }

  private void dfs(int row, int col, TrieNode parent) {
    Character letter = this.board[row][col];
    TrieNode currNode = parent.children.get(letter);

    if (currNode.word != null) {
      this.result.add(currNode.word);
      currNode.word = null;
    }
    this.board[row][col] = '#';
    int[] rowOffset = {-1, 0, 1, 0};
    int[] colOffset = {0, 1, 0, -1};
    for (int i = 0; i < 4; ++i) {
      int newRow = row + rowOffset[i];
      int newCol = col + colOffset[i];
      if (newRow < 0 || newRow >= this.board.length || newCol < 0
          || newCol >= this.board[0].length) {
        continue;
      }
      if (currNode.children.containsKey(this.board[newRow][newCol])) {
        dfs(newRow, newCol, currNode);
      }
    }
    this.board[row][col] = letter;

    if (currNode.children.isEmpty()) {
      parent.children.remove(letter);
    }
  }
}
