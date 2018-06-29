package apcmag.examples;

public class Book
{
	private String name, rate;

	public Book(String name, String rate)
	{
		this.name = name;
		this.rate = rate;
	}

	public String getData(){
		return rate;
	}

}
