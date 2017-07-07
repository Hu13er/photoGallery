import java.awt.BorderLayout;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainFrame extends JFrame{
	public static Gallery thisGallery;
	
	public static ControlPanel cp;
	public static SettingPanel sp;
	public static AlbumPanel ap;
	public static MenuPanel mp;
	
	private JLabel picture;
	
	private static MyTimer timer;
	
	
	public void addAlbum(Gallery glr){
		ap.addItem(glr);
	}
	
	public static void setGallery(Gallery glr){
		thisGallery = glr;
		thisGallery.setFinishFunc(new DoFunc() {
			public void DoIt() {
				if(!cp.isRepeat()){
					if(timer.ply){
						timer.Stop();
						cp.togglePlay();
					}
				}
				System.out.println(cp.isRepeat());
			}
		});
		cp.Enable();
	}
	
	public MainFrame() {
		// Menu Panel
		mp = new MenuPanel(this);
		this.setJMenuBar(mp);
		
		// Control Panel
		cp = new ControlPanel();
		
		timer = new MyTimer(new DoFunc() {
			public void DoIt() {
				picture.setIcon(new ImageIcon(thisGallery.nextPic()));
			}
		}, 1000);
		
		cp.setPlayFunc(new DoFunc() {
			@Override
			public void DoIt() {
				System.out.println(cp.isPlay());
				if(!cp.isPlay())
					timer.Start(new DoFunc() {
						public void DoIt() {
							picture.setIcon(new ImageIcon(thisGallery.nextPic()));
							System.out.println("Pulse");
						}
					});
				else
					timer.Stop();
			}
		});
		
		cp.setNextFunc(new DoFunc() {
			public void DoIt() {
				picture.setIcon(new ImageIcon(thisGallery.nextPic()));
			}
		});
		
		cp.setBackFunc(new DoFunc() {
			public void DoIt() {
				picture.setIcon(new ImageIcon(thisGallery.prevPic()));
			}
		});
		
		cp.setShuffleFunc(new DoFunc() {
			
			public void DoIt() {
				thisGallery.setShuffle(cp.isShuffle());
				System.out.println(cp.isShuffle());
			}
		});
		
		
		cp.setRepeatFunc(new DoFunc() {
			public void DoIt() {
				thisGallery.setRepeat(cp.isRepeat());
				
			}
		});
		
		this.add(cp, BorderLayout.SOUTH);
		
		
		// Setting Panel
		
		sp = new SettingPanel(1500, 1000, 600);
		sp.setOnChange(new DoFunc() {
			public void DoIt() {
				timer.setDly(sp.getDly());
				System.out.println(sp.getDly());
			}
		});
		
		this.add(sp, BorderLayout.EAST);
		
		
		
		// Album Panel
		ap = new AlbumPanel();
		
		this.add(ap, BorderLayout.WEST);
		
		picture = new JLabel();
		this.add(picture, BorderLayout.CENTER);
		
		
		
	}
}
