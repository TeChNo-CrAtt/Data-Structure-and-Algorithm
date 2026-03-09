class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges){
        List<int[]>[] adj = new ArrayList[n];

        for(int i=0;i<n;i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=0;i<redEdges.length;i++){
            int u = redEdges[i][0];
            int v = redEdges[i][1];
            adj[u].add(new int[]{v,0});
        }

        for(int i=0;i<blueEdges.length;i++){
            int u = blueEdges[i][0];
            int v = blueEdges[i][1];
            adj[u].add(new int[]{v,1});
        }


        Queue<int[]> queue = new LinkedList<>();
        int[] res = new int[n];
        Arrays.fill(res,-1);
        res[0] = 0;
        boolean[][] visited = new boolean[n][2];

        queue.add(new int[]{0,0,-1}); // node , distance , previous color

        while(queue.size() > 0){
            int[] prev = queue.remove();
            List<int[]> nodes = adj[prev[0]];
            for(int i = 0; i < nodes.size(); i++){
                int[] next = nodes.get(i);

                if(!visited[next[0]][next[1]] && next[1] != prev[2]){

                    if(res[next[0]] == -1){
                        res[next[0]] = prev[1] + 1;
                    }
                    visited[next[0]][next[1]] = true;
                    queue.add(new int[]{next[0], prev[1]+1, next[1]});
                }
            }
        }
        return res;
    }
}