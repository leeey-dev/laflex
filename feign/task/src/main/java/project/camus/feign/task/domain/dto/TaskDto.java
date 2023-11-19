package project.camus.feign.task.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.camus.feign.task.domain.enums.TaskPriorityType;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {

    private Long id;

    private Long memberId;

    private String description;

    private TaskPriorityType priority;
}
