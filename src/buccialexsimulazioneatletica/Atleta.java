/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buccialexsimulazioneatletica;

/**
 *
 * @author bucci.alex
 */
public abstract class Atleta {
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
    public abstract int calcolaPunteggio();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    
    
}
