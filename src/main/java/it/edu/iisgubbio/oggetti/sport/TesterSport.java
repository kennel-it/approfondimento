package it.edu.iisgubbio.oggetti.sport;

/**
 * Classe di test
 * @hidden
 */
public class TesterSport {
    public static void main(String[] args) {
	    ClassTestManager m = new ClassTestManager("it.edu.iisgubbio.oggetti.sport", false);

        // --- Atleta ---
        // Luigi: eta=24, pesoKg=78.0, altezzaM=182.0, anniEsperienza=6
        m.classe = "Atleta";
        try {
            Object p1 = m.crea("Luigi", 24, 78.0, 182.0, 6);
            m.stampa("costruttore (\"Luigi\",24,78.0,182.0,6)", true);
            m.brontolaStringa(p1.toString(), "Luigi, di 24anni (con 6 di esperienza) e 78.0kg di peso per un altezza di 182.0m");
            // calcolaRecupero: base=4.0, bonusEsp=1.8 → 4.0-1.8=2.2
            m.stampa("calcolaRecupero(40,false)", m.chiama(p1, "calcolaRecupero", 40, false).equals(2.2));
            // calcolaRecupero: base=10.0, *2=20.0, bonusEsp=1.8 → 20.0-1.8=18.2
            m.stampa("calcolaRecupero(100,true)", m.chiama(p1, "calcolaRecupero", 100, true).equals(18.2));
            // calcolaIdoneita: 100 -10[bmi<18.5] +3[bonusEsp=min(3,10)] = 93.0
            m.stampa("calcolaIdoneita(60,false)", m.chiama(p1, "calcolaIdoneita", 60, false).equals(93.0));
            // calcolaIdoneita: 100 -10[bmi] -20[fumo] -5[(80-70)*0.5] +3[bonusEsp] = 68.0
            m.stampa("calcolaIdoneita(80,true)",  m.chiama(p1, "calcolaIdoneita", 80, true).equals(68.0));
        } catch (Exception e) {
            m.stampa(e);
        }

        // --- Maratoneta ---
        // Marco: eta=35, pesoKg=70.0, altezzaM=1.80, anniEsperienza=10, asfalto, altitudine=1000
        m.classe = "Maratoneta";
        try {
            Object mar = m.crea("Marco", 35, 70.0, 1.80, 10, "asfalto", 1000);
            m.stampa("costruttore(\"Marco\",35,70.0, 1.80, 10, \"asfalto\",1000", true);
            m.brontolaStringa(mar.toString(), "Maratoneta{nome='Marco', superficie='asfalto', altitudine=1000m, eta=35}");
            m.stampa("getSuperficiePrediletta()", m.chiama(mar, "getSuperficiePrediletta").equals("asfalto"));
            m.stampa("getAltitudineAllenamento()", m.chiama(mar, "getAltitudineAllenamento").equals(1000));
            // calcolaRecupero: base=6.0, alt<1500(no), eta>30→+2.5=8.5, bonusEsp=min(3.0,5)=3.0→-3.0=5.5
            m.stampa("calcolaRecupero(60,false)", m.chiama(mar, "calcolaRecupero", 60, false).equals(5.5));
            // calcolaRecupero: base=12.0, *2=24.0, +2.5=26.5, bonusEsp=3.0→-3.0=23.5
            m.stampa("calcolaRecupero(120,true)", m.chiama(mar, "calcolaRecupero", 120, true).equals(23.5));
            // calcolaRitmo: 4.5, noCaldo, noSterrato, alt<1500(no), bmiOk, bonusEsp=min(0.25,0.3)=0.25 → 4.25
            m.stampa("calcolaRitmo(42,false)",    m.chiama(mar, "calcolaRitmo", 42, false).equals(4.25));
        } catch (Exception e) {
            m.stampa(e);
        }

        // --- Nuotatore ---
        // Sara: eta=28, pesoKg=62.0, altezzaM=1.72, anniEsperienza=8, farfalla, vasca50m=true
        m.classe = "Nuotatore";
        try {
            Object nuo = m.crea("Sara", 28, 62.0, 1.72, 8, "farfalla", true);
            m.stampa("costruttore(\"Sara\", 28, 62.0, 1.72, 8, \"farfalla\", true)", true);
            m.brontolaStringa(nuo.toString(), "Nuotatore{nome='Sara', stile='farfalla', vasca50m=true, eta=28}");
            m.stampa("getStile()",   m.chiama(nuo, "getStile").equals("farfalla"));
            m.stampa("isVasca50m()", m.chiama(nuo, "isVasca50m").equals(true));
            // calcolaRecupero: base=1.0, *1.4=1.4, eta≤30, bonusEsp=min(2.4,5)=2.4 → 1.4-2.4=-1→max=1.0
            m.stampa("calcolaRecupero(10,false)", m.chiama(nuo, "calcolaRecupero", 10, false).equals(1.0));
            // calcolaRecupero: base=5.0, *1.4=7.0, *2=14.0, bonusEsp=2.4 → 14.0-2.4=11.6
            m.stampa("calcolaRecupero(50,true)",  m.chiama(nuo, "calcolaRecupero", 50, true).equals(11.6));
            // calcolaTempo: vel=1.6, base=100/1.6=62.5, noCorsia, virate=(100/50)-1=1, +1*0.8=63.3
            m.stampa("calcolaTempo(100,false)",   m.chiama(nuo, "calcolaTempo", 100, false).equals(63.3));
            // calcolaTempo: base=62.5, *1.03=64.375, +0.8=65.175
            m.stampa("calcolaTempo(100,true)",    m.chiama(nuo, "calcolaTempo", 100, true).equals(65.175));
        } catch (Exception e) {
            m.stampa(e);
        }
    }
}
