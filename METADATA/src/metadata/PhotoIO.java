package metadata;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author fluke
 */
public final class PhotoIO {
    
    public static void savePhoto(ImageIcon imoriginal,String name) throws IOException{
        File file = new File(name);
        Image img = (imoriginal.getImage());
        BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null),
        BufferedImage.TYPE_INT_RGB);
        Graphics bg = bi.getGraphics();
        bg.drawImage(img, 0, 0, null);
        bg.dispose();
        ImageIO.write(bi, "JPG", file);
    }
    
    
}
