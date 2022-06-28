package com.uce.edu.demo.estudiante.repository;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.ProyectoU2KcApplication;
import com.uce.edu.demo.estudiante.to.Estudiante;

@Repository
public class EstudianteJdbcRepository implements IEstudianteJdbcRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final Logger logger = Logger.getLogger(EstudianteJdbcRepository.class);

	@Override
	public void insertar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("insert into estudiante(id,nombre,apellido,cedula,edad) values(?,?,?,?,?)",
				new Object[] { estudiante.getId(), estudiante.getNombre(), estudiante.getApellido(),
						estudiante.getCedula(), estudiante.getEdad() });
		logger.info("Se ingreso el estudiante: "+estudiante);
	}

	@Override
	public Estudiante buscar(int id) {
		// TODO Auto-generated method stub
		logger.info("Estudiante encontrado: ");
		return this.jdbcTemplate.queryForObject("select * from estudiante where id=?", new Object[] { id },
				new BeanPropertyRowMapper<Estudiante>(Estudiante.class));
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		logger.info("Se actualizo el estudiante: "+estudiante);
		this.jdbcTemplate.update("update estudiante set nombre=?,apellido=?,cedula=?,edad=? where id=?",
				new Object[] {estudiante.getNombre(), estudiante.getApellido(),
						estudiante.getCedula(), estudiante.getEdad(), estudiante.getId() });
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		logger.info("Se elimino el estudiante con id: "+id);
		this.jdbcTemplate.update("delete from estudiante where id =?", new Object[] { id });
	}

}
