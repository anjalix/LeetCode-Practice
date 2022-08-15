 class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int j_flag = 1;
        int i_flag = 1;

        for(int i = 0; i<m;i++) {
            for(int j = 0; j<n; j++){
                if(matrix[i][j] == 0) {
                    if(i!=0 && j!=0) {
                        matrix[0][j] = 0;
                        matrix[i][0] = 0;
                    }
                    if(i == 0 && j ==0) {
                        i_flag = 0;
                        j_flag = 0;
                    }
                    if(j == 0) {
                        j_flag = 0;
                    }
                    else if(i == 0) {
                        i_flag = 0;
                    }
                }
            }
        }
        // Mark it as 0
        for(int i = 1; i<m;i++) {
            if(matrix[i][0] == 0) {
                for(int j = 0; j<n; j++){
                    matrix[i][j] = 0;
                }
            }
        }

        // Mark it as 0
        for(int j = 1; j<n;j++) {
            if(matrix[0][j] == 0) {
                for(int i = 0; i<m; i++){
                    matrix[i][j] = 0;
                }
            }
        }

        if(i_flag == 0) {
            for(int j = 0; j<n; j++){
                    matrix[0][j] = 0;
            }
        }

        if(j_flag == 0) {
            for(int i = 0; i<m; i++){
                matrix[i][0] = 0;
            }
        }
    }
}


/*
class Solution {
    public void setZeroes(int[][] matrix) {
        List<Integer> row = new ArrayList<Integer>();        
        List<Integer> col = new ArrayList<Integer>();
        
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i<m; i++)
        {
            for(int j = 0; j<n; j++)
            {
                if(matrix[i][j] == 0) {
                    if(!row.contains(i))
                        row.add(i);
                    if(!col.contains(j))
                        col.add(j);
                }
            }
        }
        
        for(int i = 0; i<m; i++)
        {
            for(int j = 0; j<n; j++)
            {
               if(row.contains(i) || col.contains(j))
                   matrix[i][j] = 0;                   
            }
        }
    }
}
*/