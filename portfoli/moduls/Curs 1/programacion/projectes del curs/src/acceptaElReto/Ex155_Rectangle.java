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
public class Ex155_Rectangle {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
      
        while (true)
        {
            int x = sc.nextInt();
            int y = sc.nextInt(); 
            
            if (x >= 0 && y >= 0)
                System.out.println(2*(x + y));
            else
                break;
        }
        
        
    }
}
