package Light;
import javax.swing.ImageIcon;
public abstract class Lightbulb {
    private static ImageIcon
        on = new ImageIcon("E:\\OneDrive\\Works\\JAVA PROJECT\\Week13\\lighton.jpg"),
        off = new ImageIcon("E:\\OneDrive\\Works\\JAVA PROJECT\\Week13\\lightoff.jpg");
    
    public static ImageIcon turnOn(){       
        return on;
    }
    
    public static ImageIcon turnOff(){
        return off;
    }
    
}
