import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExtraiPalavra {
    private BufferedReader arqIn;
    private String linhaAtual;
    private int posLinha;

    private int numLinha;
    private int numColuna;

    public ExtraiPalavra(String nomeArq) throws IOException {
        this.arqIn = new BufferedReader(new FileReader(nomeArq));
        this.linhaAtual = null;
        this.posLinha = 0;
        this.numLinha = 0;
        this.numColuna = 0;
    }

    public String extraiPalavra() throws IOException {
        while (true) {
            if (this.linhaAtual == null || this.posLinha >= this.linhaAtual.length()) {
                this.linhaAtual = this.arqIn.readLine();
                this.posLinha = 0;

                if (this.linhaAtual == null) {
                    return null;
                }
                this.numLinha++;
            }

            while (this.posLinha < this.linhaAtual.length() &&
                    !Character.isLetter(this.linhaAtual.charAt(this.posLinha))) {
                this.posLinha++;
            }

            if (this.posLinha >= this.linhaAtual.length()) {
                continue;
            }

            this.numColuna = this.posLinha + 1;
            int inicio = this.posLinha;

            while (this.posLinha < this.linhaAtual.length() &&
                    Character.isLetterOrDigit(this.linhaAtual.charAt(this.posLinha))) {
                this.posLinha++;
            }

            return this.linhaAtual.substring(inicio, this.posLinha);
        }
    }

    public int getNumLinha() {
        return numLinha;
    }

    public int getNumColuna() {
        return numColuna;
    }

    public void fechar() throws IOException {
        if (this.arqIn != null) {
            this.arqIn.close();
        }
    }
}