//ICSD16157 YURIY PYRIH
//DISTRIBUTED SYSTEMS LAB_1

import java.io.Serializable;
import java.util.UUID;

public abstract class PaperObject implements Serializable{
	
	protected static final long serialVersionUID = 1L;
	
	protected String uniqueID;
	protected String str_name_of_article;
	protected String str_name_of_author ;
	
	public PaperObject(String str_name_of_article,String str_name_of_author ) {
		uniqueID = UUID.randomUUID().toString().substring(0, 7);
		this.str_name_of_article = str_name_of_article;
		this.str_name_of_author = str_name_of_author;
	}
	
	
	public abstract String getDetails();
	public abstract Object[] getObjectDataTable();

}
