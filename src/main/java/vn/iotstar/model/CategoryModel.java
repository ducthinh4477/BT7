package vn.iotstar.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryModel {

    private Long categoryId;
    private String categoryName;
    private String categoryCode;
    private String images;
    private Boolean status = true;
}
