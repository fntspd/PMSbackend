//package com.fenton.rest_api.servicelayer;
//import com.fenton.rest_api.Model.StudentProfile;
//import com.fenton.rest_api.Model.PasswordChangeRequest;
//import com.fenton.rest_api.repository.StudentProfileRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class StudentPasswordChangeService {
//
//        @Autowired
//        private StudentProfileRepository studentProfileRepository;
//
//        @Autowired
//        private PasswordEncoder passwordEncoder;
//
//        public void changePassword(Long id, String oldPassword, String newPassword) {
//            StudentProfile studentProfile = StudentProfileRepository.findById(id);
//
//            if (studentProfile == null) {
//                throw new RuntimeException("User not found");
//            }
//
//            if (!passwordEncoder.matches(oldPassword, studentProfile.getPassword())) {
//                throw new RuntimeException("Old password is incorrect");
//            }
//
//            user.setPassword(passwordEncoder.encode(newPassword));
//            userRepository.save(user);
//        }
//    }
//
//}
