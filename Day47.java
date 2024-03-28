// There are n cities labeled from 0 to n-1 with m edges connecting them. Given the array edges where edges[i] = [fromi , toi ,weighti]  represents a bidirectional and weighted edge between cities fromi and toi, and given the integer distanceThreshold. You need to find out a city with the smallest number of cities that are reachable through some path and whose distance is at most Threshold Distance. If there are multiple such cities, our answer will be the city with the greatest label.

// Note: The distance of a path connecting cities i and j is equal to the sum of the edge's weights along that path.

class Solution {
    int findCity(int n, int m, int[][] e, int d) {
        // code here
        int[][] ma = new int[n][n];
        for (int[] r : ma) {
            Arrays.fill(r, 10001);
        }
        for (int i = 0; i < n; i++) {
            ma[i][i] = 0;
        }
        for (int[] it : e) {
            ma[it[0]][it[1]] = ma[it[1]][it[0]] = it[2];
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    ma[i][j] = Math.min(ma[i][j], ma[i][k] + ma[k][j]);
                }
            }
        }
        int ans = -1;
        int ne = n + 1;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (ma[i][j] <= d)
                    cnt++;
            }
            if (cnt <= ne) {
                ne = cnt;
                ans = i;
            }
        }
        return ans;
    }
}