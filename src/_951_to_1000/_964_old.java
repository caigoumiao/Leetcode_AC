package _951_to_1000;

/**
 * @author larry miao
 * @date 2018-01-16
 * @url https://leetcode-cn.com/problems/least-operators-to-express-number/
 * @title 964. 表示数字的最少运算符
 */
public class _964_old
{
    int[] factor;
    int min;

    public int leastOpsExpressTarget(int x , int target)
    {
        factor = new int[target / x + 2];
        min = Integer.MAX_VALUE;

        factor[0] = x;
        for (int i = 1; i <= target / x; i++)
        {
            factor[i] = factor[i - 1] * x;
        }

        int remain = target % x;
        int ex = 0;
        if (remain < (x / 2 + 1))
        {
            ex = remain + remain - 1;
        } else
        {
            ex = 2 * (x - remain);
        }
        System.out.println("ex=" + ex);

        target = target - remain;

        System.out.println("target=" + target);
        dfs(x , target , 0);
        return min - 1 + 1 + ex;
    }

    public void dfs(int x , int target , int sum)
    {
//        System.out.println("target="+target);
        if (sum >= min) return;
        if (target == 0)
        {
            if (sum < min) min = sum;
            return;
        }
        for (int i = 0; factor[i] <= target && factor[i + 1] >= target; i++)
        {
            dfs(x , target - factor[i] , sum + 1 + i);
            dfs(x , target + factor[i] , sum + 1 + i);
        }
    }

    public static void main(String[] args)
    {
        System.out.println(new _964_old().leastOpsExpressTarget(3 , 19));
    }
}
