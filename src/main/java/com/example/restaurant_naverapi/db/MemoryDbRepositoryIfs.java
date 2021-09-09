package com.example.restaurant_naverapi.db;

import java.util.List;
import java.util.Optional;

public interface MemoryDbRepositoryIfs<T> {
    Optional<T> findById(int index); // type에 대한 데이터를 찾아서 리턴
    T save(T entity); //저장
    void deleteById(int index); //삭제
    List<T> listAll(); //전체를 리턴
}

// interface 완료