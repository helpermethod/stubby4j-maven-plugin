package com.github.helpermethod;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

@Mojo(name = "stop", defaultPhase = LifecyclePhase.POST_INTEGRATION_TEST)
public class StopMojo extends AbstractMojo {
    public void execute() throws MojoExecutionException {
        StubServer server = (StubServer) getPluginContext().remove("server");

        if (server != null) {
            server.stop();
        }
    }
}
