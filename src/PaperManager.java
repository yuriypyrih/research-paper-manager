import java.util.LinkedList;




public class PaperManager {
	
	LinkedList<PaperObject> paperObjectList = new LinkedList<PaperObject>();
	
	
	public void addObject(PaperObject object) {
		
		System.out.println(object + " object has been added");
	this.paperObjectList.add(object);
	}
	
	public void removeObject(PaperObject object) {
		
		System.out.println(object + " object has been removed");
	this.paperObjectList.remove(object);
	
	}
	
	public void listAllObject() {
		for(PaperObject object : paperObjectList) {
			System.out.println(object.getDetails());
		}
	}
	
	
}
