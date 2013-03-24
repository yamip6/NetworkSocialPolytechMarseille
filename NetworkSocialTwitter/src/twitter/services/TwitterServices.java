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
 * Certaines fonctions nécessitent la modification de la JVM pour permettre à une collection
 * de prendre plus de 2 Mo de données, important pour les comptes Twitter ayant une tonne 
 * d'informations.
 */
public class TwitterServices {

	private ArrayList<String> 			 _amis;
	private ArrayList<ArrayList<String>> _amisDamis;
	private Twitter						 _twitter;
	
	/**
	 * 
	 */
	public TwitterServices () {
		_amis 		= new ArrayList<String>();
		_twitter   	= TwitterFactory.getSingleton();
		_amisDamis 	= new ArrayList<ArrayList<String>>();
	} // TwitterDB
	
	/**
	 * 
	 * @param account est le compte twitter dont on veut savoir le nom et prénom
	 * @return le nom et prénom du propriétaire du compte twitter
	 * @throws TwitterException
	 */
	public String getIdentite (String account) throws TwitterException{
		ResponseList<User> liste = _twitter.searchUsers(account, -1);
		String identite = null;
		for (User user : liste){
			identite = user.getName();
		}
		return identite;
	} // getIdentite ()
	
	/**
	 * 
	 * @param account est le compte twitter dont on veut savoir la langue
	 * @return la langue du propriétaire du compte twitter
	 * @throws TwitterException
	 */
	public String getLangue (String account) throws TwitterException{
		ResponseList<User> liste = _twitter.searchUsers(account, -1);
		String langue = null;
		for (User user : liste){
			langue = user.getLang();
		}
		return langue;
	} // getLangue ()
	
	/**
	 * 
	 * @param account est le compte twitter dont on veut savoir sa localisation
	 * @return la localisation du propriétaire du compte twitter
	 * @throws TwitterException
	 */
	public String getLocalisation (String account) throws TwitterException{
		ResponseList<User> liste = _twitter.searchUsers(account, -1);
		String localisation = null;
		for (User user : liste){
			localisation = user.getLang();
		}
		return localisation;
	} // getLocalisation ()
	
	/**
	 * 
	 * @param account est le compte twitter dont on veut connaître sa date de création
	 * @return la date de création du compte twitter
	 * @throws TwitterException
	 */
	public Date getDateCreation (String account) throws TwitterException{
		ResponseList<User> liste = _twitter.searchUsers(account, -1);
		Date date = null;
		for (User user : liste){
			date = user.getCreatedAt();
		}
		return date;
	} // getLocalisation ()
	
	/**
	 * 
	 * @param account est le compte twitter dont on veut savoir son nombre de followers
	 * @return le nombre de followers du propriétaire du compte twitter
	 * @throws TwitterException
	 */
	public int getNbFollowers (String account) throws TwitterException{
		ResponseList<User> liste = _twitter.searchUsers(account, -1);
		int follow = 0;
		for (User user : liste){
			follow = user.getFollowersCount();
		}
		return follow;
	} // getNbFollowers ()
	
	/**
	 * 
	 * @param account est le compte twitter dont on veut savoir son nombre d'amis
	 * @return le nombre d'amis du propriétaire du compte twitter
	 * @throws TwitterException
	 */
	public int getNbAmis (String account) throws TwitterException{
		ResponseList<User> liste = _twitter.searchUsers(account, -1);
		int amis = 0;
		for (User user : liste){
			amis = user.getFriendsCount();
		}
		return amis;
	} // getNbAmis ()
	
	/**
	 * 
	 * @param account est le compte twitter dont on veut savoir son nombre de favoris (tweets en l'occurence)
	 * @return le nombre de favoris du propriétaire du compte twitter
	 * @throws TwitterException
	 */
	public int getNbFavoris (String account) throws TwitterException{
		ResponseList<User> liste = _twitter.searchUsers(account, -1);
		int fav = 0;
		for (User user : liste){
			fav = user.getFavouritesCount(); 
		}
		return fav;
	} // getNbFavoris ()
	
	/**
	 * 
	 * @param account est le compte twitter dont on veut connaître ses 20 derniers tweets
	 * @return les 20 derniers tweets du propriétaire du compte twitter
	 * @throws TwitterException
	 */
	public ArrayList<String> get20LastTweets (String account) throws TwitterException {
		ResponseList<Status> tweets = _twitter.getUserTimeline(account);
		ArrayList<String> res = new ArrayList<String>();
		for (Status s : tweets){
			res.add(s.getText());
		}
		return res;
	} // get20LastTweets ()
	
	/**
	 * 
	 * @param account est le compte twitter dont on veut savoir sa liste d'amis
	 * @return la liste d'amis du propriétaire du compte twitter
	 * @throws TwitterException
	 */
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
	
	/**
	 * Le premier élément de la matrice désigne l'ami de account. Les éléments qui suivent
	 * sont les amis de l'ami de account. Exemple : les amis de x sont z,y. Les amis de z sont x,b
	 * et les amis de y sont x,n. On aura donc [[z,x,b][y,x,n]]
	 * @param account désigne le compte twitter de qui on veut obtenir sa liste d'amis d'amis
	 * @return une matrice
	 * @throws TwitterException
	 */
	public ArrayList<ArrayList<String>> getAmisDamis (String account) throws TwitterException {
		PagableResponseList<User> l; ArrayList<String> tmp;
		long cursor = -1; long cursor2;
		do
		{
			l = _twitter.getFriendsList(account, cursor);
			for (User u : l){
				cursor2 = -1;
				do
				{
					PagableResponseList<User> ll = _twitter.getFriendsList(u.getScreenName(), cursor2);
					tmp = new ArrayList<String>();
					tmp.add(u.getScreenName());
					for (User uu : ll)
						tmp.add(uu.getScreenName());	
				}
				while((cursor2 = l.getNextCursor()) != 0);
				_amisDamis.add(tmp);
			} // Si vous voulez réellement avoir toutes les informations d'un bloc, consulter la classe JSON
		}
		while((cursor  = l.getNextCursor()) != 0);
		return _amisDamis;
		
	} // getAmisDamis ()
	
/*	public ArrayList<ArrayList<String>> getNbAmisDamis (String account) throws TwitterException {
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
		
	} // getNbFavorisDamis ()*/
	
	
}
