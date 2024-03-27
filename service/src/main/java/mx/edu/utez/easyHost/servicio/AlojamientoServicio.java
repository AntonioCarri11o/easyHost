package mx.edu.utez.easyHost.servicio;

import mx.edu.utez.easyHost.modelo.Alojamiento;
import mx.edu.utez.easyHost.repositorio.AlojamientoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlojamientoServicio {
    @Autowired
    AlojamientoRepositorio alojamientoRepositorio;

    public List<Alojamiento> listarAlojamientos() { return alojamientoRepositorio.findAll(); }



}
