package Github;

import java.util.Scanner;
import java.io.*;

import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.User;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.UserService;
import org.eclipse.egit.github.core.service.RepositoryService;

public class GithubAPI {

	public static void main(String[] args) throws IOException {
		boolean complete = false;
		while(!complete) {
			System.out.print("\n" + "Username:\n");
			FileWriter tsv = new FileWriter("src//visualise.tsv", false);
			tsv.append("User, Followers, Repos\n");
			Scanner input = new Scanner (System.in);
			String user = input.nextLine();
			if (user == "done") {
				complete  = true;
			}
			int repos = publicRepos(user);
			int followers = followers(user);
			System.out.print("Followers: " + followers + "\n" + "Public Repos: " + repos);
			tsv.append(user + ",");
			tsv.append(String.valueOf(followers) +",");
			tsv.append(String.valueOf(repos));
			tsv.flush();
			tsv.close();
		}
	}
	
		static int publicRepos (String username) throws IOException {
		int repos = 0;
		RepositoryService service = new RepositoryService();
		for (Repository repo : service.getRepositories(username)){
			System.out.println(repos++ +") Name: " + repo.getName());
		}
		return repos;
		}
	
		static int followers (String username) throws IOException {
			FileWriter tsv = new FileWriter("src//visualise.tsv", false);
			int followers = 0;
			UserService userService = new UserService();
			for (User user : userService.getFollowers(username)){
				followers++;
			}
			return followers;
		}
}