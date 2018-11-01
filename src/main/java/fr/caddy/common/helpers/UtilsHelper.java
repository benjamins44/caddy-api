package fr.caddy.common.helpers;

import java.text.NumberFormat;

public class UtilsHelper {

    public static Float castTwoDecimal(Float input) {
        final NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMinimumFractionDigits(2);
        formatter.setMaximumFractionDigits(2);
        return Float.valueOf(formatter.format(input).replace(",","."));
    }

}
