package br.com.seteideias;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
	
	private static final String template = "" +
			"<html>" +
				"<font size=20>" +
				"	Ola.... aqui é o Carlos... bem vindo -> %s!" +
				"</font>" +
			"</html>";

	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/")
	public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@RequestMapping("/teste")
	public String teste() {
		return "ola ola --- estou em teste";
	}

	@RequestMapping(value = "/sum/{numero1}/{numero2}", method = RequestMethod.GET)
	public Double sum(@PathParam(value="numero1") String numero1,
					   @PathParam(value="numero2") String numero2) throws Exception {

//		if(!isNumeric(numero1) && !isNumeric(numero2)){
//			throw new Exception();
//		}

		Double somaDeNumeros = convertToDouble(numero1) + convertToDouble(numero2);

		return somaDeNumeros;
	}

	private Double convertToDouble(String numeroAConverter) {
		Double resultado = 0.00;
		try{
			resultado = Double.parseDouble(numeroAConverter);
		}catch (Exception e){
			System.err.println("erro no covertToDouble");
		}

		System.out.println("resultado -> " + resultado);
		return resultado;
	}

	private boolean isNumeric(String numero) {
		try{
			Double.parseDouble(numero);
			return true;
		}catch (Exception e){
			return false;
		}
	}

}
