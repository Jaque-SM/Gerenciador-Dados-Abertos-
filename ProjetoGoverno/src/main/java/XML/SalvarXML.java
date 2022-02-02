package XML;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import Model.Fornecedor;

public class SalvarXML {


	public void Salvar_Fornecedor() throws ParserConfigurationException, SAXException, IOException {
		Fornecedor ba = new Fornecedor();

		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = fabrica.newDocumentBuilder();

		org.w3c.dom.Document doc = builder.parse(new File("src/main/webapp/META-INF/fornecedores.xml"));

		FornecedorBD dae = new FornecedorBD();
		NodeList prod = doc.getElementsByTagName("resource");

		for (int i = 1; i < prod.getLength(); i++) {

			Node tat = prod.item(i);
			if (tat.getNodeType() == Node.ELEMENT_NODE) {
				Element novo = (Element) prod.item(i);

				ba.setId(Integer.parseInt(novo.getElementsByTagName("id").item(0).getTextContent()));
				ba.setCnpj(novo.getElementsByTagName("cnpj").item(0).getTextContent());
				ba.setNome(novo.getElementsByTagName("nome").item(0).getTextContent());
				ba.setAtivo(novo.getElementsByTagName("ativo").item(0).getTextContent());
				ba.setId_municipio(novo.getElementsByTagName("id_municipio").item(0).getTextContent());
				ba.setUf(novo.getElementsByTagName("uf").item(0).getTextContent());
				ba.setId_natureza_juridica(novo.getElementsByTagName("id_natureza_juridica").item(0).getTextContent());
				ba.setId_porte_empresa(novo.getElementsByTagName("id_porte_empresa").item(0).getTextContent());
				ba.setId_cnae(novo.getElementsByTagName("id_cnae").item(0).getTextContent());
				ba.setHabilitado_licitar(novo.getElementsByTagName("habilitado_licitar").item(0).getTextContent());

				/*
				 * System.out.print("\n"); System.out.println("Id: "+ba.getId());
				 * System.out.println("Cnpj: "+ba.getCnpj());
				 * System.out.println("Nome: "+ba.getNome());
				 * System.out.println("Status: "+ba.getAtivo());
				 * System.out.println("Id de municipio: "+ba.getId_municipio());
				 * System.out.println("Id Porte da empresa: "+ba.getId_porte_empresa());
				 * System.out.println("Id de cnae: "+ba.getId_cnae());
				 * System.out.println("Status de habilitação: "+ba.getHabilitado_licitar());
				 */
				System.out.println("\n");

				dae.saveFornecedor(ba);

			}

		}

	}

}
