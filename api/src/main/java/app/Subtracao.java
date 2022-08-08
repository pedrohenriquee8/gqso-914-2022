package app;

import java.util.ArrayList;

import io.jooby.annotations.*;

@Path("/subtracao/{nums}*")
public class Subtracao {

    @GET
    public double calculoSubtracao(@PathParam String nums) {
        String[] numsParam = nums.split("/");
        ArrayList<Double> numsDouble = new ArrayList<>();
        double parametroSoma = 0;

        for(int i = 0; i < numsParam.length; i++) {
            numsDouble.add(Double.parseDouble(numsParam[i]));
        }

        for(int i = 1; i < numsDouble.size(); i++) {
            parametroSoma = parametroSoma + numsDouble.get(i);
        }

        return numsDouble.get(0) - parametroSoma;
    }

}