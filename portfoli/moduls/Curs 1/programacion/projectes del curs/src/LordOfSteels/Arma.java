/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LordOfSteels;

/**
 *
 * @author sarab
 */
public class Arma {
    protected String tipus;
    protected int wpow; //força
    protected int wvel;//velocitat

    public Arma(String tipus){
        this.tipus=tipus;
        switch (tipus){
            case "Daga":
                this.wpow=5;
                this.wvel=15;
               break;
           case "Espada":
                this.wpow=10;
                this.wvel=10;
                break;
            case "Martillo":
                this.wpow=15;
                this.wvel=5;
                break;
                    
        }
    }
    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public int getWpow() {
        return wpow;
    }

    public void setWpow(int wpow) {
        this.wpow = wpow;
    }

    public int getWvel() {
        return wvel;
    }

    public void setWvel(int wvel) {
        this.wvel = wvel;
    }
        
    
}
