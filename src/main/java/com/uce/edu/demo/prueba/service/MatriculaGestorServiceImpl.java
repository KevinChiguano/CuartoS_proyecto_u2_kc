package com.uce.edu.demo.prueba.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.prueba.modelo.Matricula;
import com.uce.edu.demo.prueba.modelo.Propietario;
import com.uce.edu.demo.prueba.modelo.Vehiculo;
import com.uce.edu.demo.prueba.repository.IMatriculaRepository;
import com.uce.edu.demo.prueba.repository.IPropietarioRepository;
import com.uce.edu.demo.prueba.repository.IVehiculoRepository;

@Service
public class MatriculaGestorServiceImpl implements IMatriculaGestorService{

	@Autowired
	private IPropietarioRepository iPropietarioRepository;
	
	@Autowired
	private IVehiculoRepository iVehiculoRepository;
	
	@Autowired
	@Qualifier("pesado")
	private IMatriculaService iMatriculaServicePesado;
	
	@Autowired
	@Qualifier("liviano")
	private IMatriculaService iMatriculaServiceLiviano;
	
	@Autowired
	private IMatriculaRepository iMatriculaRepository;
	
	@Override
	public void generar(String cedula, String placa) {
		// TODO Auto-generated method stub
		Propietario pro = this.iPropietarioRepository.consultar(cedula);
		Vehiculo vehi = this.iVehiculoRepository.buscar(placa);
		String tipo = vehi.getTipo();
		BigDecimal valorMatricula;
		if(tipo.equals("P")) {
			valorMatricula = this.iMatriculaServicePesado.calcular(vehi.getPrecio());
			
		}else {
			valorMatricula = this.iMatriculaServiceLiviano.calcular(vehi.getPrecio());
		}
		
		if(valorMatricula.compareTo(new BigDecimal(2000)) > 0) {
			BigDecimal valorDescuento = valorMatricula.multiply(new BigDecimal(7)).divide(new BigDecimal(100));
			valorMatricula = valorMatricula.subtract(valorDescuento);
		}
		
		Matricula matricula = new Matricula();
		matricula.setFechaMatricula(LocalDateTime.now());
		matricula.setPropietario(pro);
		matricula.setValorMatricula(valorMatricula);
		matricula.setVehiculo(vehi);
		
		this.iMatriculaRepository.crear(matricula);
		
	}

}
