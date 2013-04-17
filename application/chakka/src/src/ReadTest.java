package src;

import java.awt.BorderLayout;
import java.io.*;

import javax.swing.JFrame;


public class ReadTest {
	public void NewsFeed(String name) throws IOException {
		char Enter = '\n';
		char Dot = '.';
		char Space = ' ';
		String url = "";
		File fileName = new File(name);
		FileWriter fw = new FileWriter(fileName);
		if(name.equals("ദി ഹിന്ദു"))
			url = "http://beta.thehindu.com/news/?service=rss";
		else if(name.equals("മാത്രുഭൂമി"))
			url = "http://feeds.feedburner.com/mathrubhumi";
		else if(name.equals("ഇന്ത്യാവിഷന്‍"))
			url = "http://www.indiavisiontv.com/feed";
		else
			return;
		RSSFeedParser parser = new RSSFeedParser(url);
	    Feed feed = parser.readFeed();
	    System.out.println(feed);
	    for (FeedMessage message : feed.getMessages()) {
			 fw.write(Dot);
			 fw.write(Space);
		     fw.write(message.title);
			 fw.write(Enter);		 
		    }
	    System.out.println("file created ! ");
		fw.close();	
	}
	
				
}
