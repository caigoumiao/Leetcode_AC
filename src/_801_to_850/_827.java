
package _801_to_850;

/**
 * @author larry miao
 * @date 2018-01-12
 * @url https://leetcode-cn.com/problems/making-a-large-island/
 * @title 827. 最大人工岛
 */
public class _827
{
    int maxArea = Integer.MIN_VALUE;
    int width;
    int height;

    int area = 0;
    int value = 2;

    int[][] color;
    int[] size;

    public int largestIsland(int[][] grid)
    {
        height = grid.length;
        width = grid[0].length;
        color = new int[height][width];
        size = new int[width * height / 2 + 2];

        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < width; j++)
            {
                color[i][j] = grid[i][j];
            }
        }

        // 将各分开的大陆按颜色区分
        // color[i][j] 记录（i, j）位置的颜色值
        // size[color] 记录颜色值锁对应大陆的面积
        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < width; j++)
            {
                // 找到一块新的陆地
                if (grid[i][j] == 1 && color[i][j] == 1)
                {
                    dfs(grid , i , j);
                    size[value] = area;
                    value++;
                    area = 0;
                }
            }
        }

        int num;
        int[] b = new int[value];
        int v;

        // 用一个 1 将分开的大陆连接，找出合并后的最大值
        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < width; j++)
            {
                if (grid[i][j] == 0)
                {
                    num = 0;
                    for (int i1 = 0; i1 < b.length; i1++)
                    {
                        b[i1] = 0;
                    }

                    if (j - 1 >= 0 && grid[i][j - 1] == 1)
                    {
                        v = color[i][j - 1];
                        if (b[v] == 0)
                        {
                            num += size[v];
                            b[v] = 1;
                        }
                    }

                    if (i + 1 < height && grid[i + 1][j] == 1)
                    {
                        v = color[i + 1][j];
                        if (b[v] == 0)
                        {
                            num += size[v];
                            b[v] = 1;
                        }
                    }

                    if (j + 1 < width && grid[i][j + 1] == 1)
                    {
                        v = color[i][j + 1];
                        if (b[v] == 0)
                        {
                            num += size[v];
                            b[v] = 1;
                        }
                    }

                    if (i - 1 >= 0 && grid[i - 1][j] == 1)
                    {
                        v = color[i - 1][j];
                        if (b[v] == 0)
                        {
                            num += size[v];
                            b[v] = 1;
                        }
                    }

                    if (num + 1 > maxArea) maxArea = num + 1;
                }
            }
        }

        // 处理没有0的情况
        for (int aSize : size) if (aSize > maxArea) maxArea = aSize;

        return maxArea;
    }

    // 深搜遍历， 区分各块大陆，记录颜色值以及面积
    public void dfs(int[][] grid , int x , int y)
    {
        // 达到边界
        if (x < 0 || x == width || y < 0 || y == height) return;

        if (color[x][y] != 1) return;

        if (grid[x][y] == 1)
        {
            area++;
            color[x][y] = value;

            dfs(grid , x , y - 1);
            dfs(grid , x + 1 , y);
            dfs(grid , x , y + 1);
            dfs(grid , x - 1 , y);
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
        int l = new _827().largestIsland(grid);
        System.out.println("最大面积为：" + l);
    }
}
