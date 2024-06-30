import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
    public class BunTest {
        private final String expectedName;
        private final float expectedPrice;
        private Bun bun;
    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"Флюоресцентная булка", 988.0f},
                {"", 988.0f},
                {null, 988.0f},
                {"Special burger", 988.0f},
                {"&/*;как сюда попали эти символы?", Float.MIN_VALUE},
                {"Normal Burger", Float.MAX_VALUE},
                {"Eat Meat", 988.345f}
                // если вместо price - null - падаем(*пошел искать требования:))
        };
    }
    public BunTest(String name, float price)  {
        this.expectedName = name;
        this.expectedPrice = price;
        }
    @Before
    public void setUp() {
        bun = new Bun(expectedName, expectedPrice);
     }
    @Test
    public void bunTest(){
        assertEquals(expectedName, bun.name);
        assertEquals(expectedPrice, bun.price, 0.001);
        }
    @Test
    public void getNameTest(){
        assertEquals(expectedName, bun.getName());
   }
    @Test
    public void getPriceTest(){
        assertEquals(expectedPrice, bun.getPrice(),0.001);
    }
}
