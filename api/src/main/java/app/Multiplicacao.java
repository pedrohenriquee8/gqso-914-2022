package app;

import java.util.Arrays;
import io.jooby.annotations.*;

@Path("/multiplicacao/{nums}*")
public class Multiplicacao {

    @GET
    public double calculoMultiplicacao(@PathParam String nums) {
        return Arrays.stream(nums.split("/"))
                .map(num -> Double.parseDouble(num))
                .reduce(0.0, (a, b) -> a * b);
    }

}
