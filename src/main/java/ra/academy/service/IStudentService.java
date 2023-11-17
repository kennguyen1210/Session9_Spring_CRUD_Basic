package ra.academy.service;

import ra.academy.dto.request.StudentRequest;
import ra.academy.model.Student;

public interface IStudentService extends IGeneric<Student, Integer>{
    Student createStudent(StudentRequest s);
}
