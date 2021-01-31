import java.util.ArrayList;
import java.util.logging.Logger;

public class Runner {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(ParagraphService.class.getName());

        logger.info("Please provide input below to start, and a blank line if you want to finish the input state");

        ParagraphService paragraph = new ParagraphService();

        ArrayList<String> output = paragraph.read();

        for (int i = 0; i < output.size(); i++) {
            logger.info(output.get(i));
        }
    }
}
