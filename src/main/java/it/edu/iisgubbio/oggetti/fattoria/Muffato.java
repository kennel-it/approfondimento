package it.edu.iisgubbio.oggetti.fattoria;

public class Muffato extends Formaggio{
    String muffa;
    boolean interno;
    public Muffato(String nome, double prezzoAlKg, String muffa) {
        super(nome, prezzoAlKg, 0, false);
        this.muffa = muffa;
        this.interno = true;
    }

}
