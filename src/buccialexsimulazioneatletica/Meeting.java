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
    
    
    public Meeting(){
        listaGare = new ArrayList<>();
    }
    
    /**
     * Metodo che crea la gara
     * @param durataGara
     * @param tipologia 
     */
    public void creaGara(Float durataGara, String tipologia){
        listaGare.add(new Gara(durataGara, tipologia));  
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
     * @param listaGare 
     */
    public void setListaGare(ArrayList<Gara> listaGare) {
        this.listaGare = listaGare;
    }

    /**
     * ritorna la lista di gare create
     * @return 
     */
    @Override
    public String toString() {
        return "Meeting{" + "listaGare=" + listaGare + '}';
    }
    
    
        
}

