package app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import io.jooby.MockRouter;
import io.jooby.StatusCode;

public class SubtracaoTest {

    @Test
    public void testeSubtracao() {
        MockRouter router = new MockRouter(new App());
        router.get("/subtracao/5/5/5", rsp -> {
            assertEquals(-5.0, rsp.value());
            assertEquals(StatusCode.OK, rsp.getStatusCode());
        });
    }

    @Test
    public void testeSubtracaoString() {
        MockRouter router = new MockRouter(new App());
        assertThrows(NumberFormatException.class, () -> {
            router.get("/subtracao/abc", rsp -> {
            });
        });
    }

}
