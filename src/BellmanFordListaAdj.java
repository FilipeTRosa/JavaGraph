
import java.util.*;

public class BellmanFordListaAdj {
    public static void executarBellmanFord(GrafoListaAdj grafo, int origem) {
        LinkedList<Integer>[] listaAdj = grafo.getListaAdj();
        int vertices = listaAdj.length;

        int[] distancias = new int[vertices];
        Arrays.fill(distancias, Integer.MAX_VALUE);
        distancias[origem] = 0;

        for (int i = 0; i < vertices - 1; i++) {
            for (int u = 0; u < vertices; u++) {
                for (int v : listaAdj[u]) {
                    if (distancias[u] != Integer.MAX_VALUE && distancias[u] + 1 < distancias[v]) {
                        distancias[v] = distancias[u] + 1; // Peso da aresta assumido como 1
                    }
                }
            }
        }

        // Verificar ciclos negativos
        for (int u = 0; u < vertices; u++) {
            for (int v : listaAdj[u]) {
                if (distancias[u] != Integer.MAX_VALUE && distancias[u] + 1 < distancias[v]) {
                    System.out.println("Ciclo negativo detectado!");
                    return;
                }
            }
        }

        System.out.println("Distâncias a partir do vértice " + origem + ": " + Arrays.toString(distancias));
    }
}
