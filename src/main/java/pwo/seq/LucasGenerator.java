package pwo.seq;

import java.math.BigDecimal;

public class LucasGenerator extends FibonacciGenerator {

    public LucasGenerator() {
        current = new BigDecimal(2);
        f_2 = new BigDecimal(2);
    }

    @Override
    public BigDecimal nextTerm() {
        if (lastIndex == 0) {
            lastIndex++;
            return new BigDecimal(2);
        }
        return super.nextTerm();
    }
    
    @Override
    public void reset() {
        super.reset();
        current = new BigDecimal(2);
        f_2 = new BigDecimal(2);
    }

    // Nowa metoda do obliczeń "wstecz"
    @Override
    public BigDecimal getPreviousTerm() {
        if (lastIndex > 0) {
            lastIndex--;
            if (lastIndex == 0) {
                return new BigDecimal(2);
            } else {
                return super.getPreviousTerm();
            }
        } else {
            throw new IllegalStateException("No previous term available.");
        }
    }
}
