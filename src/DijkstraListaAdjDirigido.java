import java.util.*;

public class DijkstraListaAdjDirigido {
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
                int peso = aresta.peso; // Acessa o peso da aresta

                int novaDistancia = distanciaAtual + peso;
                if (novaDistancia < distancias[vizinho]) {
                    distancias[vizinho] = novaDistancia;
                    filaPrioridade.add(new int[]{vizinho, novaDistancia});
                }
            }
        }

        System.out.println("Distâncias a partir do vértice " + origem + ": " + Arrays.toString(distancias));
    }
}
