package com.bilgeadam.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorType {

    INTERNAL_ERROR(1000,"Sunucuda beklenmeyen hata oluştu",HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST_ERROR(1001, "Parametre eksik yada hatalı", HttpStatus.BAD_REQUEST),
    LOGIN_ERROR(1002,"Kullanıcı adı yada şifre hatalı",HttpStatus.BAD_REQUEST),
    REGISTER_REPASSWORD_ERROR(1003,"Girilen şifreler uyuşmuyor",HttpStatus.BAD_REQUEST),
    JWT_TOKEN_CREATE_ERROR(1004,"Token Oluşturma Hatası",HttpStatus.BAD_REQUEST),
    REGISTER_EMAIL_KAYITLI(1005,"Email zaten kayıtlı",HttpStatus.BAD_REQUEST),
    GECERSIZ_GIRIS_DENEMESI(1006,"Yetkisiz giriş denemesi",HttpStatus.UNAUTHORIZED),
    KULLANICI_BULUNAMADI(1007,"Kullanıcı bulunamadı",HttpStatus.NOT_FOUND),
    USER_NOT_CREATED(2001, "Personel oluşturulamadı", HttpStatus.BAD_REQUEST);
    int code;
    String message;
    HttpStatus httpStatus;
}
