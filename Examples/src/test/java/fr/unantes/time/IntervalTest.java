package fr.unantes.time;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class IntervalTest {
    private Interval<Integer> interval_1_10;

    @BeforeEach
    void setup() {
        interval_1_10 = new Interval<>(0, 10);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10})
    void testIncludes(int value) {
        assertTrue(interval_1_10.includes(value));
    }

    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, -1, 11, Integer.MAX_VALUE})
    void testNotIncludes(int value) {
        assertFalse(interval_1_10.includes(value));
    }
}