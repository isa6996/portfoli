/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miproyectojava;

import java.io.IOException;
import java.util.Scanner;

/**
 * Penjat
 * @author sarab
 */
public class penjat2 {

    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {

        final char[][] estatPenjatInicial
                = {
                    {' ', ' ', ' ', ' ', '_', '_', '_', '_', ' ', ' ', ' ', ' '},
                    {' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                    {' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                    {' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                    {' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                    {' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                    {' ', '_', '_', '|', '_', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                    {'|', ' ', ' ', ' ', ' ', '|', '_', '_', '_', '_', '_', ' '},
                    {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                    {'|', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '|'}
                };

        String[] paraules = {"mar", "montaña", "patata", "abecedari", "anestesia",
"bicicleta", "tren", "avio", "pisarra", "teclat", "ordinador", "boligraf",
"armari", "bicicleta", "advocat", "ascensor", "astronauta", "autopista",
"avinguda", "bigoti", "carretera", "castanya", "cervell", "civada", "cultura",
"dentista", "esquena", "estrella", "formatge", "gendre", "genoll", "infermera",
"internet", "maduixa", "malaltia", "maluc", "mandarina", "maquinista", "motocicleta",
"nebot", "pastanaga", "patinet", "perruqueria", "professor", "quadrat", "taronja",
"tramvia", "trapezi", "tricicle", "violeta"};

        char[][] estatPenjat = new char[estatPenjatInicial.length]
                                    [estatPenjatInicial[0].length];

        inicialitzarEstatPenjat(estatPenjatInicial, estatPenjat);

        final int MAXiNTENTS = 8;
        int errors = 0;
        int totalEncerts = 0;
        String paraula = paraules[(int) (Math.random()*paraules.length)]; 
        boolean[] lletresEncertades = new boolean[paraula.length()];
        String lletres = "";

        do {
            
            
            mostrarEstatPenjat(estatPenjat);

            System.out.print("Paraula: ");
            mostrarParaula(paraula, lletresEncertades);

            System.out.println("");

            System.out.print("Lletres:");

            mostrarLletresIntroduides(lletres);

            System.out.println("");

            System.out.print("Introdueix lletra: ");

            String letraTemporal = demanarLletra(lletres);
            
            if(!existeixLletra(lletres, letraTemporal.charAt(0))){
                lletres+=letraTemporal;
                
                if(paraula.indexOf(letraTemporal)==-1)
                    errors++;
                else{
                    for(int i=0;i<paraula.length();i++){
                        if (paraula.charAt(i)==letraTemporal.charAt(0)){                   
                            lletresEncertades[i]=true; 
                            totalEncerts++;
                        }
                    }      
                }
            } 
            
            actualitzarEstatPenjat(estatPenjat, errors);
            
            netejarPantalla();
                        
        } while (errors < MAXiNTENTS && totalEncerts < paraula.length());
        
        netejarPantalla();
        
        mostrarEstatPenjat(estatPenjat);

        System.out.print("Paraula: ");
        mostrarParaula(paraula, lletresEncertades);

        System.out.println("");

        System.out.print("Lletres:");

        mostrarLletresIntroduides(lletres);      
        System.out.println("");      
        
        if(totalEncerts==paraula.length()){
            System.out.println("bieeen!!!!!!!!! L'has encertat!!!! :D");
        }
        if(errors==MAXiNTENTS){
            System.out.println("oooooooh, has perdut!!!!!!!!!!!!");
            System.out.println("La paraula correcta era:"+paraula);
        }
    }

    static void mostrarEstatPenjat(char[][] estat) {
        for (char[] fila : estat) {
            for (char valor : fila) {
                System.out.print(valor);
            }
            System.out.println("");
        }

    }

    static void inicialitzarEstatPenjat(char[][] estatPenjatIni, char[][] estat) {
        for (int i = 0; i < estatPenjatIni.length; i++) {
            for (int j = 0; j < estatPenjatIni[0].length; j++) {
                estat[i][j] = estatPenjatIni[i][j];
            }
        }
    }

    static void mostrarParaula(String paraula, boolean[] encertades) {
       
        for (int i = 0; i <paraula.length(); i++) {
            if(encertades[i]==true){
                System.out.print(paraula.substring(i,i+1));                
            }
            else{
                System.out.print("*");
            }
        }
    }

    static void mostrarLletresIntroduides(String lletres) {
        System.out.println(lletres);

    }

    static String demanarLletra(String lletres) {
        lletres = entrada.nextLine().toLowerCase();

        if (lletres.length() > 0) {
            lletres = lletres.substring(0, 1);

        }

        return lletres;
    }

    static boolean existeixLletra(String lletres, char lletra) {
       
        if (lletres.indexOf(lletra) == -1) {
            return false;
        }

        return true;

    }

    static void actualitzarEstatPenjat(char[][] penjat, int errors) {
        switch (errors){
            case 1:
                penjat[1][8]='|';
                break;
            case 2:
                penjat[2][8]='O'; 
                break;
            case 3:
                penjat[3][8]='|';
                break;
            case 4:
                penjat[4][8]='|';
                break;
            case 5:
                penjat[3][7]='/';
                break;
            case 6:
                penjat[3][9]='\\';
                break;
            case 7:
                penjat[5][7]='/';
                break;
            case 8:
                penjat[5][9]='\\';
                break;
        }
                  
    }

    static void netejarPantalla() {
        
            // Esborrem pantalla
            try {
                if (System.getProperty("os.name").contains("Windows")) {
                    new ProcessBuilder("cmd", "/c", "cls").
                            inheritIO().start().waitFor();
                } else {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                }
            } catch (IOException | InterruptedException ex) {
            }
        
    }
}
