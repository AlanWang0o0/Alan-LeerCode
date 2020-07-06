package LeetCode;

public class T63_Unique_Paths_II {
    public static void main(String[] args){
        System.out.println(uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length, column = obstacleGrid[0].length;
        int[][] res = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if(i==0 && j==0){
                    if(obstacleGrid[0][0] == 1) return 0;
                    else res[0][0] = 1;
                }
                else if(i==0){  // 第一行
                    if(obstacleGrid[i][j] == 1 || res[i][j-1] == 0)    res[i][j] = 0;   // 当前为障碍物或者左边为 0.则为 0
                    else    res[i][j] = res[i][j-1];   // 否则等于左边
                }
                else if(j==0){   // 第一列
                    if(obstacleGrid[i][j] == 1 || res[i-1][j] == 0)    res[i][j] = 0;   // 当前为障碍物或者上面为 0，则为 0
                    else    res[i][j] = res[i-1][j];  //否则等于上面
                }
                else{   // 非第一行也非第一列
                    if(obstacleGrid[i][j] == 1) res[i][j] =0;    // 当前为障碍，则为 0
                    else{
                        res[i][j] = res[i-1][j] + res[i][j-1] ;  // 当前不为障碍物，为左边加右边
                    }
                }
            }

        }
        return res[row-1][column-1];
    }
}
