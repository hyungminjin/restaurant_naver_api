package com.example.restaurant_naverapi.db;
// 데이터베이스가 사용해야하는 Entity가 있어야 한다.

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemoryDbEntity {
    protected int index;
}
