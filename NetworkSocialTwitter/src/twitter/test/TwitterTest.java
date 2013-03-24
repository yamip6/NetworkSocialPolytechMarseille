package twitter.test;

import twitter.db.TwitterDB;
import twitter.services.TwitterServices;
import twitter4j.TwitterException;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TwitterServices d = new TwitterServices();
		try {
			System.out.println("ya a " + d.getAmisDamis("yamip6"));
		} catch (TwitterException e) {
			e.printStackTrace();
		}

	}

}
