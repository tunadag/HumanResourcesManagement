package com.bilgeadam.service;

import com.bilgeadam.dto.request.BaseRequestDto;
import com.bilgeadam.dto.request.LoginRequestDto;
import com.bilgeadam.dto.request.RegisterRequestDto;
import com.bilgeadam.mapper.IPersonalMapper;
import com.bilgeadam.repository.IRepository;
import com.bilgeadam.repository.entity.Personal;
import com.bilgeadam.repository.entity.UserType;
import com.bilgeadam.utility.JwtTokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HumanResourcesService {

    private final IRepository repository;
    private final JwtTokenManager jwtTokenManager;

    public Boolean register(RegisterRequestDto dto){
        Optional<Personal> personal = repository.findOptionalByEmail(dto.getEmail());
        if (personal.isPresent()){
            throw new RuntimeException("Bu email adresi ile daha önce kayıt yapılmış");
        }else{
            repository.save(IPersonalMapper.INSTANCE.fromRegisterRequestDto(dto));
            return true;
        }
    }

    public String login(LoginRequestDto dto){
        Optional<Personal> personal = repository.findOptionalByEmailAndPassword(dto.getEmail(), dto.getPassword());
        if (personal.isEmpty()){
            throw new RuntimeException("Hatalı şifre veya eposta...");
        }else{
            return jwtTokenManager.createToken(personal.get().getId()).get();
        }
    }

    public List<Personal> findAll(BaseRequestDto dto) {
        Optional<Long> id = jwtTokenManager.getByIdFromToken(dto.getToken());
        if (id.isEmpty()) System.out.println("Bu id de kullanıcı bulunmamaktadır.");
        Optional<Personal> personal = repository.findOptionalById(id.get());
        if (personal.isEmpty()){
            System.out.println("Kullanıcı bulunamadı");
        }
        if (personal.get().getUserType() != UserType.ADMIN){
            throw new RuntimeException("Yetkiniz bulunmamaktadır.");
        }
        return repository.findAll();

    }
}
