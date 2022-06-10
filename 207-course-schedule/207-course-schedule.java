class Solution {
    
    class Graph{
    private static int v;
    private static List<List<Integer>> adj;
    
    public Graph(int v) {
        this.v = v;
        adj = new ArrayList<List<Integer>>(v);
        for(int i = 0;i<v;i++)
            adj.add(new LinkedList<>());
    }
    
    public static void addLink(int src, int dest) {
        adj.get(src).add(dest);
    }
    }
    
    Graph graph;
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        graph = new Graph(numCourses);
        for(int[] p : prerequisites)
            graph.addLink(p[1] , p[0]);
        return !isCyclic();
    }
    
    public boolean isCyclic() {
        boolean[] visited = new boolean[graph.v];
        boolean[] recStack = new boolean[graph.v];
        
        for(int i = 0;i<graph.v;i++)
            if(isCyclicUtil(i, visited, recStack))
                return true;
        return false;        
    }
    
    public boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack) {
        if(recStack[i])
            return true;
        if(visited[i])
            return false;
        recStack[i] = true;
        visited[i] = true;
        List<Integer> children = graph.adj.get(i);
        
        for(int child : children) {
            if(isCyclicUtil(child, visited, recStack))
                return true;
        }
        recStack[i] = false;
        return false;
    }
    
}
