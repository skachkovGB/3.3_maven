package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TriangleTest {

    private static final Logger logger = LoggerFactory.getLogger(TriangleTest.class);
    private static final Triangle triangleForTest = new Triangle();

    @Test
    void simpleTest() {
        Supplier<String> randomSupplier = () -> Double.toString(Math.random());
        logger.error(randomSupplier);
        assertTrue(true);
        logger.info(() -> Double.toString(Math.random()));
    }
    @Test
    void simpleTest2 () {
        Supplier<String> info = ()-> "info"; // в скобках можно написать то, что хотите вывести на экран
        logger.info (info);
    }

    @Test
    //@Order(1)
    @DisplayName("a/b/c=0")
    void checkNullSide() throws MyTriangleException{
        Assertions.assertThrows(MyTriangleException.class,() -> triangleForTest.areaTriangle(0,4,5));
    }

    @Test
    //@Order(2)
    @DisplayName("a/b/c<0")
    void checkNegativeSide() throws MyTriangleException{
        Assertions.assertThrows(MyTriangleException.class,() -> triangleForTest.areaTriangle(-2,4,5));
    }

    @Test
    //@Order(3)
    @DisplayName("a+b<c")
    void checkSumNotTriangle() throws MyTriangleException{
        Assertions.assertThrows(MyTriangleException.class,() -> triangleForTest.areaTriangle(10,4,5));
    }

    @Test
    //@Order(4)
    @DisplayName("equals correct calculations")
    void checkCorrectResult() throws MyTriangleException{
        Assertions.assertEquals(6 , triangleForTest.areaTriangle(3,4,5));
    }

    @ParameterizedTest
    @CsvSource({"15.59,6,6,6"})
    //@Order(5)
    @DisplayName("parametrize correct calculations rounding")
    void checkResultWithCsvSourceRounding(double result, int a, int b, int c) throws MyTriangleException{
        Assertions.assertEquals(result , Math.round(triangleForTest.areaTriangle(a,b,c)*100.0)/100.0);
    }

//    @ParameterizedTest
//    @CsvSource({"6,3,4,5","15.588457268119896,6,6,6", "15.58845726,6,6,6", "6,0,4,5"})
//    @Order(6)
//    @DisplayName("parametrize correct calculations")
//    void checkResultWithCsvSource(double result, int a, int b, int c) throws MyTriangleException{
//        Assertions.assertEquals(result , triangleForTest.areaTriangle(a,b,c));
//    }
}