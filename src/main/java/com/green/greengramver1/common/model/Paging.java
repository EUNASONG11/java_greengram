package com.green.greengramver1.common.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Paging {
    @Schema(example = "1", description = "Selected Page")
    private int page;
    @Schema(example = "30", description = "item count per page")
    private int size;
    @JsonIgnore
    private int startIdx;

    public Paging(int page, int size) {
        this.page = page;
        this.size = (size == 0 ? 20 : size);
        this.startIdx = (page - 1) * size;
    }
}
