package com.develop.devcourse.domain.student.serviceImpl;

import com.develop.devcourse.common.exeption.DomainException;
import com.develop.devcourse.common.util.UploadService;
import com.develop.devcourse.domain.security.model.User;
import com.develop.devcourse.domain.security.repository.UserRepository;
import com.develop.devcourse.domain.security.service.UserService;
import com.develop.devcourse.domain.security.serviceImpl.UserDetailsImpl;
import com.develop.devcourse.domain.student.dto.request.StudentRequest;
import com.develop.devcourse.domain.student.dto.response.StudentResponse;
import com.develop.devcourse.domain.student.exception.StudentException;
import com.develop.devcourse.domain.student.model.Student;
import com.develop.devcourse.domain.student.repository.StudentRepository;
import com.develop.devcourse.domain.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final UserRepository userRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final UploadService uploadService;

    @Override
    public Student createStudent(User user) {
        Student student = new Student();
        student.setUser(user);
        return student;
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<StudentResponse> findAll() {
        return studentRepository.findAll().stream()
                .map(student -> modelMapper.map(student.getUser(), StudentResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public StudentResponse findById(String userId) throws StudentException {
        return modelMapper.map(studentRepository.findById(userId)
                .orElseThrow(() -> StudentException.notFound("Could not find Id")), StudentResponse.class);
    }

    @Override
    public StudentResponse getStudentProfile() {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findById(userDetails.getId()).orElseThrow(()-> DomainException.notFound("Could not found "+userDetails.getUsername()));
        return modelMapper.map(user,StudentResponse.class);
    }

    @Override
    public StudentResponse updateStudentProfile(StudentRequest studentRequest) {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findById(userDetails.getId()).orElseThrow(()-> DomainException.notFound("Could not found "+userDetails.getUsername()));

        if (!studentRequest.getFirstName().isEmpty()){
            user.setFirstName(studentRequest.getFirstName());
        }
        if (!studentRequest.getLastName().isEmpty()){
            user.setLastName(studentRequest.getLastName());
        }
        if (!studentRequest.getAddress().isEmpty()){
            user.setAddress(studentRequest.getAddress());
        }
        if (studentRequest.getBirthday() != null){
            user.setBirthday(studentRequest.getBirthday());
        }
        if (!studentRequest.getGender().isEmpty()){
            user.setGender(Boolean.parseBoolean(studentRequest.getGender()));
        }
        if (!studentRequest.getPhoneNumber().isEmpty()){
            user.setPhoneNumber(studentRequest.getPhoneNumber());
        }
        if (studentRequest.getAvatarUrl() != null){
            user.setAvatarUrl(uploadService.uploadFile(studentRequest.getAvatarUrl()));
        }
        user.setUpdateAt(new Date());
        return modelMapper.map(userRepository.save(user),StudentResponse.class);
    }

    @Override
    public void deleteById(String userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public void toggleStudentById(String userId) {
        User user = userService.findById(userId);
        user.setActive(!user.isActive());
        userRepository.save(user);
    }
}
