package mvc.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@Entity
@Table( name = "destino")
public class Destino {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double valorPassagem;
	private String cidade;
    private String pais;
   
    
    @OneToMany(mappedBy = "destino")
    private List<Viagem> viagens;
    
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getValorPassagem() {
		return valorPassagem;
	}

	public void setValorPassagem(double valorPassagem) {
		this.valorPassagem = valorPassagem;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	private String formatMoeda(double value) {
		return "R$ " + String.format("%.2f", value);
	}
		
	@Override
	public String toString() {
		
			
		return "Destino [ id = " + id + ", Valor da Passagem = " + formatMoeda(valorPassagem ) + ", Cidade Destino = " + cidade
				+ ", País Destino = " + pais + " ]";
		 

	}
    
    
}
