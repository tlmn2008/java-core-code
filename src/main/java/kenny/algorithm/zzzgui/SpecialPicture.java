package kenny.algorithm.zzzgui;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;


public class SpecialPicture extends BufferedImage{
	private int width;
	private int height;
	public SpecialPicture(int width, int height, int imageType){
		super(width, height, imageType);
		this.width = width;
		this.height = height;
	}
	
	public void DrawPicture(){
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				int color = byteArrayToInt(getRGBValue(x,y), 0);
				this.setRGB(x, y, color);	
			}
		}
	}
	
	private int byteArrayToInt(byte[] byteArray, int offset){
	    int value;    
	    value = (int) ((byteArray[offset]&0xFF)   
	            | ((byteArray[offset+1]<<8) & 0xFF00)  
	            | ((byteArray[offset+2]<<16)& 0xFF0000));  
	    return value + 0xFF000000;  
	}
	
	private byte[] getRGBValue(int x, int y){
		byte[] rgb = new byte[3];
		rgb[0] = (byte)(square(Math.cos(Math.atan2(y-height/2, x-width/2)/2))*255);
		rgb[1] = (byte)(square(Math.cos(Math.atan2(y-height/2, x-width/2)/2-2*Math.acos(-1)/3))*255);
		rgb[2] = (byte)(square(Math.cos(Math.atan2(y-height/2, x-width/2)/2+2*Math.acos(-1)/3))*255);
		return rgb;
	}
	
	private double square(double x){
		return x*x;
	}
	
	public void SavePicture(){ 
		try{
			 ImageIO.write(this, "PNG", new File("C:/SpecialPicture.png"));
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//test code
		SpecialPicture specialPicture = new SpecialPicture(1024, 512, BufferedImage.TYPE_INT_ARGB);
		
		specialPicture.DrawPicture();
		specialPicture.SavePicture();
		System.out.println("SpecialPicture has been saved!");
	}
	
}
