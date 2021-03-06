package twitter.json;

import java.util.ArrayList;
import java.util.Date;

import javax.xml.datatype.DatatypeFactory;

import twitter4j.PagableResponseList;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.json.DataObjectFactory;

/**
 * 
 * @author yassine
 *
 */
public class TwitterJSON {

	private ArrayList<String> 			 _amis;
	private ArrayList<ArrayList<String>> _amisDamis;
	private Twitter						 _twitter;
	
	public TwitterJSON () {
		_amis 		= new ArrayList<String>();
		_twitter   	= TwitterFactory.getSingleton();
		_amisDamis 	= new ArrayList<ArrayList<String>>();
	} // TwitterDB
	
	public String getIdentite (String account) throws TwitterException{
		ResponseList<User> liste = _twitter.searchUsers(account, -1);
		String identite = null;
		for (User user : liste){
			identite = user.getName();
		}
		return DataObjectFactory.getRawJSON(identite);
	} // getIdentite ()
	
	public String getLangue (String account) throws TwitterException{
		ResponseList<User> liste = _twitter.searchUsers(account, -1);
		String langue = null;
		for (User user : liste){
			langue = user.getLang();
		}
		return DataObjectFactory.getRawJSON(langue);
	} // getLangue ()
	
	public String getLocalisation (String account) throws TwitterException{
		ResponseList<User> liste = _twitter.searchUsers(account, -1);
		String localisation = null;
		for (User user : liste){
			localisation = user.getLang();
		}
		return DataObjectFactory.getRawJSON(localisation);
	} // getLocalisation ()
	
	public String getDateCreation (String account) throws TwitterException{
		ResponseList<User> liste = _twitter.searchUsers(account, -1);
		Date date = null;
		for (User user : liste){
			date = user.getCreatedAt();
		}
		return DataObjectFactory.getRawJSON(date);
	} // getLocalisation ()
	
	public String getNbFollowers (String account) throws TwitterException{
		ResponseList<User> liste = _twitter.searchUsers(account, -1);
		int follow = 0;
		for (User user : liste){
			follow = user.getFollowersCount();
		}
		return DataObjectFactory.getRawJSON(follow);
	} // getNbFollowers ()
	
	public String getNbAmis (String account) throws TwitterException{
		ResponseList<User> liste = _twitter.searchUsers(account, -1);
		int amis = 0;
		for (User user : liste){
			amis = user.getFriendsCount();
		}
		return DataObjectFactory.getRawJSON(amis);
	} // getNbAmis ()
	
	public String getNbFavoris (String account) throws TwitterException{
		ResponseList<User> liste = _twitter.searchUsers(account, -1);
		int fav = 0;
		for (User user : liste){
			fav = user.getFavouritesCount(); 
		}
		return DataObjectFactory.getRawJSON(fav);
	} // getNbFavoris ()
	
	public String get20LastTweets (String account) throws TwitterException {
		ResponseList<Status> tweets = _twitter.getUserTimeline(account);
		ArrayList<String> res = new ArrayList<String>();
		for (Status s : tweets){
			res.add(s.getText());
		}
		return DataObjectFactory.getRawJSON(res);
	} // get20LastTweets ()
	
	public String getAmis (String account) throws TwitterException {
		long cursor = -1; PagableResponseList<User> l = null;
		do
		{
			l = _twitter.getFriendsList(account, -1);
			for (User u : l){
				_amis.add(u.getScreenName()); // avec leurs comptes � notre disposition, on peut tout savoir sur eux
			} // Si vous voulez r�ellement avoir toutes les informations d'un bloc, consulter la classe JSON
		}
		while((cursor = l.getNextCursor()) != 0);
		return DataObjectFactory.getRawJSON(_amis);
	} // getAmis ()
}
