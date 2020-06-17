package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.album;
import com.example.demo.Interfaces.IAlbum;
import com.example.demo.Repository.AlbumRepository;

@Service
public class AlbumService implements IAlbum {

	@Autowired
	AlbumRepository album;
	
	@Override
	public List<album> listaAlbum() {
		return album.findAll();
	}
	
	@Override
	public album listarId(Long id) {
		return album.findById(id).get();
	}

	@Override
	public album guardarAlbum(album u) {
		return album.save(u);
	}
}
