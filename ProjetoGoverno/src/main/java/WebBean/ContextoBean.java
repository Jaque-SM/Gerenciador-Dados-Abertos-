package WebBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import Model.Fornecedor;
import Model.Usuario;
import ModelRN.FornecedorRN;
import ModelRN.UsuarioRN;

@ManagedBean
@SessionScoped
public class ContextoBean implements Serializable {

	private static final long serialVersionUID = -2071855184464371947L;
	private List<Locale> idiomas;
	private int codigoFornecedor = 0;

	public Usuario getUsuarioLogado() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		String login = external.getRemoteUser();
		if (login != null) {
			UsuarioRN usuarioRN = new UsuarioRN();
			Usuario usuario = usuarioRN.buscarPorLogin(login);
			String[] info = usuario.getIdioma().split("_");
			Locale locale = new Locale(info[0], info[1]);
			context.getViewRoot().setLocale(locale);
			return usuario;
		}
		return null;
	}
	public List<Locale> getIdiomas() {
		FacesContext context = FacesContext.getCurrentInstance();
		Iterator<Locale> locales = context.getApplication().getSupportedLocales();
		this.idiomas = new ArrayList<Locale>();
		while (locales.hasNext()) {
			this.idiomas.add(locales.next());
		}
		return this.idiomas;
	}

	public Fornecedor getContaAtiva() {
		Fornecedor conta = null;
		if (this.codigoFornecedor == 0) {
			conta = this.getContaAtivaPadrao();
		} else {
			FornecedorRN contaRN = new FornecedorRN();
			conta = contaRN.carregar(this.codigoFornecedor);
		}
		if (conta != null) {
			this.codigoFornecedor = conta.getId();
			return conta;
		}
		return null;
	}

	private Fornecedor getContaAtivaPadrao() {
		FornecedorRN forne = new FornecedorRN();
		Fornecedor conta = null;
		Usuario usuario = this.getUsuarioLogado();
		//conta = FornecedorRN.buscarFavorita(usuario);
		if (conta == null) {
			List<Fornecedor> contas = forne.listar();
			if (contas != null && contas.size() > 0) {
				conta = contas.get(0);
			}
		}
		return conta;
	}

	public void changeContaAtiva(ValueChangeEvent event) {
		this.codigoFornecedor = (Integer) event.getNewValue();
	}
}
