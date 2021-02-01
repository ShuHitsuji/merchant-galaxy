import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;


import java.util.Scanner;

import static org.mockito.Mockito.when;

public class ParagraphServiceTest {

    private String romanError;
    private String romanOk;
    private String noInput;

    @InjectMocks
    ParagraphService paragraphService;

    @Mock
    Scanner scanner;

    @Before
    public void setUp() throws Exception {
        romanError = "ABGJE";
        romanOk = "MMMI";
        noInput = "";
    }

    @Test
    public void itShouldBeReturnError() throws RomanNumberException {
        when(scanner.nextLine()).thenReturn(noInput);
//Estuve buscando un rato como mockear el scanner y ni caso asi que me rendi
        assert paragraphService.read().get(0).equals(ConstantValues.ErrorCode.NO_IDEA);
    }
}
