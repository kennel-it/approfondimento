package it.edu.iisgubbio.oggetti.mobilita;

/**
 * Motoslitta: veicolo terrestre a motore per la neve.
 *
 * <p>Estende {@link Terrestre}. Aggiunge la <b>temperatura minima
 * di funzionamento</b> specifica del modello e il controllo tramite
 * il limite fisico globale {@link #tempMinima}.</p>
 *
 * <p>Differenza importante tra i due campi:</p>
 * <ul>
 *   <li>{@code temperaturaMinima} — caratteristica del singolo modello,
 *       va impostata con {@link #setTemperaturaMinima(double)}.</li>
 *   <li>{@link #tempMinima} (statica) — soglia fisica assoluta usata
 *       da {@link #puoFunzionare(double)}, uguale per tutte le motoslitte.</li>
 * </ul>
 */
public class Motoslitta extends Terrestre {

    private double temperaturaMinima;

    /**
     * Temperatura minima assoluta (in °C) al di sotto della quale
     * nessuna motoslitta è in grado di funzionare.
     * Valore corrente: {@value} °C.
     */
    public static final int tempMinima = -20;

    /**
     * Crea una motoslitta con nome, costo e velocità massima.
     *
     * <p>La temperatura minima di funzionamento non viene impostata
     * dal costruttore e rimane {@code 0.0} finché non si chiama
     * {@link #setTemperaturaMinima(double)}.</p>
     *
     * @param nome     nome del modello
     * @param costo    costo in euro
     * @param velocita velocità massima in km/h
     */
    public Motoslitta(String nome, double costo, double velocita) {
        this.nome = nome;
        this.costo = costo;
        setVelocita(velocita);
    }

    /**
     * Restituisce una descrizione della motoslitta.
     *
     * <p>Esempio: {@code Motoslitta: Arctic, funziona fino a -35.0°C}</p>
     *
     * @return stringa con nome e temperatura minima di funzionamento
     */
    public String toString(){
        return "Motoslitta: "+nome+", funziona fino a "+temperaturaMinima+"°C";
    }

    /**
     * Verifica se la motoslitta può funzionare alla temperatura indicata.
     *
     * <p>Il controllo si basa sulla costante statica {@link #tempMinima}
     * (−20 °C), <em>non</em> sul campo {@code temperaturaMinima}
     * dell'oggetto.</p>
     *
     * @param temperatura temperatura attuale in °C
     * @return {@code true} se {@code temperatura ≥ } {@link #tempMinima}
     */
    public boolean puoFunzionare(double temperatura) {
        if( temperatura>= tempMinima) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Restituisce la temperatura minima di funzionamento specifica di questo modello.
     *
     * @return la temperatura minima di funzionamento specifica di questo modello
     */
    public double getTemperaturaMinima() {
        return temperaturaMinima;
    }

    /**
     * Imposta la temperatura minima di funzionamento del modello.
     *
     * @param temperaturaMinima la nuova temperatura minima in °C
     */
    public void setTemperaturaMinima(double temperaturaMinima) {
        this.temperaturaMinima = temperaturaMinima;
    }

}
