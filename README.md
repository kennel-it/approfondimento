# Approfondimento OOP — IIS Gubbio

Progetto Java didattico per l'approfondimento della programmazione orientata agli oggetti: ereditarietà
e gerarchia di tipi.

## Struttura del progetto

```text
src/main/java/it/edu/iisgubbio/oggetti/
├── mobilita/   — mezzi di trasporto
├── sport/      — atleti (metodi più complessi)
└── fattoria/   — prodotti agricoli (partenza)
```

## Pacchetti

### `mobilita`

Gerarchia che parte da `MezzoDiTrasporto` (nome, costo, calcolo rata).
Sottoclassi principali: `AMuscoli` e `AMotore`, da cui derivano `Bicicletta`, `Skateboard`, `Automobile`, `Motocicletta`, `Aereo`, `Barca`, `Motoslitta`, `Deltaplano`.

### `sport`

Classe base `Atleta` con dati anagrafici e fisici, calcolo BMI, stima del recupero post-gara e punteggio di idoneità atletica.
Sottoclassi: `Maratoneta`, `Nuotatore`.

### `fattoria`

Classe base `Prodotto` (nome, prezzo al kg, calcolo prezzo per peso).
Sottoclassi: `Carne`, `Ortaggio`, `Formaggio`, con gestione dello stato `Muffato`.

## Requisiti

- Java 17+
- Maven 3.x

## Compilazione ed esecuzione

```bash
mvn compile
mvn exec:java -Dexec.mainClass="it.edu.iisgubbio.oggetti.mobilita.TesterMobilita"
```

## Generazione della documentazione

Per generare la documentazione javadoc di un siongolo esercizio:
`mvn javadoc:javadoc -Dsubpackages=it.edu.iisgubbio.oggetti.mobilita`