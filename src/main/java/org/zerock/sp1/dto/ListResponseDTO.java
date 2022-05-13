package org.zerock.sp1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.zerock.sp1.domain.Board;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ListResponseDTO <E>{
    private List<E> dtoList;

    private int total;
}
