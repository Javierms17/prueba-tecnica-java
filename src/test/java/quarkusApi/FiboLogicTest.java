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
      /*
        long result0 = fiboLogic.resolveFibo(0);
        assertEquals(0, result0);
  long result1 = fiboLogic.resolveFibo(1);
        assertEquals(1, result1);
        long result4 = fiboLogic.resolveFibo(4);
        assertEquals(3, result4);
        */
        //para lograr 100% de coverage configurar hibernate en drop-and-create
        //o elejir un caso que no exista todavia en la base de datos
        // asi el test recorre todo el codigo
        //por ejemplo:
        //        long result5 = fiboLogic.resolveFibo(10);
        //        assertEquals(55, result5);
        // siendo 10 un numero todavia no consultado

    }

  
}
