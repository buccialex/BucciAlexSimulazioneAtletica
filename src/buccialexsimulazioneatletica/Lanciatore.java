/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buccialexsimulazioneatletica;

/**
 *
 * @author bucci.alex
 */
public class Lanciatore extends Atleta {

    /**
     * attributi
     */
    private int forza;
    
    /**
     * costruttore di lanciatore
     * @param nome nome del lanciatore
     * @param cognome cognome del lanciatore
     * @param forza forza del lanciatore
     */
    public Lanciatore(String nome, String cognome, int forza){
        super(nome, cognome);
        this.forza = forza;
    }

    
    
    /**
     * override del metodo della super classe "calcolaPunteggio"
     */
    @Override
    public int calcolaPunteggio() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
