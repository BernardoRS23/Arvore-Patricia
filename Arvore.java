import java.util.ArrayList;

public class Arvore {
    private No raiz;

    public Arvore(No raiz) {
        this.raiz = raiz;
    }

    public void inserirPalavra(String palavra, int linha, int coluna) {
        String bitsPalavra = converterPalavraBit(palavra);

        if (bitsPalavra.charAt(0) == '0') {
            if (raiz.getNoEsq() == null) {
                No novoNo = new No(bitsPalavra, null, null);
                novoNo.adicionarOcorrencia(linha, coluna);
                raiz.setNoEsq(novoNo);
                System.out.println("Palavra inserida com sucesso!");
            } else {
                inserirPalavra(bitsPalavra, linha, coluna, raiz.getNoEsq());
            }
        } else {
            if (raiz.getNoDir() == null) {
                No novoNo = new No(bitsPalavra, null, null);
                novoNo.adicionarOcorrencia(linha, coluna);
                raiz.setNoDir(novoNo);
                System.out.println("Palavra inserida com sucesso!");
            } else {
                inserirPalavra(bitsPalavra, linha, coluna, raiz.getNoDir());
            }
        }
    }

    private void inserirPalavra(String bits, int linha, int coluna, No raiz) {
        int i = 0;

        String valorNoStr = raiz.getValor();

        while (i < valorNoStr.length() && bits.length() > 0 && bits.charAt(0) == valorNoStr.charAt(i)) {
            bits = bits.substring(1);
            i++;
        }

        if (i<valorNoStr.length()) {
            String newValor = valorNoStr.substring(0, i);
            String valorNoNovo = valorNoStr.substring(i);
            No noDir = raiz.getNoDir();
            No noEsq = raiz.getNoEsq();

            No novoNo = new No(valorNoNovo, noEsq, noDir);
            novoNo.setOcorrencias(new ArrayList<>(raiz.getOcorrencias()));

            raiz.setValor(newValor);
            raiz.getOcorrencias().clear();

            No noInserido = new No(bits, null, null);
            noInserido.adicionarOcorrencia(linha, coluna);

            if (valorNoNovo.charAt(0) == '0') {
                raiz.setNoEsq(novoNo);
                raiz.setNoDir(noInserido);
            } else {
                raiz.setNoDir(novoNo);
                raiz.setNoEsq(noInserido);
            }

            System.out.printf("Palavra inserida com sucesso!\n");
            return;
        }

        if (bits.length() == 0) {
            raiz.adicionarOcorrencia(linha, coluna);
            System.out.println("Palavra já existe! Nova ocorrência adicionada à lista.");
            return;
        }

        if (bits.charAt(0) == '0') {
            if (raiz.getNoEsq() == null) {
                No novoFilho = new No(bits, null, null);
                novoFilho.adicionarOcorrencia(linha, coluna);
                raiz.setNoEsq(novoFilho);
                System.out.printf("Palavra inserida com sucesso!\n");
            } else {
                inserirPalavra(bits, linha, coluna, raiz.getNoEsq());
            }
        } else {
            if (raiz.getNoDir() == null) {
                No novoFilho = new No(bits, null, null);
                novoFilho.adicionarOcorrencia(linha, coluna);
                raiz.setNoDir(novoFilho);
                System.out.printf("Palavra inserida com sucesso!\n");
            } else {
                inserirPalavra(bits, linha, coluna, raiz.getNoDir());
            }
        }
    }

    public void buscarPalavra(String palavra) {
        String bitsPalavra = converterPalavraBit(palavra);

        if (bitsPalavra.charAt(0) == '0') {
            if (raiz.getNoEsq() != null) {
                buscarPalavra(bitsPalavra, raiz.getNoEsq());
            } else {
                System.out.println("Palavra não encontrada!");
            }
        } else {
            if (raiz.getNoDir() != null) {
                buscarPalavra(bitsPalavra, raiz.getNoDir());
            } else {
                System.out.println("Palavra não encontrada!");
            }
        }
    }

    private void buscarPalavra(String bits, No raiz) {
        String valorNoStr = raiz.getValor();

        if(bits.equals(valorNoStr)) imprimirOcorrencias(raiz);
        else {
            int i = 0;
            while (i<valorNoStr.length() && bits.length() > 0 && bits.charAt(0) == valorNoStr.charAt(i)) {
                bits = bits.substring(1);
                i++;
            }

            if (i<valorNoStr.length()) {
                System.out.printf("Palavra não encontrada!");
                return;
            }

            if (bits.length() == 0) {
                imprimirOcorrencias(raiz);
                return;
            }

            if (bits.charAt(0) == '0' && raiz.getNoEsq() != null) buscarPalavra(bits, raiz.getNoEsq());
            else if (bits.charAt(0) == '1' && raiz.getNoDir() != null) buscarPalavra(bits, raiz.getNoDir());
            else {
                System.out.printf("Palavra não encontrada!");
            }
        }
    }

    private void imprimirOcorrencias(No noAtual) {
        if (noAtual.getOcorrencias().isEmpty()) {
            System.out.println("Palavra não encontrada (Caminho existe, mas é apenas um nó interno de roteamento).");
            return;
        }

        System.out.println("Palavra encontrada nas seguintes posições:");
        for (Ocorrencia o : noAtual.getOcorrencias()) {
            System.out.printf("- Linha: %d, Coluna: %d\n", o.getLinha(), o.getColuna());
        }
    }

    private String converterPalavraBit(String palavra) {
        String bitsPalavra = "";
        for(int i = 0; i < 16; i++) { //converter a palavra para 128 bits
            if(i >= palavra.length()) {
                bitsPalavra += "00000000";
            } else {
                bitsPalavra += "0" + Integer.toBinaryString(palavra.charAt(i));
            }
        }

        return bitsPalavra;
    }
}