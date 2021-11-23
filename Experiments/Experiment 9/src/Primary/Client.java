package Primary;

public class Client {
	public static void main(String[] args) {
		HotelRoom hotel = new HotelRoom();
		
		hotel.displayInfo();
		
		hotel.ChangeState(new RoomReserved());
		hotel.displayInfo();
		
		hotel.ChangeState(new RoomOccupied());
		hotel.displayInfo();
	}
}
