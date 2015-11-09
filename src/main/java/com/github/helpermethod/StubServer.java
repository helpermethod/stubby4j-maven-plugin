package com.github.helpermethod;

import by.stub.client.StubbyClient;
import org.apache.maven.plugin.MojoExecutionException;

class StubServer {
    private StubbyClient client;

    private StubServer(StubbyClient client) {
        this.client = client;
    }

    static StubServer createStarted(int stubsPort, String data) throws MojoExecutionException {
        StubbyClient client = new StubbyClient();

        try {
            client.startJetty(stubsPort, data);
        } catch (Exception e) {
            throw new MojoExecutionException("Failure", e);
        }

        return new StubServer(client);
    }

    void stop() throws MojoExecutionException {
        try {
            client.stopJetty();
        } catch (Exception e) {
            throw new MojoExecutionException("Failure", e);
        }
    }

    void waitForFinish() throws MojoExecutionException {
        try {
            client.joinJetty();
        } catch (InterruptedException e) {
            throw new MojoExecutionException("Failure", e);
        }
    }
}