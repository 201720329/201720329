package ch_1;

import java.util.Random;

public class Plus {
	public static Plus[] Pluss = new Plus[100];
	public int x;
	public int y;
	public int g;
	public int w;
	public int s = 0;

	Plus() {

	}

	Plus(int x, int y, int w) {
		this.x = x;
		this.y = y;
		this.w = w;
	}

	static int randoms() {
		Random random = new Random();
		return ((int) random.nextInt(100));
	}

	void GeneratingFormula() {
		// Generate header
		x = randoms();
		// Generate symbol
		y = randoms();
		// Generating the tail
		g = randoms();
		w = 1;
		if (g % 2 == 1)
			w = -1;
	}

	boolean LegalityJudgment(int e) {
		if ((x + (y * w)) < 0 || (x + (y * w) > 100)) {
			return false;
		}
		for (int i = 1; i < e; i++) {
			if (x == Pluss[i].x && y == Pluss[i].y && w == Pluss[i].w) {
				return false;
			}
		}
		return true;
	}

	void PrintfFormula(int s) {
		System.out.print(s + " : ");
		System.out.print(x + (w == 1 ? " + " : " - ") + y + " = " + (x + y * w));
		if (s % 5 == 0)
			System.out.println();
		else
			System.out.print("\n");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 1; i <= 50; i++) {
			Plus plus = new Plus();
			// GeneratingFormula
			plus.GeneratingFormula();
			if (plus.LegalityJudgment(i) == false) {
				i--;
				continue;
			}

			Pluss[i] = new Plus(plus.x, plus.y,
					plus.w);
			plus.PrintfFormula(i);
		}
	}

}
