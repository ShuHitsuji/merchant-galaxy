import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RomanNumberServiceTest {
    protected Character[] characterArray;
    protected Character character;
    protected String romanError;
    protected String romanOk;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        character = 'P';
        characterArray = new Character[]{'I','X','V','L'};
        romanError = "ABGJE";
        romanOk = "MMMI";
    }

    @Test
    public void itShouldBeReturnError() throws RomanNumberException {
        assert RomanNumberService.romanToArabic(romanError).equals(ConstantValues.ErrorCode.INVALID_ROMAN_STRING);
    }

    @Test
    public void itShouldBeOk() throws RomanNumberException {
        String romanResult = "3001";
        assert RomanNumberService.romanToArabic(romanOk).equals(romanResult);
    }
}
