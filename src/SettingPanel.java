import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class SettingPanel extends JPanel{
	private JRadioButton btnSlow;
	private JRadioButton btnNormal;
	private JRadioButton btnFast;
	private ButtonGroup bg;
	
	private int slowDly;
	private int NormalDly;
	private int FastDly;
	
	
	private DoFunc onChangeFunc;
	
	
	public SettingPanel(int slow, int normal, int fast) {
		slowDly = slow;
		NormalDly = normal;
		FastDly = fast;
		
		btnSlow = new JRadioButton("Slow");
		btnNormal = new JRadioButton("Normal");
		btnFast = new JRadioButton("Fast");
		
		bg = new ButtonGroup();
		bg.add(btnFast);
		bg.add(btnNormal);
		bg.add(btnSlow);
		
		this.add(btnSlow);
		this.add(btnNormal);
		this.add(btnFast);
		
		btnNormal.setSelected(true);
		
		
		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onChangeFunc.DoIt();
			}
		};
		
		btnSlow.addActionListener(al);
		btnNormal.addActionListener(al);
		btnFast.addActionListener(al);
		
		
		this.setLayout(new GridLayout(10, 1));
	}
	
	public void setOnChange(DoFunc func){
		this.onChangeFunc = func;
	}
	
	public int getDly(){
		if(btnSlow.isSelected())
			return slowDly;
		else if(btnNormal.isSelected())
			return NormalDly;
		else if(btnFast.isSelected())
			return FastDly;
		return NormalDly;
	}
}
