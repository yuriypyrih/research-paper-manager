//ICSD16157 YURIY PYRIH
//DISTRIBUTED SYSTEMS LAB_1

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;




public class PaperManager{
	private static final long serialVersionUID = -1442798787354930462L;
	private static final String filepath=".\\data";
	private LinkedList<PaperObject> paperObjectList = new LinkedList<PaperObject>();
	
	public PaperManager() {
		initManager();
	}
	
	
	public void addObject(PaperObject object) {
		
		System.out.println(object + " object has been added");
	this.paperObjectList.add(object);
	WriteObjectToFile();
	
	}
	
	public void removeObject(PaperObject object) {
		
		System.out.println(object + " object has been removed");
	this.paperObjectList.remove(object);
	
	}
	
	
	
	public LinkedList<PaperObject> getPaperObjectList(SEARCH Type){
		//The SEARCH.Type is not implemented yet	
		return paperObjectList;
	}
	
	public void listAllObject() {
		for(PaperObject object : paperObjectList) {
			System.out.println(object.getDetails());
		}
	}
	
	public void WriteObjectToFile() {
		
        try {
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(paperObjectList);
            objectOut.close();
            fileOut.close();
            System.out.println("The Object  was succesfully written to a file");
            
        } 
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
	
	public void initManager() {
		try {
			FileInputStream fileIn = new FileInputStream(new File(filepath));
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			
			paperObjectList = (LinkedList<PaperObject>) objectIn.readObject(); 
			
			objectIn.close();
			fileIn.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
	
	

