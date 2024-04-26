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
		System.out.println("도시락 " + num + "개를 팔았다.");
		int defaultSalePriceResult = getSalePrice() * num;
		int discountSalePriceResult = (getSalePrice() * num) * (100 -getMassSalesDiscountRate()) / 100;
		int discountPriceResult = (getSalePrice() * num) * getMassSalesDiscountRate() / 100;
		
		if (num < getNumOfMassSales()) { // 대량 판매 수량 미달시
			System.out.println("할인율이 적용되지 않아 판매 가격은 " + defaultSalePriceResult + "원이다.");
			this.totalSalesPrice += defaultSalePriceResult;
		} else {
			System.out.println("할인율이 적용되어 판매 가격은 " + discountSalePriceResult + "원이다.");
			this.totalSalesPrice += discountSalePriceResult;
			this.totalDiscount += discountPriceResult;
		}
		
		this.totalSales += num;
		
		System.out.println();
		printAccmulateSales();
	}
	
	public void printAccmulateSales() {
		System.out.println("누적 판매 수량 = " + getNumOfTotalSales() + "개, 누적 판매 금액 = " + getTotalSalesPrice() + "원, 누적 할인금액 = " + getTotalDiscount() + "원");
		System.out.println();
	}
}
