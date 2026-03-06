package it.edu.iisgubbio.oggetti.mobilita;

/**
 * Skateboard a propulsione muscolare.
 *
 * <p>Estende {@link AMuscoli}. La lunghezza della tavola determina
 * il tipo di skateboard:</p>
 * <ul>
 *   <li><b>Normale</b> — lunghezza ≤ 80 cm (default: 60 cm)</li>
 *   <li><b>Longboard</b> — lunghezza &gt; 80 cm, più stabile
 *       e adatto a percorrere distanze lunghe</li>
 * </ul>
 *
 * <p><b>Nota:</b> entrambi i costruttori usano il costruttore senza
 * parametri di {@link AMuscoli}, quindi {@code muscoliCoinvolti}
 * rimane {@code null}. Usare
 * {@link AMuscoli#setMuscoliCoinvolti(String)} se necessario.</p>
 */
public class Skateboard extends AMuscoli{

    private int lunghezza;

    /**
     * Crea uno skateboard con lunghezza predefinita di 60 cm.
     *
     * @param nome  nome del modello
     * @param costo costo in euro
     */
    public Skateboard (String nome, double costo){
        super();
        setNome(nome);
        setCosto(costo);
        lunghezza = 60;
    }

    /**
     * Crea uno skateboard con lunghezza personalizzata.
     *
     * @param nome      nome del modello
     * @param costo     costo in euro
     * @param lunghezza lunghezza della tavola in cm
     */
    public Skateboard (String nome, double costo, int lunghezza){
        super();
        setNome(nome);
        setCosto(costo);
        this.lunghezza = lunghezza;
    }

    /**
     * Restituisce una descrizione dello skateboard.
     *
     * <p>Esempi:</p>
     * <ul>
     *   <li>{@code Skateboard normale: lungo 60cm costa 120.0€}</li>
     *   <li>{@code Skateboard longboard: lungo 95cm costa 200.0€}</li>
     * </ul>
     *
     * @return stringa con tipo (normale/longboard), lunghezza e costo
     */
    @Override
    public String toString(){
        String risposta;
        if( longboard() ) {
            risposta = "Skateboard longboard: lungo "+lunghezza+"cm costa "+costo+"€";
        } else {
            risposta = "Skateboard normale: lungo "+lunghezza+"cm costa "+costo+"€";
        }
        return risposta;
    }

    /**
     * Indica se lo skateboard è un longboard.
     *
     * <p>Un longboard ha una tavola più lunga di <b>80 cm</b>,
     * il che lo rende più stabile ma meno adatto ai trick.</p>
     *
     * @return {@code true} se la lunghezza supera 80 cm
     */
    public boolean longboard(){
        if(lunghezza > 80){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Restituisce la lunghezza della tavola dello skateboard.
     *
     * @return la lunghezza della tavola in cm
     */
    public int getLunghezza(){
        return lunghezza;
    }

    /**
     * Imposta la lunghezza della tavola dello skateboard.
     *
     * @param lunghezza la nuova lunghezza in cm
     */
    public void setLunghezza(int lunghezza){
        this.lunghezza = lunghezza;
    }

}
