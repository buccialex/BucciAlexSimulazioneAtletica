/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buccialexsimulazioneatletica;

/**
 *
 * @author bucci.alex
 */
public abstract class Atleta implements iCasualita {
    /**
     * attributi
     */
    protected String nome;
    protected String cognome;
    
    /**
     * costruttore di atleta
     * @param nome nome dell'atleta
     * @param cognome cognome dell'attleta
     */
    public Atleta(String nome, String cognome){
        this.nome = nome;
        this.cognome = cognome;
    }
    /**
     * metodo calcola punteggio da definire nelle sottoclassi
     */
    public abstract double calcolaPunteggio();

    /**
     * get di Nome
     * @return 
     */
    public String getNome() {
        return nome;
    }

    /**
     * set di Nome
     * @param nome 
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * get di Cognome
     * @return 
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * set di Cognome
     * @param cognome 
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    
    
    
    
}
