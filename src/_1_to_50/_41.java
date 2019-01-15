package _1_to_50;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author larry miao
 * @date 2018-01-12
 * @url https://leetcode-cn.com/problems/first-missing-positive/
 * @title 41. 缺失的第一个正数
 */
public class _41
{
    public int firstMissingPositive(int[] nums)
    {
        Set<Integer> sets = new LinkedHashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums)
        {
            if (num > max) max = num;
            if (num < min) min = num;
            sets.add(num);
        }
        if (min > 1) return 1;
        for (int i = min; i <= max; i++)
        {
            if (i >= 1)
            {
                if (!sets.contains(i)) return i;
            }
        }
        return max + 1;
    }

    public static void main(String[] args)
    {
        int[] nums = new int[] {1 , 2 , 3 , 4};
        System.out.println(new _41().firstMissingPositive(nums));
    }
}
