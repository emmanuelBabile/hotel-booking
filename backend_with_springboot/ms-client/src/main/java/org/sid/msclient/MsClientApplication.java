package org.sid.msclient;

import org.sid.msclient.entities.Client;
import org.sid.msclient.repositories.ClientRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

@SpringBootApplication
public class MsClientApplication {

    @Bean
    WebClient webClient(){
        return WebClient.builder().build();
    }

    public static void main(String[] args) {
        SpringApplication.run(MsClientApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ClientRepo clientRepo){
        return args -> {
            ArrayList<String> listFullName = new ArrayList<>(Arrays.asList("Lewis Johnson", "Michelle Dechamps", "Léon Camara", "Yasmine Hassan", "Paolo Francisco"));
            ArrayList<String> listCin = new ArrayList<>(Arrays.asList("RG68023", "KS88409", "UJ26893", "BU68343", "TG74598"));
            ArrayList<String> listPhoneNumber = new ArrayList<>(Arrays.asList("+33603482230", "+216640956713", "+276309758477", "+1399347776"));

            for(int i=1;i<=10; i++){
                Random random = new Random();
                int indexFullName = random.nextInt(0,4);
                int indexCin = random.nextInt(0,4);
                int indexPhoneNumber = random.nextInt(0,4);
                Client client = Client.builder()
                        .fullName(listFullName.get(indexFullName))
                        .cin(listCin.get(indexCin))
                        .phoneNumber(listPhoneNumber.get(indexPhoneNumber))
                        .build();
                clientRepo.save(client);
            }

        };
    }
}

