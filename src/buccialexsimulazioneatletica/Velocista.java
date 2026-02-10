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
public class Velocista extends Atleta implements iCasualita{
    /**
     * attributi
     */
    private int velocita;
    
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
        Random r = new Random();
        return 15 - ((double)this.velocita / 100.0) * 15 - 9.57;
    }

    /**
     * genera un valora casuale da asseganre al velocistà in modo da garantire la randomicità
     */
    @Override
    public void generaValoreCasuale() {
        Random r = new Random();
        this.velocita = r.nextInt(101);
    }
        
    
    
        
    
}
