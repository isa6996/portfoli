/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LordOfSteels;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author sarab
 */
public class LordOfSteel {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        
        
        //Arma arma= new Arma("Daga"); 
        //se puede poner aqui y luego poner el nombre del Arma y pasarlo al enano
        
        //o se puede crear directamente en el enano
        NanOrdre nan1=new NanOrdre("Tirion",10,10,10,10,10,new Arma("Martillo"),0,0);
        HumaOrdre h1=new HumaOrdre("Luis",9,11,10,10,10,new Arma("Espada"),0,0);
        MitjaCaos mi1=new MitjaCaos("Frodo",9,7,12,12,12,new Arma("Daga"),0,0);
        MaiaCaos ma1=new MaiaCaos("nilos",7,9,12,10,7,new Arma("Daga"),0,0);
        
       /*// Personajes[] personatges=new Personajes[4];
        System.out.println("Punst de dany: "+nan1.getPd());
        System.out.println("Punts de dany de n1: " + nan1.getPd());
        System.out.println("Punts de salut de n1: " + nan1.getPs());
        */
        
        /*El array se puede hacer binario o dinamico: el binario es ampliar los espacios vacioos
        a un numero que se supone que no se llegara (p.e.1000):
        
        Personajes[] personatges=new Personajes[1000];
        
        el dinamico es el de 
        ArrayList <Personajes> personatges = new ArrayList<Personajes>(); */
        
        ArrayList<Personajes> personatges = new ArrayList<Personajes>();
        personatges.add(h1);
        personatges.add(mi1);
        personatges.add(nan1);
        personatges.add(ma1); 
        
        int opcio=0;
        while(opcio!=5){
        System.out.println("");
        
        System.out.println("**MENÚ PRINCIPAL**");
        System.out.println("1 - Afegir personatge");
        System.out.println("2 - Esborrar personatge");
        System.out.println("3 - Editar personatge");
        System.out.println("4 - iniciar combat");
        System.out.println("5 - sortir");
        System.out.println("\n tria opció[1-5]");
        
        
        String entrada=sc.nextLine();
        opcio=Integer.parseInt(entrada);
        
        switch (opcio){
            case 1:
                AfegirPersonatge(personatges);
                sc.nextLine();
                break;
            case 2:
                EsborrarPersonatge(personatges);
                sc.nextLine();
                break;
            case 3:
                EditarPersonatge(personatges);
                sc.nextLine();
                break;
            case 4:
                IniciarCombat(personatges);
                sc.nextLine();
                break;
            case 5:
                break;
            default:
                System.out.println("opcio incorrecta");
                break;
        
        }
        
        }
    }
    
    public static void AfegirPersonatge(ArrayList<Personajes> personatges){
        
        System.out.println("escull classe: ");
        System.out.println("1 - Nan");
        System.out.println("2 - Huma");
        System.out.println("3 - Maia");
        System.out.println("4 - Mitja");
            System.out.println("");
        int clase=sc.nextInt();
        
        System.out.println("posa nom: ");
        sc.nextLine();
        String nom=sc.nextLine();
        
        int forca;
        int cons;
        int veloc;
        int intel;
        int sort;
        
        while(true){        
        System.out.println("posa força:");
        forca=sc.nextInt();
        System.out.println("posa constitucio:");
        cons=sc.nextInt();
        System.out.println("posa velocitat:");
        veloc=sc.nextInt();
        System.out.println("posa inteligència:");
        intel=sc.nextInt();
        System.out.println("posa sort:");
        sort=sc.nextInt(); 
        int suma=forca+cons+veloc+intel+sort;
        if(suma<=60&&suma>=5)
            break;
        else{
            suma=0;
                System.out.println("\nT'has pasat possant punts!!!\n");
        }
        }
        System.out.println("posa arma: (1- daga 2-espasa 3-martell)");
        int arma1=sc.nextInt();
        Arma armaP=new Arma("");
        
        if(arma1==1){
            armaP=new Arma("Daga");
        }
        else if(arma1==2){
            armaP=new Arma("Espada");
        }
        else
            armaP=new Arma("Martillo");
        
        System.out.println("Escull devocio: 1-Ordre 2-Caos");
        int devocio=sc.nextInt();
        
                switch(clase){
                    case 1:
                        if(devocio==1){
                            NanOrdre nan=new NanOrdre(nom,forca,cons,veloc,intel,
                                                      sort,armaP,0,0);
                            personatges.add(nan);
                        }
                        else {
                            NanCaos nan=new NanCaos(nom,forca,cons,veloc,intel,
                                    sort,armaP,0,0);
                            personatges.add(nan);
                        }                             
                        break;
                    case 2:
                        if(devocio==1){
                            HumaOrdre huma=new HumaOrdre(nom,forca,cons,veloc,
                                    intel,sort,armaP,0,0);
                            personatges.add(huma);
                        }
                        else {
                            HumaCaos huma=new HumaCaos(nom,forca,cons,veloc,
                                    intel,sort,armaP,0,0);
                            personatges.add(huma);
                        }
                        break;
                    case 3:
                        if(devocio==1){
                            MaiaOrdre maia=new MaiaOrdre(nom,forca,cons,veloc,
                                    intel,sort,armaP,0,0);
                            personatges.add(maia);
                        }
                        else {
                            MaiaCaos maia=new MaiaCaos(nom,forca,cons,veloc,intel,
                                    sort,armaP,0,0);
                            personatges.add(maia);
                        }
                        
                        break;
                    case 4:
                        if(devocio==1){
                            MitjaOrdre mitja=new MitjaOrdre(nom,forca,cons,veloc,
                                    intel,sort,armaP,0,0);
                            personatges.add(mitja);
                        }
                        else {
                            MitjaCaos mitja=new MitjaCaos(nom,forca,cons,veloc,
                                    intel,sort,armaP,0,0);
                            personatges.add(mitja);
                        }
                        
                        break;
                }
                
        

        }
    
    
    public static void IniciarCombat(ArrayList<Personajes> personatges){
        
        boolean[] seleccionats= new boolean[personatges.size()];
        Personajes[] lluitadors =new Personajes[2];
        int index=personatges.size()+2;
        
        for(int sele=1;sele<=2;sele++){
            
            for(int i=0; i<personatges.size();i++){
                if (!seleccionats[i]){       
                    if(i<index)
                MostrarPersonatge(personatges.get(i), i);   
                    
                    else
                        MostrarPersonatge(personatges.get(i), i-1);
            }
                else{
                    index=i;
                }
            }
        System.out.println("\n Tria personatge "+sele+": ");
        int opcio=sc.nextInt();        
        while(opcio<0||opcio>personatges.size()){
            sc.hasNextLine();
            System.out.println("opcio incorrecta, torna a probar-ho ");
            opcio=sc.nextInt();
            
            System.out.println("");
            
        }
        
        seleccionats[opcio-1]=true;
        if(opcio<=index){
        lluitadors[sele-1]=personatges.get(opcio-1);
        System.out.println("Personatge "+sele+" triat: "+personatges.get(opcio-1).getNom());
        }
        else{
            lluitadors[sele-1]=personatges.get(opcio);
        System.out.println("Personatge "+sele+" triat: "+personatges.get(opcio).getNom());
        }
        
        
        }
       
                
        Dau[] daus = new Dau[3];
        daus[0] = new Dau();
        daus[1] = new Dau();
        daus[2] = new Dau();
        
        Personajes atacante  = lluitadors[0];
        Personajes defensor = lluitadors[1];
        
        int vidaAtacant=atacante.getPs();
        int vidaDefensor=defensor.getPs();
        
        while(defensor.getPs()>0){
            System.out.println("vida " +atacante.getNom()+" : "+atacante.getPs());
            System.out.println("vida " +defensor.getNom()+" : "+defensor.getPs());
            
        int paDef=defensor.getPa();
        
        int psAta=vidaAtacant;
        
        int valor =daus[0].lanzar()+daus[1].lanzar()+daus[2].lanzar();
        
        
        if(valor<=atacante.getPa()){
            valor =daus[0].lanzar()+daus[1].lanzar()+daus[2].lanzar();
            if(valor<=defensor.getPe()){
                System.out.println("Esquivat");
                
                if (defensor instanceof HumaCaos||defensor instanceof NanCaos||
                   defensor instanceof MaiaCaos||defensor instanceof MitjaCaos){
                    if(defensor.atacPAreduit(daus[0],daus[1],daus[2])){
                        System.out.println("Contratac amb èxit");
                        atacante.setPs(atacante.getPs()-valor);
                        
                    }
                }
            }
        
            else{
                System.out.println(atacante.getNom()+" ataca!!");
                defensor.setPs(defensor.getPs()-atacante.getPd());
                if(atacante instanceof HumaOrdre||atacante instanceof NanOrdre ||
                   atacante instanceof MaiaOrdre||atacante instanceof MitjaOrdre){
                    System.out.println("el "+atacante.getNom()+" es recupera vida");
                    atacante.restaurarPs(atacante.getPs());
                    System.out.println("ara el "+atacante.getNom()+"té "+
                            atacante.getPs()+" de vida");
                }
            }
        }
            if(defensor.getPs()<=0){
                System.out.println(defensor.getNom()+"");
            }
        defensor.setPa(paDef);
        Personajes aux=atacante;
        atacante =defensor;
        defensor =aux;
        
        
        
        }
        
        atacante.setPs(vidaAtacant);
        defensor.setPs(vidaDefensor);
        System.out.println("victoria per "+atacante.getNom());
        
        atacante.setExperiencia(defensor.getPs());
        
        
    
    }
    public static void EsborrarPersonatge(ArrayList<Personajes> personatges){
        for(int i=0; i<personatges.size();i++){
            MostrarPersonatge(personatges.get(i), i);
        }
    
        System.out.println("\n Tria personatge que vols esborrar: ");
        int opcio=sc.nextInt();
        personatges.remove(opcio-1);       
        
    }
    
    public static void EditarPersonatge(ArrayList<Personajes> personatges){
        for(int i=0; i<personatges.size();i++){
            MostrarPersonatge(personatges.get(i), i);
        }
        System.out.println("\n Tria personatge que vols modificar: ");
        int opcio=sc.nextInt();  
        
        int forca;
        int cons;
        int veloc;
        int intel;
        int sort;
        while(true){        
        System.out.println("posa força:");
        forca=sc.nextInt();
        System.out.println("posa constitucio:");
        cons=sc.nextInt();
        System.out.println("posa velocitat:");
        veloc=sc.nextInt();
        System.out.println("posa inteligència:");
        intel=sc.nextInt();
        System.out.println("posa sort:");
        sort=sc.nextInt(); 
        int suma=forca+cons+veloc+intel+sort;
        if(suma<=60&&suma>=5)
            break;
        else{
            suma=0;
                System.out.println("\nT'has pasat possant punts!!!\n");
        }
        }
        
    }
    
    
    private static void MostrarPersonatge(Personajes personatges, int index){
        
                String tipus="";                
                if(personatges instanceof NanOrdre)
                    tipus="Nan ordre";
                
                else if(personatges instanceof NanCaos)
                    tipus="Nan caos";

                else if(personatges instanceof MaiaOrdre)
                    tipus="Maia ordre";
                
                else if(personatges instanceof MaiaCaos)
                    tipus="Maia caos";

                else if(personatges instanceof HumaOrdre)
                    tipus="Huma ordre";
                
                else if(personatges instanceof HumaCaos)
                    tipus="Huma caos";

                else if(personatges instanceof MitjaOrdre)
                    tipus="Mitja ordre";
                
                else if(personatges instanceof MitjaCaos)
                    tipus="Mitja caos";
                System.out.printf("%d %s (lvl %s) (%s)\n",(1+index),personatges.nom,
                                   personatges.getNivell(), tipus);
            
    }
    
}
