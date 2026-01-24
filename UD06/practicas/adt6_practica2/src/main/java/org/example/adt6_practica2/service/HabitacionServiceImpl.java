package org.example.adt6_practica2.service;

import org.example.adt6_practica2.model.Habitacion;
import org.example.adt6_practica2.repository.IHabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HabitacionServiceImpl implements IHabitacionService {

    @Autowired
    private IHabitacionRepository repository;

    private IHotelService hotelService;

    @Override
    public List<Habitacion> listar() {
        return repository.findAll();
    }

    @Override
    public Habitacion listarPorId(Integer id) {
        Optional<Habitacion> optionalHabitacion = repository.findById(id);
        return optionalHabitacion.isPresent() ? optionalHabitacion.get() : null;
    }

    @Override
    public Habitacion registrar(Habitacion habitacion) throws Exception {
        Integer hotelId = habitacion.getHolel().getId();
        if (hotelId == null || hotelService.listarPorId(hotelId) == null) {
            throw new Exception("El hotel con el ID: " + hotelId + " no existe.");
        }
        return repository.save(habitacion);
    }

    @Override
    public Habitacion modificar(Habitacion habitacion) {
        return repository.save(habitacion);
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Habitacion modificarOcupacion(Integer id) {
        return null;
    }

    @Override
    public List<Habitacion> listarHabitaciones(Integer idHotel) {
        return repository.listarHabitaciones(idHotel);
    }

    @Override
    public List<Habitacion> listarHabitacionesLibres(Integer idHotel) {
        return repository.listarHabitacionesLibres(idHotel);
    }

}
