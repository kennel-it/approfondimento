package it.edu.iisgubbio.oggetti.mobilita;

/**
 * Veicolo mosso dalla forza muscolare dell'utente.
 *
 * <p>Estende {@link MezzoDiTrasporto} aggiungendo l'informazione su
 * quali muscoli vengono coinvolti durante l'uso del mezzo.</p>
 *
 * <p>Il nome dei muscoli viene sempre memorizzato in <b>minuscolo</b>,
 * indipendentemente da come viene passato al costruttore o al setter.</p>
 *
 * <p>Come insieme minimo i muscoli da tener ein considerazione
 * sono quadricipiti, bicipiti, pettorali e dorsali.</p>
 *
 * <p>Sottoclassi concrete:
 * {@link Bicicletta}, {@link Skateboard}, {@link Barca}.</p>
 */
public class AMuscoli extends MezzoDiTrasporto{

    private String muscoliCoinvolti;

    /**
     * Crea un veicolo a muscoli con valori predefiniti.
     * I campi {@code nome}, {@code costo} e {@code muscoliCoinvolti}
     * rimangono ai valori di default ({@code null} / {@code 0}).
     */
    public AMuscoli() {
        super();
    }

    /**
     * Crea un veicolo a muscoli completo.
     *
     * @param nome             nome del veicolo
     * @param costo            costo in euro
     * @param muscoliCoinvolti muscoli usati durante la propulsione
     *                         (viene convertito automaticamente in minuscolo)
     */
    public AMuscoli(String nome, double costo, String muscoliCoinvolti) {
        super(nome, costo);
        this.muscoliCoinvolti = muscoliCoinvolti.toLowerCase();
    }

    /**
     * Restituisce una descrizione del veicolo.
     *
     * <p>Esempio: {@code Veicolo a muscoli: Kayak, 850.0€ (usa bicipiti)}</p>
     *
     * @return stringa nel formato
     *         {@code "Veicolo a muscoli: <nome>, <costo>€ (usa <muscoli>)"}
     */
    @Override
    public String toString() {
        String risposta;
        risposta = "Veicolo a muscoli: "+nome+", "+getCosto()+"€ (usa "+muscoliCoinvolti+")";
        return risposta;
    }

    /**
     * Indica se il veicolo coinvolge la parte alta del corpo.
     *
     * <p>I muscoli considerati della parte alta sono:</p>
     * <ul>
     *   <li>{@code bicipiti}</li>
     *   <li>{@code pettorali}</li>
     *   <li>{@code dorsali}</li>
     * </ul>
     * <p>Tutti gli altri (ad es. {@code quadricipiti}) appartengono
     * alla parte bassa.</p>
     *
     * @return {@code true} se il muscolo è nella parte alta del corpo
     */
    public boolean parteAlta() {
        // parte alta del corpo: bicipiti, pettorali, dorsali
        if( muscoliCoinvolti.equals("bicipiti") ||
            muscoliCoinvolti.equals("pettorali") ||
            muscoliCoinvolti.equals("dorsali")
        ) {
            return true;
        }else {
            return false;
        }
        // oppure
        // return  muscoliCoinvolti.equals("bicipiti") ||
        //    muscoliCoinvolti.equals("pettorali") || muscoliCoinvolti.equals("dorsali");
    }

    /**
     * Restituisce il nome dei muscoli coinvolti durante la propulsione.
     *
     * @return il nome dei muscoli coinvolti (sempre in minuscolo)
     */
    public String getMuscoliCoinvolti() {
        return muscoliCoinvolti;
    }

    /**
     * Imposta i muscoli coinvolti, convertendo automaticamente in minuscolo.
     *
     * @param muscoli nome dei muscoli da impostare
     */
    public void setMuscoliCoinvolti(String muscoli) {
        muscoliCoinvolti = muscoli.toLowerCase();
    }

}
