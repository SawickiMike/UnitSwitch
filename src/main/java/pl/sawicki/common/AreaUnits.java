package pl.sawicki.common;

import pl.sawicki.Unit;

import java.util.function.DoubleUnaryOperator;

public enum AreaUnits implements Unit {

    SQUARE_METER("m²", val -> val, val -> val),
    SQUARE_KILOMETER("km²", val -> val * 1_000_000, val -> val / 1_000_000),
    SQUARE_MILLIMETER("mm²", val -> val / 1_000_000, val -> val * 1_000_000),
    SQUARE_CENTIMETER("cm²", val -> val / 10_000, val -> val * 10_000),
    HECTARE("ha", val -> val * 10_000, val -> val / 10_000),
    ACRE("acre", val -> val * 4046.856422, val -> val / 4046.856422),
    ARE("a", val -> val * 100, val -> val / 100),
    SQUARE_FOOT("ft²", val ->  val * 0.0929030, val -> val / 0.0929030),
    SQUARE_INCH("in²", val -> val * 0.00064516, val -> val / 0.00064516),
    SQUARE_MILE("mi²", val -> val * 2589988.110336, val -> val / 2589988.110336),
    SQUARE_YARD("yd²", val -> val * 0.8361274, val -> val / 0.8361274);

    private final String symbol;
    private final DoubleUnaryOperator toBaseConverter;
    private final DoubleUnaryOperator fromBaseToUnitConverter;

    AreaUnits(String symbol, DoubleUnaryOperator toBaseConverter, DoubleUnaryOperator fromBaseToUnitConverter) {
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
        return null;
    }

    @Override
    public double toValueInBaseUnit(double valueInThisUnit) {
        return 0;
    }

    @Override
    public double fromValueInBaseUnit(double valueInBaseUnit) {
        return 0;
    }
}
