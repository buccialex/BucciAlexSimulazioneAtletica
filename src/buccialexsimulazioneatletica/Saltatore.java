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
public class Saltatore extends Atleta implements iCasualita{
    /**
     * attributi
     */
    private int potenzaSalto;

    /**
     * costruttore di saltatore
     * @param nome nome del saltatore
     * @param cognome cognome del saltatore
     */
    public Saltatore(String nome, String cognome) {
        super(nome, cognome);
    }

    /**
     * override del metodo calcola punteggio della superclasse astratta
     * @return il punteggio dell'attleta
     */
    @Override
    public double calcolaPunteggio() {
        return 4.50 + ((double)this.potenzaSalto/ 100.0) * (8.96 - 4.50);
    }

    /**
     * assegna un valora casuale al saltatore in modo che ognuno abbia una potenza diversa
     */
    @Override
    public void generaValoreCasuale() {
        Random r = new Random();
        potenzaSalto = r.nextInt(101);
    }
    
    
}
