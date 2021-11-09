package Utama;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Client extends Frame {
	
	public static final int GAME_WIDTH = 800;
	public static final int GAME_HEIGHT = 600;
	private Tank tank = new Tank(300, 300, true, Tank.Direction.STOP, this);
    Blood b = new Blood();
    Wall w1 = new Wall(100, 200, 20, 150, this), w2 = new Wall(300, 100, 300, 20, this);
	ArrayList<Missile> missiles = new ArrayList<Missile>();
	ArrayList<Tank> tanks = new ArrayList<Tank>();
	ArrayList<Explode> explodes = new ArrayList<>();
	private Tank.Direction dir = Tank.Direction.STOP;
	Image offScreenImage = null;
	
	public void paint(Graphics g) {
		g.drawString("tanks count: " + tanks.size(), 10, 90);
		g.drawString("tank life: " + tank.getLife(), 10, 110);
		g.drawString("missiles count: " + missiles.size(), 10, 50);
		g.drawString("explodes count: " + explodes.size(), 10, 70);
		
		for (int i = 0; i < tanks.size(); i++) {
            Tank t = tanks.get(i);
            t.collidesWithWall(w1);
            t.collidesWithWall(w2);
            t.collidesWithTanks(tanks);
            t.draw(g);
        }
		
		for(int i = 0; i < missiles.size(); i++) {
			Missile m = missiles.get(i);
            m.collidesWithTanks(tanks);
            m.collidesWithTank(tank);
            m.collidesWithWall(w1);
            m.collidesWithWall(w2);
            m.draw(g);
		}
		
		for(int i = 0; i < explodes.size(); i++) {
			Explode e = explodes.get(i);
			e.draw(g);
		}
		
		tank.draw(g);
		w1.draw(g);
		w2.draw(g);
		b.draw(g);
	}
	
	public void update(Graphics g) {
		if(offScreenImage == null) {
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
		}
		
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.GREEN);
		gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		gOffScreen.setColor(c);
		print(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}


	public void launchFrame() {
		this.setLocation(300, 50);
		this.setSize(GAME_WIDTH, GAME_HEIGHT);
		this.setTitle("Tank War");
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		for(int i = 0; i < 10; i++) {
			tanks.add(new Tank(50 + 40 * (i + 1), 50, false, this));
		}

		this.setResizable(false);
		this.setBackground(Color.GREEN);
		this.addKeyListener(new KeyMonitor()); 
		setVisible(true);
		
		new Thread(new PaintThread()).start();
	}
	
	public static void main(String[] args) {
		Client tc = new Client();
		tc.launchFrame();
	}
	
	private class PaintThread implements Runnable {

		public void run() {
			while(true) {
				repaint();
				try {
					Thread.sleep(50);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private class KeyMonitor extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			tank.KeyPressed(e);
		}
		
		public void keyReleased(KeyEvent e) {
			tank.keyReleased(e);
		}
	}
}

