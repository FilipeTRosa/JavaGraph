public class GrafoMatrizAdj {
    private int vertices;
    private int[][] matrizAdj;

    // Construtor
    public GrafoMatrizAdj(int vertices) {
        this.vertices = vertices;
        matrizAdj = new int[vertices][vertices];
    }

    // Adicionar aresta
    public void adicionarAresta(int origem, int destino) {
        matrizAdj[origem][destino] = 1;
        matrizAdj[destino][origem] = 1; // Para grafos não-dirigidos
    }

    // Imprimir a matriz de adjacência
    public void imprimirGrafo() {
        System.out.println("Matriz de Adjacência:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(matrizAdj[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Obter a matriz de adjacência
    public int[][] getMatrizAdj() {
        return matrizAdj;
    }
}
