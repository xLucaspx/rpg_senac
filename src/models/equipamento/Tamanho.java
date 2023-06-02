package models.equipamento;

public enum Tamanho {
	// short e long
	SHORT(0), LONG(1);
	
	private int tamanho;
	
	private Tamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	
	public int getTamanho() {
		return tamanho;
	}
}
