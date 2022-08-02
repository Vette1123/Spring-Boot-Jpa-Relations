package com.example.jpacrud.services;
import com.example.jpacrud.models.SchoolId;
import com.example.jpacrud.reposotries.SchoolIdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolIdService {
    private final SchoolIdRepository schoolIdRepository;

    public SchoolId createSchoolId(SchoolId schoolId) {
        return schoolIdRepository.save(schoolId);
    }

    public SchoolId getSchoolId(Long id) {
        return schoolIdRepository.findById(id).orElse(null);
    }

    public List<SchoolId> getAllSchoolIds() {
        return (List<SchoolId>) schoolIdRepository.findAll();
    }

}
