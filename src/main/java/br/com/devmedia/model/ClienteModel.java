package br.com.devmedia.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "cliente")
public class ClienteModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id_cliente;
	@Column(name = "nome")
	String nome;
	@Column(name = "cpf_cnpj")
	String cpf_cnpj;
	@Column(name = "rg")
	String rg;
	@Column(name = "endereco")
	String endereco;
	@Column(name = "bairro")
	String bairro;
	@Column(name = "cidade")
	String cidade;
	@Column(name = "estado")
	String estado;
	@Column(name = "email")
	String email;
	@Column(name = "data_cadastro")
	@Temporal(TemporalType.TIMESTAMP)
	Date data_cadastro;

	/**
	 * @return the id
	 */
	public int getId() {
		return id_cliente;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id_cliente = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

}
