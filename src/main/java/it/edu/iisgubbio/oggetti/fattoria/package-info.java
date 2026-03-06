/***********************************************
 * i "+" sono i passi nella classe di test
 *
 * gli studenti dovrebbero creare soltanto i metodi richiesti,
 * ad esempio i "toString" sono richiesti quando serve
 * anche per mostrare come funziona l'ereditarietà.
 *
 * creare una classe Prodotto, che ha:
 * - due proprietà: il nome e il prezzo al chilo
 * - le proprietà devono essere visibili alle sottoclassi
 * - un costruttore che le imposta entrambe
 * - un costruttore che non imposta nulla
 * - il metodo toString
 * - un metodo calcolaPrezzo che dato il peso
 *   ritorna il costo dell'oggetto
 *
 * + creare una classe Fattoria con il metodo main
 * + creare un oggetto "carote" che costano 2.5€/kg
 * + stampare "carote" sulla console
 * + stampare quanto costano 4kg di carote
 *
 * - Un Ortaggio è un particolare tipo di Prodotto
 *   che in più può essere biologico o no
 * - anche questa classe implementa toString
 * - Ortaggio ha un costruttore per impostare tutte
 *   le sue proprietà
 *
 * + nella classe Fattoria creare un ortaggio "pomodoro"
 *   che costa 2€/kg ed è biologico
 * + stampare pomodoro
 * + stampare quanto costa mezzo kg di pomodori
 *
 * - Un Formaggio è un particolare tipo di prodotto che
 *   ha due caratteristiche in più: il tempo di stagionatura (in mesi, intero)
 *   e il fatto che sia DOP o meno
 *  - ha due costruttori: uno che imposta tutte le proprietà
 *   e uno che ha come parametri nome, prezzoalkg e periodo di stagionatura e
 *   serve a creare un formaggio non DOP
 *
 * + nella classe fattoria crerare il Taleggio che costa 25€/kg,
 *   stagiona un mese ed è DOP
 * + creare anche ricotta che non stagiona, costa 4€/kg e non è DOP
 * + stampare taleggio e ricotta
 *
 * - Formaggio ha un metodo toString che mostra tutte le sue
 *   caratteristiche ma il periodo di stagionatura
 *   solo se è maggiore di zero.
 *
 * - un Muffato è un particolare tipo di formaggio che... ha la muffa
 *   la muffa in pratica è un fungo: dobbiamo memorizzare il suo nome
 *   e il fatto che colonizzi l'interno o l'esterno del formaggio.
 * - un formaggio muffato ha un solo costruttore che specifica:
 *   nome, prezzoAlKilo e il nome della muffa. Il formaggio
 *   creato non è DOP, non stagiona e ha la muffa all'interno.
 *
 * - Carne è un particolare tipo di Prodotto che
 *   ha due caratteristiche in più (che non possono
 *   essere viste neanche da eventuali sottoclassi):
 * - i tipo di macellazione che può essere "kosher"
 *   oppure no
 * - il fatto che sia carne bianca o meno
 *
 * - Carne ha un solo costruttore che imposta tutti i parametri
 *   Realizzare il metodo toString che stampi una descrizione
 *   tipo quella qui sotto:
 *   "costarelle 9.5€/Kg NON Kosher [carne rossa]"
 * - è possibile leggere il valore delle proprietà kosher o bianca
 *   di un oggetto di tipo Carne ma non modificarle.
 *
 * + nella classe Fattoria dichiarare un oggetto che
 *   rappresenta un pollo e stamparlo
 * + stampare anche il valore della proprietà carneBianca
 *
 * =?= Negozio è un inizio di interfaccia grafica da dare agli studenti
 *     per completarlo
 *
 **********************************************/


package it.edu.informatica.oggetti.fattoria;