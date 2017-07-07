import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FileDialog;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.util.*;

public class Gallery {
	private String picPaths[];
	private String shuffledPaths[];
	
	public String path;
	private int count;
	private int now = 0;
	
	private Boolean shuffle = false;
	private Boolean repeat = false;
	
	private DoFunc finishFunc;
	
	private void makeSuffile(){
		shuffledPaths = new String[picPaths.length];
		Boolean []used = new Boolean[picPaths.length];
		
		for(int i = 0 ; i < picPaths.length ; i++)
			used[i] = false;
		
		for(int i = 0 ; i < picPaths.length ; i++){
			int r;
			do{
				r = (int) (Math.random() * picPaths.length);
			}while(used[r] == true);
			used[r] = true;
			
			shuffledPaths[i] = picPaths[r];
		}
		
		for(int i = 0 ; i < shuffledPaths.length ; i++)
			System.out.println(shuffledPaths[i]);
	}
	
	public void setFinishFunc(DoFunc func){
		this.finishFunc = func;
	}
	
	
	public void setShuffle(Boolean val){
		this.shuffle = val;
		makeSuffile();
	}
	
	public void setRepeat(Boolean val){
		this.repeat = val;
	}
	
	public Gallery(String path) {
		this.path = path;
		
		File file = new File(path);
		picPaths = file.list();
		
		makeSuffile();
		
		count = picPaths.length;
		now = 0;
		
		System.out.println(count);
		
	}
	
	private BufferedImage getPic(int num){
		File file;
		if(!shuffle)
			file = new File(path + '/' + picPaths[num - 1]);
		else
			file = new File(path + '/' + shuffledPaths[num - 1]);
		
		BufferedImage image;
		try
		{
			System.out.println(file.getPath());
			image = ImageIO.read(file);
			return image;
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public BufferedImage nextPic(){
		System.out.println(path + ":" + ">>");
		now++;
		if(now >= count){
			if(finishFunc != null)
				finishFunc.DoIt();
			now = 1;
		}
		System.out.println(now);
		return getPic(now);
	}
	
	public BufferedImage prevPic(){
		System.out.println(path + ":" + "<<");
		now--;
		if(now <= 0)
			now = count;
		System.out.println(now);
		return getPic(now);
	}
}
