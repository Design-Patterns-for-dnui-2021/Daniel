
public class TVFactory {
	public TV produceTV(String brand) {
		if(brand.equals("haier")) return new HaierTV();
		if(brand.equals("hisense")) return new HisenseTV();
		throw new Error("This brand is not available.");
	}
}
