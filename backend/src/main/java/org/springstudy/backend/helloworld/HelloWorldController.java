package org.springstudy.backend.helloworld;

import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

  private final MessageSource messageSource;

  public HelloWorldController(MessageSource messageSource) {
    this.messageSource = messageSource;
  }

  @GetMapping("/basicauth")
  public String basicAuth() {
    return "Success";
  }

  @GetMapping(path = "/hello")
  public String hello() {
    return "Hello World! v2";
  }

  @GetMapping(path = "/hello-world-bean")
  public HelloWorld helloWorldBean() {
    return new HelloWorld("Hello World Bean! v2");
  }

  @GetMapping(path = "/hello-world/path-variable/{name}")
  public HelloWorld helloWorldPathVariable(@PathVariable String name) {
    return new HelloWorld(String.format("Hello World, %s!", name));
  }

  @GetMapping(path = "/hello-international")
  public String helloInternational() {
    Locale locale = LocaleContextHolder.getLocale();
    return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
  }
}