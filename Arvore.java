public class Arvore {
    private No raiz;

    public Arvore(No raiz) {
        this.raiz = raiz;
    }

    public void inserirPalavra(String palavra) {
        String bitsPalavra = converterPalavraBit(palavra);

        if (bitsPalavra.charAt(0) == '0') inserirPalavra(palavra, raiz.getNoEsq());
        else inserirPalavra(palavra, raiz.getNoDir());
    }

    private void inserirPalavra(String palavra, No raiz) {
        int i = 0;

        while (i < raiz.getValor().length() && palavra.charAt(0) == raiz.getValor().charAt(i)) {
            palavra = palavra.substring(1);
            i++;
        }

        if (i<raiz.getValor().length()) {
            String newValor = raiz.getValor().substring(0, i);
            String valorNoNovo = raiz.getValor().substring(i);
            No noDir = raiz.getNoDir();
            No noEsq = raiz.getNoEsq();

            raiz.setValor(newValor);
            No novoNo = new No(valorNoNovo, noEsq, noDir);
            No noInserido = new No(palavra, null, null);
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

        if (palavra.length() == 0) {
            raiz.setOcorrencias(raiz.getOcorrencias() + 1);
            System.out.println("Essa palavra ja existe na árvore! Repeticao adicionada!");
            return;
        }

        if (palavra.charAt(0) == '0') {
            if (raiz.getNoEsq() == null) {
                raiz.setNoEsq(new No(palavra, null, null));
                System.out.printf("Palavra inserida com sucesso!\n");
            } else {
                inserirPalavra(palavra, raiz.getNoEsq());
            }
        } else {
            if (raiz.getNoDir() == null) {
                raiz.setNoDir(new No(palavra, null, null));
                System.out.printf("Palavra inserida com sucesso!\n");
            } else {
                inserirPalavra(palavra, raiz.getNoDir());
            }
        }
    }

    public void buscarPalavra(String palavra) {
        String bitsPalavra = converterPalavraBit(palavra);
        if (bitsPalavra.charAt(0) == '0') buscarPalavra(bitsPalavra, raiz.getNoEsq());
        else buscarPalavra(bitsPalavra, raiz.getNoDir());
    }

    private void buscarPalavra(String palavra, No raiz) {
        if(palavra.equals(raiz.getValor())) System.out.printf("Palavra encontrada! Número de repetições: " + raiz.getOcorrencias());
        else {
            int i = 0;
            while (i<raiz.getValor().length() && palavra.charAt(0) == raiz.getValor().charAt(i)) {
                palavra = palavra.substring(1);
                i++;
            }

            if (i<raiz.getValor().length()) {
                System.out.printf("Palavra não encontrada!");
                return;
            }

            if (palavra.length() == 0) {
                System.out.printf("Palavra encontrada! Número de repetições: " + raiz.getOcorrencias());
                return;
            }

            if (palavra.charAt(0) == '0' && raiz.getNoEsq() != null) buscarPalavra(palavra, raiz.getNoEsq());
            else if (palavra.charAt(0) == '1' && raiz.getNoDir() != null) buscarPalavra(palavra, raiz.getNoDir());
            else {
                System.out.printf("Palavra não encontrada!");
            }
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
