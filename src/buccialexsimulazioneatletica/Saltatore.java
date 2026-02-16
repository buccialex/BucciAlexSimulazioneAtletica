
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
public class Saltatore extends Atleta {
    /**
     * attributi
     */
    private double potenzaSalto;

    /**
     * costruttore di saltatore
     * @param nome nome del saltatore
     * @param cognome cognome del saltatore
     */
    public Saltatore(String nome, String cognome) {
        super(nome, cognome);
    }

    /**
     * override del metodo calcola punteggio 
     * @return il punteggio dell'atleta
     */
    @Override
    public double calcolaPunteggio() {
        return -potenzaSalto;
    }

    /**
     * override per variare il punteggio
     */
    @Override
    public void generaValoreCasuale() {
        Random r = new Random();
        potenzaSalto = 2.5 + r.nextDouble() * 6.5;
    }
    
    
}
