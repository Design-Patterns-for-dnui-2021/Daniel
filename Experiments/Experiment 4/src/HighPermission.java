
public class HighPermission implements Permission{
	
	@Override
	public void operate() {
		System.out.println("High Level User: Can do low level and high level operation.");
	}
	
}
