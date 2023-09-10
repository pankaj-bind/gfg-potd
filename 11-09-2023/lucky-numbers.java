class Solution
{
    public static boolean isLucky(int n)
    {
        if(n == 1)
            return true;
        if(n % 2 == 0)
            return false;

        int nextPosition = n;
        int step = 2;

        while (nextPosition >= step) {
            if (nextPosition % step == 0)
                return false;

            nextPosition -= nextPosition / step;
            step++;
        }

        return true;
    }
}
