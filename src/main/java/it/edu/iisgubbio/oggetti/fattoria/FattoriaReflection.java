package it.edu.iisgubbio.oggetti.fattoria;

import it.edu.iisgubbio.oggetti.ClassTestManager;

public class FattoriaReflection {

	public static void main(String[] args) {

	    ClassTestManager m = new ClassTestManager("it.edu.informatica.oggetti.fattoria", true);

        // --- Prodotto ---
        m.classe = "Prodotto";
        try {
            Object p1 = m.crea("carote", 2.5);
            m.brontolaStringa(p1.toString(), "prodotto carote, 2.5€/kg");
            m.stampa("calcolaPrezzo", m.chiama(p1, "calcolaPrezzo", 4.0).equals(10.0));

            // costruttore vuoto: campi rimangono null/0
            Object p2 = m.crea();
            m.brontolaStringa(p2.toString(), "prodotto null, 0.0€/kg");
        } catch (Exception e) {
            m.stampa(e);
        }

        // --- Ortaggio ---
        m.classe = "Ortaggio";
        try {
            Object o1 = m.crea("pomodoro", 2.0, true);
            m.brontolaStringa(o1.toString(), "Ortaggio [biologico=true, nome=pomodoro, prezzoAlKg=2.0]");
            m.stampa("calcolaPrezzo", m.chiama(o1, "calcolaPrezzo", 0.5).equals(1.0));

            Object o2 = m.crea("patata", 1.2, false);
            m.brontolaStringa(o2.toString(), "Ortaggio [biologico=false, nome=patata, prezzoAlKg=1.2]");
            m.stampa("calcolaPrezzo", m.chiama(o2, "calcolaPrezzo", 1.0).equals(1.2));
        } catch (Exception e) {
            m.stampa(e);
        }

        // --- Formaggio ---
        m.classe = "Formaggio";
        try {
            // costruttore con 4 parametri (dop esplicito)
            Object f1 = m.crea("Taleggio", 25.0, 1, true);
            m.brontolaStringa(f1.toString(), "Formaggio Taleggio, prezzoAlKg=25.0, stagionato 1 mesi DOP");
            m.stampa("calcolaPrezzo", m.chiama(f1, "calcolaPrezzo", 0.5).equals(12.5));

            Object f2 = m.crea("Ricotta", 4.0, 0, false);
            m.brontolaStringa(f2.toString(), "Formaggio Ricotta, prezzoAlKg=4.0, stagionato 0 mesi");
            m.stampa("calcolaPrezzo", m.chiama(f2, "calcolaPrezzo", 0.5).equals(2.0));

            // costruttore con 3 parametri (dop = false di default)
            Object f3 = m.crea("Asiago", 18.0, 6);
            m.brontolaStringa(f3.toString(), "Formaggio Asiago, prezzoAlKg=18.0, stagionato 6 mesi");
            m.stampa("calcolaPrezzo", m.chiama(f3, "calcolaPrezzo", 0.5).equals(9.0));
        } catch (Exception e) {
            m.stampa(e);
        }

        // --- Muffato (extends Formaggio, usa il toString di Formaggio) ---
        m.classe = "Muffato";
        try {
            Object mu = m.crea("Gorgonzola", 22.0, "Penicillium glaucum");
            m.brontolaStringa(mu.toString(), "Formaggio Gorgonzola, prezzoAlKg=22.0, stagionato 0 mesi");
            m.stampa("calcolaPrezzo", m.chiama(mu, "calcolaPrezzo", 0.5).equals(11.0));
        } catch (Exception e) {
            m.stampa(e);
        }

        // --- Carne ---
        m.classe = "Carne";
        try {
            Object c1 = m.crea("costarelle", 9.5, false, false);
            m.brontolaStringa(c1.toString(), "costarelle 9.5€/Kg NON Kosher [carne rossa]");
            m.stampa("calcolaPrezzo", m.chiama(c1, "calcolaPrezzo", 2.0).equals(19.0));

            Object c2 = m.crea("petto di pollo", 12.0, true, true);
            m.brontolaStringa(c2.toString(), "petto di pollo 12.0€/Kg macellazione Kosher [carne bianca]");
            m.stampa("calcolaPrezzo", m.chiama(c2, "calcolaPrezzo", 0.5).equals(6.0));
        } catch (Exception e) {
            m.stampa(e);
        }
	}

}
