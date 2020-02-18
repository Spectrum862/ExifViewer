
package metadata;

import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.MetadataException;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;

public class PhotoJpeg implements Photo {
    private File file;
    private ImageIcon pic;
    private String path;
    private int width,height;
    private JpegExif exif;
    private static PhotoJpeg instance = null; //Singleton
        
    private  PhotoJpeg(String p) throws ImageProcessingException, IOException, MetadataException {
        this.setAttribute(p);               
    }
    
    private void setAttribute(String p) throws ImageProcessingException, IOException, MetadataException{
        file = new File(p);
        pic = new ImageIcon(p);
        path = p;
        width = pic.getIconWidth();
        height =  pic.getIconHeight();
        exif = JpegExif.getInstance(file);
    }         
            
    public String getPath(){
        return path;
    }
    
    public File getFile(){
        return file;
    }
    
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
    public ImageIcon getPic(){
        return pic;
    }
    
    public String getExif(String metatype){
    
        switch (metatype){
            case "shutterspeed" : return exif.getShutterspeed();
            case "iso"          : return exif.getIso();
            case "aperture"     : return exif.getF();
            case "lens"         : return exif.getLen();
            case "camera"       : return exif.getCamera();
            case "artist"       : return exif.getAuthor();
            case "filename"     : return exif.getName();
            case "filetype"     : return exif.getType();
            case "filesize"     : return exif.getSize();
            case "focalrange"   : return exif.getFocalrange();
            case "date"         : return exif.getDate();
            default: return "not support";
        }
    }
    
    //Singleton
    public static PhotoJpeg getInstance(String path) throws ImageProcessingException, IOException, MetadataException{
        if(instance==null){
            instance = new PhotoJpeg(path);
        }
        else{
            instance.setAttribute(path);
        }
        return instance;
    }
    
}
