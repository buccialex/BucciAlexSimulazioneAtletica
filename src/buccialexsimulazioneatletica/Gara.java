/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buccialexsimulazioneatletica;
import java.io.BufferedReader;
import java.io.FileReader;
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
    private List<Atleta> databaseAtleti = new ArrayList<>();
    
    /**
     * costruttore di gara
     * @param durata durata della gara
     * @param tipologia tipologia della gara
     */
    public Gara(Float durata, String tipologia){
        listaAtleti = new ArrayList<>();
        this.durata = durata;
        this.tipologia = tipologia;
    }
<<<<<<< HEAD
    
    public static List<Atleta> caricaAtleti(String percorsoFile) {
        List<Atleta> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(percorsoFile))) {
            String riga;
            while ((riga = br.readLine()) != null) {
                String[] col = riga.split(",");
                if (col.length < 4) continue;

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
                        lista.add(new Lanciatore(nome, cognome, specialita));
                        break;
                    case "alto":
                    case "lungo":
                        lista.add(new Saltatore(nome, cognome, specialita));
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
    
=======
   
    /**
     * metodo che avvia lo svolgimento della gare
     */
>>>>>>> 179d81c634dc42ee0af9a5c72d513f97bf4f87f0
    public void svolgiGara(){
        
    }

    /**
     * get di Durata
     * @return 
     */
    public double getDurata() {
        return durata;
    }

    /**
     * set di Durata
     * @param durata 
     */
    public void setDurata(Float durata) {
        this.durata = durata;
    }

    /**
     * get di Tipologia
     * @return 
     */
    public String getTipologia() {
        return tipologia;
    }

    /**
     * set di Tipologia
     * @param tipologia 
     */
    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    /**
     * get di Vincitore
     * @return 
     */
    public Atleta getVincitore() {
        return vincitore;
    }

    /**
     * set di Vincitore
     * @param vincitore 
     */
    public void setVincitore(Atleta vincitore) {
        this.vincitore = vincitore;
    }

    /**
     * ritorna il risultato della gara
     * @return 
     */
    @Override
    public String toString() {
        return "Gara{" + "listaAtleti=" + listaAtleti + ", durata=" + durata + ", tipologia=" + tipologia + ", vincitore=" + vincitore + '}';
    }
    
    
    
}
