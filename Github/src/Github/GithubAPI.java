package Github;

import java.util.Scanner;
import java.io.*;
import org.eclipse.egit.github.core.User;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.UserService;

public class GithubAPI {

	public static void main(String[] args) throws IOException {
		System.out.println("Username:\n");
		Scanner input = new Scanner (System.in);
		String username = input.nextLine();
		System.out.println("Password:\n");
		String password = input.nextLine();
		User user = FindUser(username, password);
		System.out.println("Information on this user:\nLogin: "
							+ user.getLogin() + "\nName: "
							+ user.getName() + "\nEmail: "
							+ user.getEmail() + "\nFollowers: "
							+ user.getFollowers() + "\nFollowing: "
							+ user.getFollowing() + "\nPublic Repos: "
							+ user.getPublicRepos() + "\nPrivate Repos: "
							+ user.getTotalPrivateRepos());
		}
	
	private static User FindUser(String username, String password) throws IOException {
		GitHubClient client = new GitHubClient();
		client.setCredentials(username, password);
		UserService userService = new UserService(client);
		return userService.getUser();
	}

}