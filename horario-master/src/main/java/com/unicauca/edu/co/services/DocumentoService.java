package com.unicauca.edu.co.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.unicauca.edu.co.response.ResponseRest;

@Service
public class DocumentoService {
	
	public ResponseEntity<Object> trabajarDocumento(MultipartFile file)  {
		ResponseRest response = new ResponseRest();
		if(!file.isEmpty()) {
//esparcio para trabajar file que es el archivo
							   // nombre del archivo	//lo spliteo por(.) como puede tener varios . en el nombre solo uso la ultima posición
			String extension = file.getOriginalFilename().split("\\.")[file.getOriginalFilename().split("\\.").length-1];
			System.out.println("archivo "+file.getOriginalFilename());
			if(extension.equals("xlsx")) {
				try {
					File convertFile = new File(System.getProperty("java.io.tmpdir")+"/"+file.getOriginalFilename());
					file.transferTo(convertFile);
					InputStream inp = new FileInputStream(convertFile);
					Workbook wb = WorkbookFactory.create(inp);
					Sheet sheet = wb.getSheetAt(0);
					int irow = 0;
					Row row = sheet.getRow(irow);
					
					while(row!=null) {
						if(row.getCell(1) == null) {
							break;
						}
						Cell cell = row.getCell(1);
						String value = cell.getStringCellValue();
						
						System.out.println(" "+value);
						irow++;
						row = sheet.getRow(irow);
						
					}
				} catch (Exception e) {
					e.printStackTrace();
					response.setMetadata("Respuesta nok", "-1", "Se lanzo una excepcion");
					return new ResponseEntity<Object> (response, HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
//fin espacio para trabajar file 
			response.setMetadata("Respuesta ok", "00", "Se cargo el archivo");
		}
		else {
			response.setMetadata("Respuesta nok", "-1", "No se envio archivo");
			return new ResponseEntity<Object> (response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object> (response, HttpStatus.OK);
	}
}
