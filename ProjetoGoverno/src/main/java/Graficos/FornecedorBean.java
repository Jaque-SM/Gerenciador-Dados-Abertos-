package Graficos;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped; 
import org.primefaces.model.chart.PieChartModel;

@ManagedBean(name = "vendaBean") 
@RequestScoped 
public class FornecedorBean {
	private PieChartModel forne;

	public FornecedorBean() {
		this.forne = new PieChartModel();
		this.forne.set("Brasil", 540.50f);
		this.forne.set("Estados Unidos", 590.52f);
		this.forne.set("Inglaterra", 475.30f);
		this.forne.set("França", 400);
		this.forne.set("Alemanha", 397.33f);
		this.forne.setTitle("Gráfico de vendas por país");
		this.forne.setLegendPosition("e");
		this.forne.setShowDataLabels(true);
		this.forne.setDataFormat("percent");
	}

	public PieChartModel getVendaPais() {
		return forne;
	}
}
