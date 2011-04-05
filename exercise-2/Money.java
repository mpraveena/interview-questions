/**
 * @author Praveena 
 * 
 * Implements Money in dollar and cents. 
 * Supports basic arithmetic operations on Money instances. 
 * Formats Money in USD Currency.   
 */
package uiowa;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class Money implements Comparable<Money> {
	
	//Amount represents dollars and cents
	private BigDecimal amount;
	
	public Money(BigDecimal aAmount) {
		this.setAmount(aAmount);
	}
	
	public Money(double aAmount) {
		this.setAmount(new BigDecimal(aAmount));
	}
	
	public void setAmount(BigDecimal aAmount) {
		this.amount = aAmount;
	}

	public BigDecimal getAmount() {
		return amount;
	}
	
	/** 
	 * Adds given amount to this.amount.
	 * Returns a Money instance whose value is 
	 * (this.amount + given money instance's amount)
     */ 
	public Money add(Money money) {
		return (money == null)?null:(new Money(amount.add(money.getAmount())));
	}

	/**
	 * Subtracts given amount from this.amount. 
	 * Returns a Money instance whose value is 
	 * (this.amount - given money instance's amount)
     */
	public Money subtract(Money money) {
		return (money == null)?null:(new Money(amount.subtract(money.getAmount())));
	}

	/** 
	 * Multiplies this.amount with given number of times. 
	 * Returns a Money instance whose value is (this.amount * times)
     */ 
	public Money multiply(int times) {
		return new Money(amount.multiply(new BigDecimal(times)));
	}

	/** Divides this.amount into given number of parts.
	 *  'divisor' represents the number of parts to divide the amount into.
	 *  Returns an array of Money instances. Each Money instance value is (this.amount / divisor)
     */
	public Money[] divide(int divisor) throws ArithmeticException {
		BigDecimal quotient = amount.divide(new BigDecimal(divisor));
		Money[] dividedMonies = new Money[divisor];
		for(int i =0; i < dividedMonies.length; i++) {
			dividedMonies[i] = new Money(quotient);
		}
		return dividedMonies;
	}

	/** 
	 * Returns formatted Amount in USD format
	 */
	public String getFormatedAmount() {
		return (NumberFormat.getCurrencyInstance(Locale.US)).format(amount);
	}
	
	@Override
	/**
	 * Compares given money instance with this. 
	 * Returns 0 when this.amount is equal to given money instance's amount.
	 * returns -1 when this.amount is less than given money instance's amount.
	 * returns 1 when this.amount is greater than given money instance's amount.
	 */
	public int compareTo(Money aMoney) {
	    if ( this == aMoney ) return 0;
	    //Not handling Null pointer exception when aMoney is null
	    return this.amount.compareTo(aMoney.getAmount());
	}
	
	public boolean equals(Object aObject){
	    if (this == aObject) return true;
	    if (! (aObject instanceof Money) ) return false;
	    return this.amount.equals(((Money)aObject).getAmount());
	}
	  
	public int hashCode(){	    
	    return amount.hashCode();
	}
}
