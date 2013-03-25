package webServices.facebook.JSON;

import java.util.*;

import com.restfb.*;
import com.restfb.types.NamedFacebookType;
import com.restfb.types.User;
import com.restfb.types.User.Education;
import com.restfb.types.User.Sport;
import com.restfb.types.User.Work;

/**
 * 
 * @author BOUGRINE, Seif Eddine
 * 
 */

public class FacebookC {
	private static FacebookClient facebookClient;
	private static User user;

	public FacebookC() {
		facebookClient = new DefaultFacebookClient(
				"AAACEdEose0cBABYHyklz2D8ZBZAEpZBtVUngd7WfzBLlNNiBZCBPoHk8FNPZAZBXQnWe2W92OorATZApaweGZCTMI7ljjzZBqXp4ZB38srSMTBbU12mB1oAigA");

		user = null;
	}

	/* Texte de présentation qui apparaît sous leur photo de profil. */

	public String about() {
		return user.getAbout();
	}

	/* Extrait biographique de l'utilisateur. */

	public String biographical(String who) {

		return user.getBio();
	}

	/* Anniversaire de l'utilisateur */
	public String birthay() {
		return user.getBirthday();
	}

	/* Liste de l'histoire de l'éducation à partir du profil de l'utilisateur */

	public List<String> education() {
		List<String> l = new ArrayList<>();
		for (Education e : user.getEducation()) {
			l.add(e.toString());
		}
		return l;
	}

	/* L'adresse proxy ou de contacts électroniques accordée par l'utilisateur */

	public String email() {
		return user.getEmail();
	}

	/* Prénom de l'utilisateur. */

	public String firstName() {
		return user.getFirstName();
	}

	/* Nom de l'utilisateur. */

	public String userName() {
		return user.getUsername();
	}

	/* Sexe de l'utilisateur. */

	public String gender() {
		return user.getGender();
	}

	/* La ville natale de l'utilisateur. */

	public String homeTown() {
		NamedFacebookType n = user.getHometown();
		return n.toString();
	}

	/* Le nom de la ville natale de l'utilisateur. */

	public String homeTownName() {
		return user.getHometownName();
	}

	/* The genders the user is interested in. */

	public List<String> interesedIn() {
		return user.getInterestedIn();
	}

	/* Liste des langues du profil de l'utilisateur */

	public List<String> languages() {
		List<String> l = new ArrayList<String>();
		for (NamedFacebookType s : user.getLanguages())
			s.toString();
		return l;
	}

	/* Une liste des athlètes préférés du profil de l'utilisateur. */

	public List<String> favoriteAthletes() {
		List<String> s = new ArrayList<String>();
		for (NamedFacebookType a : user.getFavoriteAthletes())
			s.add(a.toString());
		return s;
	}

	/*
	 * Liste des équipes sportives favorites à partir du profil de
	 * l'utilisateur.
	 */

	public List<String> favoriteTeams() {
		List<String> s = new ArrayList<String>();
		for (NamedFacebookType a : user.getFavoriteTeams())
			s.add(a.toString());
		return s;
	}

	/* Un lien vers le profil de l'utilisateur. */

	public String link() {
		return user.getLink();
	}

	/* La localisation de l'utilisateur. */

	public String locale() {
		return user.getLocale();
	}

	/* Emplacement actuel de l'utilisateur. */

	public String location() {
		return user.getLocation().toString();
	}

	/* Les sexes que l'utilisateur est intéressé pour connaissance. */

	public List<String> meetingFor() {
		return user.getMeetingFor();
	}

	/* L'affiliation politique de l'utilisateur. */

	public String political() {
		return user.getPolitical();
	}

	/* Citations favorites de l'utilisateur. */

	public String quotes() {
		return user.getQuotes();
	}

	/* Statut de la relation de l'utilisateur. */

	public String relationStatus() {
		return user.getRelationshipStatus();
	}

	/* Religion de l'utilisateur. */

	public String religion() {
		return user.getReligion();
	}

	/* Liste des sports de l'utilisateur. */

	public List<String> sports() {
		List<String> s = new ArrayList<String>();
		for (Sport a : user.getSports())
			s.add(a.toString());
		return s;
	}

	/* L'identifiant anonyme et unique de l'utilisateur. */

	public String thirdPartyId() {
		return user.getThirdPartyId();
	}

	/* Le fuseau horaire de l'utilisateur. */

	public Double timezone() {
		return user.getTimezone();
	}

	/* Jour du profil de l'utilisateur ou a été mis a jour. */

	public Date updatedTime() {
		return user.getUpdatedTime();
	}

	/* Is the user verified? */

	public Boolean verified() {
		return user.getVerified();
	}

	/* Un lien vers le site personnel de l'utilisateur. */

	public String website() {
		return user.getWebsite();
	}

	/* Une liste des antécédents de travail à partir du profil de l'utilisateu */

	public List<String> work() {
		List<String> l = new ArrayList<String>();
		for (Work w : user.getWork())
			l.add(w.toString());
		return l;
	}

	/* Les noms amis d'un utilisateur */

	public List<String> getFriends() {
       List<String> l = new ArrayList<String>();
		Connection<User> myFriends = facebookClient.fetchConnection(
				"user/friends", User.class);
		for (User u : myFriends.getData()) {
			l.add(u.getName());
		}
		return l;
	}
	
	/* Les numeros des amis d'un utilisateur*/

	public Integer getFiendsSize(){
		Connection<User> myFriends = facebookClient.fetchConnection(
				"user/friends", User.class);
		return myFriends.getData().size();
	}

}
