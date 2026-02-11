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
        List<String[]> candidati = new ArrayList<>();
        for (String[] col : righe) {
            String specialita = col[3].trim().toLowerCase();
            if (tipologia.equalsIgnoreCase("100m") && specialita.equals("100m")) {
                candidati.add(col);
            } else if (tipologia.equalsIgnoreCase("maratona") && specialita.equals("maratona")) {
                candidati.add(col);
            } else if (tipologia.equalsIgnoreCase("lancio del peso") && specialita.equals("lancio del peso")) {
                candidati.add(col);
            } else if ((tipologia.equalsIgnoreCase("alto") || tipologia.equalsIgnoreCase("lungo")) && (specialita.equals("alto") || specialita.equals("lungo"))) {
                candidati.add(col);
            }
        }

        // Scegli randomicamente un numero di atleti (ad esempio 8)
        Random rand = new Random();
        int nAtleti = Math.min(8, candidati.size());
        Set<Integer> scelti = new HashSet<>();
        while (scelti.size() < nAtleti) {
            int idx = rand.nextInt(candidati.size());
            scelti.add(idx);
        }
        for (int idx : scelti) {
            String[] col = candidati.get(idx);
            String nome = col[0].trim();
            String cognome = col[1].trim();
            // Crea atleta della specialità giusta
            if (tipologia.equalsIgnoreCase("100m")) {
                listaAtleti.add(new Velocista(nome, cognome));
            } else if (tipologia.equalsIgnoreCase("maratona")) {
                listaAtleti.add(new Velocista(nome, cognome));
            } else if (tipologia.equalsIgnoreCase("lancio del peso")) {
                listaAtleti.add(new Lanciatore(nome, cognome));
            } else if (tipologia.equalsIgnoreCase("alto") || tipologia.equalsIgnoreCase("lungo")) {
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
                    case "Maratona":
                        lista.add(new Velocista(nome, cognome));
                        break;
                    case "Lancio del peso":
                        lista.add(new Lanciatore(nome, cognome));
                        break;
                    case "alto":
                    case "lungo":
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
        for (Atleta a : listaAtleti) {
            double punteggio = a.calcolaPunteggio();
            if (punteggio < migliorPunteggio) {
                migliorPunteggio = punteggio;
                vincitore = a;
            }
        }
        this.vincitore = vincitore; // Salva il vincitore nella gara
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
