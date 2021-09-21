
public class OAPermissionFactory implements PermissionFactory {
	
	@Override
	public Permission getPermission(int level) {
		switch(level) {
		case 1:
			return new LowPermission();
			
		case 2:
			return new HighPermission();
		
		default:
			throw new Error("Level is invalid.");
		}
	}
}
