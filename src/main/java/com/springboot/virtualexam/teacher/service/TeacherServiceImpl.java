package com.springboot.virtualexam.teacher.service;

import com.springboot.virtualexam.teacher.data.ITeacherRepository;
import com.springboot.virtualexam.teacher.data.TeacherEntity;
import com.springboot.virtualexam.util.StringManipulation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements ITeacherService{
    private final ITeacherRepository teacherRepository;

    @Override
    public boolean existsFieldRepeat(TeacherEntity teacher) {
        return teacherRepository.existsTeacherByDuiOrCellphoneOrEmail(
                teacher.getDui(),
                teacher.getCellphone(),
                teacher.getEmail()
        );
    }

    @Override
    public String save(TeacherEntity teacher) {
        String teacherId = StringManipulation.generationId('t', teacher.getLastName());

        teacher.setId(teacherId);
        teacher.setPhoto("default.png");

        return teacherRepository.save(teacher)
                                .getId();
    }

}
