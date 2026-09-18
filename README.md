# JAVA_projects

Raccolta di esercizi e piccoli/medi progetti scritti in **Java**, sviluppati nel tempo su temi diversi: comunicazione client-server, multithreading, conversione dati (JSON/XML), interfacce grafiche a form ed esercitazioni a tema.

> ℹ️ Nota dell'autore: tutto il codice in questa repository è stato scritto **a mano, in epoca "pre-AI"**, incluso il debug — nessuna riga è stata generata con l'assistenza di strumenti di intelligenza artificiale.

## 📋 Descrizione

Questo repository funge da **contenitore/archivio** per numerose esercitazioni Java accumulate nel tempo, probabilmente in ambito scolastico/universitario o di autoapprendimento. I progetti spaziano dalla comunicazione in rete (client-server su socket TCP/UDP) alla gestione della concorrenza (thread), dalla conversione di formati dati (JSON ↔ XML) a piccole applicazioni con interfaccia grafica, fino a esercizi tematici come simulatori di banca, cinema e gioco del tris.

## 🗂️ Struttura del repository

Cartelle presenti nella root (basate sui nomi, senza garanzia sul contenuto interno di ciascuna, non essendo stato possibile ispezionarle in dettaglio):

| Cartella | Area presunta |
|---|---|
| `ClientEsercizio2C_belluccià` | Esercizio client (client-server), variante "bellucci" |
| `CommunicationLibrary` | Libreria riutilizzabile per la comunicazione di rete |
| `CommunicationLibrary2_meaven` | Seconda versione/variante della libreria di comunicazione |
| `EsempioMinimale_2_server_comunicanti` | Esempio minimale di due server che comunicano tra loro |
| `EsercizioCinema-bellucci` | Esercizio a tema gestionale cinema |
| `Json_xml_1/ConvertXJ` | Conversione tra formati JSON e XML |
| `SenderPackResult_prova_1` | Invio di pacchetti dati / risultati, prova preliminare |
| `banca_1` | Simulatore/esercizio a tema bancario |
| `cinema__2` | Seconda versione dell'esercizio cinema |
| `es_2_3_c_s` | Esercizio client-server (c_s) |
| `es_4date _s/es_4_server` | Esercizio con gestione date, lato server |
| `es_9_5_cam_pll` | Esercizio (con webcam/camera, dato "cam") |
| `es_9_5_finito` | Versione completata di un esercizio della serie 9.5 |
| `librerie_fine_5/ConvertXJ` | Libreria di conversione JSON/XML, versione finale |
| `life_es` | Esercizio (possibilmente ispirato al "Game of Life") |
| `serverPack` | Pacchetto/modulo server |
| `upd` | Esercizio legato a comunicazione UDP o aggiornamento (update) |

Archivi `.zip` presenti nella root, **non ancora estratti**:

| Archivio | Contenuto presunto |
|---|---|
| `Eser2ClientServer.zip` | Secondo esercizio client-server |
| `es_9_5_cam_pll.zip` | Versione compressa dell'esercizio "cam" |
| `secondo_es_udp.zip` | Secondo esercizio su comunicazione UDP |
| `threads.zip` | Esercizi sul multithreading |
| `tris_Pillitu.zip` | Gioco del tris |

## 🛠️ Tecnologie utilizzate

- **Java** (linguaggio principale)
- **Socket TCP/UDP** per la comunicazione client-server
- **Java Swing/AWT** (per le interfacce a "form" menzionate nella descrizione)
- **JSON / XML** per la serializzazione e conversione dati
- **Multithreading** (Java Thread API)

## ⚙️ Come esplorare il repository

Non essendoci un unico entry point (è una raccolta di progetti indipendenti), il modo più semplice per lavorare su un singolo esercizio è:

1. Clona l'intero repository:
   ```bash
   git clone https://github.com/luca-g-pll/JAVA_projects.git
   ```
2. Entra nella cartella dell'esercizio che ti interessa.
3. Se il progetto usa Maven o Gradle (verifica la presenza di `pom.xml` o `build.gradle`), compilalo con il relativo tool; altrimenti, se sono semplici file `.java`, compila ed esegui direttamente con `javac` e `java`, oppure apri la cartella in un IDE (IntelliJ IDEA, Eclipse, NetBeans).
4. Per gli archivi `.zip` non ancora estratti, decomprimili prima di poterli esplorare/eseguire.

## ⚠️ Note e possibili miglioramenti

- **Struttura non uniforme**: essendo una raccolta accumulata nel tempo, le convenzioni di naming delle cartelle non sono coerenti (es. `es_9_5_cam_pll` vs `es_9_5_finito` vs `cinema__2`), il che rende difficile capire a colpo d'occhio la relazione tra le varie versioni di uno stesso esercizio.
- **Archivi `.zip` non estratti**: alcuni progetti (`Eser2ClientServer.zip`, `es_9_5_cam_pll.zip`, `secondo_es_udp.zip`, `threads.zip`, `tris_Pillitu.zip`) sono ancora compressi nella root e non fanno parte della struttura navigabile dei file sorgente.
- **Mancanza di un README per singolo progetto**: essendo esercizi accumulati nel tempo, la maggior parte delle sottocartelle probabilmente non ha una propria documentazione; può valere la pena, in futuro, aggiungere un breve `README.md` per cartella con una riga di descrizione dell'esercizio.
- **Codice pre-AI**: come specificato dall'autore, il codice è stato scritto interamente a mano; può quindi contenere pattern meno ottimizzati rispetto a codice generato/assistito, ma rappresenta un buon percorso di apprendimento manuale del linguaggio.

## 📄 Licenza

Progetto realizzato a scopo di esercitazione personale.
