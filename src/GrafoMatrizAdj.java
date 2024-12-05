public class GrafoMatrizAdj {
    private int vertices;
    private int[][] matrizAdj;

    public GrafoMatrizAdj(int vertices) {
        this.vertices = vertices;
        matrizAdj = new int[vertices][vertices];
        // Inicializa a matriz com valores grandes (infinito) para representar a ausência de arestas
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (i != j) {
                    matrizAdj[i][j] = Integer.MAX_VALUE; // Representa "infinito" para arestas ausentes
                }
            }
        }
    }

    // Adiciona aresta direcionada (com peso)
    public void adicionarArestaDirigida(int origem, int destino, int peso) {
        matrizAdj[origem][destino] = peso; // Adiciona o peso na matriz de adjacência
    }

    // Adiciona aresta não direcionada (com peso)
    public void adicionarAresta(int origem, int destino, int peso) {
        matrizAdj[origem][destino] = peso;
        matrizAdj[destino][origem] = peso; // Adiciona peso em ambas as direções
    }

    // Método para retornar a matriz de adjacência
    public int[][] getMatrizAdj() {
        return matrizAdj;
    }

    // Imprimir o grafo
    public void imprimirGrafo() {
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (matrizAdj[i][j] == Integer.MAX_VALUE) {
                    System.out.print("∞ "); // Representa "infinito"
                } else {
                    System.out.print(matrizAdj[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
