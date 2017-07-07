import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ImageButton extends JButton{
	BufferedImage pic;
	
	public ImageButton(String Path) {
		// TODO Auto-generated constructor stub
		try {
			File file = new File(Path);
			this.pic = ImageIO.read(file);
			this.setIcon(new ImageIcon(this.pic));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
}
