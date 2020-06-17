package com.example.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class PruebaAlbumApplication {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		SpringApplication.run(PruebaAlbumApplication.class, args);
	}
}
