package com.epam.training.student_ulises_lara.model;

import java.util.Objects;

/**
 * Represents checkout information with first name, last name and zip code.
 */
public class CheckoutData {

    private final String firstName;
    private final String lastName;
    private final String zipCode;

    /**
     * Constructs CheckoutData with the specified values.
     *
     * @param firstName the first name
     * @param lastName the last name
     * @param zipCode the postal code
     */
    public CheckoutData(String firstName, String lastName, String zipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.zipCode = zipCode;
    }

    /**
     * Returns the first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns the last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns the zip code.
     *
     * @return the zip code
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Returns a string representation of the CheckoutData.
     *
     * @return a string representation
     */
    @Override
    public String toString() {
        return "CheckoutData{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }

    /**
     * Compares this object to another for equality.
     *
     * @param o the object to compare
     * @return true if equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CheckoutData)) return false;
        CheckoutData that = (CheckoutData) o;
        return Objects.equals(getFirstName(), that.getFirstName()) &&
                Objects.equals(getLastName(), that.getLastName()) &&
                Objects.equals(getZipCode(), that.getZipCode());
    }

    /**
     * Returns hash code for this object.
     *
     * @return hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getZipCode());
    }
}