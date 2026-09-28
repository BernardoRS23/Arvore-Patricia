public class No {
    private String valor;
    private int ocorrencias;
    private No noEsq;
    private No noDir;

    public No() {
        this.valor = "";
        this.ocorrencias = 0;
        this.noEsq = null;
        this.noDir = null;
    }

    public No(String valor, No noEsq, No noDir) {
        this.valor = valor;
        this.ocorrencias = 0;
        this.noEsq = noEsq;
        this.noDir = noDir;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getOcorrencias() {
        return ocorrencias;
    }

    public void setOcorrencias(int ocorrencias) {
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
