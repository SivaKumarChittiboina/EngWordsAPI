package com.EngWordsAPI.back.entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entry")
public class EntryController {

    @Autowired
    private EntryService entryService;

    @PostMapping
    public EntryEntity institutionRegistration(@RequestBody EntryEntity entryEntity) {
        return entryService.institutionRegistration(entryEntity);
    }

}
