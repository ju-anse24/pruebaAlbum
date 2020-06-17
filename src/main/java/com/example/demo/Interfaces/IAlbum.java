package com.example.demo.Interfaces;

import java.util.List;

import com.example.demo.Entity.album;

public interface IAlbum {
	public List<album>listaAlbum();
	public album listarId(Long id);
	public album guardarAlbum(album u);

}
