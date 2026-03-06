package it.edu.iisgubbio.oggetti.mobilita;

/**
 * Bicicletta a propulsione muscolare.
 *
 * <p>Estende {@link AMuscoli}: il muscolo usato è sempre
 * {@code "quadricipiti"}, impostato automaticamente dal costruttore.</p>
 *
 * <p>Una bicicletta è considerata <b>leggera</b> se pesa meno di 10 kg
 * (tipico delle bici da corsa professionali ≈ 6.8 kg),
 * <b>pesante</b> altrimenti (come le mountain bike ≈ 14 kg).</p>
 */
public class Bicicletta extends AMuscoli {

    private int numeroDiRapporti;
    private double peso;

    /**
     * Crea una bicicletta con il costo e il peso specificati.
     *
     * <p>Il nome viene impostato a {@code "bicicletta"} e i muscoli
     * a {@code "quadricipiti"} automaticamente.</p>
     *
     * @param costo costo in euro
     * @param peso  peso della bicicletta in kg
     */
    public Bicicletta(double costo, double peso) {
        super("bicicletta", costo, "quadricipiti");
        this.peso = peso;
    }

    /**
     * Restituisce una descrizione della bicicletta.
     *
     * <p>Esempi:</p>
     * <ul>
     *   <li>{@code Bicicletta: pesa 7.5kg (leggera) costa 350.0€ (ha 21 rapporti)}</li>
     *   <li>{@code Bicicletta: pesa 14.0kg (pesante) costa 600.0€ (ha 0 rapporti)}</li>
     * </ul>
     *
     * @return stringa con peso, categoria, costo e numero di rapporti
     */
    @Override
    public String toString() {
        String risposta;
        String descrizionePeso;
        if( leggera() ) {
            descrizionePeso = "leggera";
        }else {
            descrizionePeso = "pesante";
        }
        risposta = "Bicicletta: pesa "+peso + "kg ("+descrizionePeso+") costa "+getCosto()+"€ (ha "+numeroDiRapporti+" rapporti)";
        return risposta;
    }

    /**
     * Indica se la bicicletta è leggera.
     *
     * <p>Soglia: bici da corsa professionale ≈ 6.8 kg,
     * mountain bike ≈ 14 kg. Il limite usato è <b>10 kg</b>.</p>
     *
     * @return {@code true} se il peso è inferiore a 10 kg
     */
    public boolean leggera() {
        /*
         * Da corsa professionale deve essere di 6.8 kg mentre le mountain bike
         * all'incirca 14 Kg
         */
        if (peso < 10) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Restituisce il numero di rapporti (marce) della bicicletta.
     *
     * @return il numero di rapporti (marce) della bicicletta
     */
    public int getNumeroDiRapporti() {
        return numeroDiRapporti;
    }

    /**
     * Imposta il numero di rapporti della bicicletta.
     *
     * @param numeroDiRapporti il nuovo numero di rapporti
     */
    public void setNumeroDiRapporti(int numeroDiRapporti) {
        this.numeroDiRapporti = numeroDiRapporti;
    }

    /**
     * Restituisce il peso della bicicletta.
     *
     * @return il peso della bicicletta in kg
     */
    public double getPeso() {
        return peso;
    }

    /**
     * Imposta il peso della bicicletta.
     *
     * @param peso il nuovo peso in kg
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

}
