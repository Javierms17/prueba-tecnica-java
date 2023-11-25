package quarkusApi;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import models.Operation;

@QuarkusTest
public class FibonacciTest {
    @Test
    public void testFiboEndpoint() {
        given()
          .pathParam("pos", 5)  
          .when().get("/fibo/{pos}")
          .then()
             .statusCode(200)
             .body(is("5")); 
    }
    
    @Test
    public void testGetTop10Endpoint() {
        // Realiza algunas consultas para aumentar el contador
        


		for(int i =0; i<12;i++) {
			given()
	          .pathParam("pos", i)
	          .when().get("/fibo/{pos}")
	          .then()
	             .statusCode(200);
		}
        // Realiza una consulta múltiples veces para aumentar el contador
   

        // Realiza una solicitud al endpoint top10
        List<Operation> top10List =
                given()
                  .when().get("/fibo/top10")
                  .then()
                     .statusCode(200)
                     .extract().body().jsonPath().getList(".", Operation.class);

        // Asegura que la lista tenga tamaño 3, ya que estamos contando solo las posiciones 1, 2 y 3
        assertEquals(10, top10List.size());


    }
}
