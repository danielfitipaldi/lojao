package br.unit.lojaoDasPecas.controllers;

import java.util.List;

import br.unit.lojaoDasPecas.entidades.MaisVendidos;
import br.unit.lojaoDasPecas.repository.MaisVendidosDAO;

public class MaisVendidosController {
	MaisVendidosDAO mvDao = new MaisVendidosDAO();
	
	public List<MaisVendidos> getConsulta(){
		return mvDao.getConsulta();
	}

}
