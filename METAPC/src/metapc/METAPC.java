
package metapc;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class METAPC {
    public static void main(String[] args) throws IOException, ImageProcessingException {
        File file = new File("E:\\OneDrive\\Works\\JAVA PROJECT\\PIC\\IMG_7054.jpg");
        Metadata metadata = ImageMetadataReader.readMetadata(file);
        System.out.println(metadata.getDirectories());
        // obtain the Exif directory
        ExifSubIFDDirectory directory
        = metadata.getFirstDirectoryOfType(ExifSubIFDDirectory.class);

        // query the tag's value
        Date date
        = directory.getDate(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL);
        String shutter 
        = directory.getDescription(ExifSubIFDDirectory.TAG_SHUTTER_SPEED);
        
        
        System.out.println(shutter);
        
    
    
    }
    
}
