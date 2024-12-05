import java.util.LinkedList;

public class GrafoListaAdjNaoPonderado {
    private int vertices;
    private LinkedList<Integer>[] listaAdj;

    // Construtor
    public GrafoListaAdjNaoPonderado(int vertices) {
        this.vertices = vertices;
        listaAdj = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            listaAdj[i] = new LinkedList<>();
        }
    }

    // Adiciona aresta direcionada (de origem para destino)
    public void adicionarArestaDirigida(int origem, int destino) {
        listaAdj[origem].add(destino);
    }

    // Adiciona aresta não direcionada (de origem para destino e de destino para origem)
    public void adicionarAresta(int origem, int destino) {
        listaAdj[origem].add(destino);
        listaAdj[destino].add(origem);
    }

    // Método para retornar a lista de adjacência
    public LinkedList<Integer>[] getListaAdj() {
        return listaAdj;
    }

    // Imprimir o grafo
    public void imprimirGrafo() {
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + " -> ");
            for (int adj : listaAdj[i]) {
                System.out.print(adj + " ");
            }
            System.out.println();
        }
    }
}
