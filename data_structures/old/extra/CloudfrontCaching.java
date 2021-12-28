package old.extra;

import java.util.*;

public class CloudfrontCaching {
    public static void main(String[] args) {
        List<String> edges = new ArrayList<>();
//        edges.add("8 1");
//        edges.add("5 8");
//        edges.add("7 3");
//        edges.add("8 6");
        edges.add("1100");
        edges.add("1110");
        edges.add("0110");
        edges.add("0001");
//        int sum = connectedSum(8, edges);
//        System.out.println(sum);
        System.out.println(countGroups(edges));
    }

    public static int connectedSum(int n, List<String> edges) {
        Map<String, List<String>> g = new HashMap<>();
        int i = 1;
        while (i <= n) {
            g.put(String.valueOf(i), new ArrayList<>());
            i++;
        }

        for(String edge: edges) {
            String[] nn = edge.split(" ");
            List<String> list = g.get(nn[0]);
            list.add(nn[1]);
            g.put(nn[0], list);
        }

        Map<String, Boolean> visited = new HashMap<>();
        i = 1;
        int sum = 0;
        while(i <= n) {
            if (!visited.containsKey(String.valueOf(i))) {
                int s = bfs(visited, g, String.valueOf(i));
//                System.out.println(s);
                if (s == 1) {
                    sum += 1;
                } else {
                    sum += (int) Math.ceil(Math.sqrt(s));
                }
            }
            i++;
        }
        return sum;
    }

    public static int bfs(Map<String, Boolean> visited, Map<String, List<String>> g, String cn) {
        visited.put(cn, true);
        Queue<String> q = new ArrayDeque<>();
        q.add(cn);
        int s = 0;

        while (!q.isEmpty()) {
            String u = q.poll();
            s++;
           for(String v: g.get(u)) {
               if (!visited.containsKey(v)) {
                   q.add(v);
                   visited.put(v, true);
               }
           }
        }
        return s;
    }

    public static int countGroups(List<String> related) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        int i = 0;
        List<Integer> l;
        for(String rel: related) {
            l = new ArrayList<>();
            char[] relc = rel.toCharArray();
            for(int j = 0; j < relc.length; j++) {
                if (relc[j] == '1') {
                    l.add(j);
                }
            }
            g.put(i, l);
            i++;
        }

        boolean[] visited = new boolean[related.size()];
        i = 0;
        int c = 0;
        while(i < related.size()) {
            if (!visited[i]) {
                bfs(i, g, visited);
                c++;
            }
            i++;
        }
        return c;
    }

    public static void bfs(int u, Map<Integer, List<Integer>> g, boolean[] visited) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(u);
        visited[u] = true;

        while(!q.isEmpty()) {
            u = q.poll();
            for (int v : g.get(u)) {
                if (!visited[v]) {
                    q.add(v);
                    visited[v] = true;
                }
            }
        }
    }
}
