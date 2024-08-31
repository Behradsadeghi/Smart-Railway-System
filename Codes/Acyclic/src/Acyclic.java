import java.util.*;

class Graph {

    public final int V;
    public  List<List<Integer>> adj;

    public Graph(int V) {
        this.V = V;
        adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++)
            adj.add(new LinkedList<>());
    }
    public void addEdge(int src,int dest){
        this.adj.get(src).add(dest);
    }
    public boolean hasCycle(int u,boolean[] visited,boolean[] inPath){
        if(inPath[u])
            return true;
        if(visited[u])
            return false;
        visited[u]=true;
        inPath[u]=true;
        List<Integer> neighbours=this.adj.get(u);
        for (Integer n:neighbours) {
            if(hasCycle(n,visited,inPath))
                return true;
        }
        return false;
    }
    public boolean isCyclic(){
        boolean visited[]=new boolean[V];
        boolean inPath[]=new boolean[V];
        for (int i = 0; i <V ; i++) {
            if(hasCycle(i,visited,inPath))
                return true;
        }
        return false;
    }

}
public class Acyclic {
    public static void main(String args[]){
        Scanner input=new Scanner(System.in);
        int V=input.nextInt();
        Graph graph=new Graph(V);
        int edges=input.nextInt();
        for (int i = 0; i <edges ; i++) {
            int u=input.nextInt();
            int v=input.nextInt();
            graph.addEdge(u,v);
        }
        System.out.println(graph.isCyclic());
    }

}
