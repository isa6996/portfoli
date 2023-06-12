/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegos;

import java.util.Scanner;

/**
 *
 * @author sarab
 */
public class PedraPaperTisoresLlangardaixSpock {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int [][]resulJugadas = {{0,-1,1,1,-1},
                                {1,0,-1,-1,1},
                                {-1,1,0,1,-1},
                                {-1,1,-1,0,1},
                                {1,-1,1,-1,0}};
        
        String []nombre= {"piedra","papel","tijeras","lagarto","spook"};
        
        int ronda =1;
        int marcadorH=0;
        int marcadorM=0;
        boolean salir=false;
    
        
        while(!salir){
            System.out.println("");
            System.out.println("ronda: "+ronda+" marcador Human: " + marcadorH+
                    " marcador Maquina: "+marcadorM);
            System.out.println("");
            System.out.println("jugadas: pedra(0), paper(1), tisores(2), "
                    + "llangardaix(3), Spock(4):");
            System.out.println("");

            //pedir tiro para la persona
            int jugadaH=jugadaHuma();

            //pedir tiro de la maquina
            int jugadaM=jugadaOrdinador();

            //comprovar quien gana
            System.out.println("El jugador ha tret: "+nombre[jugadaH]);
            System.out.println("L'ordinador ha tret: "+nombre[jugadaM]);


            if (resulJugadas[jugadaH][jugadaM]==0){
                System.out.println("empate");
                ronda++;
            }
            else if(resulJugadas[jugadaH][jugadaM]==1){
                System.out.println("Tu ganas!!!!!!   UwU");
                ronda++;
                marcadorH++;            
            }
            else {
                System.out.println("has perdido T-T");
                ronda++;
                marcadorM++;            
            }

            //alguien tiene que ganar tres rondas

            if(marcadorH==3||marcadorM==3){
                System.out.println("");
                System.out.println("La partida ha acabat en "+(ronda-1)+" rondes");
                System.out.println("El marcador ha estat: ");
                System.out.println("Jugador: "+marcadorH);
                System.out.println("Maquina: "+marcadorM);
                
                
                System.out.print("Vols fer una nova partida? [S/N]: ");
                char continu=sc.nextLine().toUpperCase().charAt(0);
                
                do{     // esto no se parece en nada a lo que ha hecho el profe, el lo ha hecho en un bucle por fuera                    
                    if(continu=='N'||continu=='S'){
                        if (continu=='N'){
                            salir=true;
                            break;
                        }
                        else{
                            marcadorH=0;
                            marcadorM=0;
                            ronda++;
                            break;
                        }
                    }
                    else {
                        System.out.print("Vols fer una nova partida? [S/N]: ");
                        continu=sc.nextLine().toUpperCase().charAt(0);
                    }                        
                }while(continu!='S'||continu!='N');
            }
        }
                
    }
    static int jugadaHuma(){
        Scanner sc = new Scanner(System.in);
        
        int tiroP=0;
        
        boolean entrada=false;
        
        do{            
            if(sc.hasNextInt()){
                tiroP=sc.nextInt();
                
                if(tiroP<=4&&tiroP>=0)
                    entrada=true;
            }
                if (!entrada){
                    System.out.println("jugadas: pedra(0), paper(1), tisores(2), "
                        + "llangardaix(3), Spock(4):");
                    sc.nextLine();
                }
            
            
        }while(!entrada);
        
        return tiroP;
    }
    static int jugadaOrdinador(){       
       return (int)(Math.random()*5);
       
    }
}
