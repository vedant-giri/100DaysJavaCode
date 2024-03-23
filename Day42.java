// There are given N ropes of different lengths, we need to connect these ropes into one rope. The cost to connect two ropes is equal to sum of their lengths.
// The task is to connect the ropes with minimum cost. Given N size array arr[] contains the lengths of the ropes. 

class Solution {
    // Function to return the minimum cost of connecting the ropes.
    long minCost(long arr[], int n) {
        // your code here
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pq.add((long) arr[i]);
        }

        long cost = 0;

        while (pq.size() > 1) {
            long first = pq.remove();
            long second = pq.remove();
            long newRope = first + second;
            cost += newRope;
            pq.add(newRope);
        }
        return cost;
    }
}