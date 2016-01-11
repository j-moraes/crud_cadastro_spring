package br.com.devmedia.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.devmedia.service.ClienteService;

@Controller
@Api(value = "crud_Cadastro", description = "Cadastro de clientes")
@RequestMapping(value = "/apirest/cliente")
public class ClienteController {
	@Autowired
	private ClienteService clienteService;

	@ApiOperation(value = "View the Specific info of cliente")
	@RequestMapping(value = "/authorize/view/apirest/cliente/cliente_id", method = RequestMethod.GET)
	public ResponseEntity<Object> viewCliente(
			@ApiParam(name = "id_cliente", value = "The Id of the cliente "
					+ "to be viewed", required = true) @PathVariable String cliente_id,
			Model model) {
		return viewCliente(cliente_id, model);
	}
}