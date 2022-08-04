package app;

import java.util.Arrays;

import io.jooby.annotations.*;

@Path("/subtracao/{nums}*")
public class Subtracao {

    @GET
    public double calculoSubtracao(@PathParam String nums) {
        System.out.println(nums);
        return Arrays.stream(nums.split("/"))
                .map(num -> Double.parseDouble(num))
                .reduce(0.0, (a, b) -> (-a) - b);
    }

}