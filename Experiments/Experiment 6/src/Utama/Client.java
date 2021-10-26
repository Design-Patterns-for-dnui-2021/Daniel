package Utama;

public class Client {
	
	public static void main(String[] aargs) {
		PrinterPool app = PrinterPool.getInstance();
		app.addTask(1, "How To Get A Girlfriend.pdf", 1);
		app.addTask(2, "Dream will be dream.pdf", 1);
		app.addTask(3, "DogeCoin Master.docx", 1);
		
		app.display();
		
		app.priority(2, 3);
		app.delete(1);
		
		System.out.println("Updated Tasks: ");
		app.display();
		
		// another instance of the print pool will cause error exception
		PrinterPool app2 = PrinterPool.getInstance();
	}
}
