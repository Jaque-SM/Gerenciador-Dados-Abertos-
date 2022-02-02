package XML;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Teste {

	public static void main(String args[]) throws ParserConfigurationException, SAXException, IOException {

		SalvarXML ava = new SalvarXML();

		System.out.println("Fornecedores");
		ava.Salvar_Fornecedor();

		System.out.println("Fim");

	}
}
