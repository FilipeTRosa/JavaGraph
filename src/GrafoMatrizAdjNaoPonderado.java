import java.util.LinkedList;


public class GrafoMatrizAdjNaoPonderado {
    private int vertices;
    private int[][] matrizAdj;

    public GrafoMatrizAdjNaoPonderado(int vertices) {
        this.vertices = vertices;
        matrizAdj = new int[vertices][vertices];
    }

    // Adiciona aresta direcionada (de origem para destino)
    public void adicionarArestaDirigida(int origem, int destino) {
        matrizAdj[origem][destino] = 1; // Adiciona aresta de origem para destino
    }

    // Adiciona aresta não direcionada (de origem para destino e de destino para origem)
    public void adicionarAresta(int origem, int destino) {
        matrizAdj[origem][destino] = 1;
        matrizAdj[destino][origem] = 1; // Adiciona aresta bidirecional
    }

    // Método para retornar a matriz de adjacência
    public int[][] getMatrizAdj() {
        return matrizAdj;
    }

    // Imprimir o grafo
    public void imprimirGrafo() {
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(matrizAdj[i][j] + " ");
            }
            System.out.println();
        }
    }
}
