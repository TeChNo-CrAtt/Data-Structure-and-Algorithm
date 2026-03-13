class DSU {
    int[] parent;
    int[] rank;

    DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
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
    void unionNodes(int node1, int node2) {
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

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        List<Integer> ans = new ArrayList<>();
        // Arrays.sort(meetings, (a, b) -> {
        //     if (a[2] == b[2]) {
        //         return a[0] - b[0];
        //     }
        //     return a[2] - b[2];});

        Arrays.sort(meetings,(a,b)->a[2]-b[2]);

        DSU dsu = new DSU(n);
        dsu.unionNodes(0, firstPerson);

        for (int i = 0; i < meetings.length; ) {

            int time = meetings[i][2];
            List<Integer> people = new ArrayList<>();
            while (i < meetings.length && meetings[i][2] == time) {

                int a = meetings[i][0];
                int b = meetings[i][1];

                dsu.unionNodes(a, b);

                people.add(a);
                people.add(b);

                i++;
            }
            for (int j = 0; j < people.size(); j++) {
                int person = people.get(j);


                if (dsu.findParent(person) != dsu.findParent(0)) {
                    dsu.resetNode(person);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (dsu.findParent(i) == dsu.findParent(0)) {
                ans.add(i);
            }
        }

        return ans;
    }
}