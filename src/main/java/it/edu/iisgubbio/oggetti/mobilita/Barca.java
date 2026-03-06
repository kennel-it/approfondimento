package it.edu.iisgubbio.oggetti.mobilita;

/**
 * Barca a remi.
 *
 * <p>Estende {@link AMuscoli}. Il numero di vogatori dipende
 * da quanti remi ci sono e da come vengono usati:</p>
 * <ul>
 *   <li><b>Singolo remo</b> ({@code singoloRemo = true}):
 *       ogni vogatore usa un solo remo → un vogatore per remo.</li>
 *   <li><b>Doppio remo</b> ({@code singoloRemo = false}):
 *       ogni vogatore usa due remi → un vogatore ogni due remi.</li>
 * </ul>
 */
public class Barca extends AMuscoli {

    private int numeroDiRemi;
    private boolean singoloRemo; // un remo per vogatore

    /**
     * Crea una barca a remi.
     *
     * @param nome    nome dell'imbarcazione
     * @param costo   costo in euro
     * @param remi    numero totale di remi
     * @param singolo {@code true} se ogni vogatore usa un solo remo,
     *                {@code false} se ne usa due
     */
    public Barca(String nome, double costo, int remi, boolean singolo) {
        super();
        setNome(nome);
        setCosto(costo);
        numeroDiRemi = remi;
        singoloRemo = singolo;
    }

    /**
     * Restituisce una descrizione della barca.
     *
     * <p>Esempi:</p>
     * <ul>
     *   <li>{@code Barca: Otto con remi8 (due per vogatore)}</li>
     *   <li>{@code Barca: Canoa con remi2} — senza suffisso se singolo remo</li>
     * </ul>
     *
     * @return stringa con nome, numero di remi e modalità di voga
     */
    @Override
    public String toString(){
        String risposta;
        risposta = "Barca: "+nome+" con remi"+numeroDiRemi;
        if(!singoloRemo) {
            risposta += " (due per vogatore)";
        }
        return risposta;
    }

    /**
     * Indica se ogni vogatore usa un solo remo.
     *
     * @return {@code true} se ogni vogatore usa un solo remo
     */
    public boolean getSingoloRemo() {
        return singoloRemo;
    }

    /**
     * Restituisce il numero totale di remi della barca.
     *
     * @return il numero totale di remi della barca
     */
    public int getNumeroRemi() {
        return numeroDiRemi;
    }

    /**
     * Calcola il numero di vogatori necessari per remare.
     *
     * <ul>
     *   <li>Singolo remo → {@code numeroDiRemi} vogatori</li>
     *   <li>Doppio remo  → {@code numeroDiRemi / 2} vogatori</li>
     * </ul>
     *
     * @return numero di vogatori
     */
    public int numeroVogatori() {
        if(singoloRemo==false) {
            return numeroDiRemi/2;
        }else {
            return numeroDiRemi;
        }
    }

}
