package com.site.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.site.business.enums.OpcoesRefeicao;
import com.site.dao.DietaDAO;
import com.site.model.Alimento;
import com.site.model.Dieta;
import com.site.model.Refeicao;
import com.site.web.enums.PublicacaoDietaChaves;
import com.site.web.exception.ChaveNaoEncontradaException;

public class PublicacaoDietaBusiness implements IPublicacaoDieta {

	@Override
	public boolean criarDieta(Dieta dieta, Map<String, String> nomeAlimentos, Map<String, Integer> quantidade, Map<String, String> listaUnidadeDeMedida, String horarioRefeicaoManha, String horarioRefeicaoTarde, String horarioRefeicaoNoite ){

		try{

			List<Alimento> listaAlimentosManhaPrincipal = new ArrayList<Alimento>();
			List<Alimento> listaAlimentosTardePrincipal = new ArrayList<Alimento>();
			List<Alimento> listaAlimentosNoitePrincipal = new ArrayList<Alimento>();

			List<Alimento> listaAlimentosManhaOpcional = new ArrayList<Alimento>();
			List<Alimento> listaAlimentosTardeOpcional = new ArrayList<Alimento>();
			List<Alimento> listaAlimentosNoiteOpcional = new ArrayList<Alimento>();


			PublicacaoDietaChaves[] listaChaves = PublicacaoDietaChaves.values();
			for (PublicacaoDietaChaves chaveAlimento : listaChaves) {
				String nomeAlimento = nomeAlimentos.get(chaveAlimento.getChave());
				if(nomeAlimento != null){
					Alimento alimento = constroiAlimento(chaveAlimento, nomeAlimento, quantidade, listaUnidadeDeMedida);
					if(isAlimentoManha(chaveAlimento)){
						if(isAlimentoOpcional(chaveAlimento)){
							listaAlimentosManhaOpcional.add(alimento);
						}else {
							listaAlimentosManhaPrincipal.add(alimento);
						}

					}else if(isAlimentoTarde(chaveAlimento)){
						if(isAlimentoOpcional(chaveAlimento)){
							listaAlimentosTardeOpcional.add(alimento);
						}else{
							listaAlimentosTardePrincipal.add(alimento);
						}

					}else{
						if(isAlimentoOpcional(chaveAlimento)){
							listaAlimentosNoiteOpcional.add(alimento);
						}else{
							listaAlimentosNoitePrincipal.add(alimento);

						}
					}
				}
			}


			DietaDAO dietaDAO = new DietaDAO();
			dietaDAO.inserir(dieta);

			inserirRefeicoes(dieta, horarioRefeicaoManha, listaAlimentosManhaPrincipal, listaAlimentosManhaOpcional, dietaDAO);

			inserirRefeicoes(dieta, horarioRefeicaoTarde, listaAlimentosTardePrincipal, listaAlimentosTardeOpcional, dietaDAO);

			inserirRefeicoes(dieta, horarioRefeicaoNoite, listaAlimentosNoitePrincipal, listaAlimentosNoiteOpcional, dietaDAO);

			return true;

		}catch (Exception e) {
			return false;
		}
	}

	private Alimento constroiAlimento(PublicacaoDietaChaves chaveAlimento, String nomeAlimento, Map<String, Integer> quantidade, Map<String, String> listaUnidadeDeMedida) throws ChaveNaoEncontradaException {
		Integer quantidadeAlimento = quantidade.get(chaveAlimento.getChave());
		String unidadeDeMedida = listaUnidadeDeMedida.get(chaveAlimento.getChave());

		return new Alimento(nomeAlimento, quantidadeAlimento, unidadeDeMedida);
	}

	private void inserirRefeicoes(Dieta dieta, String horarioRefeicao, List<Alimento> listaAlimentosPrincipais, List<Alimento> listaAlimentosOpcionais, DietaDAO dietaDAO) {
		for (Alimento alimento : listaAlimentosPrincipais) {
			Refeicao refeicaoManha = new Refeicao();
			refeicaoManha.setHorarioRefeicao(horarioRefeicao);
			refeicaoManha.setDieta(dieta);
			refeicaoManha.setOpcoesRefeicao(OpcoesRefeicao.PRINCIPAL);
			alimento.setRefeicao(refeicaoManha);


			dietaDAO.inserir(refeicaoManha);
			dietaDAO.inserir(alimento);
		}

		for (Alimento alimento : listaAlimentosOpcionais) {
			Refeicao refeicaoManha = new Refeicao();
			refeicaoManha.setHorarioRefeicao(horarioRefeicao);
			refeicaoManha.setDieta(dieta);
			refeicaoManha.setOpcoesRefeicao(OpcoesRefeicao.OPCIONAL);
			alimento.setRefeicao(refeicaoManha);

			dietaDAO.inserir(refeicaoManha);
			dietaDAO.inserir(alimento);
		}
	}

	private boolean isAlimentoManha(PublicacaoDietaChaves chaveAlimento) {
		Pattern padrao = Pattern.compile("Manha");
		Matcher matcher = padrao.matcher(chaveAlimento.getChave());
		return matcher.find();
	}

	private boolean isAlimentoTarde(PublicacaoDietaChaves chaveAlimento) {
		Pattern padrao = Pattern.compile("Tarde");
		Matcher matcher = padrao.matcher(chaveAlimento.getChave());
		return matcher.find();
	}

	private boolean isAlimentoOpcional(PublicacaoDietaChaves chaveAlimento) {
		Pattern padrao = Pattern.compile("Opcional");
		Matcher matcher = padrao.matcher(chaveAlimento.getChave());
		return matcher.find();
	}
}
