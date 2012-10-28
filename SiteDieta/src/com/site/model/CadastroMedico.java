package com.site.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.site.business.enums.StatusMedico;

@Entity
@Table(name="cadastro_medico")
public class CadastroMedico {

	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="nome")
	private String nomeMedico;
	
	@Column(name="numero_cpf")
	private String cpfMedico;
	
	@Column(name="numero_registro")
	private String numeroRegistroMedico;
	
	@Column(name="tipo_registro")
	private String tipoRegistroMedico;
	
	@Column(name="endereco_consultorio")
	private String enderecoConsultorio;
	
	@Column(name="numero_consultorio")
	private String numeroConsultorio;
	
	@Column(name="bairro_consultorio")
	private String bairroConsultorio;
	
	@Column(name="cidade_consultorio")
	private String cidadeConsultorio;
	
	@Column(name="estado_consultorio")
	private String estadoConsultorio;
	
	@Column(name="cnpj_consultorio")
	private String cnpjConsultorio;
	
	@Column(name="status")
	@Enumerated(EnumType.STRING)
	private StatusMedico statusMedico;

	public long getId() {
		return id;
	}

	public String getNomeMedico() {
		return nomeMedico;
	}

	public void setNomeMedico(String nomeMedico) {
		this.nomeMedico = nomeMedico;
	}

	public String getCpfMedico() {
		return cpfMedico;
	}

	public void setCpfMedico(String cpfMedico) {
		this.cpfMedico = cpfMedico;
	}

	public String getNumeroRegistroMedico() {
		return numeroRegistroMedico;
	}

	public void setNumeroRegistroMedico(String numeroRegistroMedico) {
		this.numeroRegistroMedico = numeroRegistroMedico;
	}

	public String getTipoRegistroMedico() {
		return tipoRegistroMedico;
	}

	public void setTipoRegistroMedico(String tipoRegistroMedico) {
		this.tipoRegistroMedico = tipoRegistroMedico;
	}

	public String getEnderecoConsultorio() {
		return enderecoConsultorio;
	}

	public void setEnderecoConsultorio(String enderecoConsultorio) {
		this.enderecoConsultorio = enderecoConsultorio;
	}

	public String getNumeroConsultorio() {
		return numeroConsultorio;
	}

	public void setNumeroConsultorio(String numeroConsultorio) {
		this.numeroConsultorio = numeroConsultorio;
	}

	public String getBairroConsultorio() {
		return bairroConsultorio;
	}

	public void setBairroConsultorio(String bairroConsultorio) {
		this.bairroConsultorio = bairroConsultorio;
	}

	public String getCidadeConsultorio() {
		return cidadeConsultorio;
	}

	public void setCidadeConsultorio(String cidadeConsultorio) {
		this.cidadeConsultorio = cidadeConsultorio;
	}

	public String getEstadoConsultorio() {
		return estadoConsultorio;
	}

	public void setEstadoConsultorio(String estadoConsultorio) {
		this.estadoConsultorio = estadoConsultorio;
	}

	public String getCnpjConsultorio() {
		return cnpjConsultorio;
	}

	public void setCnpjConsultorio(String cnpjConsultorio) {
		this.cnpjConsultorio = cnpjConsultorio;
	}

	public StatusMedico getStatusMedico() {
		return statusMedico;
	}

	public void setStatusMedico(StatusMedico statusMedico) {
		this.statusMedico = statusMedico;
	}

}
