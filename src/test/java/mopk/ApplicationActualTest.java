/**
 * Created by Mopk
 * on 2014-06-30 07:39.
 */
package mopk;

import org.apache.commons.math3.util.Precision;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class ApplicationActualTest {


    /**
     * Проверяет, действительно ли программа выдаёт результат деления
     * с точностью до второго знака.
     */
    @Test(dataProvider = "a")
    public void testRoundingToTwoDecimalPlaces(
            Float dividend,
            Float divisor
    ) {
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


    @SuppressWarnings("UnnecessaryLocalVariable")
    @DataProvider(name = "a")
    public Object[][] fetchParametersForPrecisionTest() {
        Object[][] parameters =
                new Object[][]{
                        { 32.1f, 3.7f },

                        // 2-й тест с тем же результатом (относительно точности
                        // результата вычислений) лишь для того, чтобы снизить
                        // вероятность случайной корректности результатов
                        // первого и второго тестов
                        { 2f, 3f }


                        // TODO 2014-06-30 13:26 alexander:
                        // либо сюда, либо в отдельный набор для отдельного
                        // тестового метода добавить пары параметров, для
                        // которых точность частного (quotient) не должна быть
                        // изменена в соответствии со спецификацией тестируемой
                        // программы (см. протокол ручного тестирования)
                };
        return parameters;
    }


//    @Test
    public void testInputOf1stParameter() {}

//    @Test
    public void testInputOf2ndParameter() {}


    // TODO 2014-06-30 13:21 alexander:
    //      - реализовать тесты на основании протокола ручного тестирования,
    //      - затем попробовать добавить синтаксические тесты (гл. 8, Бейзер);
    //
    //      - добавить тестирование доменов параметров (гл. 7, Бейзер);
    //      - при уточнении спецификации, если будет необходимо, реализовать
    //      покрытие тестами циклов (управляющего потока) ввода параметров
    //      (гл. 4, Бейзер)
}