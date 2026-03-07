package it.edu.iisgubbio.oggetti.mobilita;

/****************************************************************************
 * Aereo a motore.
 *
 * <p>Estende {@link Volante}. Aggiunge la <b>distanza massima</b>
 * percorribile in km e la presenza o meno del motore
 * <b>a reazione</b>.</p>
 *
 * <p>Il costruttore imposta solo il nome: tutti gli altri valori
 * (costo, distanza massima, tipo di motore) partono da {@code 0} /
 * {@code false} e vanno impostati tramite i rispettivi setter.
 * La quota massima eredita il default di {@link Volante} (2400 m).</p>
 ***************************************************************************/
public class Aereo extends Volante{

    private boolean reazione;
    private int distanzaMassima;

    /**
     * Crea un aereo con il solo nome specificato.
     *
     * @param nome nome dell'aereo
     */
    public Aereo(String nome){
        super();
        this.nome = nome;
    }

    /**
     * Restituisce una descrizione dell'aereo.
     *
     * <p>Esempio: {@code Aereo: Boeing777 percorrenza massima 13000km}</p>
     *
     * @return stringa con nome e distanza massima percorribile
     */
    @Override
    public String toString(){
        String risposta;
        risposta = "Aereo: "+nome+" percorrenza massima "+distanzaMassima+"km";
        return risposta;
    }

    /**
     * Verifica se l'aereo è in grado di raggiungere la destinazione.
     *
     * <p>Il confronto è <em>stretto</em>: se la distanza del viaggio
     * è esattamente uguale alla distanza massima, il viaggio
     * <b>non</b> è considerato raggiungibile.</p>
     *
     * @param distanzaViaggio distanza del viaggio in km
     * @return {@code true} se {@code distanzaViaggio < distanzaMassima}
     */
    public boolean puoRaggiungere(int distanzaViaggio){
        return distanzaViaggio<distanzaMassima;
    }

    /**
     * Indica se il motore dell'aereo è a reazione.
     *
     * @return {@code true} se il motore è a reazione
     */
    public boolean getReazione(){
        return reazione;
    }

    /**
     * Imposta il tipo di motore dell'aereo.
     *
     * @param reaz {@code true} per impostare il motore a reazione
     */
    public void setReazione(boolean reaz){
        reazione = reaz;
    }

    /**
     * Restituisce la distanza massima percorribile dall'aereo.
     *
     * @return la distanza massima percorribile in km
     */
    public int getDistanzaMassima() {
        return distanzaMassima;
    }

    /**
     * Imposta la distanza massima percorribile dall'aereo.
     *
     * @param distanzaMassima la nuova distanza massima in km
     */
    public void setDistanzaMassima(int distanzaMassima) {
        this.distanzaMassima = distanzaMassima;
    }

}
