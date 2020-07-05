package interviewbit.Backtracking;

public class ModularExpression {
	public static void main(String[] args) {
		System.out.println(new ModularExpression().Mod(-1, 3, 20));
	}

	public int Mod(int A, int B, int C) {
		if (A == 0) return 0;
		if (B == 0) return 1;
		int power = Mod(A, B / 2, C);
		power = (int) (((long) power * power) % C);
		if (B % 2 != 0) {
			power = (int) (((long) power * A) % C);
			if (A < 0) {
				power = (power + C) % C;
			}
		}
		return power;
	}
}
