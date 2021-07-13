import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class DigitalClock extends JFrame implements Runnable{
	Calendar now;
	Font font = new Font("굴림",Font.BOLD,100);
	JLabel lbl = new JLabel("00:00:00", JLabel.CENTER);
	int x,y;
	public DigitalClock()  {
		super("시계");
		add(lbl);
		lbl.setFont(font);
		
		setSize(500,200);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public DigitalClock(int x, int y) {
		this();
		this.x = x;
		this.y = y;
		setLocation(x, y);
		setVisible(true);
		
		Thread t = new Thread(this);
		t.start();
	}
	
	public void run() {
		do {
			//시간변경
			lbl.setText(getTimer());
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}while(true);
	}
	
	public String getTimer() {
		now = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		return dateFormat.format(now.getTime());
	}
	
	public static void main(String[] args) {
		new DigitalClock(0,0);
		new DigitalClock(500,0);
		new DigitalClock(1000,0);
	}

}
