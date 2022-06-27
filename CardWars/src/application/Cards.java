package application;
import java.io.*;
import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Cards {
	
	
	public String path;
	public int attackdamage;
	public int defence;
	
	public Cards(String path,int attackdamage,int defence) {
		this.path=path;
		this.attackdamage=attackdamage;
		this.defence=defence;	
	}
	public Cards() {
		this.path = null;
		this.attackdamage = 0;
		this.defence = 0;
	}
	
	
	BufferedReader reader;
	
	public ArrayList<String> giveCard(String path) throws IOException{
		
		ArrayList<String> cardList = new ArrayList<String>();
		
		reader = new BufferedReader(new FileReader(path));
		String line;
		
		
		while((line = reader.readLine()) != null) {
			cardList.add(line);
		}
		
		return cardList;
		
	}
	public boolean isEmpty(ImageView view) {

		if(view.getImage() == null) {
			return true;
		}else {
			return false;
		}
		
		
	}
	
	public boolean isImageEqual(Image firstImage, Image secondImage){
	   
	    if(firstImage != null && secondImage == null) return false;
	    if(firstImage == null) return secondImage == null;

	    // Compare images size
	    if(firstImage.getWidth() != secondImage.getWidth()) return false;
	    if(firstImage.getHeight() != secondImage.getHeight()) return false;

	    // Compare images color
	    for(int x = 0; x < firstImage.getWidth(); x++){
	        for(int y = 0; y < firstImage.getHeight(); y++){
	            int firstArgb = firstImage.getPixelReader().getArgb(x, y);
	            int secondArgb = secondImage.getPixelReader().getArgb(x, y);

	            if(firstArgb != secondArgb) return false;
	        }
	    }

	    return true;
	}
	
	
	
	
	
	
	
}
