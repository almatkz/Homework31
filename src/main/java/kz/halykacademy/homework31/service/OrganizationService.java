package kz.halykacademy.homework31.service;

import kz.halykacademy.homework31.model.Organization;
import java.util.List;

public interface OrganizationService {

    //Создает новую организацию
    void create(Organization organization);

    //Возвращает список всех имеющихся организаций
    List<Organization> readAll();

    //Возвращает организацию по ID
    Organization read(int id);

    //Обновляет организацию с заданному ID/
    boolean update(Organization organization, int id);

    //Удаляет организацию с заданным ID/
    boolean delete(int id);
}
