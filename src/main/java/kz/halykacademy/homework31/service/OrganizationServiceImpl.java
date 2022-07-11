package kz.halykacademy.homework31.service;

import kz.halykacademy.homework31.model.Organization;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    // Хранилище организаций
    private static final Map<Integer, Organization> ORGANIZATION_REPOSITORY_MAP = new HashMap<>();

    // Переменная для генерации ID организации
    private static final AtomicInteger ORGANIZATION_ID_HOLDER = new AtomicInteger();

    @Override
    public void create(Organization organization) {
        final int organizationId = ORGANIZATION_ID_HOLDER.incrementAndGet();
        organization.setId(organizationId);
        ORGANIZATION_REPOSITORY_MAP.put(organizationId, organization);
    }

    @Override
    public List<Organization> readAll() {
        return new ArrayList<>(ORGANIZATION_REPOSITORY_MAP.values());
    }

    @Override
    public Organization read(int id) {
        return ORGANIZATION_REPOSITORY_MAP.get(id);
    }

    @Override
    public boolean update(Organization organization, int id) {
        if (ORGANIZATION_REPOSITORY_MAP.containsKey(id)) {
            organization.setId(id);
            ORGANIZATION_REPOSITORY_MAP.put(id, organization);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        return ORGANIZATION_REPOSITORY_MAP.remove(id) != null;
    }
}