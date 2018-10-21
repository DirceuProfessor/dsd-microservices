package br.unip.dsd_microservice;


import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import br.unip.dsd_microservice.config.ConfiguracaoMicroservicos;
import br.unip.dsd_microservice.healthcheck.VerificadorMetodoExemplo;
import br.unip.dsd_microservice.resource.ResourceExemplo;

public class AplicacaoExemplo extends Application<ConfiguracaoMicroservicos> {
    public static void main(String[] args) throws Exception {
        new AplicacaoExemplo().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<ConfiguracaoMicroservicos> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(ConfiguracaoMicroservicos configuration,
                    Environment environment) {
        final ResourceExemplo resource = new ResourceExemplo(
            configuration.getTemplate(),
            configuration.getDefaultName()
        );
        environment.jersey().register(resource);
        final VerificadorMetodoExemplo healthCheck =
                new VerificadorMetodoExemplo(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
    }

}