package it.edu.iisgubbio.oggetti.mobilita;

/**
 * Veicolo a motore che si muove su strada.
 *
 * <p>Estende {@link AMotore} aggiungendo la <b>velocità massima</b>
 * in km/h, utile per calcolare i tempi di percorrenza.</p>
 *
 * <p>Sottoclassi concrete:
 * {@link Automobile}, {@link Motocicletta}, {@link Motoslitta}.</p>
 */
public class Terrestre extends AMotore{

    private double velocita;


    /**
     * Crea un veicolo terrestre con valori predefiniti.
     * La velocità viene inizializzata a {@code 0}.
     */
    public Terrestre() {
        super();
    }


    /**
     * Restituisce una descrizione del veicolo terrestre.
     *
     * <p>Esempio:<br>
     * {@code Veicolo terrestre a motore: Jeep, va a benzina e al massimo percorre 160.0 km in un'ora}
     * </p>
     *
     * @return stringa con nome, carburante e velocità massima
     */
    public String toString() {
        String risposta;
        risposta = "Veicolo terrestre a motore: "+nome+", va a "+getCarburante()+
                " e al massimo percorre "+velocita+" km in un'ora";
        return risposta;
    }

    /**
     * Calcola il tempo necessario per percorrere una certa distanza.
     *
     * <p>Il tempo è espresso in ore: {@code tempo = distanza / velocità}.</p>
     *
     * <p><b>Caso speciale:</b> se la velocità è {@code 0}, restituisce
     * {@code -1} per segnalare che il calcolo non è possibile.</p>
     *
     * @param distanza distanza da percorrere in chilometri
     * @return tempo in ore, oppure {@code -1} se la velocità è zero
     */
    public double tempoDiPercorrenza(int distanza) {
        if(velocita==0) {
            return -1;
        }
        double tempo;
        tempo = distanza/velocita;
        return tempo;
    }

    /**
     * Restituisce la velocità massima del veicolo.
     *
     * @return la velocità massima del veicolo in km/h
     */
    public double getVelocita() {
        return velocita;
    }

    /**
     * Imposta la velocità massima del veicolo.
     *
     * @param velocita la nuova velocità massima in km/h
     */
    public void setVelocita(double velocita) {
        this.velocita = velocita;
    }

}
