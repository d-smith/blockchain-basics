package org.ds.bcb.mempool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class MempoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(MempoolApplication.class, args);
	}

}
