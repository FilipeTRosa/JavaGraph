import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long inicio;
        long fim;

        // Criar grafos
        GrafoListaAdj grafoLista = new GrafoListaAdj(5);
        GrafoMatrizAdj grafoMatriz = new GrafoMatrizAdj(5);

        // Adicionar arestas com pesos aleatórios
        grafoLista.adicionarAresta(0, 1, (int) (Math.random() * 20) + 1);
        grafoLista.adicionarAresta(0, 2, (int) (Math.random() * 20) + 1);
        grafoLista.adicionarAresta(1, 3, (int) (Math.random() * 20) + 1);
        grafoLista.adicionarAresta(1, 4, (int) (Math.random() * 20) + 1);

        grafoMatriz.adicionarAresta(0, 1, (int) (Math.random() * 20) + 1);
        grafoMatriz.adicionarAresta(0, 2, (int) (Math.random() * 20) + 1);
        grafoMatriz.adicionarAresta(1, 3, (int) (Math.random() * 20) + 1);
        grafoMatriz.adicionarAresta(1, 4, (int) (Math.random() * 20) + 1);



        // Criar grafos NAO PONDERADOS
        GrafoListaAdjNaoPonderado grafoListaNaoPonderado = new GrafoListaAdjNaoPonderado(5);
        GrafoMatrizAdjNaoPonderado grafoMatrizNaoPonderado = new GrafoMatrizAdjNaoPonderado(5);

        // Adicionar arestas (mesmo grafo em ambas representações)
        grafoListaNaoPonderado.adicionarAresta(0, 1);
        grafoListaNaoPonderado.adicionarAresta(0, 2);
        grafoListaNaoPonderado.adicionarAresta(1, 3);
        grafoListaNaoPonderado.adicionarAresta(1, 4);

        grafoMatrizNaoPonderado.adicionarAresta(0, 1);
        grafoMatrizNaoPonderado.adicionarAresta(0, 2);
        grafoMatrizNaoPonderado.adicionarAresta(1, 3);
        grafoMatrizNaoPonderado.adicionarAresta(1, 4);


        // Criar o grafo TESTE FUNCIONAMENTO
        GrafoListaAdj grafo = new GrafoListaAdj(4);
        grafo.adicionarAresta(0, 1, 10);
        grafo.adicionarAresta(0, 2, 3);
        grafo.adicionarAresta(1, 2, 1);
        grafo.adicionarAresta(1, 3, 2);
        grafo.adicionarAresta(2, 3, 7);

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Imprimir Grafo (Lista de Adjacência)");
            System.out.println("2. Imprimir Grafo (Matriz de Adjacência)");
            //System.out.println("3. Executar BFS (Lista de Adjacência)");
            //System.out.println("4. Executar DFS (Lista de Adjacência)");
            //System.out.println("5. Executar DFS (Matriz de Adjacência)");
            System.out.println("6. Executar Dijkstra (Lista de Adjacência - Não Dirigido)");
            System.out.println("7. Executar BellmanFord (Lista de Adjacência - Não Dirigido)");
            System.out.println("8. Executar Dijkstra (Matriz de Adjacência - Não Dirigido)");
            System.out.println("9. Executar BellmanFord (Matriz de Adjacência - Não Dirigido)");
            System.out.println("10. Executar Testes de Desempenho");
            System.out.println("11. Executar Dijkstra (Lista de Adjacência - Dirigido)");
            System.out.println("12. Executar Bellman-Ford (Lista de Adjacência - Dirigido)");
            System.out.println("13. Executar Dijkstra (Matriz de Adjacência - Dirigido)");
            System.out.println("14. Executar BellmanFord (Matriz de Adjacência - Dirigido)");
            System.out.println("16. Executar Testes com Arquivos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    grafoLista.imprimirGrafo();
                    break;
                case 2:
                    grafoMatriz.imprimirGrafo();
                    break;
                case 3:
                    BFS.executarBFS(grafoListaNaoPonderado, 0);
                    break;
                case 4:
                    DFSListaAdj.executarDFS(grafoListaNaoPonderado, 0);
                    break;
                case 5:
                    DFSMatrizAdj.executarDFS(grafoMatrizNaoPonderado, 0);
                    break;
                case 6:
                    inicio = System.nanoTime();
                    DijkstraListaAdjNaoDirigido.executarDijkstra(grafoLista, 0);
                    fim = System.nanoTime();
                    System.out.println("Tempo de execução: " + (fim - inicio) + " nanosegundos");
                    break;
                case 7:
                    inicio = System.nanoTime();
                    BellmanFordListaAdjNaoDirigido.executarBellmanFord(grafoLista, 0);
                    fim = System.nanoTime();
                    System.out.println("Tempo de execução: " + (fim - inicio) + " nanosegundos");
                    break;
                case 8:
                    inicio = System.nanoTime();
                    DijkstraMatrizAdjNaoDirigido.executarDijkstra(grafoMatriz, 0);
                    fim = System.nanoTime();
                    System.out.println("Tempo de execução: " + (fim - inicio) + " nanosegundos");
                    break;
                case 9:
                    inicio = System.nanoTime();
                    BellmanFordMatrizAdjNaoDirigido.executarBellmanFord(grafoMatriz, 0);
                    fim = System.nanoTime();
                    System.out.println("Tempo de execução: " + (fim - inicio) + " nanosegundos");
                    break;
                case 10:
                    System.out.println("Executando testes de desempenho...");
                    TestesTP2.executarTestes();
                    break;
                case 11:
                    System.out.println("Executando Dijkstra em grafo dirigido...");
                    DijkstraListaAdjDirigido.executarDijkstra(grafoLista, 0);
                    break;
                case 12:
                    System.out.println("Executando Bellman-Ford em grafo dirigido...");
                    BellmanFordListaAdjDirigido.executarBellmanFord(grafoLista, 0);
                    break;
                case 13:
                    System.out.println("Executando Dijkstra (Matriz de Adjacência - Dirigido)...");
                    inicio = System.nanoTime();
                    DijkstraMatrizAdjDirigido.executarDijkstra(grafoMatriz, 0);
                    fim = System.nanoTime();
                    System.out.println("Tempo de execução: " + (fim - inicio) + " nanosegundos");
                    break;
                case 14:
                    System.out.println("Executando Bellman-Ford (Matriz de Adjacência - Dirigido)...");
                    inicio = System.nanoTime();
                    BellmanFordMatrizAdjDirigido.executarBellmanFord(grafoMatriz, 0);
                    fim = System.nanoTime();
                    System.out.println("Tempo de execução: " + (fim - inicio) + " nanosegundos");
                    break;
                case 15:
                    grafo.imprimirGrafo();
                    System.out.println("\n--- Executando Dijkstra ---");
                    TesteBellmanDijkstra.executarDijkstra(grafo, 0); // Vértice inicial: 0

                    System.out.println("\n--- Executando Bellman-Ford ---");
                    TesteBellmanDijkstra.executarBellmanFord(grafo, 0); // Vértice inicial: 0
                    break;
                case 16:
                    List<String> arquivosGrafo = List.of(
                            "grafos/sample100-1980.gr",
                            "grafos/sample100-3960.gr",
                            "grafos/sample100-5940.gr",
                            "grafos/sample100-7920.gr",
                            "grafos/sample100-9900.gr",
                            "grafos/sample200-7960.gr",
                            "grafos/sample200-15920.gr",
                            "grafos/sample200-23880.gr",
                            "grafos/sample200-31840.gr",
                            "grafos/sample200-39800.gr",
                            "grafos/sample500-49900.gr",
                            "grafos/sample500-99800.gr",
                            "grafos/sample500-149700.gr",
                            "grafos/sample500-199600.gr",
                            "grafos/sample500-249500.gr"
                    );
                    TestesComArquivos.executarTestes(arquivosGrafo);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
