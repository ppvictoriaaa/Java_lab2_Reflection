package org.example;

import org.example.validation.*;

/**
 * A utility class for validating objects of type {@link Person}, {@link Car}, and {@link Medicine}.
 *
 * This class performs manual validation of fields using the annotations {@link NotNull}, {@link StringLength},
 * {@link MinValue}, and {@link MaxValue}, without using reflection to inspect annotations. It checks the
 * constraints on the fields directly.
 *
 * @see Person
 * @see Car
 * @see Medicine
 * @see NotNull
 * @see StringLength
 * @see MinValue
 * @see MaxValue
 */
public class ValidatorNoReflection {

    /**
     * Validates the fields of a {@link Person} object.
     *
     * @param person The {@link Person} object to be validated.
     * @throws IllegalArgumentException If any validation fails (e.g., a field is null, or a value is out of bounds).
     */
    public static void validatePerson(Person person) throws IllegalArgumentException {
        // Validation for @NotNull on 'name' field
        if (person.getName() == null) {
            throw new IllegalArgumentException("Field 'name' must not be null.");
        }

        // Validation for @StringLength on 'job' field
        if (person.getJob() != null) {
            int jobLength = person.getJob().length();
            StringLength jobLengthAnnotation = Person.class.getDeclaredFields()[1].getAnnotation(StringLength.class);
            if (jobLength < jobLengthAnnotation.min() || jobLength > jobLengthAnnotation.max()) {
                throw new IllegalArgumentException("Field 'job' length must have from " + jobLengthAnnotation.min() +
                        " to " + jobLengthAnnotation.max() + " symbols");
            }
        }

        // Validation for @MinValue and @MaxValue on 'age' field
        if (person.getAge() != null) {
            if (person.getAge() < 18) {
                throw new IllegalArgumentException("Field 'age' must not be less than 18.");
            }
            if (person.getAge() > 100) {
                throw new IllegalArgumentException("Field 'age' must not be greater than 100.");
            }
        }
    }

    /**
     * Validates the fields of a {@link Car} object.
     *
     * @param car The {@link Car} object to be validated.
     * @throws IllegalArgumentException If any validation fails (e.g., a field is null, or a value is out of bounds).
     */
    public static void validateCar(Car car) throws IllegalArgumentException {
        // Validation for @NotNull on 'brand' field
        if (car.getBrand() == null) {
            throw new IllegalArgumentException("Field 'brand' must not be null.");
        }

        // Validation for @StringLength on 'modal' field
        if (car.getModal() != null) {
            int modalLength = car.getModal().length();
            StringLength modalLengthAnnotation = Car.class.getDeclaredFields()[1].getAnnotation(StringLength.class);
            if (modalLength < modalLengthAnnotation.min() || modalLength > modalLengthAnnotation.max()) {
                throw new IllegalArgumentException("Field 'modal' length must have from " + modalLengthAnnotation.min() +
                        " to " + modalLengthAnnotation.max() + " symbols");
            }
        }

        // Validation for @MinValue and @MaxValue on 'year' field
        if (car.getYear() != null) {
            if (car.getYear() < 1990) {
                throw new IllegalArgumentException("Field 'year' must not be less than 1990.");
            }
            if (car.getYear() > 2024) {
                throw new IllegalArgumentException("Field 'year' must not be greater than 2024.");
            }
        }
    }

    /**
     * Validates the fields of a {@link Medicine} object.
     *
     * @param medicine The {@link Medicine} object to be validated.
     * @throws IllegalArgumentException If any validation fails (e.g., a field is null, or a value is out of bounds).
     */
    public static void validateMedicine(Medicine medicine) throws IllegalArgumentException {
        // Validation for @NotNull on 'name' field
        if (medicine.getName() == null) {
            throw new IllegalArgumentException("Field 'name' must not be null.");
        }

        // Validation for @StringLength on 'assignment' field
        if (medicine.getAssignment() != null) {
            int assignmentLength = medicine.getAssignment().length();
            StringLength assignmentLengthAnnotation = Medicine.class.getDeclaredFields()[1].getAnnotation(StringLength.class);
            if (assignmentLength < assignmentLengthAnnotation.min() || assignmentLength > assignmentLengthAnnotation.max()) {
                throw new IllegalArgumentException("Field 'assignment' length must have from " +
                        assignmentLengthAnnotation.min() + " to " + assignmentLengthAnnotation.max() + " symbols");
            }
        }

        // Validation for @MinValue on 'minAge' field
        if (medicine.getMinAge() != null) {
            if (medicine.getMinAge() < 12) {
                throw new IllegalArgumentException("Field 'minAge' must not be less than 12.");
            }
        }

        // Validation for @MaxValue on 'maxAge' field
        if (medicine.getMaxAge() != null) {
            if (medicine.getMaxAge() > 80) {
                throw new IllegalArgumentException("Field 'maxAge' must not be greater than 80.");
            }
        }
    }
}

