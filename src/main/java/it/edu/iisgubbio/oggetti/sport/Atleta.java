package it.edu.iisgubbio.oggetti.sport;

/************************************************************************
 * Classe base che rappresenta un atleta generico.
 * Contiene le caratteristiche anagrafiche e fisiche comuni a tutte le
 * discipline e fornisce metodi di calcolo condivisi (recupero, BMI,
 * idoneità atletica). Le sottoclassi possono fare override di
 * {@link #calcolaRecupero} per adattare la logica alla propria disciplina.
 ***********************************************************************/
public class Atleta {

    /** Nome e cognome dell'atleta. */
    protected String nome;

    /** Età dell'atleta in anni. */
    protected int eta;

    /** Peso corporeo in chilogrammi. */
    protected double pesoKg;

    /** Altezza in metri. */
    protected double altezzaM;

    /** Anni di esperienza agonistica nella disciplina. */
    protected int anniEsperienza;

    /************************************************************************
     * Costruisce un nuovo atleta con le caratteristiche specificate.
     *
     * @param nome            nome e cognome dell'atleta
     * @param eta             età in anni
     * @param pesoKg          peso corporeo in chilogrammi
     * @param altezzaM        altezza in metri
     * @param anniEsperienza  anni di esperienza agonistica
     ***********************************************************************/
    public Atleta(String nome, int eta, double pesoKg, double altezzaM, int anniEsperienza) {
        this.nome = nome;
        this.eta = eta;
        this.pesoKg = pesoKg;
        this.altezzaM = altezzaM;
        this.anniEsperienza = anniEsperienza;
    }

    /************************************************************************
     * Calcola il BMI (Body Mass Index) dell'atleta.
     * Formula: peso / (altezza^2)
     *
     * @return il valore del BMI
     ***********************************************************************/
    public double calcolaBMI() {
        return pesoKg / (altezzaM * altezzaM);
    }

    /************************************************************************
     * Stima i minuti di recupero necessari dopo una gara.
     * <ul>
     *   <li>Base: minutiGara / 10</li>
     *   <li>Se l'atleta ha subito un infortunio, il recupero raddoppia</li>
     *   <li>Ogni anno di età oltre i 30 aggiunge 0.5 minuti</li>
     *   <li>L'esperienza riduce il recupero: -0.3 minuti per anno (max -5)</li>
     * </ul>
     *
     * @param minutiGara  durata della gara in minuti
     * @param infortunio  {@code true} se l'atleta ha subito un infortunio
     * @return            minuti di recupero stimati (minimo 1)
     ***********************************************************************/
    public double calcolaRecupero(int minutiGara, boolean infortunio) {
        double recupero = minutiGara / 10.0;
        if (infortunio) {
            recupero *= 2;
        }
        if (eta > 30) {
            recupero += (eta - 30) * 0.5;
        }
        double bonusEsperienza = Math.min(anniEsperienza * 0.3, 5.0);
        recupero -= bonusEsperienza;
        return Math.max(recupero, 1.0); // minimo 1 minuto
    }

    /************************************************************************
     * Calcola un punteggio di idoneità atletica da 0 a 100.
     * <ul>
     *   <li>Parte da 100</li>
     *   <li>Penalità se il BMI è fuori dalla fascia ottimale (18.5 - 24.9): -10</li>
     *   <li>Penalità per fumo: -20</li>
     *   <li>Penalità per frequenza cardiaca a riposo alta (>70 bpm): -(bpm - 70) * 0.5</li>
     *   <li>Penalità per età oltre i 40: -(eta - 40) * 0.8</li>
     *   <li>Bonus esperienza: +anniEsperienza * 0.5 (max +10)</li>
     * </ul>
     *
     * @param bpm   frequenza cardiaca a riposo in battiti per minuto
     * @param fumo  {@code true} se l'atleta è fumatore
     * @return      punteggio di idoneità compreso tra 0 e 100
     ***********************************************************************/
    public double calcolaIdoneita(int bpm, boolean fumo) {
        double punteggio = 100.0;
        double bmi = calcolaBMI();

        if (bmi < 18.5 || bmi > 24.9) {
            punteggio -= 10;
        }
        if (fumo) {
            punteggio -= 20;
        }
        if (bpm > 70) {
            punteggio -= (bpm - 70) * 0.5;
        }
        if (eta > 40) {
            punteggio -= (eta - 40) * 0.8;
        }
        double bonusEsperienza = Math.min(anniEsperienza * 0.5, 10.0);
        punteggio += bonusEsperienza;

        // Clamp tra 0 e 100
        return Math.max(0, Math.min(100, punteggio));
    }

    /************************************************************************
     * Restituisce il nome dell'atleta.
     *
     * @return nome e cognome
     ***********************************************************************/
    public String getNome() { return nome; }

    /************************************************************************
     * Restituisce l'età dell'atleta.
     *
     * @return età in anni
     ***********************************************************************/
    public int getEta() { return eta; }

    /************************************************************************
     * Restituisce il peso corporeo dell'atleta.
     *
     * @return peso in chilogrammi
     ***********************************************************************/
    public double getPesoKg() { return pesoKg; }

    /************************************************************************
     * Restituisce l'altezza dell'atleta.
     *
     * @return altezza in metri
     ***********************************************************************/
    public double getAltezzaM() { return altezzaM; }

    /************************************************************************
     * Restituisce gli anni di esperienza agonistica dell'atleta.
     *
     * @return anni di esperienza
     ***********************************************************************/
    public int getAnniEsperienza() { return anniEsperienza; }

    /************************************************************************
     * Restituisce una rappresentazione testuale dell'atleta
     * con tutti i campi principali.
     *
     * @return stringa descrittiva dell'oggetto
     ***********************************************************************/
    @Override
    public String toString() {
        return nome + ", di " + eta + " anni (con "+anniEsperienza+" di esperienza) e "
            + pesoKg + "kg di peso per un altezza di " + altezzaM + "m";
    }
}
