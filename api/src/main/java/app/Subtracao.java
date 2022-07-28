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

        System.out.println(maxDouble);
        return Arrays.stream(nums.split("/"))
                .map(num -> Double.parseDouble(num))
                .reduce(0.0, (a, b) -> (-a) - b);
        
    }

}

