import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class Multiplicacao implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        try {
            String[] partes = exchange.getRequestURI().getPath().split("/");
            List<Double> numeros = new ArrayList<Double>();
            double multiplicacao = 0;

            if(partes[2].equals(null)) {
                byte[] resposta = "Entrada inválida".getBytes();
                exchange.sendResponseHeaders(200, resposta.length);
                exchange.getResponseBody().write(resposta);
                return;
            }

            for(int i = 2; i < partes.length; i++) {
                boolean isNumeric = checkNum(partes[i]);
                if(isNumeric) {
                    double numero = Double.parseDouble(partes[i]);
                    numeros.add(numero);
                } else {
                    byte[] resposta = "Entrada inválida".getBytes();
                    exchange.sendResponseHeaders(200, resposta.length);
                    exchange.getResponseBody().write(resposta);
                    return;
                }
            } 

            for(int i = 0; i < numeros.size(); i++) {
                multiplicacao = multiplicacao*numeros.get(i);
            }

            byte[] resposta = Double.toString(multiplicacao).getBytes();
            exchange.sendResponseHeaders(200, resposta.length);
            exchange.getResponseBody().write(resposta);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            exchange.close();
        }
    }
    
    private boolean checkNum(String strNum) {
        boolean isNumeric = true;

        for(int i = 0; i < strNum.length(); i++) {
            if(Character.isLetter(strNum.charAt(i))) {
                isNumeric = false;
            }
        }
    
        return isNumeric;
    }

}