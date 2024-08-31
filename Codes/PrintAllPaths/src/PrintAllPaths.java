import java.util.*;
import java.lang.*;
public class PrintAllPaths {
    public static int V;
    public static ArrayList<Integer>[] adjList;
    public static void addEdge(int u, int v)
    {
        adjList[u].add(v);
    }
    private static void DFS(Integer src, Integer destination, boolean[] visited, List<Integer> inPath){
        if(src.equals(destination)) {
            System.out.println(inPath);
            return;
        }
        visited[src] = true;
        for (Integer i : adjList[src]) {
            if (!visited[i]) {
                inPath.add(i);
                DFS(i, destination, visited, inPath);
                inPath.remove(i);
            }
        }
        visited[src] = false;
    }
    public static void printAllPaths(int src, int destination){
        boolean[] isVisited = new boolean[V];
        ArrayList<Integer> pathList = new ArrayList<>();
        pathList.add(src);
        DFS(src, destination, isVisited, pathList);
    }
    public static void main(String args[]){
        Scanner input=new Scanner(System.in);
        V=input.nextInt();
        int edges=input.nextInt();
        for (int i=0;i<edges;i++){
            int u=input.nextInt();
            int v=input.nextInt();
            addEdge(u,v);
        }
        int src=input.nextInt();
        int destination=input.nextInt();
        printAllPaths(src,destination);
    }
}
