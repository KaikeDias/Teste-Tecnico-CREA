package com.example.testetecnicocrea.modules.title.domain.repositories;

import com.example.testetecnicocrea.modules.title.domain.entities.Title;
import com.example.testetecnicocrea.modules.title.domain.entities.TitleDTO;

import java.util.List;

public interface TitleRepository {
    int save(TitleDTO titleDTO);

    int update(Title title);

    Title findById(int id);

    int deleteById(int id);

    List<Title> findAll();

    int deleteAll();

    List<Title> findByProfessionalId(int id);

}
