import java.io.*;
import java.util.List;

public class TestesComArquivos {
    public static void executarTestes(List<String> arquivosGrafo) {
        long inicio, fim;
        long somador, media;
        int quantExecucoes = 10;

        try (FileWriter writer = new FileWriter("resultados_grafos_prontos.csv");
             FileWriter writerTempos = new FileWriter("resultados_tempos_execucao.csv")) {

            // Cabeçalhos para os arquivos CSV
            writer.write("Arquivo,Vertices,Arestas,Densidade,Representacao,Algoritmo,Direcionado,Tempo(ns)\n");
            writerTempos.write("Arquivo,Vertices,Arestas,Densidade,Representacao,Algoritmo,Direcionado,Execucao,Tempo(ns)\n");

            for (String arquivo : arquivosGrafo) {
                System.out.println("Testando o grafo: " + arquivo);

                // Separar o nome do arquivo para obter o tamanho e número de arestas
                String[] partes = arquivo.split("-"); // Separa em 'sample100' e '1980.gr'
                String[] tamanhoPartes = partes[0].split("sample"); // Pega o número de vértices
                int tamanho = Integer.parseInt(tamanhoPartes[1]);

                // Extrair o número de arestas (removendo ".gr" e convertendo para int)
                String numeroArestasStr = partes[1].replace(".gr", "");
                int numeroArestas = Integer.parseInt(numeroArestasStr);

                // Calcular o número máximo de arestas para um grafo dirigido
                int maxArestas = tamanho * (tamanho - 1); // Fórmula para grafo dirigido

                // Calcular a densidade
                double densidade = (double) numeroArestas / maxArestas;

                // Ler grafos a partir do arquivo
                GrafoListaAdj grafoLista = LeitorGrafoGR.lerGrafo(arquivo);
                GrafoMatrizAdj grafoMatriz = LeitorGrafoGR.lerGrafoMatriz(arquivo);

                if (grafoLista == null || grafoMatriz == null) {
                    System.out.println("Erro ao ler o grafo do arquivo: " + arquivo);
                    continue;
                }

                // Testar Dijkstra para Lista (Dirigido)
                somador = 0;
                for (int i = 0; i < quantExecucoes; i++) {
                    inicio = System.nanoTime();
                    DijkstraListaAdjDirigido.executarDijkstra(grafoLista, 0);
                    fim = System.nanoTime();
                    long tempoExecucao = fim - inicio;
                    writerTempos.write(arquivo + "," + tamanho + "," + numeroArestas + "," + densidade + ",Lista,Dijkstra,Dirigido," + (i + 1) + "," + tempoExecucao + "\n");
                    somador += tempoExecucao;
                }
                media = somador / quantExecucoes;
                writer.write(arquivo + "," + tamanho + "," + numeroArestas + "," + densidade + ",Lista,Dijkstra,Dirigido," + media + "\n");

                // Testar Dijkstra para Matriz (Dirigido)
                somador = 0;
                for (int i = 0; i < quantExecucoes; i++) {
                    inicio = System.nanoTime();
                    DijkstraMatrizAdjDirigido.executarDijkstra(grafoMatriz, 0);
                    fim = System.nanoTime();
                    long tempoExecucao = fim - inicio;
                    writerTempos.write(arquivo + "," + tamanho + "," + numeroArestas + "," + densidade +  ",Matriz,Dijkstra,Dirigido," + (i + 1) + "," + tempoExecucao + "\n");
                    somador += tempoExecucao;
                }
                media = somador / quantExecucoes;
                writer.write(arquivo + "," + tamanho + "," + numeroArestas + "," + densidade + ",Matriz,Dijkstra,Dirigido," + media + "\n");

                // Testar Bellman-Ford para Lista (Dirigido)
                somador = 0;
                for (int i = 0; i < quantExecucoes; i++) {
                    inicio = System.nanoTime();
                    BellmanFordListaAdjDirigido.executarBellmanFord(grafoLista, 0);
                    fim = System.nanoTime();
                    long tempoExecucao = fim - inicio;
                    writerTempos.write(arquivo + "," + tamanho + "," + numeroArestas + "," + densidade +  ",Lista,Bellman-Ford,Dirigido," + (i + 1) + "," + tempoExecucao + "\n");
                    somador += tempoExecucao;
                }
                media = somador / quantExecucoes;
                writer.write(arquivo + "," + tamanho + "," + numeroArestas + "," + densidade + ",Lista,Bellman-Ford,Dirigido," + media + "\n");

                // Testar Bellman-Ford para Matriz (Dirigido)
                somador = 0;
                for (int i = 0; i < quantExecucoes; i++) {
                    inicio = System.nanoTime();
                    BellmanFordMatrizAdjDirigido.executarBellmanFord(grafoMatriz, 0);
                    fim = System.nanoTime();
                    long tempoExecucao = fim - inicio;
                    writerTempos.write(arquivo + "," + tamanho + "," + numeroArestas + "," + densidade +  ",Matriz,Bellman-Ford,Dirigido," + (i + 1) + "," + tempoExecucao + "\n");
                    somador += tempoExecucao;
                }
                media = somador / quantExecucoes;
                writer.write(arquivo + "," + tamanho + "," + numeroArestas + "," + densidade + ",Matriz,Bellman-Ford,Dirigido," + media + "\n");
            }

            System.out.println("Resultados salvos em resultados_grafos_prontos.csv e resultados_tempos_execucao.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
