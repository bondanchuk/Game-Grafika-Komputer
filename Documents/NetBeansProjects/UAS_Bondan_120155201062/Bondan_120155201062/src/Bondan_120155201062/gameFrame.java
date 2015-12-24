package Bondan_120155201062;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author HP
 */
public class gameFrame extends JFrame{
    private final int papanBawah, papanAtas;
    private gamePanel mbp;
    static Timer timer;
    gamePanel panel;
	
	
	public gameFrame(){
		papanBawah = 270;
		papanAtas = 210;
		mbp = new gamePanel(papanBawah, papanAtas);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setTitle("UAS Grafika Komputer");
		addKeyListener(new KeypadListener());
		setResizable(false);
		getContentPane().add(mbp);
		tampilFrame();
                runGame();
                
                timer=new Timer(10,new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            } 
        });        
	}
	
	
	public void tampilFrame(){
		pack();
		show();
	}
	
	
	public void runGame(){
		sleep(570);
		mbp.mulaiGame();
		sleep(700);
		
		

		while(true){
			int papanYbawah = mbp.getYbawah();
			int papanYatas = mbp.getYatas();
			mbp.MoveBall2(papanYbawah,papanYatas);
			if(mbp.cekBola()){
                            mbp.tambahBola();
			}
		}
	}
	
        
	public void sleep(int i){
		try{
			Thread.sleep(i); 
		}catch (Exception e){
                }
	}
	private class KeypadListener implements KeyListener{
		public void keyPressed(KeyEvent e){
			int source = e.getKeyCode();
			if(source == KeyEvent.VK_UP){
                            mbp.moveGapLocationUp();
			}else if(source == KeyEvent.VK_DOWN){
                            mbp.moveGapLocationDown();
			}
		}
		
                @Override
		public void keyReleased(KeyEvent e){
                }
                @Override
		public void keyTyped(KeyEvent e){
                }
	}		
}

