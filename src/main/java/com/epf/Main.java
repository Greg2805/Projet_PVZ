package com.epf;

import jakarta.servlet.Servlet;
import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {
        // 1. Crée le serveur Tomcat
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        // 2. Chemin du contexte webapp
        String contextPath = "/CoursEpfBack";
        // Utilise un dossier temporaire vide comme docBase
        String docBase = new File(System.getProperty("java.io.tmpdir")).getAbsolutePath();
        Context context = tomcat.addWebapp(contextPath, docBase);

        System.out.println("Webapp déployée à : " + contextPath);

        // 3. Crée et configure le contexte Spring
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.scan("com.epf"); // scanne tous tes contrôleurs, services, configs...
        appContext.refresh();
        System.out.println("✅ Spring context initialisé !");


        // 4. Crée le DispatcherServlet (contrôleur frontal Spring MVC)
        Servlet dispatcherServlet = new DispatcherServlet(appContext);
        Tomcat.addServlet(context, "dispatcher", dispatcherServlet);
        context.addServletMappingDecoded("/", "dispatcher");

        // 5. Démarre Tomcat
        tomcat.start();
        System.out.println("🚀 Tomcat en écoute sur http://localhost:8080" + contextPath);
        tomcat.getServer().await();
    }
}
