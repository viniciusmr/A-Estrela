package br.com.vinicius;

public class Borda implements Comparable<Borda> {


	public int getCusto() {
		return custo;
	}



	public void setCusto(int custo) {
		this.custo = custo;
	}



	private int custo;
	private Node pai = new Node();
	private Node estado;
	
	public void print(){
		System.out.println("Pai: " + pai.getNome() + " -> " + estado.getNome() + "      Custo: " + custo + "  G + H: " + (custo + estado.getDist_buc()) );
	}

	@Override
	public int compareTo(Borda outroNode) {
		if (this.custo + estado.getDist_buc() < outroNode.custo + outroNode.getEstado().getDist_buc()) {
            return -1;
        }
        if (this.custo + estado.getDist_buc() > outroNode.custo + outroNode.getEstado().getDist_buc()) {
            return 1;
        }
        return 0;
	}



	public Node getEstado() {
		return estado;
	}



	public void setEstado(Node estado) {
		this.estado = estado;
	}



	public Node getPai() {
		return pai;
	}



	public void setPai(Node pai) {
		this.pai = pai;
	}
	
	
}
