
public abstract class PaperObject {
	
	protected String str_name_of_article;
	protected String str_name_of_author ;
	
	public PaperObject(String str_name_of_article,String str_name_of_author ) {
		this.str_name_of_article = str_name_of_article;
		this.str_name_of_author = str_name_of_author;
	}
	
	
	public abstract String getDetails();
	public abstract Object[] getObjectDataTable();

}
