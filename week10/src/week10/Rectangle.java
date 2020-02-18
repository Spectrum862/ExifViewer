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
public class Rectangle extends GeometricObject {


    private double h,w;

    public Rectangle() {
        this.h = 1.0;
        this.w = 1.0;
    }

    public Rectangle(double h, double w) {
        this.h = h;
        this.w = w;
    }

    public Rectangle(double h, double w, String color, boolean filled) {
        super(color, filled);
        this.h = h;
        this.w = w;
    }
    
    public double getH(){
        return h;
    }
    
    public double getW(){
        return w;
    }
    
    @Override
    public double getArea() {
        return h*w;
    }

    @Override
    public double getPerimeter() {
        return 2*(h+w);
    }
    
    public boolean equals(Rectangle a){
        if((this.h == a.getH() && ( this.w == a.getW() && this.getColor() == a.getColor())) && (this.isFilled() == a.isFilled()))
            return true;
        else
            return false;
    }
    
    public String toString(){
        if(isFilled()==true)
            return "The rectangle's "+getColor()+" and filled and have area = "+getArea()+" perimeter = "+getPerimeter();
        else
            return "The rectangle's "+getColor()+" and not filled and have area = "+getArea()+" perimeter = "+getPerimeter();
        
        }

    public void setH(double h) {
        this.h = h;
    }

    public void setW(double w) {
        this.w = w;
    }
    }
    

