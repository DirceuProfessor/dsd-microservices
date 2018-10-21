package br.unip.dsd_microservice.healthcheck;

import com.codahale.metrics.health.HealthCheck;

public class VerificadorMetodoExemplo extends HealthCheck {
    private final String template;

    public VerificadorMetodoExemplo(String template) {
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        final String saying = String.format(template, "TEST");
        if (!saying.contains("TEST")) {
            return Result.unhealthy("não inclui um exemplo de json");
        }
        return Result.healthy();
    }
}