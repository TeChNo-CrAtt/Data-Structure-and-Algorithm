class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int time = 0;
        int freshOranges = 0;
        boolean freshFound = false;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    freshOranges++;
                } else if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });
                }
            }
        }
        while (!q.isEmpty() && freshOranges != 0) {
            int qSize = q.size();

            while (qSize > 0) {
                int[] currOranges = q.remove();
                int x = currOranges[0];
                int y = currOranges[1];
                //left
                if ((y - 1) >= 0 && grid[x][y - 1] == 1) {
                    freshOranges--;
                    grid[x][y - 1] = 2;
                    freshFound = true;
                    q.add(new int[] { x, y - 1 });
                }
                // right
                if ((y + 1 < n) && grid[x][y + 1] == 1) {
                    freshOranges--;
                    grid[x][y + 1] = 2;
                    freshFound = true;
                    q.add(new int[] { x, y + 1 });
                }
                // top
                if ((x - 1) >= 0 && grid[x - 1][y] == 1) {
                    freshOranges--;
                    grid[x - 1][y] = 2;
                    freshFound = true;
                    q.add(new int[] { x - 1, y });
                }
                // bottom
                if ((x + 1) < m && grid[x + 1][y] == 1) {
                    freshOranges--;
                    grid[x + 1][y] = 2;
                    freshFound = true;
                    q.add(new int[] { x + 1, y });
                }

                qSize--;
            }
            if (freshFound == true) {
                time++;
            }
        }

        if (freshOranges == 0) {
            return time;
        } else {
            return -1;
        }
    }
}