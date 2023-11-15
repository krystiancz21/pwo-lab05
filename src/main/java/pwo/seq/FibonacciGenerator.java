package pwo.seq;

import java.math.BigDecimal;

public class FibonacciGenerator extends Generator {

    public FibonacciGenerator() {
        current = new BigDecimal(0);
        f_1 = new BigDecimal(1);
        f_2 = new BigDecimal(0);
    }
    
    @Override
    public void reset() {
        super.reset();
        f_1 = new BigDecimal(1);
        f_2 = new BigDecimal(0);
    }

    // Nowa metoda do obliczeń "wstecz"
    @Override
    public BigDecimal getPreviousTerm() {
        if (lastIndex > 0) {
            lastIndex--;
            if (lastIndex == 0) {
                return new BigDecimal(0);
            } else if (lastIndex == 1) {
                return new BigDecimal(1);
            } else {
                BigDecimal temp = f_2;
                f_2 = f_1.subtract(f_2);
                f_1 = temp;
                return temp;
            }
        } else {
            throw new IllegalStateException("No previous term available.");
        }
    }
}
