package domainTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import domain.YourPurchases;

@DisplayName("Test Customer Application Domain")
@TestMethodOrder(OrderAnnotation.class)
public class YourPurchases_Test {

    @BeforeEach
    void setUp() throws Exception {
        // Initialize any preconditions or set up necessary objects here if needed
    }

    @AfterEach
    void tearDown() throws Exception {
        // Reset any changes made by the tests if necessary
    }

    @Nested
    @DisplayName("create Test")
    @TestMethodOrder(OrderAnnotation.class)
    class ConstructorTest {
        
        @Test
        @Order(1)
        @DisplayName("create Test")
        final void testCustomerCreate() {
            try {
                YourPurchases purchases = new YourPurchases();
                assertNotNull(purchases, "The YourPurchases object should not be null after creation.");
                System.out.println(purchases);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Nested
    @DisplayName("recordPurchase() Test")
    @TestMethodOrder(OrderAnnotation.class)
    class recordPurchaseTest {

        @Test
        @Order(1)
        @DisplayName("recordPurchase() test with Null arguments")
        final void testRecordPurchaseWithNullArguments() {
            YourPurchases purchases = new YourPurchases();
            // Test if purchase amount remains zero when null or no argument is provided.
            purchases.recordPurchase(0);
            assertEquals(0.0, purchases.giveChange(), "Purchase amount should be zero if no valid amount was added.");
        }

        @Test
        @Order(2)
        @DisplayName("recordPurchase() test with valid arguments")
        final void testRecordPurchaseWithValidArguments() {
        	YourPurchases purchases = new YourPurchases();
            purchases.recordPurchase(20.0);
            purchases.receivePayment(20, 0, 0, 0, 0); // Add payment to balance the purchase
            assertEquals(0.0, purchases.giveChange(), "The change should be zero after a balanced payment.");
        }
    }

    @Nested
    @DisplayName("receivePayment() Test")
    @TestMethodOrder(OrderAnnotation.class)
    class ReceivePaymentTest {

        @Test
        @Order(1)
        @DisplayName("receivePayment() test with Null arguments")
        final void testReceivePaymentWithNullArguments() {
            YourPurchases purchases = new YourPurchases();
            purchases.receivePayment(0, 0, 0, 0, 0);
            assertEquals(0.0, purchases.giveChange(), "The payment should be zero when no coins or dollars are provided.");
        }

        @Test
        @Order(2)
        @DisplayName("receivePayment() test with valid arguments")
        final void testReceivePaymentWithValidArguments() {
            YourPurchases purchases = new YourPurchases();
            purchases.recordPurchase(5.0);
            purchases.receivePayment(5, 4, 0, 0, 0); // $5 + 4 quarters
            assertEquals(1.0, purchases.giveChange(), "The change should be $1.00 after payment.");
        }
    }

    @Nested
    @DisplayName("giveChange() Test")
    @TestMethodOrder(OrderAnnotation.class)
    class GiveChangeTest {

        @Test
        @Order(1)
        @DisplayName("giveChange() test with Null arguments")
        final void testGiveChangeWithNullArguments() {
            YourPurchases purchases = new YourPurchases();
            double change = purchases.giveChange();
            assertEquals(0.0, change, "Change should be zero if no payment was received or purchase recorded.");
        }

        @Test
        @Order(2)
        @DisplayName("giveChange() test after valid payment")
        final void testGiveChangeAfterValidPayment() {
            YourPurchases purchases = new YourPurchases();
            purchases.recordPurchase(10.0);
            purchases.receivePayment(15, 0, 0, 0, 0); // $15 payment
            double change = purchases.giveChange();
            assertEquals(5.0, change, "Change should be $5.00 after payment.");
        }
    }
}
