package com.example.restaurant_naverapi.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// abstract : 추상 클래스 implements : 상속
abstract public class MemoryDbRepositoryAbstract<T extends MemoryDbEntity> implements MemoryDbRepositoryIfs<T> {
// MemoryDbEntity를 상속받은 제네릭 타입이 필요하다.
    //<T>는 MemoryDbEntity를 상속받았다.

    private final List<T> db = new ArrayList<>();
    // 리스트에 데이터를 쭉 넣는 형태
    private int index = 0;


    @Override
    public Optional<T> findById(int index) {
        return db.stream().filter(it -> it.getIndex() == index).findFirst(); //getIndex()의 값이 index와 동일하다에 findFirst를 리턴
        //getIndex()는 MemoryDbEntity에 정의된 index를 의미한다. db는 List의 type에 관한 부분이다.
    }

    @Override
    public T save(T entity) {
        var optionalEntity : Optional<T> = db.stream().filter(it -> it.getIndex() == entity.getIndex()).findFirst();

        if(optionalEntity.isEmpty()){//db에 데이터가 없는 경우
            index++;
            entity.setIndex(index);
            db.add(entity);
            return entity;

        }else{//db에 이미 데이터가 있는 경우
            var preIndex : T = optionalEntity.get().getIndex();
            entity.setIndex(preIndex);

            deleteById(preIndex);
            db.add(entity);
            return entity;
        }
    }

    @Override
    public void deleteById(int index) {

    }

    @Override
    public List<T> listAll() {
        return null;
    }
}
