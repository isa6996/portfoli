/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LordOfSteels;

/**
 *
 * @author sarab
 */
public abstract class Personajes {
  protected int forca;
    protected int constitucio;
    protected int velocitat;
    protected int intel;
    protected int sort;
    
    // Estadístiques derivades
    protected int ps;  // Punts de salut
    protected int pd;  // Punts de dany
    protected int pa;  // Probabilitat d'atac
    protected int pe;  // Probabilitat d'esquivar
    protected int experiencia;
    protected int nivell;
    protected int psMax;
   
    
    // Arma
    protected Arma arma;
    
    
    protected String nom;

    public Personajes(String nom,int forca, int constitucio, int velocitat,
                      int intel, int sort, Arma arma,int nivell, int exper) {
        this.nom           = nom;
        this.forca         = forca;
        this.constitucio   = constitucio;
        this.velocitat     = velocitat;
        this.intel = intel;
        this.sort          = sort;
        this.arma          = arma;
        this.experiencia =experiencia;
        this.nivell =nivell;
        
        EstadiDeriv();
        ExperienciaINivell();
    }

   
                      
    protected void EstadiDeriv() {
        ps = constitucio + forca+nivell;
        pd = ((forca + arma.getWpow())/4)+nivell;
        pa = intel + sort + nivell;
        pe = velocitat + sort + intel+nivell;
        psMax=constitucio + forca+nivell;
    }

    
    
     public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public int getForca() {
        return forca;
    }

    public int getConstitucio() {
        return constitucio;
    }

    public int getVelocitat() {
        return velocitat;
    }

    public int getIntel() {
        return intel;
    }

    public int getSort() {
        return sort;
    }

    public int getPs() {
        return ps;
    }

    public int getPd() {
        return pd;
    }

    public int getPa() {
        return pa;
    }

    public int getPe() {
        return pe;
    }

    public Arma getArma() {
        return arma;
    }

    
    public void setForca(int forca) {
        this.forca = forca;
    }

    public void setConstitucio(int constitucio) {
        this.constitucio = constitucio;
    }

    public void setVelocitat(int velocitat) {
        this.velocitat = velocitat;
    }

    public void setIntel(int intel) {
        this.intel = intel;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public void setPs(int ps) {
        this.ps = ps;
    }

    public void setPd(int pd) {
        this.pd = pd;
    }

    public void setPa(int pa) {
        this.pa = pa;
    }

    public void setPe(int pe) {
        this.pe = pe;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public int restaurarPs(int a){
        
        if((a+(psMax/10))>=psMax)
            this.ps=psMax;
        else
        this.ps=this.ps+((int)(psMax/10));
        
        return this.ps;
    }

    public int getPsMax() {
        return psMax;
    }

    public void setPsMax(int psMax) {
        this.psMax = psMax;
    }
    
    public void metodo(Dau... d){// poner los tres puntos sirve para crear array
       
        d[0].lanzar();//esto es para el caos. se tiene que poner aqui o en el personaje
        d[1].lanzar();//en este ejercicio lo haremos aqui aunque el enunciado lo 
        d[2].lanzar();//pida en el otro lado
        //como es cambiar el pa se tiene que hacer en el caos
    }
    
    public boolean atacPAreduit(Dau... d){
        
        return false;
    }
    
    public void ExperienciaINivell(){
        
        
        int aux=this.experiencia;
        
        this.experiencia+=aux;
        
        switch (this.nivell){
            case 0:
                if(this.experiencia>=100){
                    this.nivell=1;
                    this.experiencia-=100;
                }
                break;
            case 1:
                if(this.experiencia>=200){
                    this.nivell=2;
                    this.experiencia-=200;
                }
                break;
            case 2:
                if(this.experiencia>=500){
                    this.nivell=3;
                    this.experiencia-=500;
                }
                break;
            case 3:
                if(this.experiencia>=1000){
                    this.nivell=4;
                    this.experiencia-=1000;
                }
                break;
            case 4:
                if(this.experiencia>=2000){
                    this.nivell=5;
                    this.experiencia-=2000;
                }
                break;
                
        }
        
    }

    public int getNivell() {
        return nivell;
    }

    public void setNivell(int nivell) {
        this.nivell = nivell;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
        ExperienciaINivell();
    }

    

    
    
    
}

