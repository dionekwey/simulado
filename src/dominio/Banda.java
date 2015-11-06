package dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="tb_bandas")
public class Banda implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cod_banda;
	private String nome;
	private BigDecimal preco;
	
	@OneToMany(mappedBy="banda")
	private List<Participacao> participacoes;
	
	public Banda(){
		this.participacoes = new ArrayList<Participacao>();
	}

	public Banda(Integer cod_banda, String nome, BigDecimal preco) {
		super();
		this.cod_banda = cod_banda;
		this.nome = nome;
		this.preco = preco;
		this.participacoes = new ArrayList<Participacao>();
	}

	public Integer getCod_banda() {
		return cod_banda;
	}

	public void setCod_banda(Integer cod_banda) {
		this.cod_banda = cod_banda;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
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
		result = prime * result + ((cod_banda == null) ? 0 : cod_banda.hashCode());
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
		Banda other = (Banda) obj;
		if (cod_banda == null) {
			if (other.cod_banda != null)
				return false;
		} else if (!cod_banda.equals(other.cod_banda))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Banda [cod_banda=" + cod_banda + ", nome=" + nome + ", preco=" + preco + "]";
	}
}
