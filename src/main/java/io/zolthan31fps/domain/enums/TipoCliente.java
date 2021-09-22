package io.zolthan31fps.domain.enums;

public enum TipoCliente {
	
	PESSOAFISICA(10, "Pessoa Fisíca"),
	PESSOAJURIDICA(20, "Pessoa Juridíca");
	
	private int cod;
	private String descricao;
	
	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static TipoCliente toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (TipoCliente x : TipoCliente.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
			
		}
		
		throw new IllegalArgumentException("Id invalido: " + cod);
	}	
	

}
