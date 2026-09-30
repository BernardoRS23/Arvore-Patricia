public class Ocorrencia {
    private int linha;
    private int coluna;

    public Ocorrencia(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    public Ocorrencia() {
        this.linha = 0;
        this.coluna = 0;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }
}
