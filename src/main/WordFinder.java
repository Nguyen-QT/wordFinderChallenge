package main;

import java.util.*;

public class WordFinder {

    private final List<String> wordlist;
    int maxLength = 0;
    public WordFinder(List<String> wordlist) {
        this.wordlist = wordlist;
    }

    public Set<String> findWords(String board){
        String[] splitString = board.split("\\\\n");
        char[][] charBoard = new char[splitString.length][];
        for(int i = 0; i < splitString.length; i++){
            charBoard[i] = splitString[i].toCharArray();
        }
        int row = charBoard.length;
        int col = charBoard[0].length;
        for (String word : wordlist) {
            maxLength = Math.max(maxLength, word.length());
        }
        Set<String> wordAns = new HashSet<>();
        for (int i = 0; i < charBoard.length; i++) {
            for (int j = 0; j < charBoard[i].length; j++) {
                boolean[][] visited = new boolean[row][col];
                StringBuilder sb = new StringBuilder();
                check(i, j, sb, wordlist, wordAns, charBoard, visited);
            }
        }
        return wordAns;
    }

    public void check(int i, int j, StringBuilder sb,List<String> wordlist, Set<String> wordAns, char[][] charBoard, boolean[][] visited) {
        if (i < 0 || j < 0 || sb.length() > maxLength || i >= charBoard.length || j >= charBoard[i].length || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        sb.append(charBoard[i][j]);
        String sbString = sb.toString();
        if (wordlist.contains(sbString)) {
            wordAns.add(sbString);
        }
        check(i - 1, j - 1, sb, wordlist, wordAns, charBoard, visited);
        check(i, j - 1, sb, wordlist, wordAns, charBoard, visited);
        check(i + 1, j - 1, sb, wordlist, wordAns, charBoard, visited);
        check(i - 1, j, sb, wordlist, wordAns, charBoard, visited);
        check(i + 1, j, sb, wordlist, wordAns, charBoard, visited);
        check(i - 1, j + 1, sb, wordlist, wordAns, charBoard, visited);
        check(i, j + 1, sb, wordlist, wordAns, charBoard, visited);
        check(i + 1, j + 1, sb, wordlist, wordAns, charBoard, visited);
        visited[i][j] = false;
        sbString= String.valueOf(sb.deleteCharAt(sb.length()-1));
    }
}