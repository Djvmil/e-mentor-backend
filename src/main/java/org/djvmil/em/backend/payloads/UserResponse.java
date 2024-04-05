package org.djvmil.em.backend.payloads;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.djvmil.em.backend.core.dto.UserDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
	
	private List<UserDto> content;
	private Integer pageNumber;
	private Integer pageSize;
	private Long totalElements;
	private Integer totalPages;
	private boolean lastPage;
	
}
