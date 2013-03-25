package webServices.facebook.JSON;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.Page;


/**
 * 
 * @author BOUGRINE, Seif Eddine
 * 
 */

public class FacebookP {

	private Page page;
	private static FacebookClient facebookClient;

	public FacebookP() {
		facebookClient = new DefaultFacebookClient(
				"AAACEdEose0cBABYHyklz2D8ZBZAEpZBtVUngd7WfzBLlNNiBZCBPoHk8FNPZAZBXQnWe2W92OorATZApaweGZCTMI7ljjzZBqXp4ZB38srSMTBbU12mB1oAigA");
		page = null;
	}

	/* Informations générales sur cette page. */

	public String about() {
		return page.getAbout();
	}

	/* Un administrateur access_token pour cette page. */

	public String accessToken() {
		return page.getAccessToken();
	}

	/*
	 * Indique si l'utilisateur de la session en cours peuvent poster sur cette
	 * page.
	 */

	public Boolean canPost() {
		return page.getCanPost();
	}

	/* Le nombre total d'utilisateurs qui se sont enregistrés dans la page. */

	public Integer checkins() {
		return page.getCheckins();
	}

	/* Vue d'ensemble de la société de la page. */

	public String companyOverview() {
		return page.getCompanyOverview();
	}

	/* La photo de couverture. */

	public String cover() {
		return page.getCover().toString();
	}

	/* Une description de cette page. */

	public String description() {
		return page.getDescription();
	}

	/* Lorsque la page a été fondée. */

	public String founded() {
		return page.getFounded();
	}

	/* Les informations générales d'une page. */

	public String generalInfo() {
		return page.getGeneralInfo();
	}

	/* Si c'est une page de communauté */

	public Boolean isComunityPage() {
		return page.getIsCommunityPage();
	}

	/* Indique si la page est publiée et visible pour les non-admins. */

	public Boolean isPublished() {
		return page.getIsPublished();
	}

	/* Le nombre de la page aime a. */

	public Long likes() {
		return page.getLikes();
	}

	/* Le lien de la page */

	public String link() {
		return page.getLink();
	}

	/* The location of the place this page represents. */

	public String location() {
		return page.getLocation().toString();
	}

	/* La page de la mission. */

	public String mission() {
		return page.getMission();
	}

	/* Le numéro de téléphone pour la page */

	public String phone() {
		return page.getPhone();
	}

	/* La page de l'image. */

	public String picture() {
		return page.getPicture();
	}

	/* Produits de la page */

	public String products() {
		return page.getProducts();
	}

	/* Le nombre de personnes qui parlent cette page (les sept derniers jours). */
	
	public Long talkingAboutCount(){
		return page.getTalkingAboutCount();
	}
	
	/*Nom d'utilisateur de la page.*/
	
	public String userName(){
		return page.getUsername();
	}
}
