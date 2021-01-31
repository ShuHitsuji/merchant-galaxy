public enum PatternTypeEnum {
    ASSIGNED("Assigned", ConstantValues.Pattern.patternAssigned),
    CREDITS("Credits", ConstantValues.Pattern.patternCredits),
    HOW_MUCH("How Much", ConstantValues.Pattern.patternHowMuch),
    HOW_MANY("How Many", ConstantValues.Pattern.patternHowMany);


    private String pattern;
    private String type;

    PatternTypeEnum(String type, String patternAssigned) {
        this.pattern = patternAssigned;
        this.type = type;
    }

    public String getPattern() {
        return pattern;
    }

    public String getType() {
        return type;
    }

    public static String getLineTypeByPattern(String line) {
        line = line.trim();
        String result = ConstantValues.ErrorCode.noMatch;

        for (PatternTypeEnum e : values()) {
            if (line.matches(e.getPattern())) {
                result = e.getType();
                break;
            }
        }

        return result;
    }

}
