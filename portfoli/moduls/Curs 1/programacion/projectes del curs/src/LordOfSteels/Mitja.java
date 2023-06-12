/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LordOfSteels;

/**
 *
 * @author sarab
 */
public class Mitja extends Personajes{
    public Mitja(String nom,int forca, int constitucio, int velocitat, 
            int intel, int sort, Arma arma,int nivell,int experiencia){
        super(nom,forca, constitucio, velocitat, intel, sort, arma, nivell,experiencia);
    }
    
    @Override
    protected void EstadiDeriv(){
        super.EstadiDeriv();
         pe = velocitat+sort+intel+forca; 
    }
}
