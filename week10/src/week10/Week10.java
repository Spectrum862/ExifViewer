/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week10;

import java.util.Random;
import java.util.Scanner;

public class Week10 {

    public static void main(String[] args) {
        GeometricObject o = null;
        Random rand = new Random();
        Scanner s = new Scanner(System.in);


        testT((Triangle)o);
        if(((Triangle)o) instanceof Triangle) System.out.print("true");
        else System.out.print("false");
    }
 
 public static void testT(Triangle e){
     System.out.print(e.getPerimeter());
 }
}