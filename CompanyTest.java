import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class CompanyTest {

    private Company company;
    private User client1, client2, seller1, seller2;
    private Property property1, property2;

    @Before
    public void setUp() {
        company = new Company();
        client1 = new User("José Manuel", "911111111", "zemanel@yahoo.com");
        client2 = new User("António Francisco", "922222222", "tochico@hotmail.com");
        seller1 = new User("Fernando Fernandes", "966777101", "fefe@remax.pt");
        seller2 = new User("Rodrigo Rodrigues", "966777152", "roro@remax.pt");
        property1 = new Property("T3 Monte Belo", 150000.0, 1);
        property2 = new Property("T2 Jardins", 200000.0, 2);
    }

    @Test
    public void testConstructor() {
        assertNotNull(company.getClients());
        assertNotNull(company.getSellers());
        assertNotNull(company.getProperties());
        assertNotNull(company.getSells());

    }

    @Test
    public void testRegisterClient() {
        assertTrue(company.registerClient(client1));
        assertTrue(company.getClients().contains(client1));
    }

    @Test
    public void testRegisterClients() {
        assertTrue(company.registerClient(client1));
        assertTrue(company.registerClient(client2));
        assertTrue(company.getClients().contains(client1));
        assertTrue(company.getClients().contains(client2));
    }

    @Test
    public void testRegisterClientDuplicate() {
        assertTrue(company.registerClient(client1));
        assertFalse(company.registerClient(client1));
        assertEquals(1, company.getClients().size());
    }

    @Test
    public void testRegisterClientNull() {
        assertFalse(company.registerClient(null));
        assertEquals(0, company.getClients().size());
    }

    @Test
    public void testRegisterSeller() {
        assertTrue(company.registerSeller(seller1));
        assertTrue(company.getSellers().contains(seller1));
    }

    @Test
    public void testRegisterSellers() {
        assertTrue(company.registerSeller(seller1));
        assertTrue(company.registerSeller(seller2));
        assertTrue(company.getSellers().contains(seller1));
        assertTrue(company.getSellers().contains(seller2));
    }

    @Test
    public void testRegisterSellerDuplicate() {
        assertTrue(company.registerSeller(seller1));
        assertFalse(company.registerSeller(seller1));
        assertEquals(1, company.getSellers().size());
    }

    @Test
    public void testRegisterSellerNull() {
        assertFalse(company.registerSeller(null));
        assertEquals(0, company.getSellers().size());
    }

    @Test
    public void testRegisterProperty() {
        assertTrue(company.registerProperty(property1));
        assertTrue(company.getProperties().contains(property1));
    }

    @Test
    public void testRegisterProperties() {
        Property property2 = new Property("T2 Jardins", 200000.0, 2);
        assertTrue(company.registerProperty(property1));
        assertTrue(company.registerProperty(property2));
        assertTrue(company.getProperties().contains(property1));
        assertTrue(company.getProperties().contains(property2));
    }

    @Test
    public void testRegisterPropertyDuplicate() {
        assertTrue(company.registerProperty(property1));
        assertFalse(company.registerProperty(property1));
        assertEquals(1, company.getProperties().size());
    }

    @Test
    public void testRegisterPropertyNull() {
        assertFalse(company.registerProperty(null));
        assertEquals(0, company.getProperties().size());
    }

    @Test
    public void testCreateSell() {
        assertTrue(company.registerClient(client1));
        assertTrue(company.registerSeller(seller1));
        assertTrue(company.registerProperty(property1));
        assertTrue(company.createSell(client1, seller1, property1));
        assertEquals(1, company.getSells().size());
    }

    @Test
    public void testCalculateSellsOfTheYear() {
        assertTrue(company.registerClient(client1));
        assertTrue(company.registerSeller(seller1));
        assertTrue(company.registerProperty(property1));
        assertTrue(company.createSell(client1, seller1, property1));
        assertEquals(1, company.calculateSellsOfTheYear(2024));
    }

    @Test
    public void testFindSellerOfTheYear() {
        assertTrue(company.registerClient(client1));
        assertTrue(company.registerClient(client2));
        assertTrue(company.registerSeller(seller1));
        assertTrue(company.registerSeller(seller2));
        assertTrue(company.registerProperty(property1));
        assertTrue(company.registerProperty(property2));

        assertTrue(company.createSell(client1, seller1, property1));
        assertTrue(company.createSell(client2, seller2, property2));

        assertEquals(seller1.getName(), company.findSellerOfTheYear(2024));
    }

}
