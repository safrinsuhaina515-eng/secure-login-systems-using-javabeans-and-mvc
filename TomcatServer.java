package com.example.login.server;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TomcatServer {
    private static final Logger LOGGER = Logger.getLogger(TomcatServer.class.getName());

    public static void main(String[] args) {
        String portValue = System.getProperty("tomcat.port", "8082");
        int port = Integer.parseInt(portValue);
        Tomcat tomcat = null;

        try {
            File baseDir = new File("target/tomcat");
            File webappsDir = new File(baseDir, "webapps");
            if (!webappsDir.exists() && !webappsDir.mkdirs()) {
                LOGGER.warning("Unable to create Tomcat webapps directory.");
            }

            String webappDir = new File("src/main/webapp").getAbsolutePath();

            tomcat = new Tomcat();
            tomcat.setPort(port);
            tomcat.setBaseDir(baseDir.getAbsolutePath());
            tomcat.getEngine().setParentClassLoader(Thread.currentThread().getContextClassLoader());
            tomcat.getConnector();

            Context context = tomcat.addWebapp("", webappDir);
            context.setReloadable(true);

            System.out.println("Starting Tomcat on port " + port + "...");
            tomcat.start();
            System.out.println("Tomcat started successfully!");
            tomcat.getServer().await();
        } catch (LifecycleException ex) {
            LOGGER.log(Level.SEVERE, "LifecycleException starting Tomcat", ex);
            stopQuietly(tomcat);
        } catch (RuntimeException ex) {
            LOGGER.log(Level.SEVERE, "Unexpected error starting Tomcat", ex);
            stopQuietly(tomcat);
        }
    }

    private static void stopQuietly(Tomcat tomcat) {
        if (tomcat == null) {
            return;
        }
        try {
            tomcat.stop();
        } catch (LifecycleException ex) {
            LOGGER.log(Level.SEVERE, "Error stopping Tomcat", ex);
        }
    }
}
