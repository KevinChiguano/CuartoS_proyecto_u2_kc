package com.uce.edu.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.prueba.modelo.Propietario;
import com.uce.edu.demo.prueba.modelo.Vehiculo;
import com.uce.edu.demo.prueba.service.IMatriculaGestorService;
import com.uce.edu.demo.prueba.service.IPropietarioService;
import com.uce.edu.demo.prueba.service.IVehiculoService;
import com.uce.edu.demo.service.IPersonaJpaService;

@SpringBootApplication
public class ProyectoU2KcApplication implements CommandLineRunner{

	private static final Logger LOGGER = Logger.getLogger(ProyectoU2KcApplication.class);
	
	@Autowired
	private IPersonaJpaService iPersonaJpaService;
	
	@Autowired
	private IPropietarioService iPropietarioService;
	
	@Autowired
	private IVehiculoService iVehiculoService;
	
	@Autowired
	private IMatriculaGestorService gestorService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2KcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setMarca("Totota");
		vehiculo.setPlaca("PGH5999");
		vehiculo.setPrecio(new BigDecimal(35000));
		vehiculo.setTipo("P");
		
		this.iVehiculoService.insertar(vehiculo);
		
		vehiculo.setPrecio(new BigDecimal(25000));
		vehiculo.setMarca("Nissan");
		this.iVehiculoService.actualizar(vehiculo);
		
		Propietario pro = new Propietario();
		pro.setApellido("Aguilar");
		pro.setNombre("Juan");
		pro.setCedula("1593582467");
		pro.setFechaNacimiento(LocalDateTime.now());
		this.iPropietarioService.crear(pro);
		
		
	}

}
