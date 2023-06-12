/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aceptaelreto;

import java.util.Scanner;

/**
 *
 * @author rferrero
 */
public class Ex659_NumerosJeroglificos {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        char[] simbolos = {'H','R','D','F','C','G','T'};
        int[] valores   = {1000000,100000,10000,1000,100,10,1};
        
        while (true)
        {
            int nombre = sc.nextInt();
            if (nombre == 0) 
                break;
                
            while (nombre > 0)
            {
                //1922
                // Opció 1
                /*
                if (nombre >= 1000000) 
                {
                    System.out.print("H");
                    nombre -= 1000000;
                }
                else if (nombre >= 100000)
                {
                    System.out.print("R");
                    nombre -= 100000;                
                }
                else if (nombre >= 10000)
                {
                    System.out.print("D");
                    nombre -= 10000;                
                }
                else if (nombre >= 1000)
                {
                    System.out.print("F");
                    nombre -= 1000;                
                }
                else if (nombre >= 100)
                {
                    System.out.print("C");
                    nombre -= 100;                
                }
                else if (nombre >= 10)
                {
                    System.out.print("G");
                    nombre -= 10;                
                }
                else if (nombre >= 1)
                {
                    System.out.print("T");
                    nombre--;
                }*/
                
                // Opció 2
                for (int i = 0; i < valores.length; i++) {
                    if (nombre >= valores[i]) 
                    {
                        System.out.print(simbolos[i]);
                        nombre -= valores[i];
                    }
                }                
                
            }
            System.out.println("");
        }
    }
}
