package it.edu.iisgubbio.oggetti.fattoria;

public class Carne extends Prodotto {

    private boolean kosher;
    private boolean carneBianca;

    public Carne(String n, double p, boolean k, boolean cb) {
    	super(n,p);
    	nome = n;
        kosher = k;
        carneBianca = cb;
    }

    public String toString() {
        String desc = nome + " " + prezzoAlKg + "€/Kg";
        if (kosher == true) {
            desc = desc + " macellazione Kosher";
        } else {
            desc = desc + " NON Kosher";
        }
        if (carneBianca) {
            desc = desc + " [carne bianca]";
        } else {
            desc = desc + " [carne rossa]";
        }
        return desc;
    }
}
