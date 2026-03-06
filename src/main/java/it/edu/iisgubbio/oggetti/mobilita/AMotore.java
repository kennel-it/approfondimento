package it.edu.iisgubbio.oggetti.mobilita;

/**
 * Veicolo dotato di motore.
 *
 * <p>Estende {@link MezzoDiTrasporto} aggiungendo la
 * <b>rumorosità</b> in decibel e il tipo di <b>carburante</b>.</p>
 *
 * <p>Sottoclassi:
 * {@link Terrestre} (veicoli su strada) e
 * {@link Volante} (veicoli in volo).</p>
 */
public class AMotore extends MezzoDiTrasporto{

    private double rumorosita;
    private String carburante;

    /**
     * Crea un veicolo a motore con valori predefiniti.
     */
    public AMotore() {
        super();
    }

    /**
     * Crea un veicolo a motore con tutte le caratteristiche specificate.
     *
     * @param nome       nome del veicolo
     * @param costo      costo in euro (parametro {@code int},
     *                   viene salvato internamente come {@code double})
     * @param rumorosita livello di rumorosità in decibel (dB)
     * @param carburante tipo di carburante (es. {@code "benzina"}, {@code "diesel"})
     */
    public AMotore(String nome, int costo, double rumorosita, String carburante) {
        super(nome, costo);
        this.rumorosita = rumorosita;
        this.carburante = carburante;
    }

    /**
     * Restituisce una descrizione del veicolo.
     *
     * <p>Esempio:<br>
     * {@code Mezzo motorizzato: Vespa (3000.0€) che emette 65.0dB di rumore, consuma benzina}
     * </p>
     *
     * @return stringa con nome, costo, rumorosità e carburante
     */
    @Override
    public String toString(){
        String risposta;
        risposta = "Mezzo motorizzato: "+nome+" ("+costo+"€) che emette "+rumorosita+"dB di rumore, consuma "+carburante;
        return risposta;
    }

    /**
     * Verifica se il veicolo può circolare nei centri abitati
     * rispettando i limiti acustici.
     *
     * <p>Il limite di rumorosità consentito nei centri abitati è
     * <b>68 dB</b>. Veicoli più rumorosi non sono ammessi.</p>
     *
     * @return {@code true} se la rumorosità è ≤ 68 dB
     */
    public boolean possibileCentriAbitati() {
        boolean possibileNeiCentriAbitati = false;
        if (getRumorosita() <= 68) {
            possibileNeiCentriAbitati = true;
        }
        return possibileNeiCentriAbitati;
    }

    /**
     * Restituisce la rumorosità del veicolo.
     *
     * @return la rumorosità del veicolo in decibel (dB)
     */
    public double getRumorosita() {
        return rumorosita;
    }

    /**
     * Imposta la rumorosità del veicolo.
     *
     * @param rumorosita la nuova rumorosità in decibel (dB)
     */
    public void setRumorosita(double rumorosita) {
        this.rumorosita = rumorosita;
    }

    /**
     * Restituisce il tipo di carburante utilizzato dal veicolo.
     *
     * @return il tipo di carburante utilizzato
     */
    public String getCarburante(){
        return carburante;
    }

    /**
     * Imposta il tipo di carburante del veicolo.
     *
     * @param c il nuovo tipo di carburante
     */
    public void setCarburante(String c) {
        carburante = c;
    }

}
