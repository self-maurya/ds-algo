package old.extra;

public class MinimizeTransactions {
    public static void main(String[] args) {
//        int[][] graph = {
//                {0, 1000, 2000},
//                {0, 0, 5000},
//                {0, 0, 0},
//        };
        int[][] graph = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 40, 0, 0, 0, 0},
                {0, 0, 0, 20, 0, 0, 0},
                {0, 0, 0, 0, 50, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 10, 30, 10, 10, 0, 0},
                {0, 30, 0, 10, 0, 0, 0}
        };
        minCashFlow(graph);
    }

    public static void minCashFlow(int[][] graph) {
        int[] amount = new int[graph.length];
        for(int p = 0; p < graph.length; p++) {
            for(int i = 0; i < graph.length; i++) {
                amount[p] += (graph[i][p] - graph[p][i]); // credit - debit
            }
        }
        minCashFlowHelper(amount);
    }

    private static void minCashFlowHelper(int[] amount) {
        int maxCredit = findMax(amount);
        int maxDebit = findMin(amount);
        if(amount[maxCredit] == 0 && amount[maxDebit] == 0) {
            return;
        }

        int min = Math.min(-amount[maxDebit], amount[maxCredit]);
        amount[maxCredit] -= min;
        amount[maxDebit] += min;

        System.out.println("Person " + maxDebit + " pays " + min + " to Person " + maxCredit);
        minCashFlowHelper(amount);
    }

    private static int findMax(int[] amount) {
        int maxInd = 0;
        for(int i = 0; i < amount.length; i++) {
            if (amount[i] > amount[maxInd]) {
                maxInd = i;
            }
        }
        return maxInd;
    }

    private static int findMin(int[] amount) {
        int minInd = 0;
        for(int i = 0; i < amount.length; i++) {
            if (amount[i] < amount[minInd]) {
                minInd = i;
            }
        }
        return minInd;
    }
}
