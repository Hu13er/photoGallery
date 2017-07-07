import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuPanel extends JMenuBar{
	private JMenu mnuFile = new JMenu("File");
	private JMenu mnuHelp = new JMenu("Help");
	
	private JMenuItem mnuOpen = new JMenuItem("Open");
	private JMenuItem mnuExit = new JMenuItem("Exit");
	
	private JMenuItem mnuAbout = new JMenuItem("About");
	
	public MenuPanel(MainFrame thisFrame) {
		// TODO Auto-generated constructor stub
		
		mnuOpen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FileDialog dialog;

				dialog = new FileDialog(thisFrame);
				dialog.setVisible(true);
				thisFrame.addAlbum(new Gallery(dialog.getDirectory()));
				System.out.println(dialog.getDirectory());
				
			}
		});
		
		mnuExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		mnuFile.add(mnuOpen);
		mnuFile.add(mnuExit);
		
		mnuHelp.add(mnuAbout);
		
		this.add(mnuFile);
		this.add(mnuHelp);
		
		
	}
}
