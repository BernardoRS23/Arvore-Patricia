import java.util.ArrayList;

public class No {
    private String valor;
    private ArrayList<Ocorrencia> ocorrencias;
    private No noEsq;
    private No noDir;

    public No() {
        this.valor = "";
        this.ocorrencias = new ArrayList<>();
        this.noEsq = null;
        this.noDir = null;
    }

    public No(String valor, No noEsq, No noDir) {
        this.valor = valor;
        this.ocorrencias = new ArrayList<>();
        this.noEsq = noEsq;
        this.noDir = noDir;
    }

    public void adicionarOcorrencia(int linha, int coluna) {
        this.ocorrencias.add(new Ocorrencia(linha, coluna));
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public ArrayList<Ocorrencia> getOcorrencias() {
        return ocorrencias;
    }

    public void setOcorrencias(ArrayList<Ocorrencia> ocorrencias) {
        this.ocorrencias = ocorrencias;
    }

    public No getNoEsq() {
        return noEsq;
    }

    public void setNoEsq(No noEsq) {
        this.noEsq = noEsq;
    }

    public No getNoDir() {
        return noDir;
    }

    public void setNoDir(No noDir) {
        this.noDir = noDir;
    }


}