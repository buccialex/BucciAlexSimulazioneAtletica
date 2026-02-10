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
    
    public void svolgiGara(){
        
    }

    public double getDurata() {
        return durata;
    }

    public void setDurata(Float durata) {
        this.durata = durata;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public Atleta getVincitore() {
        return vincitore;
    }

    public void setVincitore(Atleta vincitore) {
        this.vincitore = vincitore;
    }

    @Override
    public String toString() {
        return "Gara{" + "listaAtleti=" + listaAtleti + ", durata=" + durata + ", tipologia=" + tipologia + ", vincitore=" + vincitore + '}';
    }
    
    
    
}
