package br.unit.lojaoDasPecas.controllers;

import java.util.List;

import br.unit.lojaoDasPecas.entidades.RelatorioVendas;
import br.unit.lojaoDasPecas.repository.RelatorioVendasDAO;

public class RelatorioVendasController {
	RelatorioVendasDAO rvDao = new RelatorioVendasDAO();
	public List<RelatorioVendas> getConsulta(){
		return rvDao.getConsulta();
	}

}
