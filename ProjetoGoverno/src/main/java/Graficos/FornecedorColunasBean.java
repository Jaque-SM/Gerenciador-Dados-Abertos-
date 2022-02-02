package Graficos;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

import Model.Fornecedor;
import ModelRN.FornecedorRN;

@ManagedBean(name = "fornecedorColunasBean") 
@RequestScoped
public class FornecedorColunasBean {

	private BarChartModel fornecedor;
	
	
	public BarChartModel getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(BarChartModel fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	
	/**
	 * Representa o UFs e as quantidades de fornecedores relacionadas a cada um.
	 */
	
	public FornecedorColunasBean() {
		
		List<EstadoFornecedor> forns;
		
		List<String> estados;

		this.fornecedor=new BarChartModel();
		
		forns=new FornecedorRN().listarPopulosos();
		
	   estados=new FornecedorRN().listarUf();
	   
		for (int i = 0; i<13; i++) {
			
			EstadoFornecedor forn=new EstadoFornecedor();
			
		     forn.setUflocal(estados.get(i));
		     
		     
		     List<Fornecedor> fornecedores=new FornecedorRN().listarFornecedorPorUF(estados.get(i));
		     forn.setFornecedores(fornecedores.size());

			ChartSeries fornecedorseries = new ChartSeries();

			fornecedorseries.setLabel(forn.getUflocal());
			fornecedorseries.set(" ",forn.getFornecedores());
			this.fornecedor.addSeries(fornecedorseries);
			
		
		}
		System.out.print("\n");
		fornecedor.setLegendPosition("AV");
		
	}

	
}


