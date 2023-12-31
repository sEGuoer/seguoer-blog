package com.seguo.service.impl;


import com.seguo.entity.PasswordResetToken;
import com.seguo.repository.PasswordResetTokenRepository;
import com.seguo.service.PasswordResetTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasswordResetTokenServiceImpl implements PasswordResetTokenService {
    private final PasswordResetTokenRepository passwordResetTokenRepository;

    @Autowired
    public PasswordResetTokenServiceImpl(PasswordResetTokenRepository passwordResetTokenRepository) {
        this.passwordResetTokenRepository = passwordResetTokenRepository;
    }

    @Override
    public PasswordResetToken findFirstByTokenOrderByIdDesc(String token) {
        return passwordResetTokenRepository.findFirstByTokenOrderByIdDesc(token).orElse(null);
    }

    @Override
    public PasswordResetToken save(PasswordResetToken passwordResetToken) {
        return passwordResetTokenRepository.save(passwordResetToken);
    }

    @Override
    public PasswordResetToken findByToken(String token) {
        return passwordResetTokenRepository.findByToken(token).orElse(null);
    }

    @Override
    public int expireThisToken(String token) {
        return passwordResetTokenRepository.updateExpirationDateForThisToken(token);
    }
}
