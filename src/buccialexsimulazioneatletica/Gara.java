/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buccialexsimulazioneatletica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author bucci.alex
 */
public class Gara {

    /**
     * attributi
     */
    private final ArrayList<Atleta> listaAtleti;
    private Float durata;
    private String tipologia;
    private Atleta vincitore;

    /**
     * costruttore di gara
     *
     * @param durata durata della gara
     * @param tipologia tipologia della gara
     */
    public Gara(Float durata, String tipologia) {
        listaAtleti = new ArrayList<>();
        this.durata = durata;
        this.tipologia = tipologia;

        // Carica tutti gli atleti dal file
        List<String[]> righe = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Atleti.txt"))) {
            String riga;
            while ((riga = br.readLine()) != null) {
                String[] col = riga.split(",");
                if (col.length >= 4) {
                    righe.add(col);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Filtra per specialità coerente con la tipologia
        // Normalizziamo la tipologia passata dall'interfaccia (es. "Atletica 100m")
        // affinché corrisponda ai valori nel file Atleti.txt.
        String tipoNorm = tipologia.trim().toLowerCase();
        List<String[]> candidati = new ArrayList<>();
        for (String[] col : righe) {
            String specialita = col[3].trim().toLowerCase();

            // controlli più permissivi: usiamo contains per gestire prefissi/testi diversi
            if (tipoNorm.contains("100m") && specialita.equals("100m")) {
                candidati.add(col);
            } else if (tipoNorm.contains("maratona") && specialita.equals("maratona")) {
                candidati.add(col);
            } else if (tipoNorm.contains("peso") && specialita.contains("lancio del peso")) {
                candidati.add(col);
            } else if (tipoNorm.contains("giavellotto") && specialita.contains("giavellotto")) {
                candidati.add(col);
            } else if ((tipoNorm.contains("alto") || tipoNorm.contains("lungo") || tipoNorm.contains("salto"))
                    && (specialita.contains("alto") || specialita.contains("lungo") || specialita.contains("salto"))) {
                candidati.add(col);
            }
        }
        if (candidati.isEmpty()) {
            // Nel caso in cui non siano stati trovati atleti compatibili loggiamo per aiutare il debug
            System.err.println("[Gara] nessun atleta trovato per tipologia '" + tipologia + "'." +
                    " controllare i nomi presenti in Atleti.txt o il valore della combobox.");
        }

        // Scegli randomicamente un numero di atleti (ad esempio 8)
        Random rand = new Random();
        // per la maratona vogliamo più partecipanti (100) se disponibili
        int nAtleti;
        if (tipologia.toLowerCase().contains("maratona")) {
            nAtleti = Math.min(100, candidati.size());
        } else {
            nAtleti = Math.min(8, candidati.size());
        }
        Set<Integer> scelti = new HashSet<>();
        while (scelti.size() < nAtleti) {
            int idx = rand.nextInt(candidati.size());
            scelti.add(idx);
        }
        for (int idx : scelti) {
            String[] col = candidati.get(idx);
            String nome = col[0].trim();
            String cognome = col[1].trim();
            // Crea atleta della specialità giusta in base al tipo selezionato (non alla specialità del file)
            String tipoNorm2 = tipologia.trim().toLowerCase();
            if (tipoNorm2.contains("100m") || tipoNorm2.contains("maratona")) {
                Velocista v = new Velocista(nome, cognome);
                if (tipoNorm2.contains("maratona")) {
                    v.setDistanzaKm(46.0);
                } else {
                    v.setDistanzaKm(0.1);
                }
                listaAtleti.add(v);
            } else if (tipoNorm2.contains("peso") || tipoNorm2.contains("giavellotto")) {
                listaAtleti.add(new Lanciatore(nome, cognome));
            } else if (tipoNorm2.contains("alto") || tipoNorm2.contains("lungo") || tipoNorm2.contains("salto")) {
                listaAtleti.add(new Saltatore(nome, cognome));
            }
        }
    }

    /**
     * Restituisce una coppia nome/cognome random da una lista di atleti
     */
    public static String[] scegliNomeCognomeRandom(List<Atleta> atleti) {
        if (atleti == null || atleti.isEmpty()) {
            return new String[]{"Nome", "Cognome"};
        }
        Random rand = new Random();
        Atleta a = atleti.get(rand.nextInt(atleti.size()));
        return new String[]{a.getNome(), a.getCognome()};
    }

    public static List<Atleta> caricaAtleti(String percorsoFile) {
        List<Atleta> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(percorsoFile))) {
            String riga;
            while ((riga = br.readLine()) != null) {
                String[] col = riga.split(",");
                if (col.length < 4) {
                    continue;
                }

                String nome = col[0].trim();
                String cognome = col[1].trim();
                String specialita = col[3].trim().toLowerCase(); // Quarta colonna

                // Decidiamo quale sottoclasse istanziare
                switch (specialita) {
                    case "100m":
                    case "maratona":
                        lista.add(new Velocista(nome, cognome));
                        break;
                    case "lancio del peso":
                    case "lancio del giavellotto":
                        lista.add(new Lanciatore(nome, cognome));
                        break;
                    case "alto":
                    case "lungo":
                    case "salto in lungo":
                    case "salto":
                        lista.add(new Saltatore(nome, cognome));
                        break;
                    default:
                        // Opzionale: un caso generico se la specialità non è mappata
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }

    /**
     * metodo che avvia lo svolgimento della gare
     */
    public void svolgiGara() {
        for (Atleta a : listaAtleti) {
            a.generaValoreCasuale(); // Genera un valore casuale per ogni atleta
        }
        // Determina il vincitore confrontando i punteggi
        Atleta vincitore = null;
        double migliorPunteggio = Double.MAX_VALUE; // Per gare di tempo, minore è meglio
        // terreni per calcolo durata gara
        double peggiorTempo = 0.0; // in secondi
        boolean haTimingEvents = false; // ha atleti la cui gara si base su tempo?
        
        for (Atleta a : listaAtleti) {
            double punteggio = a.calcolaPunteggio();
            if (punteggio < migliorPunteggio) {
                migliorPunteggio = punteggio;
                vincitore = a;
            }
            // convertiamo in tempo positivo
            double tempoSec;
            if (a instanceof Velocista) {
                tempoSec = punteggio; // già in secondi
                haTimingEvents = true;
            } else if (a instanceof Saltatore || a instanceof Lanciatore) {
                // punteggio negativo = -distanza, ma la gara non ha "tempo"
                // ignoriamo per durata
                tempoSec = 0;
            } else {
                tempoSec = punteggio;
            }
            if (tempoSec > peggiorTempo) {
                peggiorTempo = tempoSec;
            }
        }
        this.vincitore = vincitore; // Salva il vincitore nella gara
        // imposta la durata in ore pari al tempo del "last finisher" (se vale)
        if (peggiorTempo > 0 && haTimingEvents) {
            this.durata = (float) (peggiorTempo / 3600.0);
        } else if (!haTimingEvents) {
            // Per gare senza timing (salti, lanci) genera durata random tra 1 e 4 ore
            Random rand = new Random();
            this.durata = 1.0f + rand.nextFloat() * 3.0f;
        }
    }

    /**
     * get di Durata
     *
     * @return
     */
    public double getDurata() {
        return durata;
    }

    /**
     * set di Durata
     *
     * @param durata
     */
    public void setDurata(Float durata) {
        this.durata = durata;
    }

    /**
     * get di Tipologia
     *
     * @return
     */
    public String getTipologia() {
        return tipologia;
    }

    /**
     * set di Tipologia
     *
     * @param tipologia
     */
    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    /**
     * get di Vincitore
     *
     * @return
     */
    public Atleta getVincitore() {
        return vincitore;
    }

    /**
     * set di Vincitore
     *
     * @param vincitore
     */
    public void setVincitore(Atleta vincitore) {
        this.vincitore = vincitore;
    }

    /**
     * get di Lista Atleti
     *
     * @return la lista degli atleti della gara
     */
    public ArrayList<Atleta> getListaAtleti() {
        return listaAtleti;
    }

    /**
     * ritorna il risultato della gara
     *
     * @return
     */
    @Override
    public String toString() {
        return "Gara{" + "listaAtleti=" + listaAtleti + ", durata=" + durata + ", tipologia=" + tipologia + ", vincitore=" + vincitore + '}';
    }

}
