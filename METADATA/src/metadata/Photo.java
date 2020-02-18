package metadata;

import javax.swing.ImageIcon;

/**
 *
 * @author fluke
 */
public abstract class Photo {
    abstract public String getExif(String metatype);
    abstract public int getWidth();
    abstract public int getHeight();
    abstract public ImageIcon getPic();
}
