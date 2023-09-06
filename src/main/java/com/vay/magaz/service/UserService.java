//package com.vay.magaz.service;
//
//import com.vay.magaz.store.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Collections;
//
//@Service
//@RequiredArgsConstructor
//public class UserService implements UserDetailsService {
//    private final UserRepository userRepository;
//
////    @Override
////    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////        return userRepository.findByUsername(username)
////                .map(user -> new org.springframework.security.core.userdetails.User(
////                        user.getUsername(),
////                        user.getPassword(),
////                        Collections.singleton(user.getUsername())
////        ))
////        .orElseThrow(() -> new UsernameNotFoundException("Failed"));
////    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return userRepository.findByUsername(username)
//                .map(user -> new org.springframework.security.core.userdetails.User(
//                        user.getUsername(),
//                        user.getPassword(),
//                        Collections.singleton(user.getAuthorities())
//                ))
//                .orElseThrow(() -> new UsernameNotFoundException("Failed to retrieve user: " + username));
//    }
//}
