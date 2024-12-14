package com.EngWordsAPI.back.entry;

import com.EngWordsAPI.uiUtils.CommonUiUtils;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
 class EntryService {
    @Autowired
    private EntryRepository entryRepository;
    public EntryEntity institutionRegistration(EntryEntity entity) {

        String institutionName = entity.getInstitutionName();
        String adminContactNumber = entity.getAdminContactNumber().toString();
        if (institutionName.isEmpty() || institutionName.isBlank()) {
            throw new HibernateException("Invalid institution name");
        }
        if(adminContactNumber.isEmpty() || adminContactNumber.isBlank() || adminContactNumber.length() < 9){
            throw new HibernateException("Invalid mobile number");
        }

        Long lastPrimaryKeyId = entryRepository.findLastPrimaryKeyIdValue();
        if(lastPrimaryKeyId == null){
            lastPrimaryKeyId = 0L;
        }
        lastPrimaryKeyId = lastPrimaryKeyId + 1;
        String institutionId =  CommonUiUtils.concatenateFirstLetters(entity.getInstitutionName().toUpperCase()) + CommonUiUtils.generateRandomNumber(entity.getAdminContactNumber().toString(),3) + lastPrimaryKeyId;
        entity.setInstitutionId(institutionId);
//
//        BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
//        String hashedPassword = pwdEncoder.encode("SivaKumar!9977");
//        boolean isMatch1 = pwdEncoder.matches("SivaKumar!9977","$2a$10$lvRukJO9jy3c/r0MbxREOu/G54tEBpu46SgFim0IKHLpK/A/TO9Iy");
//        entity.setAdminName(isMatch1 + "_");
//        boolean isMatch2 = pwdEncoder.matches("Sivakumar!9977",hashedPassword);
//        entity.setEmailId(isMatch2 + "#");
//        entity.setEmailId(hashedPassword);

        return entryRepository.save(entity);
    }

}
