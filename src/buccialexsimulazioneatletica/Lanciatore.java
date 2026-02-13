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
public class Lanciatore extends Atleta {

    /**
     * attributi
     */
    // distanza del lancio in metri
    private double forza;
    
    /**
     * costruttore di lanciatore
     * @param nome nome del lanciatore
     * @param cognome cognome del lanciatore
     */
    public Lanciatore(String nome, String cognome){
        super(nome, cognome);
        
    }

    
    
    /**
     * override del metodo della super classe "calcolaPunteggio"
     */
    @Override
    public double calcolaPunteggio() {
        // più lunga è la distanza, migliore il punteggio (minore)
        return -forza;
    }

    /**
     * genera un valore casuale per la forza del lanciatore
     */
    @Override
    public void generaValoreCasuale() {
        Random r = new Random();
        // lancio in giavellotto/peso: prendiamo range 20..90 metri
        forza = 20 + r.nextDouble() * 70;
    }
    
    
    
}
