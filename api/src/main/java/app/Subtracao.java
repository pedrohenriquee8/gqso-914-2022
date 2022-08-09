package app;

import io.jooby.annotations.*;

@Path("/subtracao/{nums}*")
public class Subtracao {

    @GET
    public double calculoSubtracao(@PathParam String nums) {
        String[] numsParam = nums.split("/");
        double parametroSoma = 0;

        for(int i = 1; i < numsParam.length; i++) {
            parametroSoma += Double.parseDouble(numsParam[i]);
        }

        return Double.parseDouble(numsParam[0]) - parametroSoma;
    }

}