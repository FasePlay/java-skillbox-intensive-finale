import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Screenshots extends Thread {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    public static ByteArrayOutputStream baos;

    @Override
    public void run() {
        BufferedImage image;
        int tests = 0;
        while (true) {


            try {
                sleep(5000);
                image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
                baos = new ByteArrayOutputStream();
                ImageIO.write(image, "png", baos);
                tests++;
                System.out.println(ANSI_PURPLE + "Testings: make picture № " + tests + " with: x - " + (image.getHeight()) + ", y - " + (image.getWidth()) + ANSI_RESET);
            } catch (AWTException | IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
