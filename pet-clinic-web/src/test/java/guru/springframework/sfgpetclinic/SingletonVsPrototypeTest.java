package guru.springframework.sfgpetclinic;

import guru.springframework.sfgpetclinic.SingletonVsPrototypeTest.AndAnotherSingletonBean;
import guru.springframework.sfgpetclinic.SingletonVsPrototypeTest.AnotherSingletonBean;
import guru.springframework.sfgpetclinic.SingletonVsPrototypeTest.PrototypeBean;
import guru.springframework.sfgpetclinic.SingletonVsPrototypeTest.SingletonBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

@SpringBootTest(classes = {SingletonBean.class, PrototypeBean.class, AnotherSingletonBean.class, AndAnotherSingletonBean.class})
class SingletonVsPrototypeTest {
  @Autowired
  ApplicationContext context;

  @Test
  void test() {
    SingletonBean singleton = context.getBean(SingletonBean.class);
  }

  public static class SingletonBean {

    public SingletonBean() {
      System.out.println("------- Singleton created");
    }
  }

  @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
  public static class PrototypeBean {

    public PrototypeBean() {
      System.out.println("!------ Prototype created");
    }
  }

  public static class AnotherSingletonBean {
    @Autowired
    private SingletonBean singletonBean;
    @Autowired
    private PrototypeBean prototypeBean;

    public AnotherSingletonBean() {
      System.out.println("----------- AnotherSingletonBean");
    }
  }

  public static class AndAnotherSingletonBean {
    @Autowired
    private SingletonBean singletonBean;

    @Autowired
    private PrototypeBean prototypeBean;

    public AndAnotherSingletonBean() {
      System.out.println("----------------- AndAnotherSingletonBean");
    }
  }
}

