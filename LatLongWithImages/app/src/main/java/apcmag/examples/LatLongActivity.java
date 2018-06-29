package apcmag.examples;

import java.util.HashMap;

import swin.examples.R;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * This block of example code shows how to create and use a custom layout for lists.
 * 
 * @author Rajesh Vasa, 2011
 */
public class LatLongActivity extends ListActivity
{
	private HashMap<String, Book> books;
	private String[] bookIm;

	/** Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		books = loadBookData();
		bookIm = getBookName();
		initializeUI();

	}
	
	private void initializeUI()
	{
		// use custom row adapter
		setListAdapter(new RowIconAdapter()); 
		// force to display information about Melbourne
		displaySelectedBookInfo("Pokemon", 0);
	}

	private String[] getBookName()
	{
		String[] booksN = new String[books.size()];
		booksN = books.keySet().toArray(booksN);
		return booksN;
	}

	public void onListItemClick(ListView l, View v, int position, long id)
	{
		String selectedItem = (String) getListView().getItemAtPosition(position);
		displaySelectedBookInfo(selectedItem, position);
	}

	private void displaySelectedBookInfo(String bookName, int pos)
	{
		Book loc = books.get(bookName);
		TextView cityTextView = (TextView) findViewById(R.id.cityNameTextView);
		TextView locTextView = (TextView) findViewById(R.id.latLongTextView);
		cityTextView.setText(loc.getData());
		if (loc != null) locTextView.setText(bookName);
		ImageView icon = (ImageView) findViewById(R.id.imageView2);


		String book = bookIm[pos];
		if (book.startsWith("Lord of the Rings")) {
			icon.setImageResource(R.drawable.lotr);
		}
		else if (book.startsWith("Twilight")) {
			icon.setImageResource(R.drawable.tl);
		}
		else if (book.startsWith("The BFG")) {
			icon.setImageResource(R.drawable.bfg);
		}
		else if (book.startsWith("Deltora Quest")) {
			icon.setImageResource(R.drawable.del);
		}
		else if (book.startsWith("Harry Potter")) {
			icon.setImageResource(R.drawable.hp);
		}
		else if (book.startsWith("Girl on the Train")) {
			icon.setImageResource(R.drawable.got);
		}
		else if (book.startsWith("Game of Thrones")) {
			icon.setImageResource(R.drawable.rgot);
		}
		else if (book.startsWith("Pokemon")) {
			icon.setImageResource(R.drawable.pok);
		}
		else if (book.startsWith("Born to Run")) {
			icon.setImageResource(R.drawable.btr);
		}
		else if (book.startsWith("Inferno")) {
			icon.setImageResource(R.drawable.in);
		}
		else {
			icon.setImageResource(R.drawable.lotr);
		}
	}
	
	private HashMap<String, Book> loadBookData()
	{
		HashMap<String, Book> books = new HashMap<String, Book>();
		books.put("Lord of the Rings", new Book("lotr", "9/10"));
		books.put("Twilight", new Book("tw", "-10/10"));
		books.put("The BFG", new Book("bfg", "6/10"));
		books.put("Deltora Quest", new Book("dq", "7/10"));
		books.put("Harry Potter", new Book("hp", "6/10"));
		books.put("Girl on the Train", new Book("goot", "7/10"));
		books.put("Game of Thrones", new Book("gt", "4/10"));
		books.put("Pokemon", new Book("p", "7/10"));
		books.put("Born to Run", new Book("br", "5/10"));
		books.put("Inferno", new Book("i", "7/10"));
		return books;
	}
	
	/** Custom row adapter -- that gives the books their own icons */
	class RowIconAdapter extends ArrayAdapter<String> 
	{
		public RowIconAdapter()
		{
			super(LatLongActivity.this, R.layout.listrow, R.id.row_label, bookIm);
		}
		
		public View getView(int pos, View cView, ViewGroup parent)
		{
			View row = super.getView(pos, cView, parent);
			// get current image
			ImageView icon = (ImageView) row.findViewById(R.id.row_icon);
			String book = bookIm[pos];
			Log.i("CRAZY-MESSAGE", "Book Position"+pos+" "+book);
			if (book.startsWith("Lord of the Rings")) {
				icon.setImageResource(R.drawable.lotr);
			}
			else if (book.startsWith("Twilight")) {
				icon.setImageResource(R.drawable.tl);
			}
			else if (book.startsWith("The BFG")) {
				icon.setImageResource(R.drawable.bfg);
			}
			else if (book.startsWith("Deltora Quest")) {
				icon.setImageResource(R.drawable.del);
			}
			else if (book.startsWith("Harry Potter")) {
				icon.setImageResource(R.drawable.hp);
			}
			else if (book.startsWith("Girl on the Train")) {
				icon.setImageResource(R.drawable.got);
			}
			else if (book.startsWith("Game of Thrones")) {
				icon.setImageResource(R.drawable.rgot);
			}
			else if (book.startsWith("Pokemon")) {
				icon.setImageResource(R.drawable.pok);
			}
			else if (book.startsWith("Born to Run")) {
				icon.setImageResource(R.drawable.btr);
			}
			else if (book.startsWith("Inferno")) {
				icon.setImageResource(R.drawable.in);
			}
			else {
				icon.setImageResource(R.drawable.lotr);
			}
			
			return row;			
		}
	}

}