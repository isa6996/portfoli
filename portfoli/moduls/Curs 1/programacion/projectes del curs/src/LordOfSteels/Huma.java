/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LordOfSteels;

/**
 *
 * @author sarab
 */
public  class Huma extends Personajes{
    public Huma(String nom,int forca, int constitucio, int velocitat, 
            int intel, int sort, Arma arma,int nivell,int experiencia){
        super(nom,forca, constitucio, velocitat, intel, sort, arma, nivell,experiencia);
    }
    
    @Override
    protected void EstadiDeriv(){
        super.EstadiDeriv(); 
        ps = constitucio+forca+intel; 
    }
    
}
