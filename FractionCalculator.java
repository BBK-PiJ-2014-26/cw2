import java.util.Scanner;

public class FractionCalculator {

	private Fraction f1;
	private Fraction f2;
	private boolean operatorPresent;
	private boolean add;
	private boolean subtract;
	private boolean divide;
	private boolean multiply;
	private	Scanner input;
	private boolean finished;
	private boolean quit;
	private boolean error;
	private boolean clear;

	public Fraction launch(Scanner input) {
		this.input = input;
		this.operatorPresent = false;
		this.add = false;
		this.subtract = false;
		this.divide = false;
		this.multiply = false;
		this.f1 = null;
		this.f2 = null;
		this.finished = false;
		this.quit = false;
		this.error = false;
		this.clear = false;
		while (input.hasNext()) {
			String s = input.next();
			if (f1 == null) {
				this.setF1(s);
			} else if (!operatorPresent) {
				this.setOperator(s);
			} else {
				this.setF2(s);
			}

		}
		return this.f1;
	}

	public void error() {
		System.out.println("Invalid input, please try again.");
		this.error = true;
	}

	public void setF1(String s) {
		int sLength = s.length();
		int count = 0;
		int slashPos = 0;
		boolean slashPresent = false;
		for (count = 0; count < sLength; count++) {
			char slash = s.charAt(count);
			if (slash == ('/')) {
				slashPos = count;
				slashPresent = true;
			}
		}
		if (slashPresent) {
			String temp = s.substring(0, slashPos);
			int num = Integer.parseInt(temp);
			temp = s.substring((slashPos + 1), sLength);
			int denom = Integer.parseInt(temp);
			this.f1 = new Fraction(num, denom);
		} else {
			String temp = s.substring(0, sLength);
			int num = Integer.parseInt(temp);
			int denom = 1;
			this.f1 = new Fraction(num, denom);
		}

	}


	public void setOperator(String s) {
		if (s.equals("+")) {
			if (!add) {
				this.add = true;
				this.operatorPresent = true;
			} else {
				this.error();
			}
		} else if (s.equals("-")) {
			if (!subtract) {
				this.subtract = true;
				this.operatorPresent = true;
			} else {
				this.error();
			}
		} else if (s.equals("/")) {
			if (!divide) {
				this.divide = true;
				this.operatorPresent = true;
			} else {
				this.error();
			}
		} else if (s.equals("*")) {
			if (!multiply) {
				this.multiply = true;
				this.operatorPresent = true;
			} else {
				this.error();
			}
		} else if (s.equals("a") || s.equals("A") || s.equals("abs")) {
			this.f1 = this.f1.absValue();
		} else if (s.equals("n") || s.equals("N") || s.equals("neg")) {
			this.f1 = this.f1.negate();
		} else if (s.equals("c") || s.equals("C") || s.equals("clear")) {
			this.f1 = null;
			this.clear = true;
		} else if (s.equals("q") || s.equals("Q") || s.equals("quit")) {
			this.quit = true;
		} else {
			this.error();
		}
	}

	public void setF2(String s) {
		int sLength = s.length();
		int count = 0;
		int slashPos = 0;
		boolean slashPresent = false;
		for (count = 0; count < sLength; count++) {
			char slash = s.charAt(count);
			if (slash == ('/')) {
				slashPos = count;
				slashPresent = true;
			}
		}
		if (slashPresent) {
			String temp = s.substring(0, slashPos);
			int num = Integer.parseInt(temp);
			temp = s.substring((slashPos + 1), sLength);
			int denom = Integer.parseInt(temp);
			this.f2 = new Fraction(num, denom);

		} else {
			String temp = s.substring(0, sLength);
			int num = Integer.parseInt(temp);
			int denom = 1;
			this.f2 = new Fraction(num, denom);
		}
		if (add) {
			this.f1 = this.f1.add(this.f2);
			this.f2 = null;
			this.operatorPresent = false;
			this.add = false;
			this.subtract = false;
			this.divide = false;
			this.multiply = false;
		} else if (subtract) {
			this.f1 = this.f1.subtract(this.f2);
			this.f2 = null;
			this.operatorPresent = false;
			this.add = false;
			this.subtract = false;
			this.divide = false;
			this.multiply = false;
		} else if (divide) {
			this.f1 = this.f1.divide(this.f2);
			this.f2 = null;
			this.operatorPresent = false;
			this.add = false;
			this.subtract = false;
			this.divide = false;
			this.multiply = false;
		} else if (multiply) {
			this.f1 = this.f1.multiply(this.f2);
			this.f2 = null;
			this.operatorPresent = false;
			this.add = false;
			this.subtract = false;
			this.divide = false;
			this.multiply = false;
		} else {
			this.error();
		}
	}

	public void evaluate(Fraction fraction, String inputString) {
		Scanner input = new Scanner(inputString);
		FractionCalculator test = new FractionCalculator();
		Fraction testFraction = new Fraction(1, 1);
		testFraction = test.launch(input);
		if (!fraction.equals(testFraction)) { System.out.println("Test failed"); }
	}

	public static void main(String[] args)  {

		System.out.println("\n" + "My name is Gareth Moore.\n" + "Welcome to my Fraction Calculator.\n" + "The calculator is intialised to 0.\n" + "To begin, please enter your problem on the next line:\n" + "+ 1/2... or * 1/4... etc.\n" + "Type q, Q or quit to leave the application.\n");
		FractionCalculator myCalc = new FractionCalculator();
		Fraction myFraction = new Fraction(0, 1);
		Scanner sc = null;
		boolean finished = false;
		do {
			String s1 = myFraction.toString() + " ";
			System.out.println(s1);
			sc = new Scanner(System.in);
			String s2 = sc.nextLine();
			String s3 = s1 + s2;
			sc = new Scanner(s3);
			myFraction = myCalc.launch(sc);
			if (myCalc.quit) {
				System.out.println("Goodbye.");
				finished = true;
			} else if (myCalc.error) {
				System.out.println("Error.");
				myFraction = new Fraction(0, 1);
			} else if (myCalc.clear) {
				myFraction = new Fraction(0, 1);
			}
		} while (!finished);
	}
}

