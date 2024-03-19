package mx.edu.utez.easyHost.servicio;

import mx.edu.utez.easyHost.modelo.Alojamiento;
import mx.edu.utez.easyHost.repositorio.AlojamientoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlojamientoServicio {
    @Autowired
    AlojamientoRepositorio alojamientoRepositorio;



}
