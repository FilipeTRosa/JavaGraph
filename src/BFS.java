import java.util.*;

public class BFS {
    public static void executarBFS(GrafoListaAdj grafo, int inicio) {
        LinkedList<Integer>[] listaAdj = grafo.getListaAdj();
        boolean[] visitado = new boolean[listaAdj.length];
        Queue<Integer> fila = new LinkedList<>();

        visitado[inicio] = true;
        fila.add(inicio);

        System.out.println("BFS a partir do vértice " + inicio + ":");
        while (!fila.isEmpty()) {
            int vertice = fila.poll();
            System.out.print(vertice + " ");

            for (int adj : listaAdj[vertice]) {
                if (!visitado[adj]) {
                    visitado[adj] = true;
                    fila.add(adj);
                }
            }
        }
        System.out.println();
    }
}
