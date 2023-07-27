package com.Bank.ATB.dto;

import java.util.List;

public record PageResponse(
        List<MoneyDto>moneys,
        Long totalElements,
        int totalPage,
        boolean hasNextPage
) {
}
