package pl.sawicki.common;

import pl.sawicki.PhysicalQuantity;

import java.util.Objects;

public class Volume implements PhysicalQuantity<VolumeUnits> {

    public static final Volume PHYSICAL_MIN_LIMIT = Volume.ofCubicMeters(0);
    private final double value;
    private final double baseValue;
    private final VolumeUnits unit;

    public Volume(double value, VolumeUnits unit) {
        this.value = value;
        this.unit = unit;
        this.baseValue = unit.toValueInBaseUnit(value);
    }
    public static Volume of(double value, VolumeUnits unit) {
        return new Volume(value, unit);
    }
    public static Volume ofCubicMeters(double value) {
        return new Volume(value, VolumeUnits.CUBIC_METER);
    }    public static Volume ofCubicCentimeter(double value) {
        return new Volume(value, VolumeUnits.CUBIC_CENTIMETER);
    }    public static Volume ofMilliliter(double value) {
        return new Volume(value, VolumeUnits.MILLILITRE);
    }    public static Volume ofHectolitre(double value) {
        return new Volume(value, VolumeUnits.HECTOLITRE);
    }    public static Volume ofLiter(double value) {
        return new Volume(value, VolumeUnits.LITER);
    }    public static Volume ofOunce(double value) {
        return new Volume(value, VolumeUnits.OUNCE);
    }    public static Volume ofPint(double value) {
        return new Volume(value, VolumeUnits.PINT);
    }    public static Volume ofGallon(double value) {
        return new Volume(value, VolumeUnits.GALLON);
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
    public VolumeUnits getUnit() {
        return unit;
    }

    @Override
    public Volume toBaseUnit() {
        double valueInCubicMeter = unit.toValueInBaseUnit(value);
        return Volume.of(valueInCubicMeter,VolumeUnits.CUBIC_METER);
    }

    @Override
    public Volume toUnit(VolumeUnits targetUnit) {
        double valueInCubicMeter = unit.toValueInBaseUnit(value);
        double valueInTargetUnit = unit.fromValueInBaseUnit(valueInCubicMeter);
        return Volume.of(valueInTargetUnit,targetUnit);
    }

    public Volume toCubicMeter() {
        return toUnit(VolumeUnits.CUBIC_METER);
    }
    public Volume toCubicCentimeter() {
        return toUnit(VolumeUnits.CUBIC_CENTIMETER);
    }
    public Volume toLiter() {
        return toUnit(VolumeUnits.LITER);
    }
    public Volume toHectolitre() {
        return toUnit(VolumeUnits.HECTOLITRE);
    }
    public Volume toOunce() {
        return toUnit(VolumeUnits.OUNCE);
    }
    public Volume toPint() {
        return toUnit(VolumeUnits.PINT);
    }
    public Volume toGallon() {
        return toUnit(VolumeUnits.GALLON);
    }
    public Volume toMillilitre() {
        return toUnit(VolumeUnits.MILLILITRE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Volume inputQuantity = (Volume) o;
        return Double.compare(inputQuantity.toBaseUnit().value, baseValue) == 0 && Objects.equals(unit.getBaseUnit(), inputQuantity.getUnit().getBaseUnit());
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseValue, unit.getBaseUnit());
    }

    @Override
    public String toString() {
        return "Volume{ " + value + " " + unit.getSymbol() + '}';
    }
}
