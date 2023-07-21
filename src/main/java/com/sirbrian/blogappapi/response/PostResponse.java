package com.sirbrian.blogappapi.response;

import com.sirbrian.blogappapi.dto.PostDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PostResponse {

   private List<PostDto> content;
   private int pageNumber;
   private int pageSize;
   private long totalElements;
   private int totalPages;
   private boolean lastPage;
}
