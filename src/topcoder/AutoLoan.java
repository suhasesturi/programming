package topcoder;

public class AutoLoan {

    public double interestRate(double price, double monthlyPayment, int loanTerm) {
        double low = 0, high = 100;
        int iterations = 200;
        while (low < high && iterations-- > 0) {
            double mid = low + (high - low) / 2;

            double loan = price;
            for (int i = 1; i <= loanTerm && loan >= 0; i++) {
                loan += (loan * mid) / (1200);
                loan -= monthlyPayment;
            }

            if (loan == 0) return mid;
            if (loan < 0) low = mid;
            else high = mid;
        }
        return 0;
    }
}

