package dominio;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="tb_participacoes")
public class Participacao implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cod_participacao;
	private Integer ordem;
	
	@ManyToOne
	@JoinColumn(name="participacoes")
	private Espetaculo espetaculo;
	@ManyToOne
	@JoinColumn(name="participacoes")
	private Banda banda;
	
	public Participacao(){
	}
	
	public Participacao(Integer cod_participacao, Integer ordem, Espetaculo espetaculo, Banda banda) {
		super();
		this.cod_participacao = cod_participacao;
		this.ordem = ordem;
		this.espetaculo = espetaculo;
		this.banda = banda;
	}

	public Integer getCod_participacao() {
		return cod_participacao;
	}

	public void setCod_participacao(Integer cod_participacao) {
		this.cod_participacao = cod_participacao;
	}

	public Integer getOrdem() {
		return ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

	public Espetaculo getEspetaculo() {
		return espetaculo;
	}

	public void setEspetaculo(Espetaculo espetaculo) {
		this.espetaculo = espetaculo;
	}

	public Banda getBanda() {
		return banda;
	}

	public void setBanda(Banda banda) {
		this.banda = banda;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod_participacao == null) ? 0 : cod_participacao.hashCode());
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
		Participacao other = (Participacao) obj;
		if (cod_participacao == null) {
			if (other.cod_participacao != null)
				return false;
		} else if (!cod_participacao.equals(other.cod_participacao))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Participacao [cod_participacao=" + cod_participacao + ", ordem=" + ordem + "]";
	}
}
