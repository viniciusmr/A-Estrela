package br.com.vinicius;

import java.util.ArrayList;
import java.util.List;

public class Node{
	
	
	public int getDist_buc() {
		return dist_buc;
	}
	public void setDist_buc(int dist_buc) {
		this.dist_buc = dist_buc;
	}
	public List<Node> getVizinhos() {
		return vizinhos;
	}
	public void setVizinhos(List<Node> vizinhos) {
		this.vizinhos = vizinhos;
	}
	
	public void AddVizinhos(Node vizinho) {
		this.vizinhos.add(vizinho);
	}
	
	/*public byte getIndex() {
		return index;
	}
	public void setIndex(byte index) {
		this.index = index;
	}*/
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	List <Node> vizinhos = new ArrayList<Node>();
	
	//byte index;
	String nome;
	int dist_buc;
	
}