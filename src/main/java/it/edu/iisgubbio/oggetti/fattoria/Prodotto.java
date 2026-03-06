package it.edu.iisgubbio.oggetti.fattoria;

public class Prodotto {
    protected String nome;
    protected double prezzoAlKg;

    public Prodotto(String nome, double prezzoAlKg) {
        this.nome = nome;
        this.prezzoAlKg = prezzoAlKg;
        }

    public Prodotto() {
    }

    public double calcolaPrezzo(double peso){
        return peso*prezzoAlKg;
    }

    @Override
    public String toString() {
        return "prodotto "+nome+", "+prezzoAlKg+"€/kg";
    }
}
