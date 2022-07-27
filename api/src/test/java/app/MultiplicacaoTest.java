package app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import io.jooby.MockRouter;
import io.jooby.StatusCode;

public class MultiplicacaoTest{

    @Test
    public void testeMultiplicacao() {
        MockRouter router = new MockRouter(new App());
        router.get("/multiplicacao/5/5/5", rsp -> {
            assertEquals(125.0, rsp.value());
            assertEquals(StatusCode.OK, rsp.getStatusCode());
        });
    }

    @Test
    public void testeMultiplicacaoString() {
        MockRouter router = new MockRouter(new App());
        assertThrows(NumberFormatException.class, () -> {
            router.get("/multiplicacao/abc", rsp -> {
            });
        });
    }

}
