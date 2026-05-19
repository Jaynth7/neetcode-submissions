

class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        // 1. Check every row
        for(int r = 0 ; r < 9 ; r++){
            Set<Character> seen = new HashSet<>();
            for(int i = 0 ; i < 9 ; i++){
                // Fixed: Changed double quotes to single quotes and simplified
                if(board[r][i] != '.'){
                    if(seen.contains(board[r][i])){
                        return false;
                    }
                    seen.add(board[r][i]);
                }
            }
        }

        // 2. Check every column
        for(int c = 0 ; c < 9 ; c++){
            Set<Character> seen = new HashSet<>();
            for(int i = 0 ; i < 9 ; i++){
                // Fixed: Corrected the placement of '!' and changed to single quotes
                if(board[i][c] != '.'){
                    if(seen.contains(board[i][c])){
                        return false;
                    }
                    seen.add(board[i][c]);
                }
            }
        }

        // 3. Check every 3x3 sub-box
        for(int s = 0 ; s < 9 ; s++){
            Set<Character> seen = new HashSet<>();
            for(int i = 0 ; i < 3 ; i++){
                for (int j = 0; j < 3; j++) {
                    int row = (s / 3) * 3 + i;
                    int col = (s % 3) * 3 + j;
                    if (board[row][col] == '.') continue;
                    if (seen.contains(board[row][col])) return false;
                    seen.add(board[row][col]);
                }
            }
        }

        // Fixed: Added the missing return statement
        return true; 
    }
}