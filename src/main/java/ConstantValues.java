public class ConstantValues {

    public class Validator {

        public static final String romanNumberValidator = "^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";

    }

    public class Pattern {

        public static final String patternAssigned = "^([A-Za-z]+) is ([I|V|X|L|C|D|M])$";
        public static final String patternCredits = "^([A-Za-z]+)([A-Za-z\\s]*) is ([0-9]+) ([c|C]redits)$";
        public static final String patternHowMuch = "^how much is (([A-Za-z\\s])+)\\?$";
        public static final String patternHowMany = "^how many [c|C]redits is (([A-Za-z\\s])+)\\?$";

    }

    public class ErrorCode {

        public static final String INVALID_ROMAN_STRING = "Codigo romano Invalido";
        public static final String NO_INPUT = "No se a informado un ingreso/input";
        public static final String INVALID = "Formato de ingreso invalido";
        public static final String INVALID_ROMAN_CHARACTER = "Un caracter en el codigo romano es invalido";
        public static final String INCORRECT_LINE_TYPE = "Hubo una Exception en el proceso";
        public static final String NO_IDEA = "No tengo idea de lo que estas hablando";
        public static final String noMatch = "No Match";

    }

    public class Code {

        public static final String SUCCESS_OK = "Funciono correctamente";

    }
}
