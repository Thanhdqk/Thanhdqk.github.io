package view;

import java.util.Iterator;

public class progessbar {
public static void main(String[] args) {
	trangloaddingjframe pro = new trangloaddingjframe();
	loginform main = new loginform();
	pro.setVisible(true);
	
	for (int i = 50 ; i<=100;i++) {
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pro.progressBar.setValue(i);
		if(i%2==0)
		{
			pro.lblNewLabel_1.setText("Waiting..");
		}
		else
		{
			pro.lblNewLabel_1.setText("Waiting...");	
		}
		if(i==100)
		{
			main.setVisible(true);
			pro.dispose();
		}
		
	}
		
		
	}
}

