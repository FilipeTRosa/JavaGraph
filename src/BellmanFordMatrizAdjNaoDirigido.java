import java.util.*;

public class BellmanFordMatrizAdjNaoDirigido {
    public static void executarBellmanFord(GrafoMatrizAdj grafo, int origem) {
        int[][] matrizAdj = grafo.getMatrizAdj();
        int vertices = matrizAdj.length;

        int[] distancias = new int[vertices];
        Arrays.fill(distancias, Integer.MAX_VALUE);
        distancias[origem] = 0;

        // Relaxar as arestas (V - 1) vezes
        for (int i = 0; i < vertices - 1; i++) {
            for (int u = 0; u < vertices; u++) {
                for (int v = 0; v < vertices; v++) {
                    // Verifica se há uma aresta entre u e v
                    if (matrizAdj[u][v] != Integer.MAX_VALUE && distancias[u] != Integer.MAX_VALUE
                            && distancias[u] + matrizAdj[u][v] < distancias[v]) {
                        distancias[v] = distancias[u] + matrizAdj[u][v]; // Relaxação
                    }
                }
            }
        }

        // Verificar ciclos negativos
        for (int u = 0; u < vertices; u++) {
            for (int v = 0; v < vertices; v++) {
                if (matrizAdj[u][v] != Integer.MAX_VALUE && distancias[u] != Integer.MAX_VALUE
                        && distancias[u] + matrizAdj[u][v] < distancias[v]) {
                    System.out.println("Ciclo negativo detectado!");
                    return;
                }
            }
        }

        System.out.println("Distâncias a partir do vértice " + origem + ": " + Arrays.toString(distancias));
    }
}
