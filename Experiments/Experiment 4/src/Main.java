
public class Main {
	
	public static void main(String[] args) {
		
		User user1 = new User(12721, 1, "Alexander");
		User user2 = new User(55555, 2, "Gitarja");
		
		Permission permission;
		PermissionFactory factory = new OAPermissionFactory();
		
		permission = user1.login(factory);
		permission.operate();
		
		System.out.println("\n");

		permission = user2.login(factory);
		permission.operate();
	}
}
