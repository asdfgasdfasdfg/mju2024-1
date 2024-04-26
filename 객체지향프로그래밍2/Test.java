package itemsales;

public class Test {
	public static void main(String []args) {
		ItemSales lunchBox1 = new ItemSales(1000, 10, 30);
		lunchBox1.salesResult(1);
		lunchBox1.salesResult(9);
		lunchBox1.salesResult(10);
		lunchBox1.salesResult(50);
	}
	
}
