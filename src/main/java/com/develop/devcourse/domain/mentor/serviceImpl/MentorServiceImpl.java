package com.develop.devcourse.domain.mentor.serviceImpl;

import com.develop.devcourse.domain.mentor.dto.request.MentorRequest;
import com.develop.devcourse.domain.mentor.dto.response.MentorResponse;
import com.develop.devcourse.domain.mentor.exeption.MentorException;
import com.develop.devcourse.domain.mentor.model.Mentor;
import com.develop.devcourse.domain.mentor.repository.MentorRepository;
import com.develop.devcourse.domain.mentor.service.MentorService;
import com.develop.devcourse.domain.security.dto.response.MessageResponse;
import com.develop.devcourse.domain.security.model.Role;
import com.develop.devcourse.domain.security.model.RoleName;
import com.develop.devcourse.domain.security.model.User;
import com.develop.devcourse.domain.security.repository.UserRepository;
import com.develop.devcourse.domain.security.service.RoleServices;
import com.develop.devcourse.domain.security.service.UserService;
import com.develop.devcourse.domain.security.serviceImpl.UserDetailsImpl;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MentorServiceImpl implements MentorService {

    private final RoleServices roleServices;
    private final UserService userService;
    private final MentorRepository mentorRepository;
    private final UserRepository userRepository;

    @Transactional
    @Override
    public MessageResponse registerToMentor(MentorRequest mentorRequest) {

        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.findByEmail(userDetails.getEmail());
        if(mentorRepository.existsByMentorId(user.getUserId())){
            throw new MentorException("You already register to be mentor");
        }
        Set<Role> roles = new HashSet<>();
        roles.add(roleServices.findRoleByRoleName(RoleName.ROLE_MENTOR));
        roles.add(roleServices.findRoleByRoleName(RoleName.ROLE_STUDENT));
        user.setRoles(roles);
        Mentor mentor = new Mentor();
        mentor.setUser(user);
        mentor.setMentorId(user.getUserId());
        mentor.setDegree(mentorRequest.getDegree());
        mentor.setExperience(mentorRequest.getExperience());
        mentor.setUser(user);

        mentorRepository.save(mentor);
        return MessageResponse.builder()
                .httpStatus(HttpStatus.CREATED)
                .message("Register to be mentor successfully")
                .build();
    }

    @Override
    public MentorResponse updateProfileMentor(MentorRequest mentorRequest) {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Mentor mentor = mentorRepository.findById(userDetails.getId()).orElse(null);
        if(mentor == null){
            throw new MentorException("You must be register to be mentor to update your mentor profile");
        }
        mentor.setExperience(mentorRequest.getExperience());
        mentor.setDegree(mentorRequest.getDegree());
        mentorRepository.save(mentor);
        return MentorResponse.builder()
                .userId(mentor.getMentorId())
                .degree(mentor.getDegree())
                .experience(mentor.getExperience())
                .build();
    }

    @Override
    public MentorResponse showMentorProfile() {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Mentor mentor = mentorRepository.findById(userDetails.getId()).orElse(null);
        if(mentor == null){
            throw new MentorException("You must be register to be mentor to see your mentor profile");
        }
        User user = userService.findByEmail(userDetails.getEmail());
        return MentorResponse.builder()
                .userId(mentor.getMentorId())
                .fullName(user.getFullName())
                .degree(mentor.getDegree())
                .experience(mentor.getExperience())
                .build();
    }
}
