import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;
public class IngredientTest {
    private final String expectedName = "cheese";
    private final float expectedPrice = 100.0f;
    private Ingredient ingredient;
    @Mock
    private IngredientType type;
    @Before
    public void setUp(){
        ingredient = new Ingredient(type,  expectedName,  expectedPrice);
    }
    @Test
    public void getPriceTest(){
        assertEquals(expectedPrice, ingredient.getPrice(), 0.001);
    }
    @Test
    public void getNameTest(){
        assertEquals(expectedName, ingredient.getName());
    }
    @Test
    public void getTypeTest(){
        assertEquals(type, ingredient.getType());
    }
    @Test
    public void ingredientTest(){
        assertEquals(expectedPrice, ingredient.price, 0.001);
        assertEquals(expectedName, ingredient.name);
        assertEquals(type, ingredient.type);
    }
}
