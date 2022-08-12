package meli.dh.com.finalmeliproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductBatchStockDTO {

    private int batchNumber;
    private int currentQuantity;
    private LocalDate dueDate;

}
