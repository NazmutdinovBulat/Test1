package com.example.studentlist;

     import org.springframework.data.jpa.repository.JpaRepository;

     public interface StudentRepository extends JpaRepository<Student, Long> {
     }
