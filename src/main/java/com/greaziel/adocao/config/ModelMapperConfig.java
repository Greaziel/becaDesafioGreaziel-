package com.greaziel.adocao.config;

import com.greaziel.adocao.domains.Adocao;
import com.greaziel.adocao.domains.Pets;
import com.greaziel.adocao.dtos.requests.PostAdocaoRequest;
import com.greaziel.adocao.dtos.responses.*;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        var modelMapper = new ModelMapper();

        modelMapper.createTypeMap(Pets.class, GetPetsObterResponse.class).<Integer>addMapping(
                src -> src.getProprietario().getId(), (dest, value) -> dest.setDoador(value)
        ).<String>addMapping(src -> src.getProprietario().getNome(), (dest, value) -> dest.setProprietario(value)
        ).<String>addMapping(src -> src.getProprietario().getCidade(), (dest, value) -> dest.setCidade(value));

        modelMapper.createTypeMap(Pets.class, GetPetsListarResponse.class).<String>addMapping(
                src -> src.getProprietario().getNome(), (dest, value) -> dest.setProprietario(value)
        );

        modelMapper.createTypeMap(PostAdocaoRequest.class, Adocao.class).<Integer>addMapping(
                src -> src.getDoador(), (dest, value) -> dest.getDoador().setId(value)
        ).<Integer>addMapping(
                src -> src.getDonatario(), (dest, value) -> dest.getDonatario().setId(value)
        ).<Integer>addMapping(
                src-> src.getPet(), (dest, value) -> dest.getPet().setId(value)
        );

        modelMapper.createTypeMap(Adocao.class, PostAdocaoResponse.class).<String>addMapping(
                src -> src.getDoador().getNome(), (dest, value) -> dest.setDoador(value)
        ).<String>addMapping(src -> src.getDonatario().getNome(), (dest, value) -> dest.setDonatario(value)
        ).<String>addMapping(
                src -> src.getPet().getNome(), (dest, value) -> dest.setPet(value)
        );

        modelMapper.createTypeMap(Adocao.class, PatchAdocaoResponse.class).<String>addMapping(
                src -> src.getDoador().getNome(), (dest, value) -> dest.setDoador(value)
        ).<String>addMapping(src -> src.getDonatario().getNome(), (dest, value) -> dest.setDonatario(value)
        ).<String>addMapping(
                src -> src.getPet().getNome(), (dest, value) -> dest.setPet(value)
        );

        modelMapper.createTypeMap(Adocao.class, GetAdocaoListarResponse.class).<String>addMapping(
                src -> src.getDoador().getNome(), (dest, value) -> dest.setDoador(value)
        ).<String>addMapping(
                src -> src.getDonatario().getNome(), (dest, value) -> dest.setDonatario(value)
        ).<String>addMapping(
                src -> src.getPet().getNome(), (dest, value) -> dest.setPet(value)
        );

        return modelMapper;
    }
}
