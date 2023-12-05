package pl.sawicki.common;

import pl.sawicki.Unit;

import java.util.function.DoubleUnaryOperator;

public enum MassUnits implements Unit {

    KILOGRAM("kg",val -> val, val -> val),
    GRAM("g",val -> val / 1000, val -> val * 1000),
    TONNE("t", val -> val * 1000, val -> val / 1000),
    MILLIGRAM("mg",val -> val / 1_000_000, val -> val * 1_000_000),
    POUND("lb",val -> val * 0.45359237, val -> val / 0.45359237),
    OUNCE("oz",val -> val * 0.0283495, val -> val / 0.0283495),
    CARAT("ct", val -> val * 0.0002, val -> val / 0.0002);

    private final String symbol;
    private final DoubleUnaryOperator toBaseConverter;
    private final DoubleUnaryOperator fromBaseToUnitConverter;

    MassUnits(String symbol, DoubleUnaryOperator toBaseConverter, DoubleUnaryOperator fromBaseToUnitConverter) {
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
        return KILOGRAM;
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
