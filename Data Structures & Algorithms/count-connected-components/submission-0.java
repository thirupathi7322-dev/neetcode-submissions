class Solution {
    public int countComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,adj,visited);
                count++;
            }
        }
        return count;

    }
    public void dfs(int node,ArrayList<ArrayList<Integer>> graph,boolean[] visited){
        visited[node]=true;
        for(int neighbour:graph.get(node)){
            if(!visited[neighbour]){
                dfs(neighbour,graph,visited);
            }
        }
    }
}

