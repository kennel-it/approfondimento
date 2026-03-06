package it.edu.iisgubbio.oggetti.mobilita;

/**
 * Deltaplano.
 *
 * <p>Estende {@link Volante}. La caratteristica principale è il
 * <b>numero di posti</b> a bordo, che determina se il deltaplano
 * può portare un passeggero.</p>
 *
 * <ul>
 *   <li>{@code numeroDiPosti == 1} → <em>monoposto</em>,
 *       non accetta passeggeri</li>
 *   <li>{@code numeroDiPosti == 2} → <em>biposto</em>,
 *       accetta un passeggero oltre al pilota</li>
 * </ul>
 */
public class Deltaplano extends Volante {

    private int numeroDiPosti;

    /**
     * Crea un deltaplano con nome, costo e numero di posti.
     *
     * @param nome        nome del modello
     * @param costo       costo in euro
     * @param numeroPosti numero di posti a bordo (tipicamente 1 o 2)
     */
    public Deltaplano(String nome, double costo, int numeroPosti){
        super();
        this.nome = nome;
        this.costo = costo;
        this.numeroDiPosti = numeroPosti;
    }

    /**
     * Restituisce una descrizione del deltaplano.
     *
     * <p>Esempi:</p>
     * <ul>
     *   <li>{@code Deltaplano: monoposto} — se ha 1 posto</li>
     *   <li>{@code Deltaplano: 2 posti}   — se ha più di 1 posto</li>
     * </ul>
     *
     * @return stringa che indica se è monoposto o il numero di posti
     */
    @Override
    public String toString() {
        if(numeroDiPosti==1) {
            return "Deltaplano: monoposto";
        } else {
            return "Deltaplano: "+numeroDiPosti+" posti";
        }
    }

    /**
     * Indica se il deltaplano può trasportare un passeggero oltre al pilota.
     *
     * <p>Restituisce {@code true} solo se il numero di posti è
     * esattamente <b>2</b>.</p>
     *
     * @return {@code true} se {@code numeroDiPosti == 2}
     */
    public boolean accettaPasseggero(){
        /* if(numeroDiPosti==2) {
            return true;
        }else {
            return false;
        }*/
        return numeroDiPosti==2;
    }

    /**
     * Restituisce il numero di posti a bordo del deltaplano.
     *
     * @return il numero di posti a bordo del deltaplano
     */
    public int getNumeroDiPosti() {
        return numeroDiPosti;
    }

    /**
     * Imposta il numero di posti a bordo del deltaplano.
     *
     * @param numeroDiPosti il nuovo numero di posti
     */
    public void setNumeroDiPosti(int numeroDiPosti) {
        this.numeroDiPosti = numeroDiPosti;
    }

}
