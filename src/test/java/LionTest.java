package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LionTest {

    @Mock
    private Feline feline;

    @Test
    void testLionConstructorMale() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    void testLionConstructorFemale() throws Exception {
        Lion lion = new Lion("Самка", feline);
        assertFalse(lion.doesHaveMane());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "Неизвестный", "123"})
    void testLionConstructorInvalidSex(String invalidSex) {
        Exception exception = assertThrows(Exception.class, () ->
                new Lion(invalidSex, feline));

        assertTrue(exception.getMessage().contains("Используйте допустимые значения пола животного"));
    }

    @Test
    void testGetKittensReturnsCorrectValue() throws Exception {
        Lion lion = new Lion("Самец", feline);
        when(feline.getKittens()).thenReturn(3);

        assertEquals(3, lion.getKittens());
    }

    @Test
    void testGetKittensCallsFelineMethod() throws Exception {
        Lion lion = new Lion("Самец", feline);
        when(feline.getKittens()).thenReturn(3);

        lion.getKittens();

        verify(feline, times(1)).getKittens();
    }

    @Test
    void testGetFoodReturnsCorrectFood() throws Exception {
        Lion lion = new Lion("Самец", feline);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");

        when(feline.eatMeat()).thenReturn(expectedFood);

        List<String> actualFood = lion.getFood();

        assertEquals(expectedFood, actualFood);
    }

    @Test
    void testGetFoodCallsEatMeatOnce() throws Exception {
        Lion lion = new Lion("Самец", feline);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");

        when(feline.eatMeat()).thenReturn(expectedFood);

        lion.getFood();

        verify(feline, times(1)).eatMeat();
    }

    @Test
    void testGetFoodException() throws Exception {
        Lion lion = new Lion("Самец", feline);

        when(feline.eatMeat()).thenThrow(new Exception("Test exception"));

        assertThrows(Exception.class, lion::getFood);
    }

    @Test
    void testGetFoodExceptionVerifyCall() throws Exception {
        Lion lion = new Lion("Самец", feline);

        when(feline.eatMeat()).thenThrow(new Exception("Test exception"));

        assertThrows(Exception.class, lion::getFood);
        verify(feline, times(1)).eatMeat();
    }
}