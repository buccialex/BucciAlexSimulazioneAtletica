/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buccialexsimulazioneatletica;
import java.util.*;
/**
 *
 * @author bucci.alex
 */
public class Velocista extends Atleta {
    /**
     * attributi
     */
    // velocita in km/h (valore usato per calcolare il tempo sui 100m o maratona)
    private double velocita;
    // distanza della gara in km (default 0.1 per 100m)
    private double distanzaKm = 0.1;
    
    /**
     * costruttore di velocista
     * @param nome nome del velocista
     * @param cognome cognome del velocista
     */
    public Velocista(String nome, String cognome){
        super(nome, cognome);
    }

   
    
    /**
     * override del metodo della superclasse "calcolaPunteggio"
     * @return punteggio in secondi del velocista
     */
     @Override
    public double calcolaPunteggio() {
        // tempo in secondi = distanza (km) / velocita (km/h) * 3600
        if (velocita <= 0 || distanzaKm <= 0) {
            return Double.MAX_VALUE;
        }
        return (distanzaKm / velocita) * 3600.0;
    }

    /**
     * genera un valora casuale da asseganre al velocistà in modo da garantire la randomicità
     */
    @Override
    public void generaValoreCasuale() {
        Random r = new Random();
        if (distanzaKm >= 42) { // maratona
            // corridori di maratona medi: 8–20 km/h
            this.velocita = 8 + r.nextDouble() * 12;
        } else {
            // velocità media dei migliori sprinter: 35–45 km/h,
            // prendiamo un range 25..50 per maggiore variabilità
            this.velocita = 25 + r.nextDouble() * 25; // km/h
        }
    }
        
    
    
        
    
    // getter/setter distance
    public double getDistanzaKm() {
        return distanzaKm;
    }

    public void setDistanzaKm(double distanzaKm) {
        this.distanzaKm = distanzaKm;
    }
}
