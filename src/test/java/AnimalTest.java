 package com.example;
 import org.junit.jupiter.api.Test;
 import org.junit.jupiter.params.ParameterizedTest;
 import org.junit.jupiter.params.provider.ValueSource;

 import java.util.List;

 import static org.junit.jupiter.api.Assertions.*;

 class AnimalTest {

     @Test
     void testGetFoodForHerbivore() throws Exception {
         Animal animal = new Animal();
         List<String> expectedFood = List.of("Трава", "Различные растения");
         assertEquals(expectedFood, animal.getFood("Травоядное"));
     }

     @Test
     void testGetFoodForPredator() throws Exception {
         Animal animal = new Animal();
         List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
         assertEquals(expectedFood, animal.getFood("Хищник"));
     }

     @ParameterizedTest
     @ValueSource(strings = {"", "Всеядное", "Насекомоядное"})
     void testGetFoodForUnknownType(String unknownType) {
         Animal animal = new Animal();
          Exception exception = assertThrows(Exception.class, () ->
                 animal.getFood(unknownType));

         assertTrue(exception.getMessage().contains("Неизвестный вид животного"));
     }

     @Test
     void testGetFamily() {
         Animal animal = new Animal();
         String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
         assertEquals(expected, animal.getFamily());
     }
 }