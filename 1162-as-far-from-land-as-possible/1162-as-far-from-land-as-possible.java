class Solution {
    public int maxDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dist = -1;
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    q.add(new int[]{i , j});
                }
            }
        }if(q.isEmpty() || q.size() == m*n){
            return -1;
        }
        return bfs(q , grid , dist);
    }
    public int bfs(Queue<int[]> q , int[][] grid , int dist){
        int[] dr = {-1 , 0 , 1 , 0};
        int[] dc = {0 , 1, 0 , -1};

        while(!q.isEmpty()){
            int size = q.size();
            dist++;

            for(int i = 0; i < size; i++){
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                for(int j = 0; j < 4; j++){
                    int nr = r + dr[j];
                    int nc = c + dc[j];

                    if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 0){
                        grid[nr][nc] = 1;
                        q.add(new int[]{nr , nc});
                    }
                }
            }
        }
        return dist;
    }
}