// Given an undirected graph with v vertices(numbered from 1 to v) and e edges. Find the number of good components in the graph.
// A component of the graph is good if and only if the component is fully connected.
// Note: A fully connected component is a subgraph of a given graph such that there's an edge between every pair of vertices in the component, the given graph can be a disconnected graph. 

class Solution {

    public int findNumberOfGoodComponent(int numberOfEdges, int numberOfVertices, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjacencyList = buildAdjacencyList(numberOfVertices, edges);
        int countGoodComponents = 0;
        int[] visited = new int[numberOfVertices + 1];

        for (int i = 1; i <= numberOfVertices; i++) {
            if (visited[i] == 0) {
                int[] vertices = { 0 };
                int[] edgeCount = { 0 };
                depthFirstSearch(i, vertices, edgeCount, adjacencyList, visited);
                edgeCount[0] /= 2; // Since each edge is counted twice
                if (edgeCount[0] == (vertices[0] * (vertices[0] - 1)) / 2) {
                    countGoodComponents++;
                }
            }
        }
        return countGoodComponents;
    }

    private void depthFirstSearch(int vertex, int[] vertices, int[] edges, ArrayList<ArrayList<Integer>> adjacencyList,
            int[] visited) {
        visited[vertex] = 1;
        vertices[0]++;
        edges[0] += adjacencyList.get(vertex).size();

        for (int neighbor : adjacencyList.get(vertex)) {
            if (visited[neighbor] == 0) {
                depthFirstSearch(neighbor, vertices, edges, adjacencyList, visited);
            }
        }
    }

    private ArrayList<ArrayList<Integer>> buildAdjacencyList(int numberOfVertices, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>(numberOfVertices + 1);

        for (int i = 0; i <= numberOfVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u); // Since it's an undirected graph
        }
        return adjacencyList;
    }
}
