public enum RomanNumbersEnum {
    I('I', 1),
    V('V', 5),
    X('X', 10),
    L('L', 50),
    C('C', 100),
    D('D', 500),
    M('M', 1000);

    private Integer value;
    private Character code;


    RomanNumbersEnum(Character code, Integer value) {
        this.code = code;
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public Character getCode() {
        return code;
    }

    public static Integer getValueFromCode(Character code) throws RomanNumberException {
        for (RomanNumbersEnum e : values()) {
            if (e.getCode().equals(code))
                return e.getValue();
        }
        throw new RomanNumberException(ConstantValues.ErrorCode.INVALID_ROMAN_CHARACTER);
    }
}
