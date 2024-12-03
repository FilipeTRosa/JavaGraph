import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Comparator;

public class DijkstraMatrizAdj {
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

            if (visitado[verticeAtual]) continue;
            visitado[verticeAtual] = true;

            for (int vizinho = 0; vizinho < vertices; vizinho++) {
                if (matrizAdj[verticeAtual][vizinho] != 0 && !visitado[vizinho]) {
                    int novaDistancia = distancias[verticeAtual] + matrizAdj[verticeAtual][vizinho];
                    if (novaDistancia < distancias[vizinho]) {
                        distancias[vizinho] = novaDistancia;
                        filaPrioridade.add(new int[]{vizinho, novaDistancia});
                    }
                }
            }
        }

        System.out.println("Distâncias a partir do vértice " + origem + ": " + Arrays.toString(distancias));
    }
}
