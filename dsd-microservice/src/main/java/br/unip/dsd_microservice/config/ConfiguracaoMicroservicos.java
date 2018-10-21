package br.unip.dsd_microservice.config;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

public class ConfiguracaoMicroservicos extends Configuration {
    @NotEmpty
    private String template;

    @NotEmpty
    private String nomePadrao = "Estranho";

    @JsonProperty
    public String getTemplate() {
        return template;
    }

    @JsonProperty
    public void setTemplate(String template) {
        this.template = template;
    }

    @JsonProperty
    public String getNomePadrao() {
        return nomePadrao;
    }

    @JsonProperty
    public void setNomePadrao(String name) {
        this.nomePadrao = name;
    }
}