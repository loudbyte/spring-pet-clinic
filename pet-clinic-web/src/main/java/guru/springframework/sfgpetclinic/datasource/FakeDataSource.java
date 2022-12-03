package guru.springframework.sfgpetclinic.datasource;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:datasource.properties")
public class FakeDataSource {

  private String username;
  private String password;
  private String jdbcurl;

}
