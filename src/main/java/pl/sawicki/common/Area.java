package pl.sawicki.common;

import pl.sawicki.PhysicalQuantity;

import java.util.Objects;

public class Area implements PhysicalQuantity <AreaUnits> {

    public static final Area PHYSICAL_MIN_LIMIT = Area.ofSquareMeters(0);
    private final double value;
    private final double baseValue;
    private final AreaUnits unit;

    public Area(double value, AreaUnits unit) {
        this.value = value;
        this.unit = unit;
        this.baseValue = unit.toValueInBaseUnit(value);
    }

    public static Area of(double value, AreaUnits unit) {
        return new Area(value, unit);
    }

    public static Area ofSquareMeters(double value) {
        return new Area(value, AreaUnits.SQUARE_METER);
    }
    public static Area ofSquareKilometers(double value) {
        return new Area(value, AreaUnits.SQUARE_KILOMETER);
    }
    public static Area ofSquareMillimeters(double value) {
        return new Area(value,AreaUnits.SQUARE_MILLIMETER);
    }
    public static Area ofSquareFoot(double value) {
        return new Area(value, AreaUnits.SQUARE_FOOT);
    }
    public static Area ofSquareInches(double value) {
        return new Area(value, AreaUnits.SQUARE_INCH);
    }
    public static Area ofAcres(double value) {
        return new Area(value, AreaUnits.ACRE);
    }
    public static Area ofHectares(double value) {
        return new Area(value, AreaUnits.HECTARE);
    }
    public static Area ofAres(double value) {
        return new Area(value, AreaUnits.ARE);
    }
    public static Area ofSquareMiles(double value) {
        return new Area(value, AreaUnits.SQUARE_MILE);
    }
    public static Area ofSquareYards(double value) {
        return new Area(value, AreaUnits.SQUARE_YARD);
    }
    public static Area ofSquareCentimeters(double value) {
        return new Area(value, AreaUnits.SQUARE_CENTIMETER);
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
    public AreaUnits getUnit() {
        return unit;
    }

    @Override
    public Area toBaseUnit() {
        double valueInSquareMeters = unit.toValueInBaseUnit(value);
        return Area.of(valueInSquareMeters, AreaUnits.SQUARE_METER);
    }

    @Override
    public Area toUnit(AreaUnits targetUnit) {
        double valueInSquareMeters = unit.toValueInBaseUnit(value);
        double valueInTargetUnit = targetUnit.fromValueInBaseUnit(valueInSquareMeters);
        return Area.of(valueInTargetUnit, targetUnit);
    }

    public Area toSquareMeters() {
        return toUnit(AreaUnits.SQUARE_METER);
    }
    public Area toSquareMillimeters() {
        return toUnit(AreaUnits.SQUARE_MILLIMETER);
    }
    public Area toSquareCentimeters() {
        return toUnit(AreaUnits.SQUARE_CENTIMETER);
    }
    public Area toSquareKilometers() {
        return toUnit(AreaUnits.SQUARE_KILOMETER);
    }
    public Area toAres() {
        return toUnit(AreaUnits.ARE);
    }
    public Area toAcres() {
        return toUnit(AreaUnits.ACRE);
    }
    public Area toHectares() {
        return toUnit(AreaUnits.HECTARE);
    }
    public Area toSquareInches() {
        return toUnit(AreaUnits.SQUARE_INCH);
    }
    public Area toSquareFoot() {
        return toUnit(AreaUnits.SQUARE_FOOT);
    }
    public Area toSquareYards() {
        return toUnit(AreaUnits.SQUARE_YARD);
    }

    public double getInSquareMeters() {
        return getIn(AreaUnits.SQUARE_METER);
    }

    public double getInSquareKilometers() {
        return getIn(AreaUnits.SQUARE_KILOMETER);
    }

    public double getInSquareCentimeters() {
        return getIn(AreaUnits.SQUARE_CENTIMETER);
    }

    public double getInSquareMillimeters() {
        return getIn(AreaUnits.SQUARE_MILLIMETER);
    }

    public double getInAres() {
        return getIn(AreaUnits.ARE);
    }

    public double getInHectares() {
        return getIn(AreaUnits.HECTARE);
    }

    public double getInSquareInches() {
        return getIn(AreaUnits.SQUARE_INCH);
    }

    public double getInSquareFeet() {
        return getIn(AreaUnits.SQUARE_FOOT);
    }

    public double getInSquareYards() {
        return getIn(AreaUnits.SQUARE_YARD);
    }

    public double getInAcres() {
        return getIn(AreaUnits.ACRE);
    }

    public double getInSquareMiles() {
        return getIn(AreaUnits.SQUARE_MILE);
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Area inputQuantity = (Area) o;
        return Double.compare(inputQuantity.toBaseUnit().value,baseValue) == 0 && Objects.equals(unit.getBaseUnit(), inputQuantity.getUnit().getBaseUnit());
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseValue, unit.getBaseUnit());
    }

    @Override
    public String toString() {
        return "Area{"  + value + " " + unit.getSymbol() + '}';
    }
}
