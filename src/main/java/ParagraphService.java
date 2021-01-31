import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;
import java.util.logging.Logger;

public class ParagraphService {
    private Scanner scan;
    private ArrayList<String> output;
    private HashMap<String, String> constantAssignments;
    private HashMap<String, String> computedLiterals;

    Logger logger = Logger.getLogger(ParagraphService.class.getName());

    public ParagraphService() {
        this.scan = new Scanner(System.in);
        this.constantAssignments = new HashMap<String, String>();
        this.computedLiterals = new  HashMap<String, String>();
        this.output = new ArrayList<String>();
    }

    public ArrayList<String> read() {
        String line;
        int count = 0;
        String error = null;


        while (this.scan.hasNextLine() && (line = this.scan.nextLine()).length() > 0) {
            error = validate(line);

            if (error.equals(ConstantValues.ErrorCode.NO_IDEA))
                this.output.add(ConstantValues.ErrorCode.NO_IDEA);
            else
                logger.info(error);

            count++;
        }

        if (count == 0)
            logger.info(ConstantValues.ErrorCode.NO_INPUT);

        return this.output;

    }

    private String validate(String line) {

        String result = ConstantValues.Code.SUCCESS_OK;

        String lineType = PatternTypeEnum.getLineTypeByPattern(line);

        if (lineType.equals(PatternTypeEnum.ASSIGNED.getType())) {
            processAssignmentLine(line);
            return result;
        }

        if (lineType.equals(PatternTypeEnum.CREDITS.getType())) {
            processCreditsLine(line);
            return result;
        }

        if (lineType.equals(PatternTypeEnum.HOW_MUCH.getType())) {
            processHowMuchQuestion(line);
            return result;
        }

        if (lineType.equals(PatternTypeEnum.HOW_MANY.getType())) {
            processHowManyCreditsQuestion(line);
            return result;
        }

        result = ConstantValues.ErrorCode.NO_IDEA;

        return result;
    }

    private void processAssignmentLine(String line) {
        String[] split = line.trim().split("\\s+");

        try {

            constantAssignments.put(split[0], split[2]);

        } catch (ArrayIndexOutOfBoundsException e) {

            logger.info(ConstantValues.ErrorCode.INCORRECT_LINE_TYPE);
            logger.info(e.getMessage());

        }
    }


    private void processHowMuchQuestion(String line) {
        try {

            String formatted = line.split("\\sis\\s")[1].trim();

            formatted = formatted.replace("?", "").trim();

            String keys[] = formatted.split("\\s+");

            String romanResult = "";
            String completeResult = null;
            boolean errorOccured = false;

            for (String key : keys) {

                String romanValue = constantAssignments.get(key);
                if (romanValue == null) {

                    completeResult = ConstantValues.ErrorCode.NO_IDEA;
                    errorOccured = true;
                    break;

                }
                romanResult += romanValue;
            }

            if (!errorOccured) {
                romanResult = RomanNumberService.romanToArabic(romanResult);
                completeResult = formatted + " is " + romanResult;
            }

            output.add(completeResult);

        } catch (Exception e) {

            logger.info(ConstantValues.ErrorCode.INCORRECT_LINE_TYPE);
            logger.info(e.getMessage());

        }
    }


    private void processCreditsLine(String line) {
        try {

            String formatted = line.replaceAll("(is\\s+)|([c|C]redits\\s*)", "").trim();

            String[] keys = formatted.split("\\s");

            String toBeComputed = keys[keys.length - 2];
            float value = Float.parseFloat(keys[keys.length - 1]);

            String roman = "";

            for (int i = 0; i < keys.length - 2; i++) {

                roman += constantAssignments.get(keys[i]);

            }

            int romanNumber = Integer.parseInt(RomanNumberService.romanToArabic(roman));
            float credit = (float) (value / romanNumber);
            computedLiterals.put(toBeComputed, credit + "");
        } catch (Exception e) {

            logger.info(ConstantValues.ErrorCode.INCORRECT_LINE_TYPE);
            logger.info(e.getMessage());

        }
    }

    private void processHowManyCreditsQuestion(String line) {
        try {

            String formatted = line.split("(\\sis\\s)")[1];

            formatted = formatted.replace("?", "").trim();

            String[] keys = formatted.split("\\s");

            boolean found = false;
            String roman = "";
            String outputResult = null;
            Stack<Float> cvalues = new Stack<Float>();

            for (String key : keys) {
                found = false;

                String romanValue = constantAssignments.get(key);
                if (romanValue != null) {
                    roman += romanValue;
                    found = true;
                }

                String computedValue = computedLiterals.get(key);
                if (!found && computedValue != null) {
                    cvalues.push(Float.parseFloat(computedValue));
                    found = true;
                }

                if (!found) {
                    outputResult = ConstantValues.ErrorCode.NO_IDEA;
                    break;
                }
            }

            if (found) {
                float res = 1;
                for (int i = 0; i < cvalues.size(); i++)
                    res *= cvalues.get(i);

                int finalResult = (int) res;
                if (roman.length() > 0)
                    finalResult = (int) (Integer.parseInt(RomanNumberService.romanToArabic(roman)) * res);
                outputResult = formatted + " is " + finalResult + " Credits";
            }

            this.output.add(outputResult);

        } catch (Exception e) {

            logger.info(ConstantValues.ErrorCode.INCORRECT_LINE_TYPE);
            logger.info(e.getMessage());

        }

    }

}
