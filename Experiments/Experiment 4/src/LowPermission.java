
public class LowPermission implements Permission{
	
	@Override
	public void operate() {
		System.out.println("Low level User: Can only do low level operation.");
	}
	
}
