package _901_to_950;

/**
 * @author larry miao
 * @date 2018-01-04
 * @url https://leetcode-cn.com/problems/largest-time-for-given-digits/
 * @title 949. 给定数字能组成的最大时间
 */
public class _949
{
    boolean hasClock=false;
    int[] maxClock=new int[]{0,0,0,0};

    public String largestTimeFromDigits(int[] A) {
        int[] t=new int[]{0,0,0,0};
        int[] b=new int[]{0,0,0,0};
        dfs(A, t, b,0);
        if(!hasClock) return "";
        return ""+maxClock[0]+maxClock[1]+":"+maxClock[2]+maxClock[3];
    }

    public void dfs(int[] A, int[] t, int[] b, int len){
        if(len==4){
            if(isClock(t)){
                hasClock=true;
                if(compareClock(t, maxClock)){
                    maxClock=t.clone();
                }
            }
            return ;
        }
        for(int i=0;i<4;i++){
            if(b[i]==0) {
                t[len]= A[i];
                b[i]=1;
                dfs(A, t, b,len+1);
                b[i]=0;
            }
        }
    }

    /**
     * 判断是否符合时间格式
     * @param a
     * @return
     */
    public boolean isClock(int[] a){
        if(a[0]>2) return false;
        if(a[0]==2&&a[1] >= 4) return false;
        if(a[2]>5) return false;
        return true;
    }

    /**
     * 比较两个时间的大小。 若a>=b 则返回true,否则返回false
     * @param a
     * @param b
     * @return
     */
    public boolean compareClock(int[] a, int[] b){
        for(int i=0;i<4;i++){
            if(a[i]==b[i]) continue;
            return a[i]>b[i];
        }
        return true;
    }
}
