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
    
    public Atleta(String nome){
        this.nome = nome;
    }
    /**
     * metodo calcola punteggio da definire nelle sottoclassi
     */
    public abstract void calcolaPunteggio();
}
