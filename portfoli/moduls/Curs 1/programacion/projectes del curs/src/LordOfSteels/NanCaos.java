/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LordOfSteels;

/**
 *
 * @author sarab
 */
public class NanCaos extends Nan {
    public NanCaos(String nom,int forca, int constitucio, int velocitat, 
            int intel, int sort, Arma arma,int nivell,int experiencia){
        super(nom,forca, constitucio, velocitat, intel, sort, arma, nivell,experiencia);
    }
    public boolean atacPAreduit(Dau... d){

        int valor=d[0].lanzar()+d[1].lanzar()+ d[2].lanzar();
        return true;
    }
}
