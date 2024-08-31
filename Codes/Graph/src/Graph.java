import java.util.*;
import java.lang.*;
class Node implements Comparator<Node> {
    public int data;
    public int weight;

    public Node()
    {
    }

    public Node(int node, int cost)
    {
        this.data = node;
        this.weight = cost;
    }

    @Override
    public int compare(Node node1, Node node2)
    {
        if (node1.weight < node2.weight)
            return -1;
        if (node1.weight > node2.weight)
            return 1;
        return 0;
    }
}
public class Graph {
    public int dist[];
    public Set<Integer> processed;
    public PriorityQueue<Node> q;
    public int V;
    List<List<Node> > adj;

    public Graph(int V)
    {
        this.V = V;
        dist = new int[V];
        processed = new HashSet<Integer>();
        q = new PriorityQueue<Node>(V, new Node());
    }
    public void ShortestPathTo(List<List<Node> > adj, int src) {
        this.adj = adj;

        for (int i = 0; i < V; i++)
            dist[i] = Integer.MAX_VALUE;
        q.add(new Node(src, 0));
        dist[src] = 0;
        while (processed.size() != V) {
            if (q.isEmpty())
                return;
            int u = q.remove().data;
            processed.add(u);
            checkNeighbours(u);
        }
    }
    public void checkNeighbours(int u) {
        int edgeDistance = -1;
        int newDistance = -1;
        for (int i = 0; i < adj.get(u).size(); i++) {
            Node v = adj.get(u).get(i);
            if (!processed.contains(v.data)) {
                edgeDistance = v.weight;
                newDistance = dist[u] + edgeDistance;
                if (newDistance < dist[v.data])
                    dist[v.data] = newDistance;
                q.add(new Node(v.data, dist[v.data]));
            }
        }
    }

    public static void main(String args[]){
        Scanner input=new Scanner(System.in);
        int V=input.nextInt();
        int edges=input.nextInt();

        List<List<Node> > adj = new ArrayList<List<Node> >();
        for (int i = 0; i < V; i++) {
            List<Node> item = new ArrayList<Node>();
            adj.add(item);
        }
        for (int i = 0; i <edges ; i++) {
            int u=input.nextInt();
            int cost=input.nextInt();
            int v=input.nextInt();
            adj.get(u).add(new Node(v,cost));
            adj.get(v).add(new Node(u,cost));
        }
        int src=input.nextInt();
        int destination=input.nextInt();
        Graph graph=new Graph(V);
        graph.ShortestPathTo(adj,src);
        System.out.println("Distance of given destination vertex "+destination+"from given source vertex is"+graph.dist[destination]);


    }
}
