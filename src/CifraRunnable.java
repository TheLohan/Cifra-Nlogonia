public class CifraRunnable implements Runnable{
    private int opCifra;
    private String paragrafoCriptografado = "";
    private String paragrafo;
    private boolean isProcessing;

    public void setOpCifra(int opCifra) {
        this.opCifra = opCifra;
    }

    public void setParagrafo(String paragrafo) {
        this.paragrafo = paragrafo;
    }

    public void run() {
        isProcessing = true;

        if (opCifra == 1)
            paragrafoCriptografado = Cifra.criptografar(paragrafo);
        if (opCifra == 2)
            paragrafoCriptografado = Cifra.descriptografar(paragrafo);

        isProcessing = false;

        synchronized (this) {
            this.notify();
        }
    }

    public String getTexto() {
        return paragrafoCriptografado;
    }

    public boolean isProcessing() {
        return isProcessing;
    }
}
