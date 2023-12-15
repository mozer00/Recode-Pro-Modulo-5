package mvc.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "viagem")
public class Viagem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double valorDiaria;
	private LocalDate dataIda;
	private LocalDate dataVolta;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	@ManyToOne
	@JoinColumn(name = "destino_id")
	private Destino destino;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	@DateTimeFormat(pattern = "dd-MM-yyyy")
    public LocalDate getDataIda() {
        return dataIda;
    }

    public void setDataIda(LocalDate dataIda) {
        this.dataIda = dataIda;
    }

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    public LocalDate getDataVolta() {
        return dataVolta;
    }

    public void setDataVolta(LocalDate dataVolta) {
        this.dataVolta = dataVolta;
    }

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}
}
