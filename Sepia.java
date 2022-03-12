package Processing;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Sepia {
    public static void main(String args[])throws IOException
    {
        BufferedImage image =ImageIO.read(new File("sidika.jpg"));
        File file = null;
        int width = image.getWidth();
        int height = image.getHeight();
        for (int y = 0; y < height; y++)
        {
            for (int x = 0; x < width; x++)
            {
                int p = image.getRGB(x,y);
                int a = (p>>24) & 0xff;
                int r = (p>>16) & 0xff;
                int g = (p>>8) & 0xff;
                int b = p & 0xff;
                r = 255 - r;
                g = 255 - g;
                b = 255 - b;
                p = (a<<24) | (r<<16) | (g<<8) | b;
                image.setRGB(x, y, p);
            }
        }
        try
        {
            file = new File("C:\\Users\\ADMIN\\Desktop\\IMAGES\\sidika.jpg");
            ImageIO.write(image, "jpg", file);
            System.out.println("Successfully converted a colored image into a negative image");
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
}
