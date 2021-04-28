package com.studentdraw.demo.services;

import com.studentdraw.demo.entities.Student;
import com.studentdraw.demo.repositories.IStudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

@Service
public class StudentService implements IStudentService {

    public final IStudentRepository repo;

    public StudentService(IStudentRepository repo) {
        this.repo = repo;
    }

    @Override
    @Transactional
    public Long generateStudents(Integer quantity) {

        var numerator = repo.maxIdentifier();
        for (int i = 0; i < quantity; i++) {
            numerator++;
            repo.save(new Student("Student " + numerator));
        }
        return numerator;
    }

    @Transactional(readOnly = true)
    @Override
    public Iterable<Student> returnStudentDraw(Integer quantity) {
        var maxId = repo.maxIdentifier();
        var studentQuantity = repo.count();
        var resultList = new HashMap<Long, Student>();

        if (quantity > studentQuantity)
            return null;
        Random random = new Random();
        for (int i = 0; i < quantity; i++) {
            var validDraw = false;
            do {
                var currentDraw = 1 + (long) (Math.random() * (maxId));
                var student = repo.findById(currentDraw);
                if (!resultList.containsKey(currentDraw) && student.isPresent()) {
                    resultList.put(currentDraw, student.get());
                    validDraw = true;
                }
            }
            while (!validDraw);
        }
        return resultList.values();
    }

}
