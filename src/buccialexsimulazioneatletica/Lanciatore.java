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
public class Lanciatore extends Atleta implements iCasualita{

    /**
     * attributi
     */
    private int forza;
    
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
        return 6.00 + ((double)this.forza/100)*(23.57 - 6.00);
    }

    /**
     * genera un valore casuale per la forza del lanciatore
     */
    @Override
    public void generaValoreCasuale() {
        Random r = new Random();
        this.forza = r.nextInt(101);
    }
    
    
    
}
