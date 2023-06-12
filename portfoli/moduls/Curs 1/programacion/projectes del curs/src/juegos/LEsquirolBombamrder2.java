/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package juegos;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author rferrero
 */
public class LEsquirolBombamrder2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        final int FILES       = 11;
        final int COLUMNES    = 22;
        final int TOTALBOMBES = 3;
        
        
        Scanner sc = new Scanner(System.in);
        
        // Mostrar presentació
        mostrarPresentacio();
        sc.nextLine(); 
        
        
        
        // Crea i inicialitza el tauler
        char[][] tauler = new char[FILES-2][COLUMNES-2];
        for (int i = 0; i < tauler.length; i++) 
        {
            for (int j = 0; j < tauler[0].length; j++) 
            {
                tauler[i][j] = ' ';
            }
        }
        
        // Posició inicial de l'Esquirol
        int posXEsquirol = 0;
        int posYEsquirol = 0;        
        tauler[posXEsquirol][posYEsquirol] = 'E';
        
        // Posició inicial del Lupin
        int posXLupin = tauler.length-1;
        int posYLupin = tauler[0].length-1;
        tauler[posXLupin][posYLupin] = 'L';
        
        // Posició de les bombes
        int[][] posicioBombes = new int[TOTALBOMBES][2];
        for (int i = 0; i < TOTALBOMBES; i++) {
            boolean posBombaCorrecte = false;
            while (!posBombaCorrecte) {
                int x = (int)(Math.random()*(tauler.length-1));
                int y = (int)(Math.random()*(tauler[0].length-1));                
                if (x > 0 && y > 0 && tauler[x][y] != '*') {
                    tauler[x][y] = '*';
                    posicioBombes[i][0] = x;
                    posicioBombes[i][1] = y;
                    posBombaCorrecte = true;
                }
            }
        }
        int[] estatBombes = new int[TOTALBOMBES];
        for (int i = 0; i < TOTALBOMBES; i++)
            estatBombes[i] = -1;
        
        int totalBombesEsquirol = 0;
        int indexBombaTriada = (int)(Math.random()*TOTALBOMBES);
        boolean restenBombesDesactivades = true;
        
        boolean finalPrograma = false;
        
        
        do {            
            try {
  		if (System.getProperty("os.name").contains("Windows")) {
    		  new ProcessBuilder("cmd", "/c", "cls").
                          inheritIO().start().waitFor();
  		} else {
    	    		System.out.print("\033[H\033[2J");
    			System.out.flush();
  		}
            } catch (IOException | InterruptedException ex) {}

            
            /* Mostrar el tauler */
            // Abans hem de refrescar l'estat de les bombes actives
            for (int i = 0; i < estatBombes.length; i++) {
                if (estatBombes[i] > 0) {
                    estatBombes[i]--;
                    tauler[posicioBombes[i][0]][posicioBombes[i][1]] = (char)('0' + estatBombes[i]);
                }
            }
            // Part superior tauler
            for (int i = 0; i < COLUMNES; i++)
                System.out.print("X");
            System.out.println("");

            for (int i = 0; i < FILES-2; i++) {
                System.out.print("X");
                for (int j = 0; j < COLUMNES-2; j++)
                    System.out.print(tauler[i][j]);
                System.out.println("X");
            }
            // Part inferior
            for (int i = 0; i < COLUMNES; i++)
                System.out.print("X");
            System.out.println("");

            // Comprovem si alguna bomba ha explotat
            for (int i = 0; i < estatBombes.length; i++) {
                if (estatBombes[i] == 0) {
                    System.out.println("BOOM!");
                    // ??? Modificar per preguntar si vol continuar
                    System.exit(0);
                }
            }
            
            // Pregunta moviment l'esquirol
            System.out.print("Cap a on vols moure? [w, a, s ,d] ");
            // Llegim el moviment com un char
            // ??? Comprovar si realment ens han introduït un char (INTRO?)
            char moviment = sc.nextLine().charAt(0);

            switch (moviment) {
                case 'w':   // Up
                    if (posXEsquirol > 0 && 
                        tauler[posXEsquirol-1][posYEsquirol] != 'L') {
                        tauler[posXEsquirol][posYEsquirol] = ' ';
                        posXEsquirol--;                        
                    }                    
                    break;
                case 'a':   // Left
                    if (posYEsquirol > 0 && 
                        tauler[posXEsquirol][posYEsquirol-1] != 'L') {
                        tauler[posXEsquirol][posYEsquirol] = ' ';
                        posYEsquirol--;                        
                    }                     
                    break;
                case 's':   // Down
                    if (posXEsquirol < tauler.length-1 && 
                        tauler[posXEsquirol+1][posYEsquirol] != 'L') {
                        tauler[posXEsquirol][posYEsquirol] = ' ';
                        posXEsquirol++;
                    }
                    break;
                case 'd':   // Right
                    if (posYEsquirol < tauler[0].length-1 && 
                        tauler[posXEsquirol][posYEsquirol+1] != 'L') {
                        tauler[posXEsquirol][posYEsquirol] = ' ';
                        posYEsquirol++;                        
                    }                                         
                    break;
                case 'e':   // Esquirol fa explotar una bomba
                    break;
                case 't':   // Fer trampa
                    break;
                case 'q':   // Sortir
                    finalPrograma = true;
                    break;
            }
            
            // Comprova si hi ha bomba en aquesta posició
            if (tauler[posXEsquirol][posYEsquirol] == '*') {
                System.out.println("Has agafat una bomba!!");
                totalBombesEsquirol++;
                // modifiquem estat de la bomba a desactivada
                for (int i = 0; i < posicioBombes.length; i++) {
                    if(posicioBombes[i][0] == posXEsquirol && posicioBombes[i][1] == posYEsquirol) {
                        estatBombes[i] = -2;   // -2 = desactivada
                        break;
                    }
                }
            }
            
            tauler[posXEsquirol][posYEsquirol] = 'E';
            
            /* Moviment Lupin            
               Només movem el Lupin si resten bombes desactivades
            */ 
            if (restenBombesDesactivades) {
                tauler[posXLupin][posYLupin] = ' ';
                // Cap a on s'ha de dirigir el Lupin
                int[] posicio = dirigirLupinBomba(posXLupin,posYLupin, posicioBombes,indexBombaTriada);
                posXLupin = posicio[0];
                posYLupin = posicio[1];
                        
                if (tauler[posXLupin][posYLupin] == '*') {
                    // Activem bomba
                    int i;
                    for (i = 0; i < TOTALBOMBES; i++) {
                        if (posicioBombes[i][0] == posXLupin && 
                            posicioBombes[i][1] == posYLupin) {
                            break;
                        }
                    }
                    estatBombes[i] = (int)(Math.random()*5) + 5;
                    tauler[posXLupin][posYLupin] = (char)('0' + estatBombes[i]);
                    // Lupin ha d'anar a cercar la següent bomba
                    // Hi ha bombes encara desactivades?
                    restenBombesDesactivades = false;
                    for (int estat : estatBombes)
                        if (estat == -1)
                            restenBombesDesactivades = true;

                    if (restenBombesDesactivades) {
                        while (estatBombes[indexBombaTriada] != -1)
                            indexBombaTriada = (int)(Math.random()*TOTALBOMBES);

                        // Movem el Lupin cap a la següent bomba
                        // FIXA'T QUE HE COPIAT ** EL MATEIX CODI ** QUE A DALT
                        posicio = dirigirLupinBomba(posXLupin,posYLupin, posicioBombes,indexBombaTriada);
                        posXLupin = posicio[0];
                        posYLupin = posicio[1];
                    } else {
                        posYLupin--;
                        indexBombaTriada = -1;
                    }

                } 
                tauler[posXLupin][posYLupin] = 'L';
            }                    
            
        } while(!finalPrograma);
        
    }
    
    
    public static void mostrarPresentacio() {

        String presentacio = "  Lupin el MUSSOL ha amagat BOMBES per la ciutat\n" +
                "          desactiva-les abans no EXPLOTIN,\n" +
                "                 amb l'ajuda de\n" +
                "\n" +
                "    _      _                       _           _\n" +
                "   | |    ( )                     (_)         | |\n" +
                "   | |    |/  ___  ___  __ _ _   _ _ _ __ ___ | |\n" +
                "   | |       / _ \\/ __|/ _` | | | | | '__/ _ \\| |\n" +
                "   | |____  |  __/\\__ \\ (_| | |_| | | | | (_) | |\n" +
                "  _|______|  \\___||___/\\__, |\\__,_|_|_|  \\___/|_|\n" +
                " |  _ \\                | || |              | |\n" +
                " | |_) | ___  _ __ ___ | ||_|  __ _ _ __ __| | ___ _ __\n" +
                " |  _ < / _ \\| '_ ` _ \\| '_ \\ / _` | '__/ _` |/ _ \\ '__|\n" +
                " | |_) | (_) | | | | | | |_) | (_| | | | (_| |  __/ |\n" +
                " |____/ \\___/|_| |_| |_|_.__/ \\__,_|_|  \\__,_|\\___|_|\n" +
                "\n" +
                "\n" +
                "               (Prem [ENTER] per continuar)";

        
        System.out.println(presentacio);
          
        
    }
    
    
    public static int[] dirigirLupinBomba(int posXLupin, int posYLupin, 
                                    int[][] posicioBombes,int indexBombaTriada) {
        
        if (Math.abs(posXLupin-posicioBombes[indexBombaTriada][0]) >
            Math.abs(posYLupin-posicioBombes[indexBombaTriada][1])) {
            // Diferència en files més gran
            if (posXLupin > posicioBombes[indexBombaTriada][0])
                posXLupin--;
            else
                posXLupin++;                
        } else {
            // Diferència en columnes més gran
            if (posYLupin > posicioBombes[indexBombaTriada][1])
                posYLupin--;
            else
                posYLupin++;                
        }

        int[] posicioLupin = {posXLupin,posYLupin};
        
        return posicioLupin;
    }
    
}
