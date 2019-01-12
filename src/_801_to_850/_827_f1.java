package _801_to_850;

/**
 * @author larry miao
 * @date 2018-01-07
 * @url https://leetcode-cn.com/problems/making-a-large-island/
 * @title 827. 最大人工岛
 */
public class _827_f1
{
    int maxArea = Integer.MIN_VALUE;
    int width;
    int height;
    boolean chance = true;

    int beginX = 0;
    int beginY = 0;

    public int largestIsland(int[][] grid)
    {
        height = grid.length;
        width = grid[0].length;

        label:
        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < width; j++)
            {
                if (grid[i][j] == 1)
                {
                    beginX = i;
                    beginY = j;
                    break label;
                }
            }
        }
        dfs(grid , beginX , beginY , 0);
        return maxArea;
    }

    public void dfs(int[][] grid , int x , int y , int area)
    {
        // 达到边界
        if (x < 0 || x == width || y < 0 || y == height)
        {
//            System.out.println(x+","+y+","+area);
            if (area > maxArea) maxArea = area;
            return;
        }

        // 已访问过的区域
        if (grid[x][y] == -1) return;

        // 区域为0 的情况
        if (grid[x][y] == 0)
        {
            if (!chance) return;
            chance = false;
            System.out.println(x + "," + y + "=" + area);

            // 往四个方向进行遍历
            dfs(grid , x , y - 1 , area + 1);
            dfs(grid , x + 1 , y , area + 1);
            dfs(grid , x , y + 1 , area + 1);
            dfs(grid , x - 1 , y , area + 1);

            chance = true;
        }

        // 区域为1 的情况
        if (grid[x][y] == 1)
        {
            System.out.println(x + "," + y + "=" + area);
            grid[x][y] = -1;

            // 往四个方向进行遍历
            dfs(grid , x , y - 1 , area + 1);
            dfs(grid , x + 1 , y , area + 1);
            dfs(grid , x , y + 1 , area + 1);
            dfs(grid , x - 1 , y , area + 1);

            grid[x][y] = 1;
        }
    }

    public static void main(String[] args)
    {
        int[][] grid = new int[][] {
                {0 , 0 , 0 , 0 , 0 , 0 , 0} ,
                {0 , 1 , 1 , 1 , 1 , 0 , 0} ,
                {0 , 1 , 0 , 0 , 1 , 0 , 0} ,
                {1 , 0 , 1 , 0 , 1 , 0 , 0} ,
                {0 , 1 , 0 , 0 , 1 , 0 , 0} ,
                {0 , 1 , 0 , 0 , 1 , 0 , 0} ,
                {0 , 1 , 1 , 1 , 1 , 0 , 0}
        };
        int l = new _827_f1().largestIsland(grid);
        System.out.println("最大面积为：" + l);
    }
}
