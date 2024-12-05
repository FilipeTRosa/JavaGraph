import java.util.LinkedList;

public class GrafoListaAdj {
    private int vertices;
    private LinkedList<Aresta>[] listaAdj;

    // Classe para representar uma aresta com peso
    class Aresta {
        int destino;
        int peso;

        public Aresta(int destino, int peso) {
            this.destino = destino;
            this.peso = peso;
        }
    }

    // Construtor
    public GrafoListaAdj(int vertices) {
        this.vertices = vertices;
        listaAdj = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            listaAdj[i] = new LinkedList<>();
        }
    }

    // Adiciona aresta direcionada (com peso)
    public void adicionarArestaDirigida(int origem, int destino, int peso) {
        listaAdj[origem].add(new Aresta(destino, peso));
    }

    // Adiciona aresta não direcionada (com peso)
    public void adicionarAresta(int origem, int destino, int peso) {
        listaAdj[origem].add(new Aresta(destino, peso));
        listaAdj[destino].add(new Aresta(origem, peso));
    }

    // Método para retornar a lista de adjacência
    public LinkedList<Aresta>[] getListaAdj() {
        return listaAdj;
    }

    // Imprimir o grafo com pesos
    public void imprimirGrafo() {
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + " -> ");
            for (Aresta aresta : listaAdj[i]) {
                System.out.print("(" + aresta.destino + ", peso " + aresta.peso + ") ");
            }
            System.out.println();
        }
    }
}
