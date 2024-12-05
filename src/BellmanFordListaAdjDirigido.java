import java.util.*;

public class BellmanFordListaAdjDirigido {
    public static void executarBellmanFord(GrafoListaAdj grafo, int origem) {
        LinkedList<GrafoListaAdj.Aresta>[] listaAdj = grafo.getListaAdj();
        int vertices = listaAdj.length;

        int[] distancias = new int[vertices];
        Arrays.fill(distancias, Integer.MAX_VALUE);
        distancias[origem] = 0;

        // Relaxar as arestas (V - 1) vezes
        for (int i = 0; i < vertices - 1; i++) {
            for (int u = 0; u < vertices; u++) {
                for (GrafoListaAdj.Aresta aresta : listaAdj[u]) {
                    int v = aresta.destino;
                    int peso = aresta.peso; // Acessa o peso da aresta

                    if (distancias[u] != Integer.MAX_VALUE && distancias[u] + peso < distancias[v]) {
                        distancias[v] = distancias[u] + peso;
                    }
                }
            }
        }

        // Verificar ciclos negativos
        for (int u = 0; u < vertices; u++) {
            for (GrafoListaAdj.Aresta aresta : listaAdj[u]) {
                int v = aresta.destino;
                int peso = aresta.peso; // Acessa o peso da aresta

                if (distancias[u] != Integer.MAX_VALUE && distancias[u] + peso < distancias[v]) {
                    System.out.println("Ciclo negativo detectado!");
                    return;
                }
            }
        }

        System.out.println("Distâncias a partir do vértice " + origem + ": " + Arrays.toString(distancias));
    }
}
