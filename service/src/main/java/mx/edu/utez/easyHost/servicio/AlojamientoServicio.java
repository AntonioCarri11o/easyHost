package mx.edu.utez.easyHost.servicio;

import jakarta.validation.*;
import mx.edu.utez.easyHost.dto.AlojamientoDTO;
import mx.edu.utez.easyHost.modelo.Alojamiento;
import mx.edu.utez.easyHost.repositorio.AlojamientoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class AlojamientoServicio {
    @Autowired
    AlojamientoRepositorio alojamientoRepositorio;

    public List<Alojamiento> listarAlojamientos() { return alojamientoRepositorio.findAll(); }

    public Alojamiento registrarAlojamiento(AlojamientoDTO alojamientoDto) throws Exception{
        ValidatorFactory fabrica = Validation.buildDefaultValidatorFactory();
        Validator validador = fabrica.getValidator();
        Set<ConstraintViolation<AlojamientoDTO>> errores = validador.validate(alojamientoDto);
        if (!errores.isEmpty()) {
            throw new ConstraintViolationException(errores);
        }
        Alojamiento alojamiento = alojamientoDto.crearAlojamiento();
        return alojamientoRepositorio.save(alojamiento);
    }



}
