package Utama;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class Tank {
	public static final int XSPEED = 5;
	public static final int YSPEED = 5;
	public static final int WIDTH = 30; 
	public static final int HEIGHT = 30;
	private static Random r = new Random();
	private int x, y, step, oldX, oldY, life;
	private boolean live;
	private boolean good;
	Client tc = null;
	Direction[] dirs = Direction.values();
	int rn = r.nextInt(dirs.length);

	private boolean bL = false,
			bU = false,
			bR = false,
			bD = false;

	enum Direction {L, LU, U, RU, R, RD, D, LD, STOP};
	private Direction dir = Direction.STOP;
	private Direction ptDir = Direction.D;
	
	public Tank(int x, int y, boolean good, Client tc) {
		this.x = x;
		this.y = y;
		this.good = good;
	}
	
	public Tank(int x, int y, boolean good, Direction dir, Client tc) {
		this(x, y, good, tc);
		this.dir = dir;
	}
	
	public boolean isLive() {
        return live;
    }

    public void setLive(Boolean live) {
        this.live = live;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public boolean isGood() {
        return good;
    }
	
    public void setLife(int live) {
        this.life = live;
    }

    public int getLife() {
        return life;
    }
	
	public boolean collidesWithWall(Wall w) {
        if(this.getRect().intersects(w.getRect()) && this.live) {
            this.stay();
            return true;
        }
        return false;
    }
	
	public boolean collidesWithTanks(ArrayList<Tank> tanks) {
        for(int i = 0; i < tanks.size(); i++) {
        	Tank t = tanks.get(i);
            if(this != t) {
                if(this.live && t.isLive() && this.getRect().intersects(t.getRect())) {
                	t.stay();
                    this.stay();
                    return true;
                }
            }
        }
        return false;
    }
	
	public void stay() {
        x = oldX;
        y = oldY;
    }
	
	private void superFire() {
        Direction[] dirs = Direction.values();
        for(int i = 0; i < 8; i++) {
        	fire();
        }
    }
	
	public boolean eat(Blood b) {
        if(this.live && b.isLive() && this.getRect().intersects(b.getRect())) {
        	this.life = 100;
        	b.setLive(false);
            return true;
        }
        return false;
    }

    private class BloodBar {
        public void draw(Graphics g) {
        	Color c = g.getColor();
        	g.setColor(Color.RED);
            g.drawRect(x, y - 10, WIDTH, 10);
            int w = WIDTH * life / 100;
            g.fillRect(x, y - 10, w, 10);
            g.setColor(c);
        }
    }
	
	public void draw(Graphics g) {
		Color c = g.getColor();
		if(good) {
			g.setColor(Color.RED);
		}
		else {
			g.setColor(Color.BLUE);
		}
		g.fillOval(x, y, WIDTH, HEIGHT);
		g.setColor(c);
		
		switch(ptDir) {
			case L:
				g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT /2, x, y + Tank.HEIGHT / 2);	
				break;
			case LU:
				g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT /2, x, y);
				break;
			case U:
				g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT /2, x + Tank.WIDTH / 2, y);	
				break;
			case RU:
				g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT /2, x + Tank.WIDTH, y);	
				break;
			case R:
				g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT /2, x + Tank.WIDTH, y + Tank.HEIGHT / 2);	
				break;
			case RD:
				g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT /2, x + Tank.WIDTH, y + Tank.HEIGHT);	
				break;
			case D:
				g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT /2, x + Tank.WIDTH / 2, y + Tank.HEIGHT);	
				break;
			case LD:
				g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT /2, x, y + Tank.HEIGHT);	
				break;
			case STOP:
				break;
		}
		
		move();
	}
	
	void move() {
		switch(dir) {
			case L:
				x -= XSPEED;
				break;
			case LU:
				x -= XSPEED;
				y -= YSPEED;
				break;
			case U:
				y -= YSPEED;
				break;
			case RU:
				x += XSPEED;
				y -= YSPEED;
				break;
			case R:
				x += XSPEED;
				break;
			case RD:
				x += XSPEED;
				y += YSPEED;
				break;
			case D:
				y += YSPEED;
				break;
			case LD:
				x -= XSPEED;
				y += YSPEED;
				break;
			case STOP:
				break;
		}
		
		if(this.dir != Direction.STOP) {
			this.ptDir = this.dir;
		}
		
		if(!good) {
			step = r.nextInt(12) + 3;
			int rn = r.nextInt(dirs.length);
			dir = dirs[rn];
		}
		step--;
		if(r.nextInt(40) > 38) this.fire();
	}

	public void KeyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch(key) {
			case KeyEvent.VK_LEFT:
				bL = true;
				break;
			case KeyEvent.VK_UP:
				bU = true;
				break;
			case KeyEvent.VK_RIGHT:
				bR = true;
				break;
			case KeyEvent.VK_DOWN:
				bD = true;
				break;
		}
		locateDirection();
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		switch(key) {
			case KeyEvent.VK_CONTROL:
				fire();
				break;
			case KeyEvent.VK_LEFT:
				bL = false;
				break;
			case KeyEvent.VK_UP:
				bU = false;
				break;
			case KeyEvent.VK_RIGHT:
				bR = false;
				break;
			case KeyEvent.VK_DOWN:
				bD = false;
				break;
			case KeyEvent.VK_A:
                superFire();
                break;
		}
		locateDirection();
	}

	void locateDirection() {
		if(bL && !bU && !bR && !bD) dir = Direction.L;
		else if(bL && bU && !bR && !bD) dir = Direction.LU;
		else if(!bL && bU && !bR && !bD) dir = Direction.U;
		else if(!bL && bU && bR && !bD) dir = Direction.RU;
		else if(!bL && !bU && bR && !bD) dir = Direction.R;
		else if(!bL && !bU && bR && bD) dir = Direction.RD;
		else if(!bL && !bU && !bR && bD) dir = Direction.D;
		else if(bL && !bU && !bR && bD) dir = Direction.LD;
		else if(!bL && !bU && !bR && !bD) dir = Direction.STOP;
	}
	
	public Missile fire() {
		int x = this.x + Tank.WIDTH / 2 - Missile.WIDTH / 2;
		int y = this.y + Tank.HEIGHT /2 - Missile.WIDTH / 2;
		Missile m = new Missile(x, y, ptDir);
		tc.missiles.add(m);
		return m;
	}
	
	public Rectangle getRect() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }
}
