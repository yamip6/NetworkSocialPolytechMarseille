package webServices.facebook.JSON;

import java.util.*;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.DefaultJsonMapper;
import com.restfb.FacebookClient;
import com.restfb.JsonMapper;
import com.restfb.types.NamedFacebookType;
import com.restfb.types.User;
import com.restfb.types.User.Education;
import com.restfb.types.User.Sport;
import com.restfb.types.User.Work;

public class FacebookC_JSON {
	private static FacebookClient facebookClient;
	private static User user;
	private JsonMapper formeJson;

	public FacebookC_JSON() {
		facebookClient = new DefaultFacebookClient(
				"AAACEdEose0cBABYHyklz2D8ZBZAEpZBtVUngd7WfzBLlNNiBZCBPoHk8FNPZAZBXQnWe2W92OorATZApaweGZCTMI7ljjzZBqXp4ZB38srSMTBbU12mB1oAigA");

		user = null;
		formeJson = new DefaultJsonMapper();
	}

	/* Texte de présentation qui apparaît sous leur photo de profil. */

	public String about() {
		return formeJson.toJson(user.getAbout());
	}

	/* Extrait biographique de l'utilisateur. */

	public String biographical(String who) {

		return formeJson.toJson(user.getBio());
	}

	/* Anniversaire de l'utilisateur */
	public String birthay() {
		return formeJson.toJson(user.getBirthday());
	}

	/* Liste de l'histoire de l'éducation à partir du profil de l'utilisateur */

	public String education() {
		List<String> l = new ArrayList<>();
		for (Education e : user.getEducation()) {
			l.add(e.toString());
		}
		return formeJson.toJson(l);
	}

	/* L'adresse proxy ou de contacts électroniques accordée par l'utilisateur */

	public String email() {
		return user.getEmail();
	}

	/* Prénom de l'utilisateur. */

	public String firstName() {
		return formeJson.toJson(user.getFirstName());
	}

	/* Nom de l'utilisateur. */

	public String userName() {
		return formeJson.toJson(user.getUsername());
	}

	/* Sexe de l'utilisateur. */

	public String gender() {
		return formeJson.toJson(user.getGender());
	}

	/* La ville natale de l'utilisateur. */

	public String homeTown() {
		NamedFacebookType n = user.getHometown();
		return formeJson.toJson(n.toString());
	}

	/* Le nom de la ville natale de l'utilisateur. */

	public String homeTownName() {
		return formeJson.toJson(user.getHometownName());
	}

	/* The genders the user is interested in. */

	public String interesedIn() {
		return formeJson.toJson(user.getInterestedIn());
	}

	/* Liste des langues du profil de l'utilisateur */

	public String languages() {
		List<String> l = new ArrayList<String>();
		for (NamedFacebookType s : user.getLanguages())
			s.toString();
		return formeJson.toJson(l);
	}

	/* Une liste des athlètes préférés du profil de l'utilisateur. */

	public String favoriteAthletes() {
		List<String> s = new ArrayList<String>();
		for (NamedFacebookType a : user.getFavoriteAthletes())
			s.add(a.toString());
		return formeJson.toJson(s);
	}

	/*
	 * Liste des équipes sportives favorites à partir du profil de
	 * l'utilisateur.
	 */

	public String favoriteTeams() {
		List<String> s = new ArrayList<String>();
		for (NamedFacebookType a : user.getFavoriteTeams())
			s.add(a.toString());
		return formeJson.toJson(s);
	}

	/* Un lien vers le profil de l'utilisateur. */

	public String link() {
		return formeJson.toJson(user.getLink());
	}

	/* La localisation de l'utilisateur. */

	public String locale() {
		return formeJson.toJson(user.getLocale());
	}

	/* Emplacement actuel de l'utilisateur. */

	public String location() {
		return formeJson.toJson(user.getLocation().toString());
	}

	/* Les sexes que l'utilisateur est intéressé pour connaissance. */

	public String meetingFor() {
		return formeJson.toJson(user.getMeetingFor());
	}

	/* L'affiliation politique de l'utilisateur. */

	public String political() {
		return formeJson.toJson(user.getPolitical());
	}

	/* Citations favorites de l'utilisateur. */

	public String quotes() {
		return formeJson.toJson(user.getQuotes());
	}

	/* Statut de la relation de l'utilisateur. */

	public String relationStatus() {
		return formeJson.toJson(user.getRelationshipStatus());
	}

	/* Religion de l'utilisateur. */

	public String religion() {
		return formeJson.toJson(user.getReligion());
	}

	/* Liste des sports de l'utilisateur. */

	public String sports() {
		List<String> s = new ArrayList<String>();
		for (Sport a : user.getSports())
			s.add(a.toString());
		return formeJson.toJson(s);
	}

	/* L'identifiant anonyme et unique de l'utilisateur. */

	public String thirdPartyId() {
		return formeJson.toJson(user.getThirdPartyId());
	}

	/* Le fuseau horaire de l'utilisateur. */

	public String timezone() {
		return formeJson.toJson(user.getTimezone());
	}

	/* Jour du profil de l'utilisateur ou a été mis a jour. */

	public String updatedTime() {
		return formeJson.toJson(user.getUpdatedTime());
	}

	/* Is the user verified? */

	public String verified() {
		return formeJson.toJson(user.getVerified());
	}

	/* Un lien vers le site personnel de l'utilisateur. */

	public String website() {
		return formeJson.toJson(user.getWebsite());
	}

	/* Une liste des antécédents de travail à partir du profil de l'utilisateu */

	public String work() {
		List<String> l = new ArrayList<String>();
		for (Work w : user.getWork())
			l.add(w.toString());
		return formeJson.toJson(l);
	}

	/* Les noms amis d'un utilisateur */

	public String getFriends() {
       List<String> l = new ArrayList<String>();
		Connection<User> myFriends = facebookClient.fetchConnection(
				"user/friends", User.class);
		for (User u : myFriends.getData()) {
			l.add(u.getName());
		}
		return formeJson.toJson(l);
	}
	
	/* Les numeros des amis d'un utilisateur*/

	public Integer getFiendsSize(){
		Connection<User> myFriends = facebookClient.fetchConnection(
				"user/friends", User.class);
		return myFriends.getData().size();
	}
}
