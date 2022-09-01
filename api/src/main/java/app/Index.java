package app;

import io.jooby.annotations.*;

@Path("/")
public class Index {
    
    @GET
    public String index() {
        return "Bem-vindo(a) a calculadora API, desenvolvida pelos discentes: Ewerton Barboza, Pedro Henrique e Pedro Vinícius.";
    }

}
