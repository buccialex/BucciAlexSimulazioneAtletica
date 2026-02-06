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
public class Gara {
    /**
     * attributi
     */
    private final ArrayList<Atleta> listaAtleti;
    private Float durata;
    private String tipologia;
    private Atleta vincitore;
    
    /**
     * costruttore di gara
     * @param durata durata della gara
     * @param tipologia tipologia della gara
     */
    public Gara(Float durata, String tipologia){
        listaAtleti = new ArrayList<>();
        this.durata = durata;
        this.tipologia = tipologia;
    }
    
    public void svolgiGara(){
        
    }

    public double getDurata() {
        return durata;
    }

    public void setDurata(Float durata) {
        this.durata = durata;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public Atleta getVincitore() {
        return vincitore;
    }

    public void setVincitore(Atleta vincitore) {
        this.vincitore = vincitore;
    }

    @Override
    public String toString() {
        return "Gara{" + "listaAtleti=" + listaAtleti + ", durata=" + durata + ", tipologia=" + tipologia + ", vincitore=" + vincitore + '}';
    }
    
    
    
}
