

public class PaperConference extends PaperObject{
	
	private String str_name_of_conferece;
	private String date_of_conference;
	private String str_city;

	public PaperConference(String str_name_of_article, String str_name_of_author, String str_name_of_conferece, String date_of_conference, String str_city) {
		super(str_name_of_article, str_name_of_author);
		
		this.str_name_of_conferece = str_name_of_conferece;
		this.date_of_conference = date_of_conference;
		this.str_city = str_city;
		
		
	}
	

	@Override
	public String getDetails() {
		return ("Name of article: " + str_name_of_article 
				+ "\nName of author: " + str_name_of_author
				+ "\nName of Conference: " + str_name_of_conferece
				+ "\nDate of Conference: " + date_of_conference  
				+ "\nCity: " + str_city) ;
	}


	@Override
	public Object[] getObjectDataTable() {
		return new Object[] {
				"RandomID", str_name_of_conferece, "Conference", "Show Details"
		};
	}

	
	

}
