import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;
    @Mock
    private Ingredient ingredient1;
    @Before
    public void setUp() {
        burger = new Burger();
        burger.bun = this.bun;
    }
    @Test
    public void setBunsTest(){
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }
    @Test
    public void addIngredientTest() {
       // ingredients.add(ingredient);
        burger.addIngredient(ingredient);
       // assertEquals(ingredients, burger.ingredients);
        assertTrue(burger.ingredients.contains(ingredient));
    }
    @Test
    public void removeIngredientTest(){
        burger.ingredients.add(ingredient);
        int size = burger.ingredients.size();
        burger.removeIngredient(0);
        assertEquals(size-1, burger.ingredients.size());
        }
    @Test
    public void moveIngredientTest(){
        burger.ingredients.add(ingredient);
        burger.ingredients.add(ingredient1);
        burger.moveIngredient(0,1);
        assertEquals(1, burger.ingredients.indexOf(ingredient));
    }
    @Test
    public void getPriceTest(){
        burger.ingredients.add(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(10F);
        Mockito.when(ingredient.getPrice()).thenReturn(50F);
        assertEquals(70F,burger.getPrice(), 0.001);
    }
    @Test
    public void getReceiptTest(){
        String expectedBun = "вкусная булка";
        String expectedIng = "вкусная начинка";
        float expectedPrice = 1000f;
        Mockito.when(bun.getName()).thenReturn(expectedBun);
        burger.ingredients.add(ingredient);
        Mockito.when(ingredient.getName()).thenReturn(expectedIng);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(burger.getPrice()).thenReturn(expectedPrice);

        String expectedReceipt = String.format("(==== %s ====)%n", expectedBun)
                + String.format("= %s %s =%n", IngredientType.SAUCE.toString().toLowerCase(), expectedIng) +
                String.format("(==== %s ====)%n", expectedBun) +
                String.format("%nPrice: %f%n", expectedPrice);
        assertEquals(expectedReceipt,burger.getReceipt());
    }

    }





