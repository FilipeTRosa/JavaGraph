import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Comparator;

public class DijkstraMatrizAdjNaoDirigido {
    public static void executarDijkstra(GrafoMatrizAdj grafo, int origem) {
        int[][] matrizAdj = grafo.getMatrizAdj();
        int vertices = matrizAdj.length;

        int[] distancias = new int[vertices];
        Arrays.fill(distancias, Integer.MAX_VALUE);
        distancias[origem] = 0;

        boolean[] visitado = new boolean[vertices];
        PriorityQueue<int[]> filaPrioridade = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        filaPrioridade.add(new int[]{origem, 0});

        while (!filaPrioridade.isEmpty()) {
            int[] atual = filaPrioridade.poll();
            int verticeAtual = atual[0];
            int distanciaAtual = atual[1];

            if (distanciaAtual > distancias[verticeAtual]) continue;

            for (int vizinho = 0; vizinho < vertices; vizinho++) {
                // Se há uma aresta entre verticeAtual e vizinho, e ainda não foi visitado
                if (matrizAdj[verticeAtual][vizinho] != Integer.MAX_VALUE && !visitado[vizinho]) {
                    int peso = matrizAdj[verticeAtual][vizinho]; // Acessa o peso da aresta
                    int novaDistancia = distanciaAtual + peso;

                    if (novaDistancia < distancias[vizinho]) {
                        distancias[vizinho] = novaDistancia;
                        filaPrioridade.add(new int[]{vizinho, novaDistancia});
                    }
                }
            }

            visitado[verticeAtual] = true;
        }

        System.out.println("Distâncias a partir do vértice " + origem + ": " + Arrays.toString(distancias));
    }
}
