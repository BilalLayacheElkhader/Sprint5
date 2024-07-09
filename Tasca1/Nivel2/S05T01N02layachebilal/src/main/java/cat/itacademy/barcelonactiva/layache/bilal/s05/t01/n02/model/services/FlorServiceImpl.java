package cat.itacademy.barcelonactiva.layache.bilal.s05.t01.n02.model.services;

import cat.itacademy.barcelonactiva.layache.bilal.s05.t01.n02.exceptions.FlorNotFoundException;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t01.n02.model.domain.Flor;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t01.n02.model.dto.dtoFlor;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t01.n02.model.repository.FlorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlorServiceImpl implements FlorService {
    @Autowired
    private FlorRepo br;
    @Override
    public void save(dtoFlor dtoflor) {
        Flor flor =  new Flor(dtoflor.getNameFlor(), dtoflor.getCountryFlor());
        br.save(flor);
    }
    @Override
    public void updateFlor(dtoFlor dtoflor) {
        Flor flor = br.findById(dtoflor.getPk_FlorID())
                .orElseThrow(()-> new FlorNotFoundException("No existe"));
        flor.setCountryFlor(dtoflor.getCountryFlor());
        flor.setNameFlor(dtoflor.getNameFlor());
        br.save(flor);
    }

    @Override
    public void deleteFlor(int florId) {
        if(!br.existsById(florId)){
            throw new FlorNotFoundException("La flor con id : "+florId + " haz intentado eliminar no existe.");
        }else {
            br.deleteById(florId);
        }

    }

    @Override
    public dtoFlor getById(int florId) {
        Flor flor = br.findById(florId)
                .orElseThrow(()-> new FlorNotFoundException("No existe"));
        dtoFlor dtoflor = new dtoFlor(flor.getNameFlor(), flor.getCountryFlor());
        dtoflor.setPk_FlorID(florId);
        return dtoflor;
    }

    @Override
    public List<dtoFlor> getAllFlor() {
        List<Flor> florList = br.findAll();

        return florList.stream()
                .map(flor -> {
                    dtoFlor dtoflor = new dtoFlor(flor.getNameFlor(), flor.getCountryFlor());
                    dtoflor.setPk_FlorID(flor.getPk_FlorID());
                    return dtoflor;
                })
                .collect(Collectors.toList());
    }
    }



