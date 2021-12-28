package old.simplepointers;

public class Candy {
    /*
    LeetCode – Candy (Java)
    There are N children standing in a line. Each child is assigned a rating value.
    You are giving candies to these children subjected to the following requirements:

    1. Each child must have at least one candy.
    2. Children with a higher rating get more candies than their neighbors.
    What is the minimum candies you must give?
     */
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        candies[0] = 1;

        int i = 1;
        while(i < ratings.length) {
            candies[i] = 1;
            if(ratings[i-1] < ratings[i])
                candies[i] = candies[i-1] + 1;
            i++;
        }

        int result = candies[ratings.length-1];

        i = ratings.length - 2;
        while(i >= 0) {
            int cur = 1;
            if(ratings[i] > ratings[i+1])
                cur = candies[i+1] + 1;

            result += Math.max(cur, candies[i]);
            candies[i] = cur;
            i--;
        }

        return result;
    }
}
