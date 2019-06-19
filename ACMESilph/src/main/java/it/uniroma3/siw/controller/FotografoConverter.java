package it.uniroma3.siw.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import it.uniroma3.siw.model.Fotografo;
import it.uniroma3.siw.repository.FotografoRepository;

@Component
public class FotografoConverter implements Converter<String, Fotografo> {

@Autowired
private FotografoRepository fotografoRepository; //Or the class that implments the repository.

    @Override
    public Fotografo convert(String arg0) {
        Long id = new Long(arg0);
        return fotografoRepository.findById(id).orElse(null);
    }

}