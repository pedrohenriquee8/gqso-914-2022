import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class Soma implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        try {
            String[] partes = exchange.getRequestURI().getPath().split("/");
            List<Double> numeros = new ArrayList<Double>();
            double soma = 0;

            //Verifica se, na terceira posição da URL, o valor é igual a null, haja vista que, caso seja válido, a aplicação deve retornar uma mensagem de "Entrada Inválida".  
            if(partes[2].equals(null)) {
                byte[] resposta = "Entrada inválida".getBytes();
                exchange.sendResponseHeaders(200, resposta.length);
                exchange.getResponseBody().write(resposta);
                return;
            }

            //Verifica se o(s) caractere(s) inserido(s) são, de fato, númericos e, em caso de confirmação, o número é adicionado ao array de números para, posteriormente, realizar a operação soma. 
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

            //A variável soma recebe os valores de cada posição do array de números, sendo inseridos na variável soma.
            for(int i = 0; i < numeros.size(); i++) {
                soma += numeros.get(i);
            }

            byte[] resposta = Double.toString(soma).getBytes();
            exchange.sendResponseHeaders(200, resposta.length);
            exchange.getResponseBody().write(resposta);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            exchange.close();
        }
    }
    
    //Função destinada à checagem do número.
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