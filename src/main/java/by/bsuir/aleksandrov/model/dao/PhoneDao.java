package by.bsuir.aleksandrov.model.dao;

import by.bsuir.aleksandrov.model.entity.phone.Phone;
import by.bsuir.aleksandrov.model.entity.phone.sorting.SortField;
import by.bsuir.aleksandrov.model.entity.phone.sorting.SortOrder;

import java.util.List;
import java.util.Optional;

public interface PhoneDao {
    Optional<Phone> get(Long key);

    List<Phone> findAll(int offset, int limit, SortField sortField, SortOrder sortOrder, String query);

    Long numberByQuery(String query);
}
