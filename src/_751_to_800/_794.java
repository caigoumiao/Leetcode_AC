package _751_to_800;

/**
 * @author larry miao
 * @date 2018-02-12
 * @url https://leetcode-cn.com/problems/valid-tic-tac-toe-state/
 * @title 794. 有效的井字游戏
 */
public class _794
{
    /**
     * 思路：
     * 1. 统计X & O 的数量，X 比 O 多0 或1 ，不符合的false
     * 2. 如果 X 胜利了， 则X 会比 O 数量多1
     * 3. 如果 O 胜利了， 则X 会和 O 数量相等
     */

    public boolean validTicTacToe(String[] board)
    {
        int numX = 0;
        int numO = 0;
        for (String s : board)
        {
            for (int i = 0; i < s.length(); i++)
            {
                if (s.charAt(i) == 'X') numX++;
                else if (s.charAt(i) == 'O') numO++;
            }
        }
        if (numX - numO < 0 || numX - numO > 1) return false;
        int whoWin = whoWins(board);
        if (whoWin == 1 && numX - numO != 1) return false;
        if (whoWin == -1 && numX != numO) return false;
        return true;
    }

    public int whoWins(String[] board)
    {
        boolean lineO = false;
        for (String s : board)
        {
            // 水平线
            if (s.equals("XXX")) return 1;
            else if (s.equals("OOO")) lineO = true;
        }

        for (int j = 0; j < board[0].length(); j++)
        {
            if (board[0].charAt(j) == board[1].charAt(j) && board[1].charAt(j) == board[2].charAt(j))
            {
                if (board[0].charAt(j) == 'X') return 1;
                else if (board[0].charAt(j) == 'O') lineO = true;
            }
        }

        if (board[0].charAt(0) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(2))
        {
            if (board[0].charAt(0) == 'X') return 1;
            else if (board[0].charAt(0) == 'O') lineO = true;
        }

        if (board[2].charAt(0) == board[1].charAt(1) && board[1].charAt(1) == board[0].charAt(2))
        {
            if (board[2].charAt(0) == 'X') return 1;
            else if (board[2].charAt(0) == 'O') lineO = true;
        }
        return lineO ? -1 : 0;
    }
}
