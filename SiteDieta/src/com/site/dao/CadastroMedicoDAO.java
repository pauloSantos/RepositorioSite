package com.site.dao;

import java.util.List;

import javax.persistence.Query;

import com.site.business.enums.StatusMedico;
import com.site.model.CadastroMedico;

public class CadastroMedicoDAO extends PrincipalDAO{

	private static final String STATUS = "status";
	private static final String ID_CADASTRO_MEDICO = "idCadastroMedico";
	private static final String QUERY_PROCURAR_CADASTRO_MEDICO_POR_STATUS = 
			"select obj from " + CadastroMedico.class.getName() + " obj"  + 
			" where obj.statusMedico =:" + STATUS +
			" order by nome";
	
	private static final String DELETAR_CADASTRO =
			"delete from " + CadastroMedico.class.getName() +" obj" +
			" where obj.id =:" + ID_CADASTRO_MEDICO;

	public CadastroMedicoDAO() {
		super();
	}
	
	public CadastroMedico encontrarCadastroMedicoPorId(Long id){
		manager.getTransaction().begin();
		CadastroMedico cadastroMedico = manager.find(CadastroMedico.class, id);
		manager.getTransaction().commit();
		return cadastroMedico;
	}
	
	@SuppressWarnings("unchecked")
	public List<CadastroMedico> procurarCadastroMedicoPorStatus(StatusMedico status){
		Query query = manager.createQuery(QUERY_PROCURAR_CADASTRO_MEDICO_POR_STATUS);
		query.setParameter(STATUS, status);
		return (List<CadastroMedico>)query.getResultList();
	}
	
	public void deletarCadastro(Long idCadastroMedico){
		Query query = manager.createQuery(DELETAR_CADASTRO);
		query.setParameter(ID_CADASTRO_MEDICO, idCadastroMedico);
		manager.getTransaction().begin();
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		manager.getTransaction().commit();
	}
}
