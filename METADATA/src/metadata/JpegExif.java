package metadata;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Metadata;
import com.drew.metadata.MetadataException;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import com.drew.metadata.jpeg.JpegDirectory;
import java.io.IOException;
import com.drew.metadata.file.FileSystemDirectory;
import com.drew.metadata.file.FileTypeDirectory;
import com.drew.metadata.exif.ExifIFD0Directory;
import java.io.File;

/**
 *
 * @author fluke
 */
public class JpegExif {
    private String shutterspeed,f,iso,len,camera,author,name,type,size,focalrange,date;
    private static JpegExif instance = null; //Singleton
    
    private JpegExif(File file) throws ImageProcessingException, IOException, MetadataException{
        this.setAttribute(file);              
    }

    private void setAttribute(File file) throws ImageProcessingException, IOException, MetadataException{
        Metadata metadata = ImageMetadataReader.readMetadata(file);
        ExifSubIFDDirectory dir
        = metadata.getFirstDirectoryOfType(ExifSubIFDDirectory.class);
        JpegDirectory dir2 
        = metadata.getFirstDirectoryOfType(JpegDirectory.class);
        FileSystemDirectory dir3 
        = metadata.getFirstDirectoryOfType(FileSystemDirectory.class);
        FileTypeDirectory dir4
        = metadata.getFirstDirectoryOfType(FileTypeDirectory.class);
        ExifIFD0Directory dir5
        = metadata.getFirstDirectoryOfType(ExifIFD0Directory.class);
        
        date = dir.getDescription(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL);
        shutterspeed = dir.getDescription(ExifSubIFDDirectory.TAG_EXPOSURE_TIME);
        f = dir.getDescription(ExifSubIFDDirectory.TAG_FNUMBER);
        len = dir.getDescription(ExifSubIFDDirectory.TAG_LENS_MODEL);
        iso = dir.getDescription(ExifSubIFDDirectory.TAG_ISO_EQUIVALENT);
        author = dir5.getDescription(ExifIFD0Directory.TAG_ARTIST);
        camera = dir5.getDescription(ExifIFD0Directory.TAG_MODEL);
        name = dir3.getDescription(FileSystemDirectory.TAG_FILE_NAME);
        size = dir3.getDescription(FileSystemDirectory.TAG_FILE_SIZE);
        type = dir4.getDescription(FileTypeDirectory.TAG_DETECTED_FILE_TYPE_NAME);
        focalrange = dir.getDescription(ExifSubIFDDirectory.TAG_FOCAL_LENGTH);
        
        
    }
    
    public String getFocalrange() {
        return focalrange;
    }

    public String getShutterspeed() {
        return shutterspeed;
    }

    public String getF() {
        return f;
    }

    public String getIso() {
        return iso;
    }

    public String getLen() {
        return len;
    }

    public String getCamera() {
        return camera;
    }

    public String getAuthor() {
        return author;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getSize() {
        return size;
    }
    
    //Singleton
    public static JpegExif getInstance(File file) throws ImageProcessingException, IOException, MetadataException {
        if(instance==null){
            instance = new JpegExif(file);
        }
        else{
            instance.setAttribute(file);
        }
        return instance;
    }
 
}
