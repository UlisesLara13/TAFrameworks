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
     * Private constructor to enforce object creation through Builder.
     *
     * @param builder the Builder instance containing checkout data
     */
    private CheckoutData(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.zipCode = builder.zipCode;
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
     * Builder class for CheckoutData.
     * Provides a flexible way to construct CheckoutData objects.
     */
    public static class Builder {

        private String firstName;
        private String lastName;
        private String zipCode;

        /**
         * Sets the first name.
         *
         * @param firstName the first name
         * @return Builder instance
         */
        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        /**
         * Sets the last name.
         *
         * @param lastName the last name
         * @return Builder instance
         */
        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        /**
         * Sets the zip code.
         *
         * @param zipCode the postal code
         * @return Builder instance
         */
        public Builder setZipCode(String zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        /**
         * Builds CheckoutData instance.
         *
         * @return CheckoutData object
         */
        public CheckoutData build() {
            return new CheckoutData(this);
        }
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