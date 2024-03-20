package mx.edu.utez.easyHost.service;

import mx.edu.utez.easyHost.model.Alojamiento;
import mx.edu.utez.easyHost.repository.AlojamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlojamientoService {
    @Autowired
    private AlojamientoRepository alojamientoRepository;

    public Alojamiento guardarAlojamiento(Alojamiento alojamiento) {
        return alojamientoRepository.save(alojamiento);
    }
}
