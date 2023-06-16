package br.com.devsFutures.cliente.dto.response;

import lombok.*;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageDto<T> {

    List<T> content;

    CustomPageDto customPageDto;

    public PageDto(Page<T> page) {
        this.content = page.getContent();
        this.customPageDto = new CustomPageDto(page.getTotalElements(),
                page.getTotalPages(), page.getNumber(), page.getSize());
    }

}