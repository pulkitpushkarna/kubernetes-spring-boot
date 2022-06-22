package com.kuberneteswithspringboot.demo.kubenetesspringboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootApplication
@RestController
public class KubernetesSpringBootApplication {

	@Value("${app.version}")
	String appVersion;

	@GetMapping("/")
	public String index() throws IOException {
		String returnString= "Spring Boot App--"+ appVersion;
		String cmd = "cat /proc/self/mountinfo | grep /docker/containers/";
		Runtime run = Runtime.getRuntime();
		Process pr = run.exec(cmd);
		try {
			pr.waitFor();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
		String line = " ";
		if (( line=buf.readLine())!=null) {
			returnString+=line;
		}
		return returnString;
	}

	public static void main(String[] args) {
		SpringApplication.run(KubernetesSpringBootApplication.class, args);
	}

}
