/**
 * @author Jorge marinho on 31 de dez de 2019
 *
 * 
 */
package com.jm.educacao.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

@Named
@RequestScoped
public class GraficosEducaoBean {
	
	
	private CartesianChartModel model;
	
	public GraficosEducaoBean() {
		
	}
	
	public void preRender() {
		this.model = new CartesianChartModel();
		
		adicionarSerie("Todas as matriculas");
		adicionarSerie("Todos os alunos");
	}

	private void adicionarSerie(String rotulo) {
		ChartSeries series = new ChartSeries(rotulo);
		series.set("1", Math.random() *10);
		series.set("2", Math.random() *10);
		series.set("3", Math.random() *10);
		series.set("4", Math.random() *10);
		series.set("5", Math.random() *10);
		
		this.model.addSeries(series);
		
	}

	public CartesianChartModel getModel() {
		return model;
	}
	
	

}
