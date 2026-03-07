package it.edu.iisgubbio.oggetti.fattoria;

public class Ortaggio extends Prodotto {

	protected boolean biologico;

	@Override
	public String toString() {
		return "Ortaggio [biologico=" + biologico + ", nome=" + nome + ", prezzoAlKg=" + prezzoAlKg + "]";
	}

	public Ortaggio(String nome, double prezzoAlKg, boolean biologico) {
		super(nome,prezzoAlKg);
		this.biologico=biologico;
	}


}
