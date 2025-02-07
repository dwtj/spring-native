package com.example.activemq;

import javax.jms.ConnectionFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.nativex.hint.NativeHint;
import org.springframework.nativex.hint.JdkProxyHint;

@SpringBootApplication
@EnableJms
public class Application {

  @Bean
  public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory,
                          DefaultJmsListenerContainerFactoryConfigurer configurer) {
    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
    // This provides all boot's default to this factory, including the message converter
    configurer.configure(factory, connectionFactory);
    // You could still override some of Boot's default if necessary.
    return factory;
  }

// TODO(dwtj): Consider using this message converter.
//   @Bean // Serialize message content to json using TextMessage
//   public MessageConverter jacksonJmsMessageConverter() {
//     MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
//     converter.setTargetType(MessageType.TEXT);
//     converter.setTypeIdPropertyName("_type");
//     return converter;
//   }

  public static void main(String[] args) {
    // Launch the application
    ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

    JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);

    // Send a message with a POJO - the template reuse the message converter
    System.out.println("Sending a `StringMessage`.");
    // TODO(dwtj): Figure out how to convert and send a POJO, `StringMessage`.
    //jmsTemplate.convertAndSend(Names.DEFAULT_DESTINATION, new StringMessage("Hello, world!"));
    // TODO(dwtj): What magic does Spring use to convert/coerce this string into a `StringMessage`?
    jmsTemplate.convertAndSend(Names.DEFAULT_DESTINATION, "Hello, world!");
  }

}
