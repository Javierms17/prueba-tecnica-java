package quarkusApi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import businessLogic.FiboLogic;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;


@QuarkusTest

public class FiboLogicTest {


	@Inject
    FiboLogic fiboLogic;

    @Test
    public void testResolveFibo() {

        long result0 = fiboLogic.resolveFibo(0);
        assertEquals(0, result0);
        long result1 = fiboLogic.resolveFibo(1);
        assertEquals(result1, 1);
        long result4 = fiboLogic.resolveFibo(4);
        assertEquals(result4, 3);

    }

  
}
