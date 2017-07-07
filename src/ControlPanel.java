
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class ControlPanel extends JPanel{
	private ToggleButton btnRepeat;
	private ImageButton btnBack;
	private ToggleButton btnPlay;
	private ImageButton btnNext;
	private ToggleButton btnShuffle;
	
	private DoFunc PlayFunc;
	private DoFunc BackFunc;
	private DoFunc NextFunc;
	private DoFunc ShuffleFunc;
	private DoFunc RepeatFunc;
	
	
	public void Enable(){
		btnPlay.setEnabled(true);
		btnBack.setEnabled(true);
		btnNext.setEnabled(true);
	}
	
	
	public ControlPanel() {
		// TODO Auto-generated constructor stub
		btnRepeat = new ToggleButton("images/a.png", "images/b.png");
		btnBack = new ImageButton("images/back.png");
		btnPlay = new ToggleButton("images/play.png", "images/a.png");
		btnNext = new ImageButton("images/next.png");
		btnShuffle = new ToggleButton("images/a.png", "images/b.png");
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(BackFunc != null)
					BackFunc.DoIt();
			}
		});
		btnBack.setEnabled(false);
		
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(NextFunc != null)
					NextFunc.DoIt();
			}
		});
		btnNext.setEnabled(false);
		
		
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(PlayFunc != null)
					PlayFunc.DoIt();
			}
		});
		btnPlay.setEnabled(false);
		
		btnShuffle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ShuffleFunc != null)
					ShuffleFunc.DoIt();
			}
		});
		
		btnRepeat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(RepeatFunc != null)
					RepeatFunc.DoIt();
			}
		});
		
		
		this.add(btnRepeat);
		this.add(btnBack);
		this.add(btnPlay);
		this.add(btnNext);
		this.add(btnShuffle);
	}
	
	public Boolean isShuffle(){
		return btnShuffle.toggled;
	}
	
	public void togglePlay(){
		btnPlay.Toggle();
	}
	
	public Boolean isRepeat(){
		return btnRepeat.toggled;
	}
	
	public Boolean isPlay(){
		return btnPlay.toggled;
	}
	
	public void setPlayFunc(DoFunc func){
		this.PlayFunc = func;
	}
	
	public void setNextFunc(DoFunc func){
		this.NextFunc = func;
	}
	
	public void setBackFunc(DoFunc func){
		this.BackFunc = func;
	}
	
	public void setShuffleFunc(DoFunc func){
		this.ShuffleFunc = func;
	}
	
	public void setRepeatFunc(DoFunc func){
		this.RepeatFunc = func;
	}
}
