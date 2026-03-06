package it.edu.iisgubbio.oggetti.mobilita;

/**
 * Automobile a motore.
 *
 * <p>Estende {@link Terrestre}. Rispetto alla classe padre aggiunge
 * la <b>targa</b> e il <b>numero di porte</b>.</p>
 *
 * <p>La rumorosità viene impostata automaticamente a <b>78 dB</b>
 * dal costruttore (livello tipico di un'auto a motore termico):
 * questo significa che le automobili <em>non</em> risultano ammesse
 * nei centri abitati secondo
 * {@link AMotore#possibileCentriAbitati()} (limite 68 dB).</p>
 *
 * <p>La targa non viene impostata dal costruttore: va assegnata
 * separatamente con {@link #setTarga(String)}; fino ad allora
 * vale {@code null}.</p>
 */
public class Automobile extends Terrestre{

    private String targa;
    private int numeroPorte;

    /**
     * Crea un'automobile con nome, costo e numero di porte.
     *
     * <p>La rumorosità viene impostata automaticamente a 78 dB.
     * La targa rimane {@code null} finché non viene impostata
     * con {@link #setTarga(String)}.</p>
     *
     * @param nome        nome del modello
     * @param costo       costo in euro
     * @param numeroPorte numero di porte dell'automobile
     */
    public Automobile(String nome, double costo, int numeroPorte){
        super();
        this.nome  = nome;
        this.costo = costo;
        this.numeroPorte = numeroPorte;
        this.setRumorosita(78);
    }

    /**
     * Restituisce una descrizione dell'automobile.
     *
     * <p>Esempi:</p>
     * <ul>
     *   <li>{@code Automobile: Panda [null]} — targa non ancora impostata</li>
     *   <li>{@code Automobile: Panda [AB123CD]} — targa impostata</li>
     * </ul>
     *
     * @return stringa con nome e targa tra parentesi quadre
     */
    @Override
    public String toString() {
        return "Automobile: " +nome + " [" + targa + "]";
    }

    /**
     * Restituisce la targa dell'automobile.
     *
     * @return la targa dell'automobile, oppure {@code null} se non ancora impostata
     */
    public String getTarga() {
        return targa;
    }

    /**
     * Imposta la targa dell'automobile.
     *
     * @param t la targa da assegnare all'automobile
     */
    public void setTarga(String t) {
        targa = t;
    }

    /**
     * Restituisce il numero di porte dell'automobile.
     *
     * @return il numero di porte dell'automobile
     */
    public int getNumeroPorte() {
        return numeroPorte;
    }

    /**
     * Imposta il numero di porte dell'automobile.
     *
     * @param numeroPorte il nuovo numero di porte
     */
    public void setNumeroPorte(int numeroPorte) {
        this.numeroPorte = numeroPorte;
    }

}
