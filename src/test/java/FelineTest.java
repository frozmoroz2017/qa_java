 package com.example;
 import org.junit.jupiter.api.Test;
 import org.junit.jupiter.params.ParameterizedTest;
 import org.junit.jupiter.params.provider.ValueSource;

 import java.util.List;

 import static org.junit.jupiter.api.Assertions.*;

 class FelineTest {

     @Test
     void testEatMeat() throws Exception {
         Feline feline = new Feline();
         List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
         assertEquals(expectedFood, feline.eatMeat());
     }

     @Test
     void testGetFamily() {
         Feline feline = new Feline();
         assertEquals("Кошачьи", feline.getFamily());
     }

     @Test
     void testGetKittensWithoutParameters() {
         Feline feline = new Feline();
         assertEquals(1, feline.getKittens());
     }

     @ParameterizedTest
     @ValueSource(ints = {0, 1, 5, 10})
     void testGetKittensWithParameters(int kittensCount) {
         Feline feline = new Feline();
         assertEquals(kittensCount, feline.getKittens(kittensCount));
     }
 }