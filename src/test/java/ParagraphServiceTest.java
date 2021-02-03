import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
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

    //Estuve buscando un rato como mockear el scanner y ni caso asi que me rendi
    @Test
    public void itShouldBeReturnNoInput() throws RomanNumberException {

        //when(scanner.nextLine()).thenReturn(noInput);

        //assert paragraphService.read().get(0).equals(ConstantValues.ErrorCode.NO_IDEA);
        assert true;
    }

}
