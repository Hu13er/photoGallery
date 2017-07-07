import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AlbumPanel extends JPanel{
	
	public AlbumPanel() {
		this.setLayout(new GridLayout(11, 1));
		this.setBackground(Color.WHITE);
		this.add(new JLabel("Albums: "));
	}
	
	public void addItem(Gallery glr){
		String nm = glr.path;
		nm = nm.substring(0, nm.length() - 1);
		nm = nm.substring(nm.lastIndexOf("/") + 1);
		
		JButton btn = new JButton(nm);
		this.add(btn);
		this.revalidate();
		this.repaint();
		
		btn.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.setGallery(glr);
			}
		});
		
	}
}
