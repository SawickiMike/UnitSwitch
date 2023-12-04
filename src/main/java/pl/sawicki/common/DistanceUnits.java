package pl.sawicki.common;

import pl.sawicki.Unit;

import java.util.function.DoubleUnaryOperator;

public enum DistanceUnits implements Unit {

    METER("m" ,val -> val,val -> val),
    MILLIMETER("m" , val -> val / 1000 , val -> 1000),
    CENTIMETER("cm", val -> val / 100, val -> val * 100),
    DECIMETER("dm", val -> val / 10, val -> val *10),
    KILOMETER("km", val -> val * 1000, val -> val / 1000),
    INCH("in", val -> val * 0.0254, val -> val / 0.0254),
    FEET("ft", val -> val * 0.3048, val -> val / 0.3048),
    MILE("mi", val -> val * 1609.344, val -> val / 1609.344);



    private final String symbol;
    private final DoubleUnaryOperator toBaseConverter;
    private final DoubleUnaryOperator fromBaseToUnitConverter;

    DistanceUnits(String symbol, DoubleUnaryOperator toBaseConverter, DoubleUnaryOperator fromBaseToUnitConverter) {
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
        return METER;
    }

    @Override
    public double toValueInBaseUnit(double valueInThisUnit) {
        return toBaseConverter.applyAsDouble(valueInThisUnit);
    }

    @Override
    public double fromValueInBaseUnit (double valueInBaseUnit) {
        return fromBaseToUnitConverter.applyAsDouble(valueInBaseUnit);
    }
}


