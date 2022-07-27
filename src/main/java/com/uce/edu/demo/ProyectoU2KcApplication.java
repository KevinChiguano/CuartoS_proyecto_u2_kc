package com.uce.edu.demo;

import java.util.Iterator;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.cajero.repository.modelo.DetalleFactura;
import com.uce.edu.demo.cajero.repository.modelo.Factura;
import com.uce.edu.demo.cajero.service.IFacturaService;

@SpringBootApplication
public class ProyectoU2KcApplication implements CommandLineRunner{

	private static final Logger LOGGER = Logger.getLogger(ProyectoU2KcApplication.class);
		
	@Autowired
	private IFacturaService facturaService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2KcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Factura fact = this.facturaService.consultar(1);
		LOGGER.info("Numero: "+fact.getNumero());
		LOGGER.info("Fecha: "+fact.getFecha());
		LOGGER.info("Cliente: "+fact.getCliente().getNumeroTarjeta());
		List<DetalleFactura> detalles = fact.getDetalles();
		for(DetalleFactura deta: detalles) {
			LOGGER.info("Detalle: "+deta);
		}
	}

}
