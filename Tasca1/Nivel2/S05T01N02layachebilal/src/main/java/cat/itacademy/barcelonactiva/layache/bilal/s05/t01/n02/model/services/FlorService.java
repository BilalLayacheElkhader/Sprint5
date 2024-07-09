package cat.itacademy.barcelonactiva.layache.bilal.s05.t01.n02.model.services;

import cat.itacademy.barcelonactiva.layache.bilal.s05.t01.n02.model.dto.dtoFlor;

import java.util.List;

public interface FlorService {
    void save(dtoFlor dtoflor);

    void updateFlor(dtoFlor dtoflor);

    void deleteFlor(int florId);

    dtoFlor getById(int florId);

    List<dtoFlor> getAllFlor();
}
