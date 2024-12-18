# JUnit-testing

## Overview

YourPurchases is a Java-based application simulating a cash register system. It allows users to record purchases, receive payments in various denominations, calculate the change due, and reset for the next transaction. This project includes both the implementation and unit tests to ensure functionality and correctness.

## Features

- **Record Purchases**: Add the price of items to the purchase total.
- **Receive Payments**: Accept payments in dollars and coins (quarters, dimes, nickels, and pennies).
- **Calculate Change**: Compute the change owed to the customer based on the purchase total and payment received.
- **Reset After Transaction**: Reset the purchase and payment amounts for the next customer.
- **Unit Testing**: Comprehensive JUnit tests to validate the functionality.

---

## Project Structure

The project is organized into the following packages and classes:

### **Package: `domain`**

- **`YourPurchases`**
  - Contains the main logic for recording purchases, receiving payments, and calculating change.

### **Package: `domainTest`**

- **`YourPurchases_Test`**
  - Implements unit tests using JUnit 5 to verify the functionality of the `YourPurchases` class.

---

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- An IDE or text editor for Java development (e.g., IntelliJ IDEA, Eclipse, or VS Code)
- Maven or Gradle for dependency management (optional but recommended)

### Running the Application

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/YourPurchases.git
   cd YourPurchases
   ```

2. Compile the Java files:
   ```bash
   javac domain/*.java
   ```

3. Run the application (for testing):
   ```bash
   java domain.YourPurchases
   ```

### Running the Unit Tests

1. Make sure JUnit 5 is configured in your project. Most IDEs support this natively.

2. Run the tests using your IDE or the command line:
   ```bash
   javac -cp .:junit-platform-console-standalone-1.9.3.jar domainTest/*.java
   java -jar junit-platform-console-standalone-1.9.3.jar --classpath . --scan-classpath
   ```

---

## Usage

### Example

```java
YourPurchases purchases = new YourPurchases();

// Record a purchase
purchases.recordPurchase(10.0);

// Customer pays $15
purchases.receivePayment(15, 0, 0, 0, 0);

// Calculate and display the change
System.out.println("Change: $" + purchases.giveChange()); // Outputs: Change: $5.0
```

---

## Testing Details

### **Tests Implemented**

#### **Constructor Tests**
- Verify the object is created successfully.

#### **recordPurchase() Tests**
- Validate that the purchase total updates correctly.
- Test with edge cases like zero or negative values.

#### **receivePayment() Tests**
- Ensure payment amounts are calculated correctly.
- Test scenarios with various coin and dollar combinations.

#### **giveChange() Tests**
- Confirm correct change calculation.
- Verify reset functionality after change is given.

### **How to Run Tests**
Tests are structured using JUnit 5. Use your IDE's test runner or execute them via the command line as shown above.

---

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository.
2. Create a feature branch.
3. Commit your changes.
4. Push to your fork.
5. Submit a pull request.

---

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

## Contact

For questions or feedback, feel free to reach out:

- **Email**: your.email@example.com
- **GitHub**: [your-username](https://github.com/your-username)

---

## Acknowledgments

- Inspiration for this project comes from hands-on practice and academic learning.
- Thanks to JUnit for providing a robust testing framework.

