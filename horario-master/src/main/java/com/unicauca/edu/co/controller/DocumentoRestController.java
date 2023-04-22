package com.unicauca.edu.co.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.unicauca.edu.co.services.DocumentoService;

@RestController
@RequestMapping("/api/v1")
public class DocumentoRestController {
	
	@Autowired DocumentoService docService;
	
	@PostMapping("/document")
	public ResponseEntity<Object> cargarDocumento(@RequestParam("file") MultipartFile file){
		ResponseEntity<Object> respuesta = docService.trabajarDocumento(file);
		return respuesta;
	}

}
