
import java.util.*;

public class DFSListaAdj {
    public static void executarDFS(GrafoListaAdjNaoPonderado grafo, int inicio) {
        LinkedList<Integer>[] listaAdj = grafo.getListaAdj();
        boolean[] visitado = new boolean[listaAdj.length];

        System.out.println("DFS a partir do vértice " + inicio + ":");
        dfsRecursivo(inicio, visitado, listaAdj);
        System.out.println();
    }

    private static void dfsRecursivo(int vertice, boolean[] visitado, LinkedList<Integer>[] listaAdj) {
        visitado[vertice] = true;
        System.out.print(vertice + " ");

        for (int adj : listaAdj[vertice]) {
            if (!visitado[adj]) {
                dfsRecursivo(adj, visitado, listaAdj);
            }
        }
    }
}
