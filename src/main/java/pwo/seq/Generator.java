package pwo.seq;

import java.math.BigDecimal;
import pwo.utils.SequenceGenerator;

abstract class Generator implements SequenceGenerator {

    protected int lastIndex = 0;
    protected BigDecimal current = null, f_1 = null, f_2 = null, f_3 = null;

    @Override
    public void reset() {
        lastIndex = 0;
        current = null;
        f_1 = null;
        f_2 = null;
        f_3 = null;
    }

    @Override
    public final BigDecimal getTerm(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i < lastIndex) {
            reset();
        }
        while (lastIndex <= i) {
            nextTerm();
        }
        return current;
    }

    @Override
    public BigDecimal nextTerm() {
        if (lastIndex > 1) {
            current = f_1.add(f_2);
            f_2 = f_1;
            f_1 = current;
        } else if (lastIndex == 1) {
            current = new BigDecimal(1);
        } else {
            current = new BigDecimal(0);
        }

        lastIndex++;
        return current;
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
                BigDecimal temp = f_1.subtract(f_2);
                f_3 = f_2;
                f_2 = f_1;
                f_1 = temp;
                return temp;
            }
        } else {
            throw new IllegalStateException("No previous term available.");
        }
    }
}
