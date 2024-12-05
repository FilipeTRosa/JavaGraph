
import java.util.*;


public class TesteBellmanDijkstra {
    // Algoritmo de Dijkstra
    public static void executarDijkstra(GrafoListaAdj grafo, int origem) {
        LinkedList<GrafoListaAdj.Aresta>[] listaAdj = grafo.getListaAdj();
        int vertices = listaAdj.length;

        int[] distancias = new int[vertices];
        Arrays.fill(distancias, Integer.MAX_VALUE);
        distancias[origem] = 0;

        PriorityQueue<int[]> filaPrioridade = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        filaPrioridade.add(new int[]{origem, 0});

        while (!filaPrioridade.isEmpty()) {
            int[] atual = filaPrioridade.poll();
            int verticeAtual = atual[0];
            int distanciaAtual = atual[1];

            if (distanciaAtual > distancias[verticeAtual]) continue;

            for (GrafoListaAdj.Aresta aresta : listaAdj[verticeAtual]) {
                int vizinho = aresta.destino;
                int peso = aresta.peso;

                int novaDistancia = distanciaAtual + peso;
                if (novaDistancia < distancias[vizinho]) {
                    distancias[vizinho] = novaDistancia;
                    filaPrioridade.add(new int[]{vizinho, novaDistancia});
                }
            }
        }

        System.out.println("Dijkstra - Distâncias a partir do vértice " + origem + ": " + Arrays.toString(distancias));
    }

    // Algoritmo de Bellman-Ford
    public static void executarBellmanFord(GrafoListaAdj grafo, int origem) {
        LinkedList<GrafoListaAdj.Aresta>[] listaAdj = grafo.getListaAdj();
        int vertices = listaAdj.length;

        int[] distancias = new int[vertices];
        Arrays.fill(distancias, Integer.MAX_VALUE);
        distancias[origem] = 0;

        for (int i = 0; i < vertices - 1; i++) {
            for (int u = 0; u < vertices; u++) {
                for (GrafoListaAdj.Aresta aresta : listaAdj[u]) {
                    int v = aresta.destino;
                    int peso = aresta.peso;

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
                int peso = aresta.peso;

                if (distancias[u] != Integer.MAX_VALUE && distancias[u] + peso < distancias[v]) {
                    System.out.println("Ciclo negativo detectado!");
                    return;
                }
            }
        }

        System.out.println("Bellman-Ford - Distâncias a partir do vértice " + origem + ": " + Arrays.toString(distancias));
    }
}