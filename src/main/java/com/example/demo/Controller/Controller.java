package com.example.demo.Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.album;
import com.example.demo.Services.AlbumService;

@RestController
@RequestMapping("albums")
public class Controller {

	@Autowired
	private AlbumService albumService;
	
	@GetMapping("/cargarJson/{id}")
	public void muestraContenido(@PathVariable(name = "id") Long idB) throws FileNotFoundException, IOException {
		File archivo = new File ("src/main/resources/albums.json");
		FileReader fr = new FileReader (archivo);
		BufferedReader br = new BufferedReader(fr);
		String linea = br.readLine();
		
        while((linea=br.readLine())!=null)
        	if(albumExistente(idB) == false) {
        		int UserId= Integer.parseInt(linea.substring(0, 10));
        		Long id= Long.parseLong(linea.substring(0, 20));
        		String title= linea.substring(0, 100);
        		agregarAlbum(UserId,  id,  title);
        	}
        System.out.println(linea);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void agregarAlbum(@RequestBody int UserId, @RequestBody Long id, @RequestBody String title) {
	  album a = new album();
	  a.setUserId(UserId);
	  a.setId(id);
	  a.setTitle(title);
	  crearAlbum(a);
	}
	
	@GetMapping("/albumListar")
	public List<album> listaAlbum() {
		return albumService.listaAlbum();
	}
	
	@GetMapping("/album/{id}")
	public album listarId(@PathVariable(name = "id") Long id) {
		album albumid = new album();
		albumid = albumService.listarId(id);
		return albumid;
	} 
	
	@GetMapping("/albumExistente/{id}")
	public boolean albumExistente(@PathVariable(name = "id") Long id) {
		album albumid = new album();
		albumid = albumService.listarId(id);
		return true;
	} 
	
	@PostMapping("/album")
	public album crearAlbum(@RequestBody album u) {
		return albumService.guardarAlbum(u);
	}
}