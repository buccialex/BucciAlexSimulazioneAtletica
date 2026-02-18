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
     * @param tipologia tipologia della gara
     */
    public Gara(String tipologia) {
        listaAtleti = new ArrayList<>();
        this.tipologia = tipologia;

        // caricamento lista di atleti
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
        // questo codice fa si che i valori che vengono presi dalla combo box siano applicabili correttamente alla gara
        
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
        

        // popola gara con numero di atleti casuale tranne che per la maratona (100 atleti)
        Random rand = new Random();
        int nAtleti;
        if (tipologia.toLowerCase().contains("maratona")) {
            nAtleti = Math.min(100, candidati.size());
        } else {
            nAtleti = Math.min(8, candidati.size());
        }
        // così so quali atleti sono stati presi
        Set<Integer> scelti = new HashSet<>();
        while (scelti.size() < nAtleti) {
            int idx = rand.nextInt(candidati.size());
            scelti.add(idx);
        }
        
        // creo n atleti tra quelli scelti, in base alla categoria della gara creo atleti della tipologia corretta
        for (int idx : scelti) {
            String[] col = candidati.get(idx);
            String nome = col[0].trim();
            String cognome = col[1].trim();

            String tipoNorm2 = tipologia.trim().toLowerCase();
            if (tipoNorm2.contains("100m") || tipoNorm2.contains("maratona")) {
                Velocista v = new Velocista(nome, cognome);
                if (tipoNorm2.contains("maratona")) {
                    // 46 km per maratona
                    v.setDistanzaKm(46.0);
                } else {
                    // 100 metri
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
     * @param atleti lista degli atleti presi dal file
     * @return un array di stringhe con i nomi e i cognomi presi
     */
    public static String[] scegliNomeCognomeRandom(List<Atleta> atleti) {
        if (atleti == null || atleti.isEmpty()) {
            return new String[]{"Nome", "Cognome"};
        }
        Random rand = new Random();
        Atleta a = atleti.get(rand.nextInt(atleti.size()));
        return new String[]{a.getNome(), a.getCognome()};
    }

    /**
     * metodo per caricare gli atleti
     * @param percorsoFile percorso del file contenente gli atleti
     * @return il contenuto dei file sottoforma di lista
     */
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
                String specialita = col[3].trim().toLowerCase(); 

                // questo switch contiene più casi nel caso si voglia implementare diversi tipi di saltatori
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
        Random r = new Random();
        for (Atleta a : listaAtleti) {
            a.generaValoreCasuale();
            
        }
        
        for (Atleta l : listaAtleti){
            if(l instanceof Lanciatore && this.tipologia.equalsIgnoreCase("lancio del peso")){
            Lanciatore lanciatore = (Lanciatore) l;
            lanciatore.setForza(lanciatore.getForza() - r.nextInt(20, 51));
        }
        }
        // Determina il vincitore confrontando i punteggi
        Atleta vincitore = null;
        double migliorPunteggio = Double.MAX_VALUE; 
        double peggiorTempo = 0.0; 
        boolean tempo = false; 
        
        for (Atleta a : listaAtleti) {
            double punteggio = a.calcolaPunteggio();
            if (punteggio < migliorPunteggio) {
                migliorPunteggio = punteggio;
                vincitore = a;
            }
            // convertiamo in tempo positivo
            double tempoSec;
            if (a instanceof Velocista) { // istanceof serve a vedere se l'oggetto istanziato appartiene alla sottoclasse di atleta "Velocista"
                tempoSec = punteggio;
                tempo = true; // la gara funziona a tempo
            } else if (a instanceof Saltatore || a instanceof Lanciatore) {
                // dato che il tempo non serve lo imposto a 0
                tempoSec = 0;
            } else {
                tempoSec = punteggio;
            }
            if (tempoSec > peggiorTempo) {
                peggiorTempo = tempoSec;
            }
        }
        this.vincitore = vincitore; 
        // se la gara ha il tempo imposta il tempo peggiore come durata
        if (peggiorTempo > 0 && tempo) {
            this.durata = (float) (peggiorTempo / 3600.0); // per rendere la durata in ore
        } else if (!tempo) {
            // genera durata random per le gare che non vanno a tempo
            Random rand = new Random();
            this.durata = 1.0f + rand.nextFloat() * 3.0f;
        }
    }

    public Float getDurata() {
        return durata;
    }

    /**
     * get di Durata
     *
     * @return
     */
    

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


