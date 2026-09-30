import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        No raiz = new No("0", null, null);
        Arvore arvore = new Arvore(raiz);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do arquivo a ser lido (ex: teste.txt): ");
        String caminhoArquivo = scanner.nextLine().trim();


        try {
            ExtraiPalavra leitor = new ExtraiPalavra(caminhoArquivo);
            String palavra;

            while ((palavra = leitor.extraiPalavra()) != null) {
                int linha = leitor.getNumLinha();
                int coluna = leitor.getNumColuna();

                arvore.inserirPalavra(palavra.toLowerCase(), linha, coluna);
            }

            leitor.fechar();
            System.out.println("\nIndexação do arquivo concluída!\n");

            String[] palavrasBusca;
            if (caminhoArquivo.equalsIgnoreCase("exemplo2.txt")) {
                palavrasBusca = new String[]{
                        "sociedade", "software", "ideia", "pessoa",
                        "informatica", "etica", "muito", "ciencia",
                        "computacao", "que", "area", "moral"
                };
            } else {
                palavrasBusca = new String[]{
                        "trabalho", "computacao", "governo", "educacao",
                        "tecnologia", "formacao", "desenvolvimento",
                        "que", "informatica", "em", "crise"
                };
            }

            for (String p : palavrasBusca) {
                System.out.println("\nBuscando por: \"" + p + "\"");
                arvore.buscarPalavra(p.toLowerCase());
            }

        } catch (Exception e) {
            System.err.println("Erro ao processar o arquivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}