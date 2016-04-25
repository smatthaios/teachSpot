package gr.teachspot.library.utils;

import java.math.BigDecimal;

/**
 * A utility class that implements mathematical operations.
 */
public class MathUtils {

    /**
     * Adds all the arguments.
     *
     * @param numbers unspecified amount of {@link BigDecimal} numbers that we will add.
     * @return A {@link BigDecimal} number holding the result of the addition of all the arguments.
     */
    public static BigDecimal addAll (BigDecimal... numbers) {
        BigDecimal result = BigDecimal.ZERO;

        for (BigDecimal num : numbers) {
            result = result.add(num);
        }

        return result;
    }
}
