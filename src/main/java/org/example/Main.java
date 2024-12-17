package org.example;

/**
 * Main class that demonstrates the validation process for {@link Person}, {@link Car}, and {@link Medicine} objects.
 * It compares the performance and correctness of validation with and without reflection.
 *
 * The program validates the fields of these objects using two validation strategies:
 * 1. Validation with reflection via the {@link Validator} class.
 * 2. Validation without reflection via the {@link ValidatorNoReflection} class.
 *
 * The program also measures the time taken for each validation process and displays the results.
 *
 * @see Person
 * @see Car
 * @see Medicine
 * @see Validator
 * @see ValidatorNoReflection
 */
public class Main {
    /**
     * The main method that demonstrates the validation process and compares the performance of validation
     * with and without reflection.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        try {
            double startTime, endTime;

            // To avoid time mismatch
            Person test = new Person("test", "test", 18);
            Validator.validate(test);
            ValidatorNoReflection.validatePerson(test);

            // Validation for Person object
            System.out.println("1) Validating Person:");

            Person person = new Person("Marta Jenkins", "Software Engineer", 18);

            // Validation with reflection
            startTime = System.nanoTime();
            Validator.validate(person); // Using Validator class with reflection
            endTime = System.nanoTime();
            System.out.println("Time for validation WITH reflection for Person: " + (endTime - startTime) / 1000000 + " ms.");
            System.out.println("Validation passed for Person!\n");

            // Validation without reflection
            startTime = System.nanoTime();
            ValidatorNoReflection.validatePerson(person); // Using ValidatorNoReflection class
            endTime = System.nanoTime();
            System.out.println("Time for validation WITHOUT reflection for Person: " + (endTime - startTime) / 1000000 + " ms.");
            System.out.println("Validation passed for Person!\n");

            // Validation for Car object
            System.out.println("2) Validating Car:");

            Car car = new Car("BMW", "X5", 2015);

            // Validation with reflection
            startTime = System.nanoTime();
            Validator.validate(car); // Using Validator class with reflection
            endTime = System.nanoTime();
            System.out.println("Time for validation WITH reflection for Car: " + (endTime - startTime) / 1000000 + " ms.");
            System.out.println("Validation passed for Car!\n");

            // Validation without reflection
            startTime = System.nanoTime();
            ValidatorNoReflection.validateCar(car); // Using ValidatorNoReflection class
            endTime = System.nanoTime();
            System.out.println("Time for validation WITHOUT reflection for Car: " + (endTime - startTime) / 1000000 + " ms.");
            System.out.println("Validation passed for Car!\n");

            // Validation for Medicine object
            System.out.println("3) Validating Medicine:");

            Medicine medicine = new Medicine("Ibuprofen", "Painkiller", 14, 75);

            // Validation with reflection
            startTime = System.nanoTime();
            Validator.validate(medicine); // Using Validator class with reflection
            endTime = System.nanoTime();
            System.out.println("Time for validation WITH reflection for Medicine: " + (endTime - startTime) / 1000000 + " ms.");
            System.out.println("Validation passed for Medicine!\n");

            // Validation without reflection
            startTime = System.nanoTime();
            ValidatorNoReflection.validateMedicine(medicine); // Using ValidatorNoReflection class
            endTime = System.nanoTime();
            System.out.println("Time for validation WITHOUT reflection for Medicine: " + (endTime - startTime) / 1000000 + " ms.");
            System.out.println("Validation passed for Medicine!\n");

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}


