package com.github.helpermethod;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo(name = "start", defaultPhase = LifecyclePhase.PRE_INTEGRATION_TEST)
public class StartMojo extends AbstractMojo {
    @Parameter(defaultValue = "8882")
    private int stubsPort;
    @Parameter(defaultValue = "src/it/stubby.yml")
    private String data;
    @Parameter(defaultValue = "true")
    private boolean skip;

    public void execute() throws MojoExecutionException, MojoFailureException {
        if (skip) {
            return;
        }

        getPluginContext().put("client", StubServer.createStarted(stubsPort, data));
    }
}