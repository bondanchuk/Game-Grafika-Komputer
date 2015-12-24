package Bondan_120155201062;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author HP
 */
public class gamePanel extends JPanel { 
    Tokoh.Bola bola;
    private Image background;
    private ArrayList<Tokoh.Bola> mb;
    Thread th;
    private ArrayList<Tokoh.Bola> BolaArray;
    static int gapLY, gapTY;
    private int level;
    
    public gamePanel(){
            
        }
	public gamePanel(int yBawah, int yAtas){
		
		mb = new ArrayList<Tokoh.Bola>();
		BolaArray = new ArrayList<Tokoh.Bola>();
		gapLY = yBawah;
		gapTY = yAtas;
		level = 1;
		
		setPreferredSize(new Dimension(640, 480));
		setBackground(Color.black);
		mb.add(new Tokoh.Bola(20, 20, 136, 39,  131, 34,  640, 480, Color.black));
		mb.add(new Tokoh.Bola(20, 20, 200, 200, 205, 195, 640, 480, Color.black));
		mb.add(new Tokoh.Bola(20, 20, 453, 282, 448, 277, 640, 480, Color.white));
		mb.add(new Tokoh.Bola(20, 20, 97,  365, 92,  360, 640, 480, Color.white));
		
		BolaArray.add(new Tokoh.Bola(20, 20, 136, 39, 131,  34,  640, 480, Color.black));
		BolaArray.add(new Tokoh.Bola(20, 20, 200, 200, 205, 195, 640, 480, Color.black));
		BolaArray.add(new Tokoh.Bola(20, 20, 453, 282, 448, 277, 640, 480, Color.white));
		BolaArray.add(new Tokoh.Bola(20, 20, 97,  365, 92,  360, 640, 480, Color.white));
                background = new ImageIcon(this.getClass().getResource("/img/background.jpg")).getImage();
	}

	public void paintComponent(Graphics g){
            Graphics2D g2d=(Graphics2D)g;
            RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHints(rh);
		
            g2d.drawImage(background, 0, 0, null);
            g2d.setColor(Color.white);
            g2d.fillRect(315,0,10,gapTY);
            g2d.fillRect(315,gapLY,10,(480-gapLY));
            g2d.setColor(Color.black);
            g2d.drawString("Hitam", 145,20);
            g2d.setColor(Color.white);
            g2d.drawString("Putih", 475,20); 
            g2d.setColor(Color.black);
            g2d.drawString(("Level: " + level), 8, 472);

		for(int x = 0; x < mb.size(); x++){
			Tokoh.Bola t = mb.get(x);
			g2d.setColor(t.getBallColor());
			g2d.fillOval(t.getCX(), t.getCY(), t.getBallSizeX(),t.getBallSizeY());
		}	    
	}
	
	
	public void mulaiGame(){
		Graphics g = getGraphics();
                Graphics2D g2d=(Graphics2D)g;
		g2d.setColor(Color.black);
		g2d.fillRect(186,157,14,5);
		g2d.fillRect(520,157,14,5);
		g2d.setColor(Color.cyan);
		g2d.drawString("Ready", 145,160);
		g2d.setColor(Color.yellow);
		g2d.drawString("Ready", 475,160);
	}
	
	public int getYbawah(){
		return gapLY;
	}
	
	
	public int getYatas(){
		return gapTY;
	}
        
        
	
	public void MoveBall2(int l, int u){
		for(int x = 0; x < mb.size(); x++){
			
			Tokoh.Bola t = mb.get(x);
			t.moveBall(l,u);
			repaint();
		}		
		sleep(20);
	}
	
	public boolean cekBola(){
		for(int x = 0; x < mb.size(); x++){
			
			Tokoh.Bola temp = mb.get(x);
			Color c = temp.getBallColor();
			int currentXPosition = temp.getCX();
			if(c == Color.black){
				if( !(currentXPosition<315) ){
					return false;
				}
			}else{
				if(!(currentXPosition>325)){
					return false;
				}
			}
		}
		return true;
	}
	
	
	public void tambahBola(){
		
		Random rm = new Random();
		int cxValue = rm.nextInt(550) + 25;
		int cyValue = rm.nextInt(435) + 25;
		int xValue = -1;
		int yValue = -1;
		int n = rm.nextInt(4) + 1;
		if(n == 1){
			xValue = 5;
			yValue = 5;
		}else if(n == 2){
			xValue = 5;
			yValue = -5;
		}else if(n == 3){
			xValue = -5;
			yValue = 5;
		}else if(n == 4){
			xValue = -5;
			yValue = -5;
		}
		
		int k = rm.nextInt(2) + 1;
		Color g = Color.black;
		if(k == 2){
			g = Color.white;
		}
		
		BolaArray.add(new Tokoh.Bola(20, 20, cxValue, cyValue, (cxValue+xValue), (cyValue+yValue), 640, 480, g));
		mb.clear();
                for(int y = 0; y < BolaArray.size(); y++){
			mb.add(BolaArray.get(y));
		}
                level++;
		if(cekBola()){
			level--;
			BolaArray.remove(BolaArray.size()-1);
			tambahBola();
		}
                
                
                if(level==5){
                    JOptionPane.showMessageDialog(new JFrame(), "Selamat Kamu Berhasil !!!\n"+"level : "+level, "Congratulation", 1);
                    System.exit(0);
                    gamePanel gp=new gamePanel();
                    gp.setVisible(false);
                    try {
                        Thread.sleep(1000);
                        Thread.currentThread().suspend();
                    } catch (InterruptedException ex) { 
                        System.out.println("Error menghentikan game "+ex);
                    }  
                }	
	}
	
	public void moveGapLocationUp(){
		gapLY-=10;
		gapTY-=10;		
	}
	
	
	public void moveGapLocationDown(){
		gapLY+=10;
		gapTY+=10;
	}
        
	public void sleep(int i){
		try{
                    Thread.sleep(i);
		}catch (Exception e){
                    System.out.println("Error pada thread"+e);
                }
	} 
}
