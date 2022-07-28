package app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import io.jooby.MockRouter;
import io.jooby.StatusCode;

public class SomaTest {

    @Test
    public void testeSoma() {
        MockRouter router = new MockRouter(new App());
        router.get("/soma/5/5/5", rsp -> {
            assertEquals(15.0, rsp.value());
            assertEquals(StatusCode.OK, rsp.getStatusCode());
        });
    }

    @Test
    public void testeSomaString() {
        MockRouter router = new MockRouter(new App());
        assertThrows(NumberFormatException.class, () -> {
            router.get("/soma/abc", rsp -> {
            });
        });
    }

}
