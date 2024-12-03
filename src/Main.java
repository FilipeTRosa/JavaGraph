import java.util.Scanner;

public class Main {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long inicio = System.nanoTime();
        long fim = System.nanoTime();

        // Criar grafos
        GrafoListaAdj grafoLista = new GrafoListaAdj(5);
        GrafoMatrizAdj grafoMatriz = new GrafoMatrizAdj(5);

        // Adicionar arestas (mesmo grafo em ambas representações)
        grafoLista.adicionarAresta(0, 1);
        grafoLista.adicionarAresta(0, 2);
        grafoLista.adicionarAresta(1, 3);
        grafoLista.adicionarAresta(1, 4);

        grafoMatriz.adicionarAresta(0, 1);
        grafoMatriz.adicionarAresta(0, 2);
        grafoMatriz.adicionarAresta(1, 3);
        grafoMatriz.adicionarAresta(1, 4);

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Imprimir Grafo (Lista de Adjacência)");
            System.out.println("2. Imprimir Grafo (Matriz de Adjacência)");
            System.out.println("3. Executar BFS (Lista de Adjacência)");
            System.out.println("4. Executar DFS (Lista de Adjacência)");
            System.out.println("5. Executar DFS (Matriz de Adjacência)");
            System.out.println("6. Executar Dijkstra (Lista de Adjacência)");
            System.out.println("7. Executar BellmanFord (Lista de Adjacência)");
            System.out.println("8. Executar Dijkstra (Matriz de Adjacência)");
            System.out.println("9. Executar BellmanFord (Matriz de Adjacência)");
            System.out.println("10. Executar Testes de Desempenho");
            System.out.println("11. Sair");
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
                    BFS.executarBFS(grafoLista, 0);
                    break;
                case 4:
                    DFSListaAdj.executarDFS(grafoLista, 0);
                    break;
                case 5:
                    DFSMatrizAdj.executarDFS(grafoMatriz, 0);
                    break;
                case 6:
                    inicio = System.nanoTime();
                    DijkstraListaAdj.executarDijkstra(grafoLista, 0);
                    fim = System.nanoTime();
                    System.out.println("Tempo de execução: " + (fim - inicio) + " nanosegundos");
                    break;

                case 7:
                    inicio = System.nanoTime();
                    BellmanFordListaAdj.executarBellmanFord(grafoLista, 0);
                    fim = System.nanoTime();
                    System.out.println("Tempo de execução: " + (fim - inicio) + " nanosegundos");
                    break;

                case 8:
                    inicio = System.nanoTime();
                    DijkstraMatrizAdj.executarDijkstra(grafoMatriz, 0);
                    fim = System.nanoTime();
                    System.out.println("Tempo de execução: " + (fim - inicio) + " nanosegundos");
                    break;

                case 9:
                    inicio = System.nanoTime();
                    BellmanFordMatrizAdj.executarBellmanFord(grafoMatriz, 0);
                    fim = System.nanoTime();
                    System.out.println("Tempo de execução: " + (fim - inicio) + " nanosegundos");
                    break;
                case 10:
                    System.out.println("Executando testes de desempenho...");
                    TestesDesempenho.executarTestes();
                    break;
                case 11:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}