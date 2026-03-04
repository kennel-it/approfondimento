package it.edu.iisgubbio.oggetti.sport;

/************************************************************************
 * Rappresenta un nuotatore, ovvero un atleta specializzato nelle gare
 * in vasca. Estende {@link Atleta} aggiungendo le caratteristiche
 * specifiche della disciplina: lo stile di nuoto praticato e il tipo
 * di vasca su cui ci si allena abitualmente, entrambi determinanti per
 * il calcolo del recupero, del tempo di percorrenza e del punteggio
 * di gara.
 ***********************************************************************/
public class Nuotatore extends Atleta {

    /************************************************************************
     * Stile di nuoto praticato dal nuotatore.
     * Valori validi: {@code "libero"}, {@code "rana"},
     * {@code "dorso"}, {@code "farfalla"}.
     ***********************************************************************/
    private String stile;

    /************************************************************************
     * Tipo di vasca utilizzata in allenamento e in gara.
     * {@code true} = vasca olimpionica da 50 m, {@code false} = vasca da 25 m.
     ***********************************************************************/
    private boolean vasca50m;

    /************************************************************************
     * Costruisce un nuovo nuotatore con le caratteristiche specificate.
     *
     * @param nome            nome e cognome dell'atleta
     * @param eta             età in anni
     * @param pesoKg          peso corporeo in chilogrammi
     * @param altezzaM        altezza in metri
     * @param anniEsperienza  anni di esperienza agonistica
     * @param stile           stile di nuoto praticato (es. "libero", "farfalla")
     * @param vasca50m        {@code true} per vasca da 50 m, {@code false} per 25 m
     ***********************************************************************/
    public Nuotatore(String nome, int eta, double pesoKg, double altezzaM,
                     int anniEsperienza, String stile, boolean vasca50m) {
        super(nome, eta, pesoKg, altezzaM, anniEsperienza);
        this.stile = stile;
        this.vasca50m = vasca50m;
    }

    /************************************************************************
     * Override: il recupero del nuotatore dipende dallo stile e dal tipo di vasca.
     * <ul>
     *   <li>"farfalla" è lo stile più faticoso: recupero base * 1.4</li>
     *   <li>"rana" è faticoso: recupero base * 1.2</li>
     *   <li>altri stili: nessun moltiplicatore aggiuntivo</li>
     *   <li>vasca da 25m implica più virate, maggiore affaticamento: +10% al recupero</li>
     *   <li>infortunio: recupero * 2 (stesso della classe base)</li>
     *   <li>età e esperienza: stessa logica della classe base</li>
     * </ul>
     *
     * @param minutiGara  durata della gara in minuti
     * @param infortunio  {@code true} se l'atleta ha subito un infortunio
     * @return            minuti di recupero stimati (minimo 1)
     ***********************************************************************/
    @Override
    public double calcolaRecupero(int minutiGara, boolean infortunio) {
        double recupero = minutiGara / 10.0;

        // Fattore stile
        if (stile.equalsIgnoreCase("farfalla")) {
            recupero *= 1.4;
        } else if (stile.equalsIgnoreCase("rana")) {
            recupero *= 1.2;
        }

        // Fattore vasca
        if (!vasca50m) {
            recupero *= 1.1;
        }

        if (infortunio) {
            recupero *= 2;
        }
        if (eta > 30) {
            recupero += (eta - 30) * 0.5;
        }
        double bonusEsperienza = Math.min(anniEsperienza * 0.3, 5.0);
        recupero -= bonusEsperienza;

        return Math.max(recupero, 1.0);
    }

    /************************************************************************
     * Stima il tempo di percorrenza in secondi.
     * </ul>
     *   <li>Velocità base: 1.8 m/s (strisciata/dorso), 1.5 m/s (rana), 1.6 m/s (farfalla)</li>
     *   <li>Corsia esterna penalizza del 3% (turbolenza ridotta al centro)</li>
     *   <li>Ogni vasca ha un tempo di virata: 0.8s per vasca da 50m, 1.2s per vasca da 25m</li>
     *   <li>Numero di virate = (distanzaMetri / lunghezzaVasca) - 1</li>
     * </ul>
     *
     * @param distanzaMetri   distanza di gara in metri
     * @param corsiaEsterna   {@code true} se il nuotatore gareggia in corsia esterna
     * @return                tempo stimato di percorrenza in secondi
     ***********************************************************************/
    public double calcolaTempo(int distanzaMetri, boolean corsiaEsterna) {
        double velocita;
        switch (stile.toLowerCase()) {
            case "rana":     velocita = 1.5; break;
            case "farfalla": velocita = 1.6; break;
            default:         velocita = 1.8; break; // strisciata, dorso
        }

        double tempoBase = distanzaMetri / velocita;

        if (corsiaEsterna) {
            tempoBase *= 1.03;
        }

        double lunghezzaVasca = vasca50m ? 50.0 : 25.0;
        double tempoVirata = vasca50m ? 0.8 : 1.2;
        int numVirate = (int)(distanzaMetri / lunghezzaVasca) - 1;
        if (numVirate < 0) numVirate = 0;

        return tempoBase + numVirate * tempoVirata;
    }

    /************************************************************************
     * Restituisce lo stile di nuoto praticato dal nuotatore.
     *
     * @return stile di nuoto (es. "libero", "rana", "dorso", "farfalla")
     ***********************************************************************/
    public String getStile() { return stile; }

    /************************************************************************
     * Indica se il nuotatore utilizza una vasca olimpionica da 50 m.
     *
     * @return {@code true} per vasca da 50 m, {@code false} per vasca da 25 m
     ***********************************************************************/
    public boolean isVasca50m() { return vasca50m; }

    /************************************************************************
     * Restituisce una rappresentazione testuale del nuotatore
     * con i campi principali.
     *
     * @return stringa descrittiva dell'oggetto
     ***********************************************************************/
    @Override
    public String toString() {
        return "Nuotatore{nome='" + nome + "', stile='" + stile +
               "', vasca50m=" + vasca50m + ", eta=" + eta + "}";
    }
}
