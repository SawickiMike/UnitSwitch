package pl.sawicki;

import java.util.Objects;

public interface PhysicalQuantity<U extends Unit> extends Comparable<PhysicalQuantity<U>> {

    int FORMATTING_RELEVANT_DIGITS = 4;

    /**
     * Get the value of the physical quantity.
     *
     * @return The value of the physical quantity.
     */
    double getValue();

    /**
     * Get value of the physical quantity in its base unit.
     *
     * @return The base value of the physical quantity.
     */
    double getBaseValue();

    /**
     * Get the unit associated with the physical quantity.
     *
     * @return The unit associated with the physical quantity.
     */
    U getUnit();

    /**
     * Convert the physical quantity to its base unit.
     *
     * @return A new physical quantity converted to its base unit.
     */
    PhysicalQuantity<U> toBaseUnit();

    /**
     * Convert the physical quantity to a target unit.
     *
     * @param targetUnit The target unit to convert to.
     * @return A new physical quantity converted to the target unit.
     */
    PhysicalQuantity<U> toUnit(U targetUnit);

    /**
     * Returns a converted value to target unit of the same type.
     *
     * @param targetUnit TThe target unit for conversion.
     * @return A value converted to target unit.
     */
    default double getIn(U targetUnit) {
        return targetUnit.fromValueInBaseUnit(getBaseValue());
    }

    @Override
    default int compareTo(PhysicalQuantity<U> other) {
        if (this == other) {
            return 0;
        }
        // Convert both quantities to the same unit for comparison
        PhysicalQuantity<U> thisInOtherUnit = this.toUnit(other.getUnit());

        // Compare the values of the two quantities
        double thisValue = thisInOtherUnit.getValue();
        double otherValue = other.getValue();

        return Double.compare(thisValue, otherValue);
    }
}
