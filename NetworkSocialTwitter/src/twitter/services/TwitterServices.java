package twitter.services;

import java.util.ArrayList;
import java.util.Date;

import twitter4j.PagableResponseList;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.conf.ConfigurationBuilder;

/**
 * 
 * @author yassine
 * Des lignes de codes liées à la base de données seront intégrées dans ces fonctions
 */
public class TwitterServices {

	private ArrayList<String> 			 _amis;
	private ArrayList<ArrayList<String>> _amisDamis;
	private Twitter						 _twitter;
	
	public TwitterServices () {
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
		return identite;
	} // getIdentite ()
	
	public String getLangue (String account) throws TwitterException{
		ResponseList<User> liste = _twitter.searchUsers(account, -1);
		String langue = null;
		for (User user : liste){
			langue = user.getLang();
		}
		return langue;
	} // getLangue ()
	
	public String getLocalisation (String account) throws TwitterException{
		ResponseList<User> liste = _twitter.searchUsers(account, -1);
		String localisation = null;
		for (User user : liste){
			localisation = user.getLang();
		}
		return localisation;
	} // getLocalisation ()
	
	public Date getDateCreation (String account) throws TwitterException{
		ResponseList<User> liste = _twitter.searchUsers(account, -1);
		Date date = null;
		for (User user : liste){
			date = user.getCreatedAt();
		}
		return date;
	} // getLocalisation ()
	
	public int getNbFollowers (String account) throws TwitterException{
		ResponseList<User> liste = _twitter.searchUsers(account, -1);
		int follow = 0;
		for (User user : liste){
			follow = user.getFollowersCount();
		}
		return follow;
	} // getNbFollowers ()
	
	public int getNbAmis (String account) throws TwitterException{
		ResponseList<User> liste = _twitter.searchUsers(account, -1);
		int amis = 0;
		for (User user : liste){
			amis = user.getFriendsCount();
		}
		return amis;
	} // getNbAmis ()
	
	public int getNbFavoris (String account) throws TwitterException{
		ResponseList<User> liste = _twitter.searchUsers(account, -1);
		int fav = 0;
		for (User user : liste){
			fav = user.getFavouritesCount(); 
		}
		return fav;
	} // getNbFavoris ()
	
	public ArrayList<String> get20LastTweets (String account) throws TwitterException {
		ResponseList<Status> tweets = _twitter.getUserTimeline(account);
		ArrayList<String> res = new ArrayList<String>();
		for (Status s : tweets){
			res.add(s.getText());
		}
		return res;
	} // get20LastTweets ()
	
	public ArrayList<String> getAmis (String account) throws TwitterException {
		long cursor = -1; PagableResponseList<User> l = null;
		do
		{
			l = _twitter.getFriendsList(account, -1);
			for (User u : l){
				_amis.add(u.getScreenName()); // avec leurs comptes à notre disposition, on peut tout savoir sur eux
			} // Si vous voulez réellement avoir toutes les informations d'un bloc, consulter la classe JSON
		}
		while((cursor = l.getNextCursor()) != 0);
		return _amis;
	} // getAmis ()
	
/*	public ArrayList<ArrayList<String>> getAmisDamis (String account) throws TwitterException {
		PagableResponseList<User> l = _twitter.getFriendsList(account, -1);
		for (User u : l){
			_twitter.getFriendsIDs(u.getScreenName(), -1);
		}
		
	} // getAmisDamis ()
	
	public ArrayList<ArrayList<String>> getNbAmisDamis (String account) throws TwitterException {
		PagableResponseList<User> l = _twitter.getFriendsList(account, -1);
		for (User u : l){
			u.getFriendsCount();
		}
		
	} // getNbAmisDamis ()
	
	public ArrayList<ArrayList<String>> getNbFollowersDamis (String account) throws TwitterException {
		PagableResponseList<User> l = _twitter.getFriendsList(account, -1);
		for (User u : l){
			u.getFollowersCount();
		}
		
	} // getNbFollowersDamis () 
	
	public ArrayList<ArrayList<String>> getNbFavorisDamis (String account) throws TwitterException {
		PagableResponseList<User> l = _twitter.getFriendsList(account, -1);
		for (User u : l){
			u.getFavouritesCount();
		}
		
	} // getNbFavorisDamis ()
	*/
	
}
