import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

    public class PropertyTest {

        @Test
        public void testConstructor() {
            // Criando um objeto Property com os valores fornecidos na Tabela 1
            Property property1 = new Property("T3 Monte Belo", 150000.0, 1);

            // Verificando se o construtor inicializou o objeto com os valores corretos
            assertEquals("T3 Monte Belo", property1.getDescription());
            assertEquals(150000.0, property1.getPrice(), 0.001);
        }
        @Test
        public void testToString() {
            Property property1 = new Property("T3 Monte Belo", 150000.0, 1);

            String expectedString = "Descricao   : T3 Monte Belo\nPreco       : 150000.0 Euros";
            assertEquals(expectedString, property1.toString());
        }
    }