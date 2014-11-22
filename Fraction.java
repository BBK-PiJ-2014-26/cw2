/**
 * Created by keith for the second coursework assignment.
 */
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int num, int denom) {
        if (denom == 0) {
            System.out.println("Invalid fraction with denominator 0"); 
	    // this should use exceptions
            return;
        }
        int gcd = myGcd(num, denom);
        setNumerator(num / gcd);
        setDenominator(denom / gcd);
    }
	// this alternative constructor uses an existing fraction instead of two integers
	public Fraction(Fraction other) {
		this.numerator = other.getNumerator();
		this.denominator = other.getDenominator();
    	}

    @Override
    public String toString() {
        return "" + getNumerator() + '/' + getDenominator();
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int num) {
        numerator = num;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int num) {
        denominator = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fraction fraction = (Fraction) o;

        if (getDenominator() != fraction.getDenominator()) return false;
        if (getNumerator() != fraction.getNumerator()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numerator;
        result = 31 * result + denominator;
        return result;
    }

    public Fraction multiply(Fraction other) {
        int num = this.getNumerator() * other.getNumerator();
        int denom = this.getDenominator() * other.getDenominator();
        return new Fraction(num, denom);
    }

    private int myGcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

	// Calculate the lowest common multiple (LCM) of two integers
	public int myLcm(int a, int b) {
		int lcm = (a * b) / myGcd(a, b);
		return lcm;
	} 

	public Fraction add(Fraction other) {
		int lcm = myLcm(this.getDenominator(), other.getDenominator());
		int aNumerator = (lcm / this.getDenominator()) * this.getNumerator();
		int bNumerator = (lcm / other.getDenominator()) * other.getNumerator();
		Fraction result = new Fraction((aNumerator + bNumerator), lcm);
		return result;
	}
		
	public Fraction subtract(Fraction other) {
		int lcm = myLcm(this.getDenominator(), other.getDenominator());
		int aNumerator = (lcm / this.getDenominator()) * this.getNumerator();
		int bNumerator = (lcm / other.getDenominator()) * other.getNumerator();
		Fraction result = new Fraction((aNumerator - bNumerator), lcm);
		return result;
	}	

	public Fraction absValue() {
		int num =  this.getNumerator();
		int denom = this.getDenominator();
		int count = 0;
		if (num < 0) {
			for(count = 0; num != 0; count++) {
				num++;
			}
			num = count;
		}
		if (denom < 0) {
			for(count = 0; denom != 0; count++) {
				denom++;
			}
			denom = count;
		}
		Fraction result = new Fraction(num, denom);
		String s = result.toString();
		System.out.println(s);
		return result;
	}

				
		
}
