/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LordOfSteels;

/**
 *
 * @author sarab
 */
public class NanOrdre extends Nan {
    
    public NanOrdre(String nom,int forca, int constitucio, int velocitat, 
            int intel, int sort, Arma arma,int nivell,int experiencia){
        super(nom,forca, constitucio, velocitat, intel, sort, arma, nivell,experiencia);
    
        restaurarPs(this.ps);
    }
    
   /* public void restaurarPs(){
   
    segun el enunciado deberia estar aqui pero no hace falta porque se puede poner 
    en personajes y lo coje por herencia
}*/
    
}
   