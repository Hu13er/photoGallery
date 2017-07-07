import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ToggleButton extends JButton{
	public Boolean toggled = false;
	
	private BufferedImage pic1;
	private BufferedImage pic2;
	
	private void UpdatePhoto(){
		if(toggled == true)
			this.setIcon(new ImageIcon(pic2));
		else
			this.setIcon(new ImageIcon(pic1));
		
	}
	
	public void Toggle(){
		toggled = !toggled;
		UpdatePhoto();
	}
	
	public ToggleButton(String Path1, String Path2) {
		
		try {
			File file = new File(Path1);
			this.pic1 = ImageIO.read(file);
			file = new File(Path2);
			this.pic2 = ImageIO.read(file);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		UpdatePhoto();
		
		this.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toggled = !toggled;
				UpdatePhoto();
			}
		});
	}
}
