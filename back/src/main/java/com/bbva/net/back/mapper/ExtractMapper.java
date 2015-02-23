package com.bbva.net.back.mapper;

import java.util.List;

import com.bbva.czic.dto.net.Extracto;
import com.bbva.net.back.model.extract.ExtractDto;

public interface ExtractMapper {

	List<ExtractDto> map(List<Extracto> extractList);

}
