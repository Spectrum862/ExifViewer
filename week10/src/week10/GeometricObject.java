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
public abstract class GeometricObject {
    private String color;
    private boolean filled;

    /** Construct a default geometric object */
    public GeometricObject() {
        color = "white";
    }
    /** Construct a geometric object with the specified color
    * and filled value
     * @param color
     * @param filled */
    public GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    /** Return color
     * @return  */
    public String getColor() {
        return color;
    }

    /** Set a new color
     * @param color */
    public void setColor(String color) {
        this.color = color;
    }

    /** Return filled. Since filled is boolean,
    its get method is named isFilled
     * @return  */
    public boolean isFilled() {
        return filled;
    }

    /** Set a new filled
     * @param filled */
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    /** Return a string representation of this object
     * @return  */
    @Override
    public String toString() {
        return "color: " + color +" and filled: " + filled;
    }
    
    public abstract  double getArea();

    public abstract double getPerimeter() ;
}

    

