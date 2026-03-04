package it.edu.iisgubbio.oggetti.sport;

/************************************************************************
 * Rappresenta un maratoneta, ovvero un atleta specializzato nelle gare
 * su lunghe distanze. Estende {@link Atleta} aggiungendo le caratteristiche
 * specifiche della disciplina: la superficie su cui ci si allena
 * abitualmente e l'altitudine del sito di allenamento, entrambe
 * determinanti per il calcolo del recupero, del ritmo e del punteggio
 * di gara.
 ***********************************************************************/
public class Maratoneta extends Atleta {

    /************************************************************************
     * Superficie su cui il maratoneta si allena prevalentemente.
     * Valori tipici: {@code "asfalto"}, {@code "sterrato"}, {@code "sabbia"}.
     ***********************************************************************/
    private String superficiePrediletta;

    /************************************************************************
     * Altitudine del sito di allenamento in metri sul livello del mare.
     * Valori elevati (oltre 1500 m) indicano un adattamento all'ipossia.
     ***********************************************************************/
    private int altitudineAllenamento;

    /************************************************************************
     * Costruisce un nuovo maratoneta con le caratteristiche specificate.
     *
     * @param nome                   nome e cognome dell'atleta
     * @param eta                    età in anni
     * @param pesoKg                 peso corporeo in chilogrammi
     * @param altezzaM               altezza in metri
     * @param anniEsperienza         anni di esperienza agonistica
     * @param superficiePrediletta   superficie di allenamento preferita
     * @param altitudineAllenamento  altitudine del sito in metri s.l.m.
     ***********************************************************************/
    public Maratoneta(String nome, int eta, double pesoKg, double altezzaM,
                      int anniEsperienza, String superficiePrediletta, int altitudineAllenamento) {
        super(nome, eta, pesoKg, altezzaM, anniEsperienza);
        this.superficiePrediletta = superficiePrediletta;
        this.altitudineAllenamento = altitudineAllenamento;
    }

    /************************************************************************
     * Override: il recupero del maratoneta dipende dalla superficie e
     * dall'altitudine.
     * <ul>
     *   <li>Superficie "sterrato" o "sabbia": recupero base * 1.3 (più usurante)</li>
     *   <li>Altitudine > 1500m: abituato all'ipossia, recupera meglio: -10%</li>
     *   <li>Altitudine > 2500m: ulteriore riduzione del recupero: -5% aggiuntivo</li>
     *   <li>infortunio, età, esperienza: stessa logica della classe base</li>
     * </ul>
     *
     * @param minutiGara  durata della gara in minuti
     * @param infortunio  {@code true} se l'atleta ha subito un infortunio
     * @return            minuti di recupero stimati (minimo 1)
     ***********************************************************************/
    @Override
    public double calcolaRecupero(int minutiGara, boolean infortunio) {
        double recupero = minutiGara / 10.0;

        String sup = superficiePrediletta.toLowerCase();
        if (sup.equals("sterrato") || sup.equals("sabbia")) {
            recupero *= 1.3;
        }

        if (altitudineAllenamento > 1500) {
            recupero *= 0.90;
        }
        if (altitudineAllenamento > 2500) {
            recupero *= 0.95; // ulteriore -5%
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
     * Calcola il ritmo di gara stimato in minuti per km.
     * <ul>
     *   <li>Ritmo base: 4.5 min/km per un atleta con BMI ottimale</li>
     *   <li>Caldo (>30°C): +0.4 min/km</li>
     *   <li>Superficie sterrato/sabbia: +0.3 min/km</li>
     *   <li>Altitudine > 1500m: +0.2 min/km per ogni 500m oltre i 1500 (ipossia),</li>
     *   dimezzato se altitudineAllenamento > 1500m (adattamento)</li>
     *   <li>BMI fuori fascia ottimale (18.5 - 24.9): +0.2 min/km</li>
     *   <li>Ogni anno di esperienza oltre il 5°: -0.05 min/km (max -0.3)</li>
     * </ul>
     *
     * @param distanzaKm  distanza della gara in chilometri
     * @param caldo       {@code true} se la temperatura supera i 30°C
     * @return            ritmo stimato in minuti per km (minimo 3.0)
     ***********************************************************************/
    public double calcolaRitmo(int distanzaKm, boolean caldo) {
        double ritmo = 4.5;

        if (caldo) {
            ritmo += 0.4;
        }

        String sup = superficiePrediletta.toLowerCase();
        if (sup.equals("sterrato") || sup.equals("sabbia")) {
            ritmo += 0.3;
        }

        // Altitudine di gara stimata uguale a quella di allenamento per semplicità
        if (altitudineAllenamento > 1500) {
            int scaglioniExtra = (altitudineAllenamento - 1500) / 500;
            double malusAltitudine = scaglioniExtra * 0.2;
            // Se allenato in quota, il malus è dimezzato
            ritmo += malusAltitudine * 0.5;
        }

        double bmi = calcolaBMI();
        if (bmi < 18.5 || bmi > 24.9) {
            ritmo += 0.2;
        }

        int esperienzaExtra = Math.max(0, anniEsperienza - 5);
        double bonusEsperienza = Math.min(esperienzaExtra * 0.05, 0.3);
        ritmo -= bonusEsperienza;

        return Math.max(ritmo, 3.0); // minimo assoluto 3 min/km
    }

    /************************************************************************
     * Restituisce la superficie di allenamento prediletta dal maratoneta.
     *
     * @return superficie prediletta (es. "asfalto", "sterrato", "sabbia")
     ***********************************************************************/
    public String getSuperficiePrediletta() { return superficiePrediletta; }

    /************************************************************************
     * Restituisce l'altitudine del sito di allenamento.
     *
     * @return altitudine in metri s.l.m.
     ***********************************************************************/
    public int getAltitudineAllenamento() { return altitudineAllenamento; }

    /************************************************************************
     * Restituisce una rappresentazione testuale del maratoneta
     * con i campi principali.
     *
     * @return stringa descrittiva dell'oggetto
     ***********************************************************************/
    @Override
    public String toString() {
        return "Maratoneta{nome='" + nome + "', superficie='" + superficiePrediletta +
               "', altitudine=" + altitudineAllenamento + "m, eta=" + eta + "}";
    }
}
