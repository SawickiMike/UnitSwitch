package pl.sawicki.common;

import pl.sawicki.Unit;

import java.util.function.DoubleUnaryOperator;

public enum VolumeUnits implements Unit {
    CUBIC_METER("m³", val -> val, val -> val),
    CUBIC_CENTIMETER("cm³", val -> val * 0.001, val -> val * 1000.0),
    LITER("L", val -> val * 0.001, val -> val * 1000.0),
    GALLON("gal", val -> val * 0.003785411784, val -> val / 0.003785411784),
    MILLILITRE("mL", val -> val * 0.0001, val -> val * 10000.0),
    PINT("pt", val -> val * 0.00047317647, val -> val / 0.00047317647),
    HECTOLITRE("hL", val -> val * 0.1, val -> val * 10.0),
    OUNCE("fl.oz", val -> val * 0.00002957352956, val -> val / 0.00002957352956);

    private final String symbol;
    private final DoubleUnaryOperator toBaseConverter;
    private final DoubleUnaryOperator fromBaseToUnitConverter;

    VolumeUnits(String symbol, DoubleUnaryOperator toBaseConverter, DoubleUnaryOperator fromBaseToUnitConverter) {
        this.symbol = symbol;
        this.toBaseConverter = toBaseConverter;
        this.fromBaseToUnitConverter = fromBaseToUnitConverter;
    }


    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public Unit getBaseUnit() {
        return CUBIC_METER;
    }

    @Override
    public double toValueInBaseUnit(double valueInThisUnit) {
        return toBaseConverter.applyAsDouble(valueInThisUnit);
    }

    @Override
    public double fromValueInBaseUnit(double valueInBaseUnit) {
        return fromBaseToUnitConverter.applyAsDouble(valueInBaseUnit);
    }
}
