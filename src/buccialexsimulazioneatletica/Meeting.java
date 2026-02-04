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
    
    public void creaGara(int durataGara, String tipologia){
        listaGare.add(new Gara(durataGara, tipologia));  
    }

    public ArrayList<Gara> getListaGare() {
        return listaGare;
    }

    public void setListaGare(ArrayList<Gara> listaGare) {
        this.listaGare = listaGare;
    }

    @Override
    public String toString() {
        return "Meeting{" + "listaGare=" + listaGare + '}';
    }
    
    
        
}

