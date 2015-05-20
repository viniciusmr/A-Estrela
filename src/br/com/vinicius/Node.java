package br.com.vinicius;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;

public class Node{
	
	List <Node> vizinhos = new ArrayList<Node>();
	
	boolean explored;
	String nome;
	int dist_buc;

	
	
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
	
	public boolean isExplored() {
		return explored;
	}
	public void setExplored(boolean explored) {
		this.explored = explored;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public boolean esta_na_borda(SortedSet<Celula> borda){
		
		for (Celula e : borda) {
			if (e.getEstado().getNome().equals(this.getNome())) {
				return true;
			}
		}
		return false;
	}
	
}
