package _401_to_450;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author larry maio
 * @date 2018-01-05
 * @url https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/
 * @title 442. 数组中重复的数据
 */
public class _442
{
    public List<Integer> findDuplicates(int[] nums)
    {
        List<Integer> res = new ArrayList<>(nums.length);
        int[] b = new int[nums.length + 1];
        for (int num : nums)
        {
            b[num] = b[num] + 1;
        }
        for (int i = 0; i < b.length; i++)
        {
            if (b[i] == 2)
                res.add(i);
        }
        return res;
    }

    public List<Integer> findDuplicates_2(int[] nums)
    {
        List<Integer> res = new ArrayList<>(nums.length);
        int t;
        for (int i = 0; i < nums.length; i++)
        {
            if (i != nums[i] && nums[i] == nums[nums[i]])
                res.add(nums[i]);
            while (i != nums[i])
            {
                t = nums[i];
                nums[i] = nums[nums[i]];
                nums[nums[i]] = t;
            }
        }
        for (int i = 0; i < nums.length; i++)
        {
            System.out.println(i + " - " + nums[i]);
        }
        return res;
    }

    public static void main(String[] args)
    {
        int[] nums = new int[] {1 , 2 , 3 , 4};
        new _442().findDuplicates_2(nums).forEach(System.out::println);
    }
}
