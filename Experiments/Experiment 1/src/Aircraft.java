public class Aircraft {
	private TakeOffStyle Takeoff;
	private FlightStyle Flight;

	public void SetTakeoff(TakeOffStyle Takeoff) {
		this.Takeoff = Takeoff;
	}
	 
	public void SetFly(FlightStyle Flight) {
		this.Flight = Flight;
	}
	 
	public void ExecuteTakeoff() {
		this.Takeoff.ExecuteTakeoff();
	}
	 
	public void ExecuteFly() {
		this.Flight.ExecuteFly();
	}
	 
	public void displaystat() {
	 
	}
	
	public static void main(String[] args) {
		Aircraft Helicopter1 = new Helicopter();
		Helicopter1.SetTakeoff(new VerticalTakeOff());
		Helicopter1.SetFly(new SubsonicFly());
		
		Aircraft Airplane1 = new Airplane();
		Airplane1.SetTakeoff(new LongDistanceTakeOff());
		Airplane1.SetFly(new SubsonicFly());
		
		Aircraft Fighter1 = new Fighter();
		Fighter1.SetTakeoff(new LongDistanceTakeOff());
		Fighter1.SetFly(new SupersonicFly());
		
		Aircraft Harrier1 = new Harrier();
		Harrier1.SetTakeoff(new VerticalTakeOff());
		Harrier1.SetFly(new SupersonicFly());
		
		Helicopter1.displaystat();
		Airplane1.displaystat();
		Fighter1.displaystat();
		Harrier1.displaystat();
	}
}

