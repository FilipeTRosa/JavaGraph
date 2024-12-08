import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeitorGrafoGR {

    // Método para ler grafo como lista de adjacência
    public static GrafoListaAdj lerGrafo(String caminhoArquivo) {
        GrafoListaAdj grafo = null;
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.startsWith("c")) continue;
                if (linha.startsWith("p")) {
                    String[] partes = linha.split("\\s+");
                    int vertices = Integer.parseInt(partes[2]);
                    grafo = new GrafoListaAdj(vertices);
                }
                if (linha.startsWith("a")) {
                    String[] partes = linha.split("\\s+");
                    int origem = Integer.parseInt(partes[1]) - 1;
                    int destino = Integer.parseInt(partes[2]) - 1;
                    int peso = Integer.parseInt(partes[3]);
                    grafo.adicionarArestaDirigida(origem, destino, peso);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return grafo;
    }

    // Método similar para ler o grafo como matriz de adjacência
    public static GrafoMatrizAdj lerGrafoMatriz(String caminhoArquivo) {
        GrafoMatrizAdj grafo = null;
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.startsWith("c")) continue;
                if (linha.startsWith("p")) {
                    String[] partes = linha.split("\\s+");
                    int vertices = Integer.parseInt(partes[2]);
                    grafo = new GrafoMatrizAdj(vertices);
                }
                if (linha.startsWith("a")) {
                    String[] partes = linha.split("\\s+");
                    int origem = Integer.parseInt(partes[1]) - 1;
                    int destino = Integer.parseInt(partes[2]) - 1;
                    int peso = Integer.parseInt(partes[3]);
                    grafo.adicionarArestaDirigida(origem, destino, peso);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return grafo;
    }
}
