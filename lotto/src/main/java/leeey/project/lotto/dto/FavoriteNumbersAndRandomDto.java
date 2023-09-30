package leeey.project.lotto.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteNumbersAndRandomDto {

  @Size(min = 1, max = 5)
  @NotEmpty
  private Set<Integer> favoriteNumbers;

  @Max(10)
  @Min(1)
  private Integer resultCount;
}
