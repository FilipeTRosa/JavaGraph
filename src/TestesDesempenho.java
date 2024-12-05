import java.io.FileWriter;
import java.io.IOException;

public class TestesDesempenho {
    public static void executarTestes() {
        int[] tamanhos = {10, 20, 50, 100}; // Tamanhos do grafo
        double[] densidades = {0.2, 0.5, 0.8}; // Proporção de arestas

        try (FileWriter writer = new FileWriter("resultados.csv")) {
            writer.write("Tamanho,Densidade,Representacao,Algoritmo,Tempo(ns)\n");

            for (int tamanho : tamanhos) {
                for (double densidade : densidades) {
                    // Criar grafos para Lista e Matriz
                    GrafoListaAdj grafoLista = new GrafoListaAdj(tamanho);
                    GrafoMatrizAdj grafoMatriz = new GrafoMatrizAdj(tamanho);

                    // Adicionar arestas com pesos de acordo com a densidade
                    int numArestas = (int) (tamanho * (tamanho - 1) * densidade);
                    for (int i = 0; i < numArestas; i++) {
                        int origem = (int) (Math.random() * tamanho);
                        int destino = (int) (Math.random() * tamanho);
                        int peso = (int) (Math.random() * 20) + 1; // Peso aleatório entre 1 e 20

                        if (origem != destino) {
                            // Adicionar arestas com peso
                            grafoLista.adicionarAresta(origem, destino, peso);
                            grafoMatriz.adicionarAresta(origem, destino, peso);
                        }
                    }

                    // Testar Dijkstra para Lista
                    long inicio = System.nanoTime();
                    DijkstraListaAdjNaoDirigido.executarDijkstra(grafoLista, 0);
                    long fim = System.nanoTime();
                    writer.write(tamanho + "," + densidade + ",Lista,Dijkstra," + (fim - inicio) + "\n");

                    // Testar Dijkstra para Matriz
                    inicio = System.nanoTime();
                    DijkstraMatrizAdjNaoDirigido.executarDijkstra(grafoMatriz, 0);
                    fim = System.nanoTime();
                    writer.write(tamanho + "," + densidade + ",Matriz,Dijkstra," + (fim - inicio) + "\n");

                    // Testar Bellman-Ford para Lista
                    inicio = System.nanoTime();
                    BellmanFordListaAdjNaoDirigido.executarBellmanFord(grafoLista, 0);
                    fim = System.nanoTime();
                    writer.write(tamanho + "," + densidade + ",Lista,Bellman-Ford," + (fim - inicio) + "\n");

                    // Testar Bellman-Ford para Matriz
                    inicio = System.nanoTime();
                    BellmanFordMatrizAdjNaoDirigido.executarBellmanFord(grafoMatriz, 0);
                    fim = System.nanoTime();
                    writer.write(tamanho + "," + densidade + ",Matriz,Bellman-Ford," + (fim - inicio) + "\n");
                }
            }

            System.out.println("Resultados salvos em resultados.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
