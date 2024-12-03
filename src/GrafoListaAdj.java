
import java.util.*;


public class GrafoListaAdj {
    private int vertices;
    private LinkedList<Integer>[] listaAdj;

    // Construtor
    public GrafoListaAdj(int vertices) {
        this.vertices = vertices;
        listaAdj = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            listaAdj[i] = new LinkedList<>();
        }
    }

    // Adicionar aresta
    public void adicionarAresta(int origem, int destino) {
        listaAdj[origem].add(destino);
        listaAdj[destino].add(origem); // Para grafos não-dirigidos
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

    // Obter lista de adjacências
    public LinkedList<Integer>[] getListaAdj() {
        return listaAdj;
    }
}
