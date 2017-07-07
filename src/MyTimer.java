import java.util.Timer;
import java.util.TimerTask;


public class MyTimer {
	private int dly;
	
	public Boolean ply = false;
	
	private Timer timer = new Timer();
	private TimerTask timertask;
	private DoFunc dofunc;
	
	
	public MyTimer(DoFunc func, int d){
		this.dly = d;
		timertask = new TimerTask() {
			public void run() {
				func.DoIt();
			}
		};
	}
	
	public void setDly(int d){
		dly = d;
		if(ply)
			this.Restart();
		
	}
	
	public void setFunc(DoFunc func){
		dofunc = func;
		timertask = new TimerTask() {
			public void run() {
				func.DoIt();
			}
		};
	}
	
	public void Start(DoFunc func){
		ply = true;
		
		dofunc = func;
		this.setFunc(func);
		timertask = new TimerTask() {
			public void run() {
				dofunc.DoIt();
			}
		};
		timer = new Timer();
		timer.scheduleAtFixedRate(timertask, 0, dly);
	}
	
	public void Start(){
		ply = true;
		
		timertask = new TimerTask() {
			public void run() {
				dofunc.DoIt();
			}
		};
		timer = new Timer();
		timer.scheduleAtFixedRate(timertask, 0, dly);
	}
	
	public void Stop(){
		ply = false;
		
		System.out.println("Stop");
		timertask.cancel();
		timer.cancel();
		timer.purge();
	}
	
	public void Restart(){
		this.Stop();
		this.Start();
	}
	
}
