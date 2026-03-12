class Solution {
    class DSU{
        int[] parent;
        int[] rank;
        DSU(int n){
            parent=new int[n];
            rank=new int[n];
            for(int i=0; i<n; i++){
                parent[i]=i;
            }
        }
        public int find(int n){
            if(parent[n]==n) return n;

            return parent[n]=find(parent[n]);
        }
        public void union(int a, int b){
            int pa=find(a);
            int pb=find(b);

            if(pa==pb) return;

            if(rank[pa]<rank[pb]) parent[pa]=pb;

            else if(rank[pa]>rank[pb]) parent[pb]=pa;

            else{
                parent[pb]=pa;
                rank[pa]++;
            }
        }
    }
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        Arrays.sort(edgeList,(a,b)->a[2]-b[2]);
        int m=queries.length;
        boolean[] ans=new boolean[m];
        DSU obj=new DSU(n);
        int[][] q=new int[m][4];
        for(int i=0; i<m; i++){
            q[i][0]=queries[i][0];
            q[i][1]=queries[i][1];
            q[i][2]=queries[i][2];
            q[i][3]=i;
        }
        Arrays.sort(q,(a,b)->a[2]-b[2]);
        int idx=0;
        for(int i=0; i<m; i++){
            int limit=q[i][2];

            while(idx<edgeList.length && edgeList[idx][2]<limit){
                int from=edgeList[idx][0];
                int to=edgeList[idx][1];
                obj.union(from,to);
                idx++;
            }
            if(obj.find(q[i][0])==obj.find(q[i][1])){
                ans[q[i][3]]=true;
            }
        }
        return ans;
    }
}