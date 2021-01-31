public class RomanNumberService {

    public static String romanToArabic(String roman) throws RomanNumberException {
        String result;

        if (validateRomanNumber(roman))
            result = convert(roman);
        else
            result = ConstantValues.ErrorCode.INVALID_ROMAN_STRING;

        return result;
    }

    private static boolean validateRomanNumber(String roman) {
        boolean result = false;

        if (roman.matches(ConstantValues.Validator.romanNumberValidator))
            result = true;

        return result;
    }

    private static String convert(String roman) throws RomanNumberException {
        Integer decimal = 0;
        Integer lastNumber = 0;

        for (int i = roman.length() - 1; i >= 0; i--) {
            Character ch = roman.charAt(i);
            decimal = CheckRoman(RomanNumbersEnum.getValueFromCode(ch), lastNumber, decimal);
            lastNumber = RomanNumbersEnum.getValueFromCode(ch);
        }

        return String.valueOf(decimal);

    }

    private static int CheckRoman(int TotalDecimal, int LastRomanLetter, int LastDecimal) {
        if (LastRomanLetter > TotalDecimal)
            return LastDecimal - TotalDecimal;
        else
            return LastDecimal + TotalDecimal;
    }
}
