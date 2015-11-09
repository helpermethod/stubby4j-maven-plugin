package com.github.helpermethod;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo(name = "run")
public class RunMojo extends AbstractMojo {
    @Parameter(defaultValue = "8882")
    private int stubsPort;
    @Parameter(defaultValue = "src/it/stubby.yml")
    private String data;
    @Parameter(defaultValue = "false")
    private boolean skip;

    public void execute() throws MojoExecutionException, MojoFailureException {
        StubServer.createStarted(stubsPort, data).waitForFinish();
    }
}