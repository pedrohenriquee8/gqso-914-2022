package app;

import java.util.Arrays;
import io.jooby.annotations.*;

@Path("/soma/{nums}*")
public class Soma {

    @GET
    public double calculoSoma(@PathParam String nums) {
        return Arrays.stream(nums.split("/"))
                .map(num -> Double.parseDouble(num))
                .reduce(0.0, (a, b) -> a + b);
    }

}