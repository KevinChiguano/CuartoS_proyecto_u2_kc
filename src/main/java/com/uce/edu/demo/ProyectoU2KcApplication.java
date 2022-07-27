package com.uce.edu.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
import com.uce.edu.demo.prueba.modelo.Propietario;
import com.uce.edu.demo.prueba.modelo.Vehiculo;
import com.uce.edu.demo.prueba.service.IMatriculaGestorService;
import com.uce.edu.demo.prueba.service.IPropietarioService;
import com.uce.edu.demo.prueba.service.IVehiculoService;

@SpringBootApplication
public class ProyectoU2KcApplication implements CommandLineRunner{

	private static final Logger LOGGER = Logger.getLogger(ProyectoU2KcApplication.class);
		
	@Autowired
	private IFacturaService facturaService;
	
	@Autowired
	private IVehiculoService vehiculoService;
	
	@Autowired 
	private IPropietarioService propietarioService;
	
	@Autowired
	private IMatriculaGestorService matriculaGestorService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2KcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		/*Factura fact = this.facturaService.consultar(1);
		LOGGER.info("Numero: "+fact.getNumero());
		LOGGER.info("Fecha: "+fact.getFecha());
		LOGGER.info("Cliente: "+fact.getCliente().getNumeroTarjeta());
		List<DetalleFactura> detalles = fact.getDetalles();
		for(DetalleFactura deta: detalles) {
			LOGGER.info("Detalle: "+deta);
		}*/
		
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setMarca("Alfa Romero");
		vehiculo.setPlaca("PJH0022");
		vehiculo.setPrecio(new BigDecimal(45000));
		vehiculo.setTipo("L");
		
		this.vehiculoService.insertar(vehiculo);
		
		vehiculo.setId(1);
		vehiculo.setMarca("Alfa Romeo");
		vehiculo.setPrecio(new BigDecimal(50000));
		
		this.vehiculoService.actualizar(vehiculo);
		
		Propietario propietario = new Propietario();
		propietario.setApellido("Correa");
		propietario.setNombre("Alan");
		propietario.setCedula("9632587410");
		propietario.setFechaNacimiento(LocalDateTime.now());
		
		this.propietarioService.crear(propietario);
		
		this.matriculaGestorService.generar("9632587410", "PJH0022");
		
	}

}
