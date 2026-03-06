package it.edu.iisgubbio.oggetti.fattoria;

public class Formaggio extends Prodotto {
    protected int tempoStagionatura;
    protected boolean dop;
    public Formaggio(String nome, double prezzoAlKg, int tempoStagionatura, boolean dop) {
        super(nome, prezzoAlKg);
        this.tempoStagionatura = tempoStagionatura;
        this.dop = dop;
    }

    public Formaggio(String nome, double prezzoAlKg, int tempoStagionatura) {
        super(nome, prezzoAlKg);
        this.tempoStagionatura = tempoStagionatura;
        this.dop = false;
    }

    @Override
    public String toString() {
        String t = "Formaggio "+nome+", prezzoAlKg="+ prezzoAlKg+", stagionato "+tempoStagionatura+" mesi";
        if(dop) {
            t+=" DOP";
        }
        return t;
    }

}
