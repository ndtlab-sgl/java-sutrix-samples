package edu.sgl.restaurant.domain.sql_builder;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface ISqlBuilder<T> {

  String prefixPattern();

  String queryPattern();

  T build();

  Function<T, Object[]> fieldsMapping();

  default StringBuilder buildSqlBuilder(int maxVal) {
    final StringBuilder sqlBuilder = new StringBuilder(prefixPattern());
    buildRandomList(maxVal).stream().map(fieldsMapping())
    .map(sqlConverter())
    .forEach(sqlBuilder::append);
    return sqlBuilder;
  }

  default List<T> buildRandomList(int maxVal) {
    return IntStream.range(0, maxVal)
        .mapToObj(i -> build())
        .collect(Collectors.toList());
  }

  default Function<Object[], String> sqlConverter() {
    return fields -> String.format(queryPattern(), fields);
  }

}
