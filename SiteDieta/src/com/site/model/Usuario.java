package com.site.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.site.business.enums.TipoUsuario;

@Entity
public class Usuario {

	@Id
	@GeneratedValue
	private Long id;

	@OneToOne
	@JoinColumn(name="cad_medico_id")
	private CadastroMedico cadastroMedico;

	@Column
	private String login;

	@Column
	private String senha;

	@Column(name="tipo")
	@Enumerated(EnumType.STRING)
	private TipoUsuario tipoUsuario;

	public Long getId(){
		return id;
	}

	public CadastroMedico getCadastroMedico() {
		return cadastroMedico;
	}

	public void setCadastroMedico(CadastroMedico cadastroMedicoId) {
		this.cadastroMedico = cadastroMedicoId;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getNomeUsuario(){
		String nomeMedico ;
		if (TipoUsuario.ADMIN.equals(this.tipoUsuario)) {
			return "Administrador";
		}else{
			nomeMedico = this.getCadastroMedico().getNomeMedico();
			return getPrimeiroNome(nomeMedico);
		}
	}

	public String getPrimeiroNome(String nomeMedico){
		String[] nomeSeparado = nomeMedico.split(" ");
		return nomeSeparado[0];
	}
}
