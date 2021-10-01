package ru.geekbrains.homework4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static ru.geekbrains.homework4.Triangle.calculateTriangleSquare;

public class TriangleTest {

    @Test
    void positiveTriangleSquareTest() throws TriangleNotExistsException, DegenerateTriangleException {
        double result = calculateTriangleSquare(3,4,5);
        Assertions.assertEquals(6, result);
    }

    @Test
    void negativeSidesTest() {
        assertThatExceptionOfType(TriangleNotExistsException.class)
                .isThrownBy(() -> calculateTriangleSquare(-3,4,5));
    }

    @Test
    void degenerateTriangleTest() {
        assertThatExceptionOfType(DegenerateTriangleException.class)
                .isThrownBy(() -> calculateTriangleSquare(3,4,8));
    }





}
