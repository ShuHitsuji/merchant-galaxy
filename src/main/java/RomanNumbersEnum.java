public enum RomanNumbersEnum {
    I('I',1) ,
    V('V',5),
    X('X',10),
    L('L',50),
    C('C', 100),
    D('D', 500),
    M('M', 1000);

    private int value;
    private char code;


    RomanNumbersEnum(char code, int value) {
        this.code = code;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public char getCode() {
        return code;
    }

    public static int getValueFromCode(char code) throws RomanNumberException {
        for(RomanNumbersEnum e : values()){
            if(e.getCode() == code) return e.getValue();
        }
        throw new RomanNumberException("Codigo invalido");
    }
}
