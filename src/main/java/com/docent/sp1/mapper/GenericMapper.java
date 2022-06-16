package com.docent.sp1.mapper;

import com.docent.sp1.dto.ListDTO;
import com.docent.sp1.domain.Board;

import java.util.List;

public interface GenericMapper <E,K>{
    void insert (E board);

    List<Board> selectList (ListDTO listDTO);

    List<Board> selectAllList (ListDTO listDTO);

    int getTotal(ListDTO listDTO);

    void delete (K bno);

    Board selectOne (K bno);

    void update (E board);
}
