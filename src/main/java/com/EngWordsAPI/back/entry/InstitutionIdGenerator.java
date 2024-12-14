
package com.EngWordsAPI.back.entry;
import com.EngWordsAPI.uiUtils.CommonUiUtils;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;


// Not required this file
@Service
public class InstitutionIdGenerator implements IdentifierGenerator  {

    @Autowired
    private EntryRepository entryRepository;

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        EntryEntity entity = (EntryEntity) object;
        String institutionName = entity.getInstitutionName();
        String adminContactNumber = (entity.getAdminContactNumber()).toString();

        if (institutionName.isEmpty() || institutionName.isBlank() || adminContactNumber.isEmpty() || adminContactNumber.isBlank() || adminContactNumber.length() < 9) {
            throw new HibernateException("Invalid username or mobile number for ID generation");
        }
        // Example: Generate an ID by combining the first character of the username and the last three digits of the mobile number
        String institutionId = CommonUiUtils.concatenateFirstLetters(institutionName.toUpperCase()) + CommonUiUtils.generateRandomNumber(adminContactNumber,4);
        return institutionId;
    }
}
