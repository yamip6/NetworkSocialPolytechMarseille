package webServices.facebook.JSON;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.DefaultJsonMapper;
import com.restfb.FacebookClient;
import com.restfb.JsonMapper;
import com.restfb.Parameter;
import com.restfb.exception.FacebookException;
import com.restfb.types.Page;
import com.restfb.types.Post;
import com.restfb.types.User;

public class Test {

	public static void main(String[] args) throws FacebookException {
		FacebookClient facebookClient = new DefaultFacebookClient(
				"AAACEdEose0cBANykf4vKfsK5ZAb4g4MIpA18LoCAdRPUTVcah0WIYeuwKXWtscvxJckaZB74nEvx5L5xo671IzareVM5KVc7N7je2nlZCQEykn6NZBI3");

		User user = facebookClient.fetchObject("100002974474813", User.class);
		 Page page = facebookClient.fetchObject("cocacola", Page.class);
//
//		System.out.println("Nom d'utilisateur: "+user.getReligion());
//		JsonMapper m =new DefaultJsonMapper();
//
//		System.out.println("Nom d'utilisateur: "+page.getLikes());

//		String json = m.toJson(user);
//		System.out.println("Nom d'utilisateur Forme JSON: "+json);
//
//		List<String> l = new ArrayList<String>();
//		Connection<User> myFriends = facebookClient.fetchConnection(
//				"me/friends", User.class);
//		for (User u : myFriends.getData()) {
//					l.add(u.getId());
//		
//		}
//		for (String s : l) {
//			System.out.println(s);
//		}
//		Connection<Post> publicSearch =
//				  facebookClient.fetchConnection("search", Post.class,
//				    Parameter.with("q", "watermelon"), Parameter.with("type", "post"));
//
//		Connection<User> targetedSearch =
//				  facebookClient.fetchConnection("me/home", User.class,
//				    Parameter.with("q", "Mark"), Parameter.with("type", "user"));
//
//				System.out.println("Public search: " + publicSearch.getData().get(0).getMessage());
//				System.out.println("Posts on my wall by friends named Mark: " + targetedSearch.getData().size());

	}
}
