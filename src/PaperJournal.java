
public class PaperJournal extends PaperObject{

	public PaperJournal(String str_name_of_article, String str_name_of_author, int int_number_of_pages) {
		super(str_name_of_article, str_name_of_author, int_number_of_pages);
		
	}
	
	public static boolean checkInput(String str_name_of_article, String str_name_of_author, int int_number_of_pages) {
		if(str_name_of_article == null || str_name_of_author == null) {
			return false;
		}
		else if(int_number_of_pages <= 0) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public String toString() {
		return (str_name_of_article + " " + str_name_of_author + " " + int_number_of_pages) ;
	}

}
