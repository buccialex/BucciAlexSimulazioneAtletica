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
    private double velocita;
    private double distanzaKm;
    
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
        if (velocita <= 0 || distanzaKm <= 0) {
            return Double.MAX_VALUE;
        }
        return (distanzaKm / velocita) * 3600.0;
    }

    /**
     * genera un valora casuale per variare i risultati
     */
    @Override
    public void generaValoreCasuale() {
        Random r = new Random();
        if (distanzaKm >= 42) { // maratona
            this.velocita = 8 + r.nextDouble() * 12;
        } else {
            this.velocita = 25 + r.nextDouble() * 25; // km/h
        }
    }
        
    
    
        
    
    // getter/setter distanza
    public double getDistanzaKm() {
        return distanzaKm;
    }

    public void setDistanzaKm(double distanzaKm) {
        this.distanzaKm = distanzaKm;
    }
}
