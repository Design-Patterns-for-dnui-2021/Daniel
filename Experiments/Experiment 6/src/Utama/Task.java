package Utama;

public class Task {
	private int id;
	private String name;
	private int prior;
	
	public Task(int id, String name, int prior) {
		this.id = id;
		this.name = name;
		this.prior = prior;
	}
	
	public void taskInfo() {
		System.out.println("ID: " + id);
		System.out.println("Document: " + name);
		System.out.println("Priority: " + prior);
		System.out.println("\n");
	}
	
	public int getId() {
		return id;
	}
	
	public void setPriority(int prior) {
		this.prior = prior;
	}
}
