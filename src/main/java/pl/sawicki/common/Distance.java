package pl.sawicki.common;

import pl.sawicki.PhysicalQuantity;

import java.util.Objects;

public class Distance implements PhysicalQuantity<DistanceUnits> {

    public static final Distance PHYSICAL_MIN_LIMIT = Distance.ofMeters(0);
    private final double value;
    private final double baseValue;
    private final DistanceUnits unit;

    public Distance(double value, DistanceUnits unit) {
        this.value = value;
        this.unit = unit;
        this.baseValue = unit.toValueInBaseUnit(value);
    }

        public static Distance of(double value, DistanceUnits unit) {
        return  new Distance(value, unit);
        }

        public static Distance ofMeters(double value){
            return new Distance(value,DistanceUnits.METER);
        }
        public static Distance ofCentimeters(double value) {
            return new Distance(value, DistanceUnits.CENTIMETER);
        }
        public static Distance ofMillimeters(double value) {
            return new Distance(value, DistanceUnits.MILLIMETER);
        }
        public static Distance ofDecimeters(double value) {
            return new Distance(value, DistanceUnits.DECIMETER);
        }
        public static Distance ofKilometers(double value) {
            return new Distance(value, DistanceUnits.KILOMETER);
        }
        public static Distance ofMiles(double value) {
            return new Distance(value, DistanceUnits.MILE);
        }
        public static Distance ofInches(double value) {
            return new Distance(value, DistanceUnits.INCH);
        }
        public static Distance ofFeet(double value) {
            return new Distance(value, DistanceUnits.FEET);
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
    public DistanceUnits getUnit() {
        return unit;
    }
    @Override
    public Distance toBaseUnit() {
        double valueInMeters = unit.toValueInBaseUnit(value);
        return Distance.of(valueInMeters, DistanceUnits.METER);
    }

    @Override
    public Distance toUnit(DistanceUnits targetUnit) {
        double valueInMeters = unit.toValueInBaseUnit(value);
        double valueInTargetUnit = targetUnit.fromValueInBaseUnit(valueInMeters);
        return Distance.of(valueInTargetUnit, targetUnit);
    }

    public Distance toMeter() {
        return toUnit(DistanceUnits.METER);
    }

    public Distance toMillimeter() {
        return toUnit(DistanceUnits.MILLIMETER);
    }

    public Distance ToCentimeter() {
        return toUnit(DistanceUnits.CENTIMETER);
    }
    public Distance ToKilometer() {
        return toUnit(DistanceUnits.KILOMETER);
    }
    public Distance ToDecimeter() {
        return toUnit(DistanceUnits.DECIMETER);
    }
    public Distance ToMile() {
        return toUnit(DistanceUnits.MILE);
    }
    public Distance ToInch() {
        return toUnit(DistanceUnits.INCH);
    }
    public Distance ToFeet() {
        return toUnit(DistanceUnits.FEET);
    }

    public double getInMeters() {
        return getIn(DistanceUnits.METER);
    }

    public double getInCentimeters() {
        return getIn(DistanceUnits.CENTIMETER);
    }

    public double getInMillimeters() {
        return getIn(DistanceUnits.MILLIMETER);
    }

    public double getInKilometers() {
        return getIn(DistanceUnits.KILOMETER);
    }

    public double getInMiles() {
        return getIn(DistanceUnits.MILE);
    }

    public double getInFeet() {
        return getIn(DistanceUnits.FEET);
    }
    public double getInDecimeters() {
        return getIn(DistanceUnits.DECIMETER);
    }
    public double getInInches () {
        return getIn(DistanceUnits.INCH);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Distance inputQuantity = (Distance) o;
        return Double.compare(inputQuantity.toBaseUnit().value, baseValue) == 0;
    }
    @Override
    public int hashCode() {
        return Objects.hash(baseValue, unit.getBaseUnit());
    }

    @Override
    public String toString() {
        return "Distance{ " + value + " " + unit.getSymbol() + '}';
    }
}
