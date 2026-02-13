
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
    // distanza del salto in metri
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
     * override del metodo calcola punteggio della superclasse astratta
     * @return il punteggio dell'attleta
     */
    @Override
    public double calcolaPunteggio() {
        // vogliamo che chi salta più lontano abbia il punteggio migliore (minore)
        // usiamo il punteggio = -distanza
        return -potenzaSalto;
    }

    /**
     * assegna un valora casuale al saltatore in modo che ognuno abbia una potenza diversa
     */
    @Override
    public void generaValoreCasuale() {
        Random r = new Random();
        // salto in lungo tra circa 2.5 e 9.0 metri
        potenzaSalto = 2.5 + r.nextDouble() * 6.5;
    }
    
    
}
