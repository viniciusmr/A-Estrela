package br.com.vinicius;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class A_Estrela {
	
	static Table<Node,Node,Integer> distancia = HashBasedTable.create();
	static Map<Node, Node> caminho = new HashMap<Node, Node>();
	static Node[] cidades = new Node[30];
	
	public static int Search_name(String nome_cidade) throws Exception{
		for (int i=0; i<20; i++){
			if (nome_cidade.equals(cidades[i].getNome())){
				return i;
			}
		}
		throw new Exception("Nao existe cidade com este nome.");
	}

	public static void add_aresta(String cid1, String cid2, int dist) throws Exception{
		int cod1 = Search_name(cid1);
		int cod2 = Search_name(cid2);
		
		cidades[cod1].AddVizinhos(cidades[cod2]);
		cidades[cod2].AddVizinhos(cidades[cod1]);
		distancia.put(cidades[cod1], cidades[cod2], dist);
		distancia.put(cidades[cod2], cidades[cod1], dist);
	}
	
	public static void popular_rotas() throws Exception{
		
		add_aresta("Arad", "Zerind", 75);
		add_aresta("Arad", "Timisoara", 118);
		add_aresta("Arad", "Sibiu", 140);
		add_aresta("Zerind", "Oradea", 71);
		add_aresta("Oradea", "Sibiu", 151);	
		add_aresta("Sibiu", "Fagaras", 99);		
		add_aresta("Sibiu", "Rimnicu Vilcea", 80);	
		add_aresta("Timisoara", "Lugoj", 111);		
		add_aresta("Lugoj", "Mehadia", 70);	
		add_aresta("Mehadia", "Dobreta", 75);
		add_aresta("Craiova", "Dobreta", 120);		
		add_aresta("Craiova", "Rimnicu Vilcea", 146);		
		add_aresta("Craiova", "Pitesti", 138);
		add_aresta("Pitesti", "Rimnicu Vilcea", 97);
		add_aresta("Bucharest", "Pitesti", 101);
		add_aresta("Bucharest", "Fagaras", 211);	
		add_aresta("Bucharest", "Giurgiu", 90);		
		add_aresta("Bucharest", "Urziceni", 85);		
		add_aresta("Hirsowa", "Urziceni", 98);	
		add_aresta("Hirsowa", "Eforie", 85);		
		add_aresta("Urziceni", "Vaslui", 142);
		add_aresta("Iasi", "Vaslui", 92);
		add_aresta("Iasi", "Neamt", 87);
	}
	
	public static void popular_cidades() throws Exception{
		
		for (int i=0; i<30; i++){
			cidades[i] = new Node();
		}
		
		cidades[0].setNome("Arad");
		cidades[0].setDist_buc(366);	
		
		cidades[1].setNome("Bucharest");
		cidades[1].setDist_buc(1);
		
		cidades[2].setNome("Craiova");
		cidades[2].setDist_buc(160);
		
		cidades[3].setNome("Dobreta");
		cidades[3].setDist_buc(242);
		
		cidades[4].setNome("Eforie");
		cidades[4].setDist_buc(161);
		
		cidades[5].setNome("Fagaras");
		cidades[5].setDist_buc(176);
		
		cidades[6].setNome("Giurgiu");
		cidades[6].setDist_buc(77);
		
		cidades[7].setNome("Hirsowa");
		cidades[7].setDist_buc(151);
		
		cidades[8].setNome("Iasi");
		cidades[8].setDist_buc(226);
		
		cidades[9].setNome("Lugoj");
		cidades[9].setDist_buc(244);
		
		cidades[10].setNome("Mehadia");
		cidades[10].setDist_buc(241);
		
		cidades[11].setNome("Neamt");
		cidades[11].setDist_buc(234);
		
		cidades[12].setNome("Oradea");
		cidades[12].setDist_buc(380);
		
		cidades[13].setNome("Pitesti");
		cidades[13].setDist_buc(10);
		
		cidades[14].setNome("Rimnicu Vilcea");
		cidades[14].setDist_buc(193);
		
		cidades[15].setNome("Sibiu");
		cidades[15].setDist_buc(253);
		
		cidades[16].setNome("Timisoara");
		cidades[16].setDist_buc(329);
		
		cidades[17].setNome("Urziceni");
		cidades[17].setDist_buc(80);
		
		cidades[18].setNome("Vaslui");
		cidades[18].setDist_buc(199);
		
		cidades[19].setNome("Zerind");
		cidades[19].setDist_buc(374);
		
		
	}

	public static void disp_borda(SortedSet<Celula> borda){
		System.out.println("------------ Borda ------------"); 
		for (Celula e : borda) {
			e.print();
		}
		System.out.println("-------------------------------\n\n\n");
	}
	
	public static boolean Reconstruct_path(Node filho){
		while (filho != null){
			System.out.print(filho.getNome() + " <-- ");
			filho = caminho.get(filho);
		}
		System.out.println();
		return true;
	}
	
	public static boolean busca_Estrela(String cid_origem, String cid_destino) throws Exception{
		
		SortedSet<Celula> borda = new TreeSet<Celula>();
		Node destino = cidades[Search_name(cid_destino)];
		
		Celula estado_atual = new Celula();
		estado_atual.setEstado(cidades[Search_name(cid_origem)]);
		
		int funcao_de_borda=0;
		
		borda.add(estado_atual);
		
		while(!borda.isEmpty()){
			
			disp_borda(borda);
			
			estado_atual=borda.first();
			borda.remove(estado_atual);
			
			System.out.println("\nCidade com menor função de borda: "+ estado_atual.getEstado().getNome());
			
			if (estado_atual.getEstado() == destino) return(Reconstruct_path(estado_atual.getEstado()));
			
			estado_atual.getEstado().setExplored(true);
			
			//System.out.println("Distancia percorrida até aqui:" + estado_atual.getCusto());
			//System.out.println("\nVizinhos de "+ estado_atual.getEstado().getNome() + ":");
			
			for (Node no : estado_atual.getEstado().vizinhos){
				System.out.println(no.getNome());
				//System.out.println(no.getDist_buc());
				
				funcao_de_borda = estado_atual.getCusto()+distancia.get(estado_atual.getEstado(), no);
				
				if (!no.isExplored() && !no.esta_na_borda(borda)){
					//System.out.println("Não foi explorado e não está na borda:" + no.getNome());
					Celula tmp = new Celula();
					tmp.setEstado(no);
					//System.out.println("Nó: " + no.getNome());
					//System.out.println("Nó: " + tmp.getEstado().getNome());
					
					tmp.setPai(estado_atual.getEstado());
					//System.out.println("Pai: " + estado_atual.getEstado().getNome());
					//System.out.println("Pai: " + tmp.getPai().getNome());
					
					tmp.setCusto(estado_atual.getCusto()+distancia.get(estado_atual.getEstado(), no));
					//System.out.println("Custo: " + funcao_de_borda);
					//System.out.println("Custo: " + tmp.getCusto());
					borda.add(tmp);
					//System.out.println(borda.add(tmp));
					caminho.put(no, estado_atual.getEstado());
					//disp_borda(borda);
				}
				else{
					for (Celula e : borda) {
				        if ( e.getEstado() == no && e.getCusto() > funcao_de_borda ) {
				        	e.setPai(estado_atual.getEstado());
				        	e.setCusto(funcao_de_borda);
				        	break;
				        }
					}
				}
				
				
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		popular_cidades();
		popular_rotas();
		//busca_Estrela("Arad","Bucharest");
		busca_Estrela("Timisoara","Bucharest");
	}
}
