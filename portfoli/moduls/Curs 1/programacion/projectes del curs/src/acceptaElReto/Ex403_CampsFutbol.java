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
public class Ex403_CampsFutbol {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int totalEntrades = sc.nextInt();

        
        for (int i = 0; i < totalEntrades;++i)
        {
            int metresQuadrats = sc.nextInt();
            int campsFutbol    = sc.nextInt();
            
            if (metresQuadrats >= campsFutbol*45*90 &&
                metresQuadrats <= campsFutbol*120*90)
                System.out.println("SI");
            else
                System.out.println("NO");
        }
    }
}
