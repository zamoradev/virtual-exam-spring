package com.springboot.virtualexam.student.service;

import com.springboot.virtualexam.student.data.IStudentRepository;
import com.springboot.virtualexam.student.data.StudentEntity;
import com.springboot.virtualexam.util.StringManipulation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements IStudentService {
    private final IStudentRepository studentRepository;

    @Override
    public boolean existsFieldRepeat(StudentEntity student) {
        return studentRepository.existsTeacherByCellphoneOrEmail(
                student.getCellphone(),
                student.getEmail()
        );
    }

    @Override
    public String save(StudentEntity student) {
        String studentId = StringManipulation.generationId('s', student.getLastName());

        student.setId(studentId);
        student.setPhoto("default.png");

        return studentRepository.save(student)
                                .getId();
    }
}
