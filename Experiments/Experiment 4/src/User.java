
public class User {
	private int idNumber;
	private int level;
	private String name;
	
	User(int idNumber, int level, String name){
		this.idNumber = idNumber;
		this.level = level;
		this.name = name;
	}
	
	Permission login (PermissionFactory factory){
		System.out.println("Name: " + name);
		System.out.println("ID: " + idNumber);
		System.out.println("level: " + level);
		return factory.getPermission(level);
	}
}
