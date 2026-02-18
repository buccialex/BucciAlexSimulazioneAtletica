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
     * 
     * @return il valore della forza 
     */
    @Override
    public double calcolaPunteggio() {
        return -forza;
    }

    /**
     * genera un valore casuale per la forza del lanciatore
     */
    @Override
    public void generaValoreCasuale() {
        Random r = new Random();
        // genero distanza compresa tra un determinato valore con aggiunta di valore random
        forza = 20 + r.nextDouble() * 70;
    }

    public double getForza() {
        return forza;
    }

    public void setForza(double forza) {
        this.forza = forza;
    }
    
    
    
    
    
}
