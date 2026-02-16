/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buccialexsimulazioneatletica;
import java.util.*;
/**
 *
 * @author goretti.leonardo
 */
public class Meeting {
    /**
     * attributi
     */
    private ArrayList<Gara> listaGare;
    
    /**
     * costruttore di meeting
     */
    public Meeting(){
        listaGare = new ArrayList<>();
    }
    
    /**
     * Metodo che crea la gara
     * @param tipologia 
     */
    public void creaGara(String tipologia){
        // popola in base alla tipologia grazie al costruttore di gara
        listaGare.add(new Gara(tipologia));
    }

    /**
     * get lista gare
     * @return 
     */
    public ArrayList<Gara> getListaGare() {
        return listaGare;
    }

    /**
     * set lista gare
     * @param listaGare lista delle gare
     */
    public void setListaGare(ArrayList<Gara> listaGare) {
        this.listaGare = listaGare;
    }

    /**
     * override tostring
     * @return la lista di gare
     */
    @Override
    public String toString() {
        return "Meeting{" + "listaGare=" + listaGare + '}';
    }
    
    
        
}

