class DSU {
    int[] parent;
    int[] rank;

    DSU(int n) {
        parent = new int[n+1];
        rank = new int[n+1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }
    int findParent(int node) {
        if (node == parent[node]) {
            return node;
        }
        parent[node] = findParent(parent[node]);
        return parent[node];
    }
    void resetNode(int node) {
        parent[node] = node;
        rank[node] = 0;
    }
    void union(int node1, int node2) {
        int parent1 = findParent(node1);
        int parent2 = findParent(node2);

        if (parent1 == parent2) {
            return;
        }
        if (rank[parent1] > rank[parent2]) {
            parent[parent2] = parent1;
        } 
        else if (rank[parent1] < rank[parent2]) {
            parent[parent1] = parent2;
        } 
        else {
            parent[parent1] = parent2;
            rank[parent2]++;
        }
    }
}

class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges , (a , b) -> b[0] - a[0]);
        DSU alice = new DSU(n);
        DSU bob = new DSU(n);
        int count = 0;
        int aliceEdges = 0;
        int bobEdges = 0;

        for(int[] i : edges){
            int type = i[0];
            int to = i[1];
            int from = i[2];

            if(type == 3){
                if(alice.findParent(to) == alice.findParent(from) && bob.findParent(to) == bob.findParent(from)){
                    count++;
                }
                else{
                    alice.union(to,from);
                    bob.union(to,from);
                    aliceEdges++;
                    bobEdges++;
                }
            }
            else if(type == 1){
                if(alice.findParent(to) == alice.findParent(from)){
                    count++;
                }
                else{
                    alice.union(to,from);
                    aliceEdges++;
                }
            }
            else if(type==2){
                if(bob.findParent(to) == bob.findParent(from)){
                    count++;
                }
                else{
                    bob.union(to,from);
                    bobEdges++;
                }
            }   
        }
        if(aliceEdges != n-1 || bobEdges != n-1){
           return -1;
        }
        return count;
    }
}
