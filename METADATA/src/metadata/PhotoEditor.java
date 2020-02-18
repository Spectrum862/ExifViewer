/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metadata;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author fluke
 */
public class PhotoEditor {
    
    public static ImageIcon reSize(ImageIcon pic,int percent){
    Image image = pic.getImage();
    ImageIcon buffim;
    int neww,newh;
    neww = (int) (pic.getIconWidth()*(percent/100.0));
    newh = (int) (pic.getIconHeight()*(percent/100.0));                
    Image newimg = image.getScaledInstance(neww, newh,  java.awt.Image.SCALE_SMOOTH);
    return buffim = new ImageIcon(newimg);      
    }
    
    public  static ImageIcon brightness(ImageIcon pic,int value){
        int bufred,bufgreen,bufblue;
        int h = pic.getIconHeight();
        int w = pic.getIconWidth();
        int[][] red = new int[w][h];
        int[][] green = new int[w][h];
        int[][] blue = new int[w][h];
        int[][] pixels =  new int[w][h]; 
        int col;
        Image img = (pic.getImage());
        BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null),
        BufferedImage.TYPE_INT_RGB);
        Graphics bg = bi.getGraphics();
        bg.drawImage(img, 0, 0, null);
        bg.dispose();
        Raster raster = bi.getData();
        for(int i = 0;i<w;i++)
            for(int j = 0;j<h;j++)
                pixels[i][j] = bi.getRGB(i, j);
        for(int i = 0;i<w;i++){
            for(int j = 0;j<h;j++){
                red[i][j] = (pixels[i][j]>>16) & 0xff;
            }
        }
        for(int i = 0;i<w;i++){
            for(int j = 0;j<h;j++){
                green[i][j] = (pixels[i][j]>>8) & 0xff;
            }
        }
        for(int i = 0;i<w;i++){
            for(int j = 0;j<h;j++){
                blue[i][j] = pixels[i][j] & 0xff;
            }
        }
            for(int x = 0; x < w; x++){
                for(int y = 0; y < h; y++){
                    bufred   = Truncate(red[x][y]   + value);
                    bufgreen = Truncate(green[x][y] + value);
                    bufblue  = Truncate(blue[x][y]  + value);
                    col = (bufred << 16) | (bufgreen<< 8) | bufblue;
                    bi.setRGB(x, y, col);
                }
            }
        return pic = new ImageIcon(bi);
        
                
    }
    
    public static ImageIcon contrast(ImageIcon pic,int value){
        int col,bufred,bufgreen,bufblue;
        int h = pic.getIconHeight();
        int w = pic.getIconWidth();
        double factor;
        int[][] red = new int[w][h];
        int[][] green = new int[w][h];
        int[][] blue = new int[w][h];
        int[][] pixels =  new int[w][h];   
        Image img = (pic.getImage());
        BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null),
        BufferedImage.TYPE_INT_RGB);
        Graphics bg = bi.getGraphics();
        bg.drawImage(img, 0, 0, null);
        bg.dispose();
        Raster raster = bi.getData();
        for(int i = 0;i<w;i++)
            for(int j = 0;j<h;j++)
                pixels[i][j] = bi.getRGB(i, j);
        for(int i = 0;i<w;i++){
            for(int j = 0;j<h;j++){
                red[i][j] = (pixels[i][j]>>16) & 0xff;
            }
        }
        for(int i = 0;i<w;i++){
            for(int j = 0;j<h;j++){
                green[i][j] = (pixels[i][j]>>8) & 0xff;
            }
        }
        for(int i = 0;i<w;i++){
            for(int j = 0;j<h;j++){
                blue[i][j] = pixels[i][j] & 0xff;
            }
        }
         
  
        for(int x = 0; x < w; x++){
            for(int y = 0; y < h; y++){
                factor = (259.0 * (value + 255)) / (255.0 * (259 - value));
                bufred   = Truncate(factor * (red[x][y]   - 128) + 128);
                bufgreen = Truncate(factor * (green[x][y] - 128) + 128);
                bufblue  = Truncate(factor * (blue[x][y]  - 128) + 128);                   
                col = (bufred << 16) | (bufgreen<< 8) | bufblue;
                bi.setRGB(x, y, col);
            }
        }  
        return pic = new ImageIcon(bi);        
    }
    
    private static int Truncate(double value){
        if (value < 0)  value = 0;
        if (value > 255) value = 255;
        return (int) value;
    }
    
    
    
    
}
