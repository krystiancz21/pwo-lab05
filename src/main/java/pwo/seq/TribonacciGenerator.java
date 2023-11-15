package pwo.seq;

import java.math.BigDecimal;

public class TribonacciGenerator extends FibonacciGenerator {

    public TribonacciGenerator() {
        f_3 = new BigDecimal(0);
    }

    @Override
    public BigDecimal nextTerm() {
        if (lastIndex > 2) {
            current = f_1.add(f_2).add(f_3);
            f_3 = f_2;
            f_2 = f_1;
            f_1 = current;
        } else if (lastIndex == 2) {
            current = new BigDecimal(1);
        } else {
            current = new BigDecimal(0);
        }
        lastIndex++;
        return current;
    }
    
    @Override
    public void reset() {
        super.reset();
        f_3 = new BigDecimal(0);
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
            } else if (lastIndex == 2) {
                return f_2;
            } else {
                BigDecimal temp = f_3;
                f_3 = f_2.subtract(f_1);
                f_2 = f_1;
                f_1 = temp;
                return temp;
            }
        } else {
            throw new IllegalStateException("No previous term available.");
        }
    }
}
