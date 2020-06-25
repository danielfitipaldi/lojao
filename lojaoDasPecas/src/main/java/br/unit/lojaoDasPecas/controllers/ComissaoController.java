package br.unit.lojaoDasPecas.controllers;

import java.util.List;

import br.unit.lojaoDasPecas.entidades.Comissao;
import br.unit.lojaoDasPecas.repository.ComissaoDAO;

public class ComissaoController {
ComissaoDAO comissaoDao = new ComissaoDAO(); 
	
	public List<Comissao> getConsulta(){
		return comissaoDao.getConsulta();
	}
}
