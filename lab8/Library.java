class LibraryMember{
	private String name;
	private Book [] mybooks;
	private int membershipID;

	public String getName(){
		return name;
	}

	LibraryMember(String name, int id){
		this.name = name;
	}
}

class Book{
	private String title;
	private String authorName;
	private double price;

	public String getTitle(){
		return title;
	}

	public String getAuthor(){
		return authorName;
	}

	public String toString(){
		String out = "";
		out.concat("Title: "+ title + "\nAuthorName: "+ authorName);
		return out;
	}

	Book(){
		title="";
		authorName = "";
		price = 0;
	}
	Book (String title, String authorName, double price){
		this.title=title;
		this.authorName = authorName;
		this.price=price;
	}
}