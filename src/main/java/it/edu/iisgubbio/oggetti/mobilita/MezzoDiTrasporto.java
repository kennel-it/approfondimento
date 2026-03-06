package it.edu.iisgubbio.oggetti.mobilita;

/**
 * Classe base per tutti i mezzi di trasporto.
 *
 * <p>Ogni veicolo ha un <b>nome</b> e un <b>costo</b> in euro.
 * Da questa classe ereditano tutte le categorie del pacchetto:</p>
 * <ul>
 *   <li>{@link AMuscoli} — veicoli a propulsione muscolare</li>
 *   <li>{@link AMotore} — veicoli con motore</li>
 * </ul>
 *
 * <p>I campi {@code nome} e {@code costo} sono {@code protected},
 * cioè accessibili direttamente anche dalle sottoclassi.</p>
 */
public class MezzoDiTrasporto {

    /** Costo del mezzo in euro. */
    protected double costo;
    /** Nome del mezzo di trasporto. */
    protected String nome;

    /**
     * Crea un mezzo con valori predefiniti:
     * nome {@code "sconosciuto"} e costo {@code 0}.
     */
    public MezzoDiTrasporto() {
        super();
        costo = 0;
        nome = "sconosciuto";
    }

    /**
     * Crea un mezzo con nome e costo specificati.
     *
     * @param n nome del mezzo
     * @param c costo in euro
     */
    public MezzoDiTrasporto(String n, double c){
        super();
        costo = c;
        nome = n;
    }

    /**
     * Restituisce una descrizione testuale del mezzo.
     *
     * <p>Esempio: {@code Mezzo di trasporto: Bici, 500.0€}</p>
     *
     * @return stringa nel formato {@code "Mezzo di trasporto: <nome>, <costo>€"}
     */
    @Override
    public String toString() {
        String risposta;
        risposta = "Mezzo di trasporto: "+nome+", "+costo+"€";
        return risposta;
    }

    /**
     * Calcola l'importo di ogni rata per acquistare il mezzo a rate.
     *
     * <p>Divide semplicemente il costo totale per il numero di rate,
     * senza applicare interessi.</p>
     *
     * <p><b>Attenzione:</b> se {@code numeroRate} è {@code 0}
     * si ottiene una divisione per zero.</p>
     *
     * @param numeroRate numero di rate in cui dividere il pagamento
     * @return importo di ciascuna rata in euro
     */
    public double importoRata(int numeroRate) {
        return costo/numeroRate;
    }

    /**
     * Restituisce il nome del mezzo.
     *
     * @return il nome del mezzo
     */
    public String getNome() {
        return nome;
    }

    /**
     * Imposta il nome del mezzo.
     *
     * @param nome il nuovo nome da assegnare
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Restituisce il costo del mezzo in euro.
     *
     * @return il costo del mezzo in euro
     */
    public double getCosto() {
        return costo;
    }

    /**
     * Imposta il costo del mezzo.
     *
     * @param costo il nuovo costo in euro
     */
    public void setCosto(double costo) {
        this.costo = costo;
    }

}
