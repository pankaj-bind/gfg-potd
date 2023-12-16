class Solution 
{ 
    static long countStr(long n)
	{
	    return  1+ 2*n + n*(n-1)/2 + n*(n-1) + n*(n-1)*(n-2)/2;
	}
} 