package br.unip.dsd_microservice.modelo;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class ExemploJson {
    private long id;

    @Length(max = 3)
    private String content;

    public ExemploJson() {
        // Jackson deserialization
    }

    public ExemploJson(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}