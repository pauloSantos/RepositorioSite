package com.site.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="menu_usuario")
public class MenuUsuario {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="nome_menu")
	private String nomeMenu;
	
	@Column(name="caminho")
	private String caminhoMenu;
	
	@Column(name="tipo_usuario")
	@Enumerated(EnumType.STRING)
	private String tipoUsuario;
	
	@Column(name="posicao")
	private int posicao;

	public int getId() {
		return id;
	}

	public String getNomeMenu() {
		return nomeMenu;
	}

	public void setNomeMenu(String nomeMenu) {
		this.nomeMenu = nomeMenu;
	}

	public String getCaminhoMenu() {
		return caminhoMenu;
	}

	public void setCaminhoMenu(String caminho) {
		this.caminhoMenu = caminho;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}
}
