class Solution {

    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean[] visited = new boolean[V];
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfsUtil(i, adj, visited, result);
            }
        }

        return result;
    }

    public void dfsUtil(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> result) {

        visited[node] = true;
        result.add(node);
        for (int next : adj.get(node)) {
        // ArrayList<Integer> neighbors = adj.get(node);

        // for (int j = 0; j < neighbors.size(); j++) {
        //     int next = neighbors.get(j);
            if (!visited[next]) {
                dfsUtil(next, adj, visited, result);
            }
        }
    }
}