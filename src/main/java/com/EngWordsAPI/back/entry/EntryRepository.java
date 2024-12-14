package com.EngWordsAPI.back.entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface EntryRepository extends JpaRepository<EntryEntity, String> {

    @Query(value = "SELECT id FROM institution_login ORDER BY id DESC LIMIT 1", nativeQuery = true)
    Long findLastPrimaryKeyIdValue();

}
