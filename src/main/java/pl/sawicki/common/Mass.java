package pl.sawicki.common;

import pl.sawicki.PhysicalQuantity;

import java.util.Objects;

public class Mass implements PhysicalQuantity<MassUnits> {

    public static final Mass PHYSICAL_MIN_LIMIT = Mass.ofKilograms(0);
    private final double value;
    private final double baseValue;
    private final MassUnits unit;

    public Mass(double value,MassUnits unit) {
        this.value = value;
        this.unit = unit;
        this.baseValue = unit.toValueInBaseUnit(value);
    }

    public static Mass of(double value,MassUnits unit){
        return new Mass(value,unit);
    }
    public static Mass ofKilograms(double value) {
        return new Mass(value, MassUnits.KILOGRAM);
    }
    public static Mass ofMilligrams(double value) {
        return new Mass(value, MassUnits.MILLIGRAM);
    }
    public static Mass ofGrams(double value) {
        return new Mass(value, MassUnits.GRAM);
    }
    public static Mass ofTonnes(double value) {
        return new Mass(value, MassUnits.TONNE);
    }
    public static Mass ofCarats(double value) {
        return new Mass(value,MassUnits.CARAT);
    }
    public static Mass ofPounds(double value) {
        return new Mass(value, MassUnits.POUND);
    }
    public static Mass ofOunces(double value) {
        return new Mass(value, MassUnits.OUNCE);
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public double getBaseValue() {
        return baseValue;
    }

    @Override
    public MassUnits getUnit() {
        return unit;
    }

    @Override
    public Mass toBaseUnit() {
        double valueInKilogram = unit.toValueInBaseUnit(value);
        return Mass.of(valueInKilogram, MassUnits.KILOGRAM);
    }

    @Override
    public Mass toUnit(MassUnits targetUnit) {
        double valueInKilogram = unit.toValueInBaseUnit(value);
        double valueInTargetUnit = targetUnit.fromValueInBaseUnit(valueInKilogram);
        return Mass.of(valueInTargetUnit,targetUnit);
    }
    public Mass toKilogram() {
        return toUnit(MassUnits.KILOGRAM);
    }
    public Mass toMilligram() {
        return toUnit(MassUnits.MILLIGRAM);
    }
    public Mass toGram() {
        return toUnit(MassUnits.GRAM);
    }
    public Mass toTonne() {
        return toUnit(MassUnits.TONNE);
    }
    public Mass toCarat() {
        return toUnit(MassUnits.CARAT);
    }
    public Mass toPound() {
        return toUnit(MassUnits.POUND);
    }
    public Mass toOunce() {
        return toUnit(MassUnits.OUNCE);
    }

    public double getIntoKilograms() {
        return getIn(MassUnits.KILOGRAM);
    }
    public double getIntoGrams() {
        return getIn(MassUnits.GRAM);
    }
    public double getIntoMilligrams() {
        return getIn(MassUnits.MILLIGRAM);
    }
    public double getIntoTonnes() {
        return getIn(MassUnits.TONNE);
    }
    public double getIntoPound() {
        return getIn(MassUnits.POUND);
    }
    public double getIntoCarat() {
        return getIn(MassUnits.CARAT);
    }
    public double getIntoOunces() {
        return getIn(MassUnits.OUNCE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mass inputQuantity = (Mass) o;
        return Double.compare(inputQuantity.toBaseUnit().value, baseValue) == 0 && Objects.equals(unit.getBaseUnit(), inputQuantity.getUnit().getBaseUnit());
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseValue, unit.getBaseUnit());
    }

    @Override
    public String toString() {
        return "Mass{ " + value + " " + unit.getSymbol() + '}';
    }
}
