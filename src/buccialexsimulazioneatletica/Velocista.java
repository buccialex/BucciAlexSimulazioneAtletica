/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buccialexsimulazioneatletica;

/**
 *
 * @author bucci.alex
 */
public class Velocista extends Atleta{
    /**
     * attributi
     */
    private int velocita;
    
    /**
     * costruttore di velocista
     * @param nome nome del velocista
     * @param cognome cognome del velocista
     * @param velocita velocità del velocista
     */
    public Velocista(String nome, String cognome, int velocita){
        super(nome, cognome);
        this.velocita = velocita;
    }

   
    
    /**
     * override del metodo della superclasse "calcolaPunteggio"
     */
     @Override
    public int calcolaPunteggio() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
        
    
    
        
    
}
