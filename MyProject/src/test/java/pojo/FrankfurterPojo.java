package pojo;

import java.util.List;

public class FrankfurterPojo {
	
	public float amount;
	public String base;
    public String date;
    public Rates rates;
    public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Rates getRates() {
		return rates;
	}
	public void setRates(Rates rates) {
		this.rates = rates;
	}
}
