package Utama;

import java.util.ArrayList;
import java.util.Optional;

public class PrinterPool {
	private static PrinterPool instance = null;
	private ArrayList<Task> tasks = new ArrayList<>();
	
	private PrinterPool() {
		
	}
	
	public static PrinterPool getInstance() {
		if(instance==null) {
			System.out.println("Singleton instantiated.");
			instance = new PrinterPool();
		}
		else
		{
			throw new IllegalStateException("Already instantiated");
		}
		return instance;
	}
	
	public void addTask(int id, String name, int prior) {
		tasks.add(new Task(id, name, prior));
	}
	
	public void delete(int id) {
		Optional<Task> task = tasks.stream().filter((item) -> item.getId() == id).findFirst();
		if (task.isPresent()) {
			tasks.remove(task.get());
		}
	}
	
	public void priority(int id, int prior) {
		Optional<Task> task = tasks.stream().filter((item) -> item.getId() == id).findFirst();
		if (task.isPresent()) {
			int index = tasks.indexOf(task.get());
			task.get().setPriority(prior);
			tasks.set(index, task.get());
		}
	}
	
	public void display() {
		tasks.forEach((item) -> item.taskInfo());
	}
}