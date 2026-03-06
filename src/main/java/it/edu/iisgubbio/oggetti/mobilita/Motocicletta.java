package it.edu.iisgubbio.oggetti.mobilita;

/**
 * Motocicletta a motore.
 *
 * <p>Estende {@link Terrestre}. Rispetto alla classe padre aggiunge
 * la <b>cilindrata</b> del motore (in cc) e il <b>numero di posti</b>
 * disponibili a bordo.</p>
 *
 * <p><b>Attenzione:</b> il numero di posti viene inizializzato a
 * {@code 0} di default; ricordati di impostarlo con
 * {@link #setNumeroPosti(int)} dopo aver creato l'oggetto.</p>
 */
public class Motocicletta extends Terrestre {

    private double cilindrata;
    private int numeroPosti;

    /**
     * Crea una motocicletta con valori predefiniti.
     */
    public Motocicletta(){
    }

    /**
     * Crea una motocicletta con la sola cilindrata specificata.
     *
     * @param cilindrata cilindrata del motore in cc
     */
    public Motocicletta(int cilindrata){
        this.cilindrata = cilindrata;
    }

    /**
     * Crea una motocicletta completa con nome, costo e cilindrata.
     *
     * @param nome       nome del modello
     * @param costo      costo in euro
     * @param cilindrata cilindrata del motore in cc
     */
    public Motocicletta(String nome, double costo, double cilindrata){
        super();
        this.nome = nome;
        this.costo = costo;
        this.cilindrata = cilindrata;
    }

    /**
     * Restituisce una descrizione della motocicletta.
     *
     * <p>Esempio: {@code Motocicletta: Ducati cilindrata 900.0}</p>
     *
     * @return stringa con nome e cilindrata
     */
    @Override
    public String toString(){
        String risposta = "Motocicletta: "+nome+" cilindrata "+cilindrata;
        return risposta;
    }

    /**
     * Indica se la motocicletta può trasportare il numero di persone richiesto.
     *
     * <p>Il confronto è non stretto: se {@code persone} è esattamente
     * uguale al numero di posti disponibili, il trasporto è possibile.</p>
     *
     * @param persone numero di persone da trasportare
     * @return {@code true} se {@code persone ≤ numeroPosti}
     */
    public boolean puoTrasportare(int persone){
        if (persone > numeroPosti) {
            return false;
        }else {
            return true;
        }
    }

    /**
     * Restituisce la cilindrata del motore.
     *
     * @return la cilindrata del motore in cc
     */
    public double getCilindrata(){
        return cilindrata;
    }

    /**
     * Imposta la cilindrata del motore.
     *
     * @param cilindrata la nuova cilindrata in cc
     */
    public void setCilindrata(double cilindrata){
        this.cilindrata = cilindrata;
    }

    /**
     * Restituisce il numero di posti disponibili a bordo.
     *
     * @return il numero di posti disponibili a bordo
     */
    public int getNumeroPosti(){
        return numeroPosti;
    }

    /**
     * Imposta il numero di posti disponibili a bordo.
     *
     * @param numeroPosti il nuovo numero di posti
     */
    public void setNumeroPosti(int numeroPosti){
        this.numeroPosti = numeroPosti;
    }

}
