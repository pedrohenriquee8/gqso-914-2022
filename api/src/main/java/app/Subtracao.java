package app;

import java.util.Arrays;

import io.jooby.annotations.*;

@Path("/subtracao/{nums}*")
public class Subtracao {

    @GET
    public double calculoSubtracao(@PathParam String nums) {
        double maxDouble = Arrays.stream(nums.split("/"))
                .map(num -> Double.parseDouble(num))
                .reduce((double) 0, Double::max);

        return Arrays.stream(nums.split("/"))
                .map(num -> Double.parseDouble(num))
                .reduce(maxDouble, (a, b) -> a - b);
    }

}