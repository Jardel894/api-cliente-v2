package br.com.devsFutures.cliente.dto.request;

import br.com.devsFutures.cliente.entities.Endereco;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoRequest {

    private String cep;

    private String logradouro;

    private String complemento;

    private String bairro;

    private String localidade;

    private String uf;

    private Integer numero;

    public Endereco to(){
        return Endereco.builder()
                .logradouro(this.logradouro)
                .numero(this.numero)
                .bairro(this.bairro)
                .cep(this.cep)
                .uf(this.uf)
                .localidade(this.localidade)
                .complemento(this.complemento)
                .build();
    }

}
