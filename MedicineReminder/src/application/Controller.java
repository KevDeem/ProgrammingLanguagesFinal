package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.controlsfx.control.Notifications;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;


public class Controller implements Serializable{
	@FXML
	public TextField MedName;
	@FXML
	public TextField MedAmount;
	@FXML
	private CheckBox am0;
	@FXML
	private CheckBox am1;
	@FXML
	private CheckBox am2;
	@FXML
	private CheckBox am3;
	@FXML
	private CheckBox am4;
	@FXML
	private CheckBox am5;
	@FXML
	private CheckBox am6;
	@FXML
	private CheckBox am7;
	@FXML
	private CheckBox am8;
	@FXML
	private CheckBox am9;
	@FXML
	private CheckBox am10;
	@FXML
	private CheckBox am11;
	@FXML
	private CheckBox pm12;
	@FXML
	private CheckBox pm13;
	@FXML
	private CheckBox pm14;
	@FXML
	private CheckBox pm15;
	@FXML
	private CheckBox pm16;
	@FXML
	private CheckBox pm17;
	@FXML
	private CheckBox pm18;
	@FXML
	private CheckBox pm19;
	@FXML
	private CheckBox pm20;
	@FXML
	private CheckBox pm21;
	@FXML
	private CheckBox pm22;
	@FXML
	private CheckBox pm23;
	@FXML
	private ListView listview;
	@FXML
	private Label labelMed;
	@FXML
	private Label labelAmount;
	@FXML 
	private Button closeButton;
	
	
	private String time;
	private String medname;
	private String medamount;
	private String medremind;
	public int index;
	public ArrayList<medicine> MedReminder = new ArrayList<medicine>();
	

	public void AddButtonClicked() throws Exception {
		medname = MedName.getText();
		medamount = MedAmount.getText();
		System.out.println(medname);
		System.out.println(medamount);
		Checkboxes();
		writefile();
		listview();
		System.out.println(time);
		System.out.println("Add");
		clearfield();
	}	

	
	public void Checkboxes() {
		time = "";
      	
		if(am0.isSelected()) {
			MedReminder.add(new medicine(medname, medamount, 24));
		}	
		
		if(am1.isSelected()) {
			MedReminder.add(new medicine(medname, medamount, 01));
		}
		
		if(am2.isSelected()) {
			MedReminder.add(new medicine(medname, medamount, 02));
		}
		
		if(am3.isSelected()) {
			MedReminder.add(new medicine(medname, medamount, 03));
		}
		
		if(am4.isSelected()) {
			MedReminder.add(new medicine(medname, medamount, 04));
		}
		
		if(am5.isSelected()) {
			MedReminder.add(new medicine(medname, medamount, 05));
		}
		
		if(am6.isSelected()) {
			MedReminder.add(new medicine(medname, medamount, 06));
		}
		
		if(am7.isSelected()) {
			MedReminder.add(new medicine(medname, medamount, 07));
		}
		
		if(am8.isSelected()) {
			MedReminder.add(new medicine(medname, medamount, 8));
		}
		
		if(am9.isSelected()) {
			MedReminder.add(new medicine(medname, medamount, 9));
		}
		
		if(am10.isSelected()) {
			MedReminder.add(new medicine(medname, medamount, 10));
		}
		
		if(am11.isSelected()) {
			MedReminder.add(new medicine(medname, medamount, 11));
		}
		
		if(pm12.isSelected()) {
			MedReminder.add(new medicine(medname, medamount, 12));
		}
		
		if(pm13.isSelected()) {
			MedReminder.add(new medicine(medname, medamount, 13));
		}
		
		if(pm14.isSelected()) {
			MedReminder.add(new medicine(medname, medamount, 14));
		}
		
		if(pm15.isSelected()) {
			MedReminder.add(new medicine(medname, medamount, 15));
		}
		
		if(pm16.isSelected()) {
			MedReminder.add(new medicine(medname, medamount, 16));
		}
		
		if(pm17.isSelected()) {
			MedReminder.add(new medicine(medname, medamount, 17));
		}
		
		if(pm18.isSelected()) {
			MedReminder.add(new medicine(medname, medamount, 18));
		}
		
		if(pm19.isSelected()) {
			MedReminder.add(new medicine(medname, medamount, 19));
		}
		
		if(pm20.isSelected()) {
			MedReminder.add(new medicine(medname, medamount, 20));
		}
		
		if(pm21.isSelected()) {
			MedReminder.add(new medicine(medname, medamount, 21));
		}
		
		if(pm22.isSelected()) {
			MedReminder.add(new medicine(medname, medamount, 22));
		}
		
		if(pm23.isSelected()) {
			MedReminder.add(new medicine(medname, medamount, 23));
		}
	}
	

	public void writefile() {
		try {
			FileOutputStream fileOut = new FileOutputStream("medicine.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(MedReminder);
			out.close();
			fileOut.close();
			System.out.println("saved to file");
 
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

    public void initialize() throws IOException, ClassNotFoundException, Exception {
        File file = new File("medicine.txt");
        if (file.exists()) {
        	try {
    			FileInputStream fileIn = new FileInputStream("medicine.txt");
    			ObjectInputStream in = new ObjectInputStream(fileIn);
    			MedReminder = ((ArrayList)in.readObject());
    			in.close();
    			fileIn.close();
    			listview();
    			NotificationThread nt = new NotificationThread(this);
    			nt.start();
;    		} 
    		catch (FileNotFoundException e) {
    			e.printStackTrace();
    		} 
    		catch (IOException e) {
    			e.printStackTrace();
    		}
        }
    }
	
	public void listview() {
		listview.getItems().addAll(MedReminder);
	}
	
    public void RemoveButtonClicked() {
        System.out.println("Remove Medicine");
        index = MedReminder.indexOf(listview.getSelectionModel().getSelectedItem());
        MedReminder.remove(index);
        listview.getItems().remove(index);
        writefile();
    }
    

    public void notification() throws Exception{
    	int i = 0 ;
		while(true) {   
			Date currentdate = new Date();
	    	SimpleDateFormat time = new SimpleDateFormat("kk:mm:ss");
			Thread.sleep(1000);
    		System.out.println(time.format(currentdate));
	        	for(i = 0; i < MedReminder.size(); i++) {
	        		String waktu = String.format("%02d",(MedReminder.get(i).getTime()));
	        		System.out.println(waktu + ":00:00");
	        		if(time.format(currentdate).equals(waktu + ":00:00")) {
	        			System.out.println("amazing");
	        			String name = MedReminder.get(i).getMedname();
	        			String amount = MedReminder.get(i).getMedamount();
	        					Platform.runLater(() ->
	        			{
		        			 Notifications.create()
		                     .title("Take Your Medicine Now")
		                     .text(name + " " + amount)
		                     .position(Pos.TOP_RIGHT)
		                     .darkStyle()
		        			 .showInformation();
	        			});
	        		}
	        	}
    	}
    }
    
    public class NotificationThread extends Thread{
    	Controller c;
    	
    	public NotificationThread(Controller c){
    		this.c = c;
    	}
    	
    	public void run(){
    		while(true) {
        		try {
    				c.notification();
    			} 
        		catch (Exception e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    		}
    	}
    }
	

	public void clearfield() {
		MedName.clear();
		MedAmount.clear();
		am0.setSelected(false);
		am1.setSelected(false);
		am2.setSelected(false);
		am3.setSelected(false);
		am4.setSelected(false);
		am5.setSelected(false);
		am6.setSelected(false);
		am7.setSelected(false);
		am8.setSelected(false);
		am9.setSelected(false);
		am10.setSelected(false);
		am11.setSelected(false);
		pm12.setSelected(false);
		pm13.setSelected(false);
		pm14.setSelected(false);
		pm15.setSelected(false);
		pm16.setSelected(false);
		pm17.setSelected(false);
		pm18.setSelected(false);
		pm19.setSelected(false);
		pm20.setSelected(false);
		pm21.setSelected(false);
		pm22.setSelected(false);
		pm23.setSelected(false);
	}
};
