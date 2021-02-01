import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

public class RomanNumberServiceTest {

    private String romanError;
    private String romanOk;

    @InjectMocks
    RomanNumberService romanNumberService;

    @Before
    public void setUp() throws Exception {
        romanError = "ABGJE";
        romanOk = "MMMI";
    }

    @Test
    public void itShouldBeReturnError() throws RomanNumberException {
        assert romanNumberService.romanToArabic(romanError).equals(ConstantValues.ErrorCode.INVALID_ROMAN_STRING);
    }

    @Test
    public void itShouldBeOk() throws RomanNumberException {
        String romanResult = "3001";
        assert romanNumberService.romanToArabic(romanOk).equals(romanResult);
    }
}
