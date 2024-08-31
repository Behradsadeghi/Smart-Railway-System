import java.util.*;
import java.lang.*;
public class MaximalClique {
    static int MAX = 100, V;
    static int []store = new int[MAX];
    static int [][]graph = new int[MAX][MAX];
    static int []d = new int[MAX];
    static boolean is_clique(int u)
    {


        for (int i = 1; i < u; i++)
        {
            for (int j = i + 1; j < u; j++)


                if (graph[store[i]][store[j]] == 0)
                    return false;
        }
        return true;
    }
    static int maxCliques(int i, int l){

        int max_ = 0;
        for (int j = i + 1; j <= V; j++)
        {
            store[l] = j;
            if (is_clique(l + 1))
            {
                max_ = Math.max(max_, l);
                max_ = Math.max(max_, maxCliques(j, l + 1));
            }
        }
        return max_;
    }
    public static void addEdge(ArrayList<ArrayList<Integer> > adj,int u,int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void main(String args[]){
        Scanner input=new Scanner(System.in);
        int V=input.nextInt();
        int edges=input.nextInt();
        int Edges[][]=new int[edges][2];
        for (int i = 0; i <edges ; i++) {
            int u=input.nextInt();
            int v=input.nextInt();
            Edges[i][0]=u;
            Edges[i][1]=v;
        }
        for (int i = 0; i <edges; i++)
        {
            graph[Edges[i][0]][Edges[i][1]] = 1;
            graph[Edges[i][1]][Edges[i][0]] = 1;
            d[Edges[i][0]]++;
            d[Edges[i][1]]++;
        }
        int mc=maxCliques(0,1);
        System.out.println(mc);
    }
}
