package com.bilgeadam.service;

import com.bilgeadam.dto.request.LoginRequestDto;
import com.bilgeadam.dto.request.RegisterRequestDto;
import com.bilgeadam.mapper.IPersonalMapper;
import com.bilgeadam.repository.IRepository;
import com.bilgeadam.repository.entity.Personal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HumanResourcesService {

    private final IRepository repository;

    public Boolean register(RegisterRequestDto dto){
        Optional<Personal> personal = repository.findOptionalByEmail(dto.getEmail());
        if (personal.isPresent()){
            throw new RuntimeException("Bu email adresi ile daha önce kayıt yapılmış");
        }else{
            repository.save(IPersonalMapper.INSTANCE.fromRegisterRequestDto(dto));
            return true;
        }
    }

    public Boolean login(LoginRequestDto dto){
        Optional<Personal> personal = repository.findOptionalByEmailAndPassword(dto.getEmail(), dto.getPassword());
        if (personal.isEmpty()){
            throw new RuntimeException("Hatalı şifre veya eposta...");
        }else{
            return true;
        }
    }

    public List<Personal> findAll() {
        List<Personal> personals = repository.findAll();
        if (personals.isEmpty()){
            throw new RuntimeException("Personel bulunamadı.");
        }
        return personals;
    }
}
