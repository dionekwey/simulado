package dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="tb_espetaculos")
public class Espetaculo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cod_espetaculo;
	private String nome;
	
	@OneToMany(mappedBy="espetaculo")
	private List<Participacao> participacoes;
	
	public Espetaculo(){
		this.participacoes = new ArrayList<Participacao>();
	}

	public Espetaculo(Integer cod_espetaculo, String nome) {
		super();
		this.cod_espetaculo = cod_espetaculo;
		this.nome = nome;
		this.participacoes = new ArrayList<Participacao>();
	}

	public Integer getCod_espetaculo() {
		return cod_espetaculo;
	}

	public void setCod_espetaculo(Integer cod_espetaculo) {
		this.cod_espetaculo = cod_espetaculo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Participacao> getParticipacoes() {
		return participacoes;
	}

	public void setParticipacoes(List<Participacao> participacoes) {
		this.participacoes = participacoes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod_espetaculo == null) ? 0 : cod_espetaculo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Espetaculo other = (Espetaculo) obj;
		if (cod_espetaculo == null) {
			if (other.cod_espetaculo != null)
				return false;
		} else if (!cod_espetaculo.equals(other.cod_espetaculo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Espetaculo [cod_espetaculo=" + cod_espetaculo + ", nome=" + nome + "]";
	}
	
	public BigDecimal precoTotal(){
		BigDecimal preco;
		preco = new BigDecimal("0.00");
		for (int i=0; i < participacoes.size();i++){
			preco = preco.add(participacoes.get(i).getBanda().getPreco());
		}
		return preco;				
	}
}
