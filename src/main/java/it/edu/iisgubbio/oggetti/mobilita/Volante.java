package it.edu.iisgubbio.oggetti.mobilita;

/**
 * Veicolo a motore capace di volare.
 *
 * <p>Estende {@link AMotore} aggiungendo la <b>quota massima</b>
 * raggiungibile in metri. Il valore di default è {@value #quotaBase} m.</p>
 *
 * <p>Oltre una certa quota è necessaria la pressurizzazione
 * della cabina (vedi {@link #necessitaPressurizzazione()}).</p>
 *
 * <p>Sottoclassi concrete: {@link Aereo}, {@link Deltaplano}.</p>
 */
public class Volante extends AMotore {

    private double quotaMassima;
    private static final double quotaBase = 2400; //usata se non viene immesso

    /**
     * Crea un veicolo volante con quota massima predefinita
     * ({@value #quotaBase} m).
     */
    public Volante () {
        super();
        quotaMassima = quotaBase;
    }

    /**
     * Crea un veicolo volante con nome e costo specificati.
     * La quota massima viene impostata al valore di default ({@value #quotaBase} m).
     *
     * @param nome  nome del veicolo
     * @param costo costo in euro
     */
    public Volante (String nome, double costo ){
        super();
        this.nome = nome;
        this.costo = costo;
        quotaMassima = quotaBase;
    }

    /**
     * Restituisce una descrizione del veicolo volante.
     *
     * <p>Esempio: {@code Mezzo volante: Pippo (5000.0€) vola fino a 2400.0m di quota}</p>
     *
     * @return stringa con nome, costo e quota massima
     */
    public String toString() {
        return "Mezzo volante: "
            + nome
            + " ("+costo+"€)"
            + " vola fino a "
            + quotaMassima+"m di quota";
    }

    /**
     * Indica se il veicolo necessita di pressurizzazione della cabina.
     *
     * <p>Oltre i <b>3000 m</b> di quota la pressione dell'aria
     * scende a livelli che richiedono pressurizzazione artificiale.</p>
     *
     * @return {@code true} se la quota massima supera 3000 m
     */
    public boolean necessitaPressurizzazione() {
        boolean pressurizzazione;
        if(quotaMassima> 3000) {
            pressurizzazione = true;
        }else {
            pressurizzazione = false;
        }
        return pressurizzazione;
    }

    /**
     * Restituisce la quota massima raggiungibile dal veicolo.
     *
     * @return la quota massima raggiungibile in metri
     */
    public double getQuotaMassima() {
        return quotaMassima;
    }

    /**
     * Imposta la quota massima raggiungibile dal veicolo.
     *
     * @param quotaMax la nuova quota massima in metri
     */
    public void setQuotaMassima(double quotaMax) {
        quotaMassima = quotaMax;
    }
}
