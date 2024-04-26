package itemsales;

public class ItemSales {
	public int numOfSales = 0;
	public int totalSales = 0;
	public int totalDiscount = 0;
	public int totalSalesPrice = 0;
	public int salePrice = 0;
	public int numOfMassSales = 0;
	public int massSalesDiscountRate = 0;
	
	public ItemSales(int salePrice, int numOfMassSales, int massSalesDiscountRate) {
		this.salePrice = salePrice;
		this.numOfMassSales = numOfMassSales;
		this.massSalesDiscountRate = massSalesDiscountRate;
	}
	
	public int getNumOfSales() {
		return numOfSales;
	}
	
	public int getTotalSalesPrice() {
		return totalSalesPrice;
	}
	
	public int getNumOfTotalSales() {
		return totalSales;
	}
	
	public int getTotalDiscount() {
		return totalDiscount;
	}
	
	public int getSalePrice() {
		return salePrice;
	}
	
	public int getNumOfMassSales() {
		return numOfMassSales;
	}
	
	public int getMassSalesDiscountRate() {
		return massSalesDiscountRate;
	}
	
	public void changeAttributes() {
		
	}
	
	public void salesResult(int num) {
		System.out.println("���ö� " + num + "���� �ȾҴ�.");
		int defaultSalePriceResult = getSalePrice() * num;
		int discountSalePriceResult = (getSalePrice() * num) * (100 -getMassSalesDiscountRate()) / 100;
		int discountPriceResult = (getSalePrice() * num) * getMassSalesDiscountRate() / 100;
		
		if (num < getNumOfMassSales()) { // �뷮 �Ǹ� ���� �̴޽�
			System.out.println("�������� ������� �ʾ� �Ǹ� ������ " + defaultSalePriceResult + "���̴�.");
			this.totalSalesPrice += defaultSalePriceResult;
		} else {
			System.out.println("�������� ����Ǿ� �Ǹ� ������ " + discountSalePriceResult + "���̴�.");
			this.totalSalesPrice += discountSalePriceResult;
			this.totalDiscount += discountPriceResult;
		}
		
		this.totalSales += num;
		
		System.out.println();
		printAccmulateSales();
	}
	
	public void printAccmulateSales() {
		System.out.println("���� �Ǹ� ���� = " + getNumOfTotalSales() + "��, ���� �Ǹ� �ݾ� = " + getTotalSalesPrice() + "��, ���� ���αݾ� = " + getTotalDiscount() + "��");
		System.out.println();
	}
}
