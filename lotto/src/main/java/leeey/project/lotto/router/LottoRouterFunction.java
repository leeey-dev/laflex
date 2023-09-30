package leeey.project.lotto.router;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import leeey.project.lotto.config.SuccessResponse;
import leeey.project.lotto.dto.FavoriteNumbersAndRandomDto;
import leeey.project.lotto.handler.FavoriteNumbersHandlerFunction;
import leeey.project.lotto.handler.HealthCheckHandlerFunction;
import leeey.project.lotto.handler.MostPickedNumbersOfYearHandlerFunction;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class LottoRouterFunction {

  private final HealthCheckHandlerFunction healthCheckHandlerFunction;

  private final FavoriteNumbersHandlerFunction favoriteNumbersHandlerFunction;

  private final MostPickedNumbersOfYearHandlerFunction mostPickedNumbersOfYearHandlerFunction;

  @RouterOperations({
      @RouterOperation(path = "/health"
          , produces = {
          MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.GET, beanClass = HealthCheckHandlerFunction.class, beanMethod = "handle",
          operation = @Operation(operationId = "healthCheck",
              tags = {"HealthCheck"},
              responses = {
                  @ApiResponse(responseCode = "200", description = "SUCCESS", content = @Content(schema = @Schema(implementation = SuccessResponse.class))),
                  @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
                  @ApiResponse(responseCode = "404", description = "NOT FOUND")})
      ),
      @RouterOperation(path = "/lotto/favorite-nums"
          , produces = {
          MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.POST,
          beanClass = FavoriteNumbersHandlerFunction.class, beanMethod = "handle",
          operation = @Operation(operationId = "getFavoriteNumbersAndRandom",
              tags = {"API"},
              responses = {
                  @ApiResponse(responseCode = "200", description = "SUCCESS", content = @Content(schema = @Schema(implementation = SuccessResponse.class))),
                  @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
                  @ApiResponse(responseCode = "404", description = "NOT FOUND")},
              requestBody = @RequestBody(content = @Content(schema = @Schema(implementation = FavoriteNumbersAndRandomDto.class))))
      ),
      @RouterOperation(path = "/lotto/most-picked-numbers-of-year"
          , produces = {
          MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.GET,
          beanClass = MostPickedNumbersOfYearHandlerFunction.class, beanMethod = "handle",
          operation = @Operation(operationId = "getMostPickedNumbersOfYear",
              tags = {"API"},
              responses = {
                  @ApiResponse(responseCode = "200", description = "SUCCESS", content = @Content(schema = @Schema(implementation = SuccessResponse.class))),
                  @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
                  @ApiResponse(responseCode = "404", description = "NOT FOUND")})
      )
  })
  @Bean
  public RouterFunction<ServerResponse> route() {

    return RouterFunctions.route()
        .path("/health", builder -> builder
            .GET(RequestPredicates.accept(MediaType.APPLICATION_JSON), healthCheckHandlerFunction))
        .path("/lotto", builder -> builder
            .nest(RequestPredicates.accept(MediaType.APPLICATION_JSON), nestBuilder -> nestBuilder
                .GET("/health", healthCheckHandlerFunction)
                .POST("/favorite-nums", favoriteNumbersHandlerFunction)
                .GET("/most-picked-numbers-of-year", mostPickedNumbersOfYearHandlerFunction)))
        .build();
  }
}
