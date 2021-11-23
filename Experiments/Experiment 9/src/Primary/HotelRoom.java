package Primary;

public class HotelRoom {
	RoomState roomstate;
	
	public HotelRoom() {
		this.roomstate =new RoomAvailable();
	}
	
	public void displayInfo() {
		this.roomstate.roomInfo();
	}
	
	public void ChangeState (RoomState roomstate) {
		this.roomstate = roomstate;
	}
}
