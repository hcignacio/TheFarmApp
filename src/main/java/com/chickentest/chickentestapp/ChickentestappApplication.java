package com.chickentest.chickentestapp;

import com.chickentest.chickentestapp.model.*;
import com.chickentest.chickentestapp.repository.*;

import java.util.LinkedList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.chickentest.chickentestapp.controller"})
@EntityScan("com.chickentest.chickentestapp.model")
@EnableJpaRepositories("com.chickentest.chickentestapp.repository")
public class ChickentestappApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChickentestappApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner initDataGamePlayer(FarmRepository farmRepository,
												ChickenRepository chickenRepository,
												EggRepository eggRepository) {
		return (String... args) -> {
			
			Farm farm = new Farm();
			Farm farmB = new Farm();
			Farm farmC = new Farm();
			
			farm.setName("Granja 1");
			farmB.setName("Granja 2");
			farmC.setName("Granja 3");
			
			farmRepository.save(farm);
			farmRepository.save(farmB);
			farmRepository.save(farmC);
			
			Chicken chicken1 = new Chicken(farm, "Gallina 1");
			Chicken chicken2 = new Chicken(farm, "Gallina 2");
			Chicken chicken3 = new Chicken(farm, "Gallina 3");
			
			List<Chicken> chickensToFarm = new LinkedList<Chicken>();
			chickensToFarm.add(chicken1);
			chickensToFarm.add(chicken2);
			chickensToFarm.add(chicken3);
			
			farm.addChickens(chickensToFarm);
			
			chickenRepository.save(chicken1);
			chickenRepository.save(chicken2);
			chickenRepository.save(chicken3);
			
			Egg egg11 = new Egg(chicken1);
			Egg egg12 = new Egg(chicken1);
			Egg egg13 = new Egg(chicken1);
			
			Egg egg21 = new Egg(chicken2);
			Egg egg22 = new Egg(chicken2);
			
			Egg egg31 = new Egg(chicken3);
			Egg egg32 = new Egg(chicken3);
			Egg egg33 = new Egg(chicken3);
			Egg egg34 = new Egg(chicken3);
			
			eggRepository.save(egg11);
			eggRepository.save(egg12);
			eggRepository.save(egg13);
			eggRepository.save(egg21);
			eggRepository.save(egg22);
			eggRepository.save(egg31);
			eggRepository.save(egg32);
			eggRepository.save(egg33);
			eggRepository.save(egg34);
		};
	}
}
