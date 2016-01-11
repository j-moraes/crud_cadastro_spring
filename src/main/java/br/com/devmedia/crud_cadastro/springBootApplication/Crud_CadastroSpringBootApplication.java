package br.com.devmedia.crud_cadastro.springBootApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class Crud_CadastroSpringBootApplication {
	@RequestMapping("/apirest/cliente")
	@ResponseBody
	public String index() {
		return "HelloWorld";
	}

	public static void main(String[] args) {
		SpringApplication.run(Crud_CadastroSpringBootApplication.class, args);
	}
}
