/**
 * Created by Mopk
 * on 2014-06-30 07:39.
 */
package mopk;

import org.apache.commons.math3.util.Precision;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ActualTestOfApp {

    /**
     * Проверяет, действительно ли программа выдаёт результат деления
     * с точностью до второго знака.
     */
    @Test
    public void testRoundingToTwoDecimalPlaces() {
        Float dividend = 32.1f;
        Float divisor = 3.7f;
        List<String> outputAndErrorLines =
                RunnerOfCalcDiv.runCalcDiv(
                    dividend.toString(),
                    divisor.toString()
                );
        String quotientReturned = outputAndErrorLines.get(0);
        Float quotientActual = new Float(quotientReturned);
        Float quotientExpected =
                Precision.round(
                        ( dividend / divisor ),
                        2
                );
        Assert.assertEquals(
                quotientActual,
                quotientExpected,
                "\nSoftware outputs result with another\n"
                        +
                    "decimal precision than stated.\n"
                            +
                        "(Actual precision is not 2 decimal place of accuracy)!"
        );
    }

}