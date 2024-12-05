import java.io.FileWriter;
import java.io.IOException;

public class TestesTP2 {
    public static void executarTestes() {
        int[] tamanhos = {10, 20, 50, 100}; // Tamanhos do grafo
        double[] densidades = {0.2, 0.5, 0.8}; // Proporção de arestas
        long media = 0, somador = 0, inicio, fim;
        int quantExecucoes = 10;

        try (FileWriter writer = new FileWriter("resultados_combinacoes.csv")) {
            writer.write("Tamanho,Densidade,Representacao,Algoritmo,Direcionado,Tempo(ns)\n");

            for (int tamanho : tamanhos) {
                for (double densidade : densidades) {
                    // Criar grafos para Lista e Matriz (não-dirigidos)
                    GrafoListaAdj grafoListaNaoDirigido = new GrafoListaAdj(tamanho);
                    GrafoMatrizAdj grafoMatrizNaoDirigido = new GrafoMatrizAdj(tamanho);

                    // Criar grafos para Lista e Matriz (dirigidos)
                    GrafoListaAdj grafoListaDirigido = new GrafoListaAdj(tamanho);
                    GrafoMatrizAdj grafoMatrizDirigido = new GrafoMatrizAdj(tamanho);

                    // Adicionar arestas de acordo com a densidade
                    int numArestas = (int) (tamanho * (tamanho - 1) * densidade);
                    for (int i = 0; i < numArestas; i++) {
                        int origem = (int) (Math.random() * tamanho);
                        int destino = (int) (Math.random() * tamanho);
                        if (origem != destino) {
                            int peso = (int) (Math.random() * 20) + 1; // Peso aleatório entre 1 e 20

                            // Arestas não-dirigidas
                            grafoListaNaoDirigido.adicionarAresta(origem, destino, peso);
                            grafoMatrizNaoDirigido.adicionarAresta(origem, destino, peso);

                            // Arestas dirigidas
                            grafoListaDirigido.adicionarArestaDirigida(origem, destino, peso);
                            grafoMatrizDirigido.adicionarArestaDirigida(origem, destino, peso);
                        }
                    }
                    for (int i = 0; i < quantExecucoes; i++) {
                        // Testar Dijkstra para Lista (Não Dirigido)
                        inicio = System.nanoTime();
                        DijkstraListaAdjNaoDirigido.executarDijkstra(grafoListaNaoDirigido, 0);
                        fim = System.nanoTime();
                        somador += (fim - inicio);
                    }
                    media = (somador / quantExecucoes);
                    writer.write(tamanho + "," + densidade + ",Lista,Dijkstra,NaoDirigido," + media + "\n");

                    // Testar Dijkstra para Matriz (Não Dirigido)
                    for (int i = 0; i < quantExecucoes; i++) {
                        inicio = System.nanoTime();
                        DijkstraMatrizAdjNaoDirigido.executarDijkstra(grafoMatrizNaoDirigido, 0);
                        fim = System.nanoTime();
                        somador += (fim - inicio);
                    }
                    media = (somador / quantExecucoes);
                    writer.write(tamanho + "," + densidade + ",Matriz,Dijkstra,NaoDirigido," + media + "\n");

                    // Testar Bellman-Ford para Lista (Não Dirigido)
                    for (int i = 0; i < quantExecucoes; i++) {
                        inicio = System.nanoTime();
                        BellmanFordListaAdjNaoDirigido.executarBellmanFord(grafoListaNaoDirigido, 0);
                        fim = System.nanoTime();
                        somador += (fim - inicio);
                    }
                    media = (somador / quantExecucoes);
                    writer.write(tamanho + "," + densidade + ",Lista,Bellman-Ford,NaoDirigido," + media + "\n");

                    // Testar Bellman-Ford para Matriz (Não Dirigido)
                    for (int i = 0; i < quantExecucoes; i++) {
                        inicio = System.nanoTime();
                        BellmanFordMatrizAdjNaoDirigido.executarBellmanFord(grafoMatrizNaoDirigido, 0);
                        fim = System.nanoTime();
                        somador += (fim - inicio);
                    }
                    media = (somador / quantExecucoes);
                    writer.write(tamanho + "," + densidade + ",Matriz,Bellman-Ford,NaoDirigido," + media + "\n");

                    // Testar Dijkstra para Lista (Dirigido)
                    for (int i = 0; i < quantExecucoes; i++) {
                        inicio = System.nanoTime();
                        DijkstraListaAdjDirigido.executarDijkstra(grafoListaDirigido, 0);
                        fim = System.nanoTime();
                        somador += (fim - inicio);
                    }
                    media = (somador / quantExecucoes);
                    writer.write(tamanho + "," + densidade + ",Lista,Dijkstra,Dirigido," + media + "\n");

                    // Testar Dijkstra para Matriz (Dirigido)
                    for (int i = 0; i < quantExecucoes; i++) {
                        inicio = System.nanoTime();
                        DijkstraMatrizAdjDirigido.executarDijkstra(grafoMatrizDirigido, 0);
                        fim = System.nanoTime();
                        somador += (fim - inicio);
                    }
                    media = (somador / quantExecucoes);
                    writer.write(tamanho + "," + densidade + ",Matriz,Dijkstra,Dirigido," + media + "\n");

                    // Testar Bellman-Ford para Lista (Dirigido)
                    for (int i = 0; i < quantExecucoes; i++) {
                        inicio = System.nanoTime();
                        BellmanFordListaAdjDirigido.executarBellmanFord(grafoListaDirigido, 0);
                        fim = System.nanoTime();
                        somador += (fim - inicio);
                    }
                    media = (somador / quantExecucoes);
                    writer.write(tamanho + "," + densidade + ",Lista,Bellman-Ford,Dirigido," + media + "\n");

                    // Testar Bellman-Ford para Matriz (Dirigido)
                    for (int i = 0; i < quantExecucoes; i++) {
                        inicio = System.nanoTime();
                        BellmanFordMatrizAdjDirigido.executarBellmanFord(grafoMatrizDirigido, 0);
                        fim = System.nanoTime();
                        somador += (fim - inicio);
                    }
                    media = (somador / quantExecucoes);
                    writer.write(tamanho + "," + densidade + ",Matriz,Bellman-Ford,Dirigido," + media + "\n");
                }
            }

            System.out.println("Resultados salvos em resultados_combinacoes.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
