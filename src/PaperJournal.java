

public class PaperJournal extends PaperObject{
	
	private String str_name_of_journal;
	private Integer int_number_of_pages;
	private String date_publish;
	private Integer int_volume;
	private Integer int_specific_page;

	public PaperJournal(String str_name_of_article, String str_name_of_author,String str_name_of_journal, Integer int_number_of_pages, String date_publish, Integer int_volume, Integer int_specific_page) {
		super(str_name_of_article, str_name_of_author);
		
		this.str_name_of_journal = str_name_of_journal;
		this.date_publish = date_publish;
		
		if (int_number_of_pages <= 0 || int_number_of_pages == null) 
			this.int_number_of_pages = -1;
		else 
			this.int_number_of_pages = int_number_of_pages;
		
		
		if (int_volume <= 0 || int_volume == null) 
			this.int_volume = -1;
		else 
			this.int_volume = int_volume;
		
		
		if (int_specific_page <= 0 || int_specific_page == null) 
			this.int_specific_page = -1;
		else 
			this.int_specific_page = int_specific_page;
		
		
		
	}
	

	
	@Override
	public String getDetails() {
		return ("Name of article: " + str_name_of_article 
				+ "\nName of author: " + str_name_of_author
				+ "\nName of Journal: " + str_name_of_journal
				+ "\nNumber of pages: " + int_number_of_pages
				+ "\nPublish date: " + date_publish 
				+ "\nVolume: " + int_volume 
				+ "\nPage: " + int_specific_page) ;
	}



	@Override
	public Object[] getObjectDataTable() {
		return new Object[] {
				"RandomID", str_name_of_journal, "Journal", "Show Details"
		};
	}

	
	

}
