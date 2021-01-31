import com.sun.org.apache.bcel.internal.Const;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

public class RomanNumberService {

    private static Logger logger = LoggerFactory.getLogger(RomanNumberService.class);

    public String romanToArabic(String roman) throws RomanNumberException {
        String result;

        if(validateRomanNumber(roman))
           result = convert(roman);
        else
           result = ConstantValues.ErrorCode.INVALID_ROMAN_STRING;

        return result;
    }

    private boolean validateRomanNumber(String roman) {
        boolean result = false;

        if(roman.matches(ConstantValues.Validator.romanNumberValidator))
            result = true;

        return result;
    }

    private static String convert(String roman) throws RomanNumberException {
        int decimal = 0;
        int lastNumber = 0;

        for(int i = roman.length() - 1; i >= 0; i--) {
            char ch = roman.charAt(i);
            decimal = CheckRoman(RomanNumbersEnum.getValueFromCode(ch), lastNumber, decimal);
            lastNumber = RomanNumbersEnum.getValueFromCode(ch);
        }

        return decimal + "";

    }

    private static int CheckRoman(int TotalDecimal, int LastRomanLetter, int LastDecimal){
        if (LastRomanLetter > TotalDecimal)
            return LastDecimal - TotalDecimal;
         else
            return LastDecimal + TotalDecimal;
    }
}
