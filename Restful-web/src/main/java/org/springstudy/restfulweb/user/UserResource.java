package org.springstudy.restfulweb.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {
  private final UserDaoService service;

  public UserResource(UserDaoService service) {
    this.service = service;
  }

  @GetMapping("/users")
  public List<User> findAll() {
    return service.findAll();
  }

  @GetMapping("/users/{id}")
  public EntityModel<User> findUser(@PathVariable Integer id) {

    User user = service.findUser(id);
    if (user == null) {
      throw new UserNotFoundException("id:" + id);
    }
    EntityModel<User> entityModel = EntityModel.of(user);

    WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).findAll());

    entityModel.add(link.withRel("all-users"));
    return entityModel;
  }

  @DeleteMapping("/users/{id}")
  public void deleteUser(@PathVariable Integer id) {
    service.deleteById(id);
  }

  @PostMapping("/users")
  public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
    User savedUser = service.save(user);
    URI location =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(savedUser.getId())
            .toUri();
    return ResponseEntity.created(location).build();
  }
}