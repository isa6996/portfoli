/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LordOfSteels;

/**
 *
 * @author sarab
 */
public class HumaCaos extends Huma{
    public HumaCaos(String nom,int forca, int constitucio, int velocitat, 
            int intel, int sort, Arma arma,int nivell,int experiencia){
        super(nom,forca, constitucio, velocitat, intel, sort, arma, nivell,experiencia);
    }
    @Override
    public boolean atacPAreduit(Dau... d){
        metodo(d[0],d[1],d[2]);
    int valor=d[0].lanzar()+d[1].lanzar()+d[2].lanzar();
        pa=(int)(pa*0.5);
        
        return valor<pa;
    }
}
