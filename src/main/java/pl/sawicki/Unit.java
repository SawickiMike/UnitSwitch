package pl.sawicki;

public interface Unit {

    /**
     *  Get symbol for the unit.
     *
     * @return The symbol related with unit.
     */
    String getSymbol();

    /**
     * Get the base Unit
     *
     * @return The base unit for the quantity type.
     */
    Unit getBaseUnit();

    /**
     * Convert a value from this unit to the base unit.
     *
     * @return The equivalent value in the base unit.
     */
    double toValueInBaseUnit(double valueInThisUnit);


    /**
     * Convert a value from the base init to the equivalent value in this unit.
     *
     * @return The equivalent value in this unit.
     */
    double fromValueInBaseUnit(double valueInBaseUnit);
}
