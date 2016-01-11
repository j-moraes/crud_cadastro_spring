package br.com.devmedia.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import br.com.devmedia.EntityManager.JpaEntityManager;
import br.com.devmedia.model.ClienteModel;

@Path("/cliente")
public class ClienteService {
	private JpaEntityManager JPAEM = new JpaEntityManager();
	private EntityManager objEM = JPAEM.getEntityManager();

	@GET
	@Path("/listar")
	@Produces("application/json")
	public List<ClienteModel> listar() {
		try {
			String query = "select c from ClienteModel c";
			List<ClienteModel> clientes = objEM.createQuery(query,
					ClienteModel.class).getResultList();
			objEM.close();
			return clientes;
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}

	@GET
	@Path("/buscar/{id_cliente}")
	@Produces("application/json")
	public ClienteModel buscar(@PathParam("id_cliente") int id_cliente) {
		try {
			ClienteModel cliente = objEM.find(ClienteModel.class, id_cliente);
			objEM.close();
			return cliente;
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}

	@POST
	@Path("/cadastrar")
	@Consumes("application/json")
	public Response cadastrar(ClienteModel objCliente) {
		try {
			objEM.getTransaction().begin();
			objEM.persist(objCliente);
			objEM.getTransaction().commit();
			objEM.close();
			return Response.status(200).entity("cadastro realizado.").build();
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}

	@PUT
	@Path("/alterar")
	@Consumes("application/json")
	public Response alterar(ClienteModel objCliente) {
		try {
			objEM.getTransaction().begin();
			objEM.merge(objCliente);
			objEM.getTransaction().commit();
			objEM.close();
			return Response.status(200).entity("cadastro alterado.").build();
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}

	@DELETE
	@Path("/excluir/{id_cliente}")
	public Response excluir(@PathParam("id_cliente") int id_cliente) {
		try {
			ClienteModel objCliente = objEM
					.find(ClienteModel.class, id_cliente);
			objEM.getTransaction().begin();
			objEM.remove(objCliente);
			objEM.getTransaction().commit();
			objEM.close();
			return Response.status(200).entity("cadastro excluido.").build();
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}
}
