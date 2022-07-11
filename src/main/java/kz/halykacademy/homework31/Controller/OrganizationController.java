package kz.halykacademy.homework31.Controller;

import kz.halykacademy.homework31.model.Organization;
import kz.halykacademy.homework31.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrganizationController {

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }


    @PostMapping(value = "/organizations")
    public ResponseEntity<?> create(@RequestBody Organization organization) {
        organizationService.create(organization);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/organizations")
    public ResponseEntity<List<Organization>> read() {
        final List<Organization> organizations = organizationService.readAll();

        return organizations != null &&  !organizations.isEmpty()
                ? new ResponseEntity<>(organizations, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/organizations/{id}")
    public ResponseEntity<Organization> read(@PathVariable(name = "id") int id) {
        final Organization organization = organizationService.read(id);

        return organization != null
                ? new ResponseEntity<>(organization, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/organizations/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Organization organization) {
        final boolean updated = organizationService.update(organization, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/organizations/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = organizationService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
