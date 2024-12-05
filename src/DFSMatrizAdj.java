import java.util.*;

public class DFSMatrizAdj {
    public static void executarDFS(GrafoMatrizAdjNaoPonderado grafo, int inicio) {
        int[][] matrizAdj = grafo.getMatrizAdj();
        boolean[] visitado = new boolean[matrizAdj.length];

        System.out.println("DFS a partir do vértice " + inicio + ":");
        dfsRecursivo(inicio, visitado, matrizAdj);
        System.out.println();
    }

    private static void dfsRecursivo(int vertice, boolean[] visitado, int[][] matrizAdj) {
        visitado[vertice] = true;
        System.out.print(vertice + " ");

        for (int i = 0; i < matrizAdj[vertice].length; i++) {
            if (matrizAdj[vertice][i] == 1 && !visitado[i]) {
                dfsRecursivo(i, visitado, matrizAdj);
            }
        }
    }
}
