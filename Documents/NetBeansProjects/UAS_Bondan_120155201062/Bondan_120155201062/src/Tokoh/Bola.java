package Tokoh;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author HP
 */
public class Bola extends Ellipse2D.Float {
    AudioClip bunyi=Applet.newAudioClip(getClass().getResource("/soundFX/Windows Ding.wav"));
    private int xBola, yBola;
    private int ballCX, ballCY;
    private int ballPX, ballPY;
    private int maxX, maxY;
    Color color;

	public Bola(int xsize, int ysize, int cX, int cY, int pX, int pY, int windowSizeX, int windowSizeY, Color c){
		xBola = xsize;
		yBola = ysize;
		ballCX = cX; 
		ballCY = cY; 
		ballPX = pX; 
		ballPY = pY; 
		maxX = windowSizeX; 
		maxY = windowSizeY; 
		color = c; 
	}

        
	public int getBallSizeX(){
		return xBola;
	}
	
	public int getBallSizeY(){
		return yBola;
	}
	
	
	public int getCX(){
		return ballCX;
	}
	
	public int getCY(){
		return ballCY;
	}
	
	
	
	public int getPX(){
		return ballPX;
	}
	
	public int getPY(){
		return ballPY;
	}
	
	
	public Color getBallColor(){
		return color;
	}
	
	
	
	public void setCX(int i){
		ballCX = i;
	}
	
	public void setCY(int i){
		ballCY = i;
	}
	
	
	
	public void setPX(int i){
		ballPX = i;
	}
	
	public void setPY(int i){
		ballPY = i;
	}
	
	
	public void moveBall(int lowY, int upY){
		int cx = getCX();
		int cy = getCY();
		int px = getPX();
		int py = getPY();
		
		int x = 0;
		int y = 0;
		
		if( (cx>=325) && (cx<=330) && (cy<=5) && (cy<=upY || cy>=lowY) ){
			x = 5;
			y = 5;
			cx = 327;
			cy = 2;
                       bunyi.play();
		}else if( (cx>=325) && (cx<=330) && (cy>=475-yBola) && (cy<=upY || cy>=lowY) ){
			x = 5;
			y = -5;
			cx = 327;
			cy = maxY-yBola-2;
                       bunyi.play();
		}else if( (cx>=310-xBola) && (cx<=315-xBola) && (cy<=5) && (cy<=upY || cy>=lowY) ){
			x = -5;
			y = 5;
			cx = 310-xBola-2;
			cy = 2;
                      bunyi.play();
		}else if( (cx>=310-xBola) && (cx<=315-xBola) && (cy>=475-yBola) && (cy<=upY || cy>=lowY) ){
			x = -5;
			y = -5;
			cx = 315-xBola-2;
			cy = maxY-yBola-2;
                       bunyi.play();
		}else if( ( (cx>=315-xBola && cx<=325-xBola) && (cy<=upY || cy>=lowY )) && (cx-px>=5) && (cy-py>=5) ){
			x-=5;
			y+=5;
                       bunyi.play();
		}else if( ( (cx>=315-xBola && cx<=325-xBola) && (cy<=upY || cy>=lowY ) ) && (cx-px>=5) && (py-cy>=5) ){
			x-=5;
			y-=5;
                      bunyi.play();
		}else if( ( (cx>=315 && cx<=325) && (cy<=upY || cy>=lowY ) ) && (px-cx>=5) && (cy-py>=5) ){
			x+=5;
			y+=5;
                      bunyi.play();
		}else if( ( (cx>=315 && cx<=325) && (cy<=upY || cy>=lowY ) ) && (px-cx>=5) && (py-cy>=5) ){
			x+=5;
			y-=5;
                       bunyi.play();
		}else if( !(cy>=maxY-yBola) && !(cx>=maxX-xBola) && !(cy<=0) && !(cx<=0) && (cx>=5) && (cy>=5) && (cx-px>=5) && (cy-py>=5) ){
			x+=5;
			y+=5;
                        
		}else if( !(cy>=maxY-yBola) && !(cx>=maxX-xBola) && !(cy<=0) && !(cx<=0) && (cx>=5)&& (cy>=5) && (cx-px>=5) && (py-cy>=5) ){
			x+=5;
			y-=5;
		}else if( !(cy>=maxY-yBola) && !(cx>=maxX-xBola) && !(cy<=0) && !(cx<=0) && (cx>=5)&& (cy>=5) && (px-cx>=5) && (cy-py>=5) ){
			x-=5;
			y+=5;
		}else if( !(cy>=maxY-yBola) && !(cx>=maxX-xBola) && !(cy<=0) && !(cx<=0) && (cx>=5)&& (cy>=5) && (px-cx>=5) && (py-cy>=5) ){
			x-=5;
			y-=5;		
		}else if( (cx<=4) && (cy<=4) ){
			x = 5;
			y = 5;
			cx = 2;
			cy = 2;
                        
		}else if( (cx<=4) && (cy>=maxY-yBola-4) ){
			x = 5;
			y = -5;
			cx = 2;
			cy = maxY-yBola-2;
                        
		}else if( (cy<=4) && (cx>=maxX-xBola-4) ){
			x = -5;
			y = 5;
			cx = maxX-xBola-2;
			cy = 2;  
		}else if( (cy>=maxY-yBola-4) && (cx>=maxX-xBola-4) ){
			x = -5;
			y = -5;
			cx = maxX-xBola-2;
			cy = maxY-yBola-2;
                        
		}else if( (cy >= 480-yBola) && (cx-px>= 5) && (cy-py>=5) ){	
			x+=5;
			y-=5;
                        
		}else if( (cy>=480-yBola) && (px-cx>=5) && (cy-py>=5) ){
			x-=5;
			y-=5;
                        
		}else if( (cy <= 4) && (cx-px >=5) && (py-cy>=5) ){
			x+=5;
			y+=5;
                        
		}else if( (cy<=4) &&  (px-cx>=5) && (py-cy>=5) ){
			x-=5;
			y+=5;
                        
		}else if( (cx>=640-xBola) &&  (cx-px>=5) && (cy-py>=5) ){
			x-=5;
			y+=5;
                        
		}else if( (cx>=640-xBola) && (cx-px>=5) && (py-cy>=5) ){
			x-=5;
			y-=5;
                        
		}else if( (cx<=4)  && (px-cx>=5) && (cy-py>=5) ){	
			x+=5;
			y+=5;
                       
		}else if( (cx<=4) &&  (px-cx>=5) && (py-cy>=5) ){
			x+=5;
			y-=5;       
		}
		
		setPX(cx);
		setPY(cy);
		setCX(cx+x);
		setCY(cy+y);
	}
	
	public void sleep(int i){
		try{
			Thread.sleep (i); 
		}catch (Exception e) { 
                     System.out.println("Error pada thread"+e);
                }
               
	}
}
