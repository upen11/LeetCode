class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int min = Integer.MAX_VALUE, minSum = 0;
        // starting from second row and storing minimum possible sum there by comparing with above row
        for(int row=1; row<matrix.length; row++) {
            for(int col=0; col<matrix[0].length; col++) {
                
                if(col-1 >= 0 && col+1 < matrix[0].length) {
                    min = Math.min(matrix[row-1][col-1], matrix[row-1][col]);
                    min = Math.min(min, matrix[row-1][col+1]);
                }
                // any row, col == 0 then it can't compare value of row-1, col-1
                else if(col-1 == -1){
                    min = Math.min(matrix[row-1][col], matrix[row-1][col+1]);
                }
                // col == last then we can't compare value of row-1, col+1
                else if(col+1 == matrix[0].length) {
                    min = Math.min(matrix[row-1][col-1], matrix[row-1][col]);
                }
                
                minSum = min + matrix[row][col];
                matrix[row][col] = minSum;
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for(int row=matrix.length-1; row<matrix.length; row++) {
            for(int col=0; col<matrix[0].length; col++) {
                
                ans = Math.min(ans, matrix[row][col]);
            }
        }
        
        return ans;
    }
}
