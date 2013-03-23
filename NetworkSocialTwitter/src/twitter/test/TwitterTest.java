package twitter.test;

import twitter.db.TwitterDB;
import twitter4j.TwitterException;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TwitterDB d = new TwitterDB();
		try {
			
			d.getDateCreation("yamip6");
			//System.out.println("Sarko a " + d.getNbAmis("NicolasSarkozy") + " amis");
		} catch (TwitterException e) {
			e.printStackTrace();
		}

	}

}
