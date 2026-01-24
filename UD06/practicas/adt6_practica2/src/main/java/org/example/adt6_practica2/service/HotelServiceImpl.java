package org.example.adt6_practica2.service;

import org.example.adt6_practica2.model.Hotel;
import org.example.adt6_practica2.repository.IHotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements IHotelService {

    @Autowired
    private IHotelRepository repository;

    @Override
    public List<Hotel> listar() {
        return repository.findAll();
    }

    @Override
    public Hotel listarPorId(Integer id) {
        Optional<Hotel> optionalHotel = repository.findById(id);
        return optionalHotel.isPresent() ? optionalHotel.get() : null;
    }

    @Override
    public Hotel registrar(Hotel hotel) {
        return repository.save(hotel);
    }

    @Override
    public Hotel modificar(Hotel hotel) {
        return repository.save(hotel);
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Hotel> listarPorLocalidadYCategoria(String localidad, String categoria) {
        if (localidad != null && categoria != null) {
            return repository.findByLocalidadAndCategoria(localidad, categoria);
        } else if (localidad != null) {
            return repository.findByLocalidad(localidad);
        } else if (categoria != null) {
            return repository.findByCategoria(categoria);
        } else {
            return repository.findAll();
        }
    }

}
