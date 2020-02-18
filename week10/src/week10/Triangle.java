/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week10;

/**
 *
 * @author Spectrum
 */
public class Triangle extends GeometricObject {
    double side1,side2,side3;

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }
        
        Triangle(){
            side1 = side2 = side3 = 1.0;
        }
        
        Triangle(double a,double b,double c){
            side1 = a;
            side2 = b;
            side3 = c;            
        }
        
        public double getSide1(){
            return side1;
        }
        
        public double getSide2(){
            return side2;
        }
         
        public double getSide3(){
            return side3;
        }
        
        public double getArea(){
            double p = (side1+side2+side3)/2;
            return Math.sqrt(p*(p-side1)*(p-side2)*(p-side3));
            
        }
        
        public double getPerimeter(){
            return side1+side2+side3;
        }
        
        public String toString(){
            if(isFilled()==true)
                return "The triangle's "+getColor()+" and filled and have area = "+getArea()+" perimeter = "+getPerimeter();
            else
                return "The triangle's "+getColor()+" and not filled and have area = "+getArea()+" perimeter = "+getPerimeter();
        
        }

    
}
