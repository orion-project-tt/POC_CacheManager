package rtl.tot.corp.mrex.prcn.provider.cachemanager.commons.azureservicebus;

import com.microsoft.azure.servicebus.primitives.ServiceBusException;

import rtl.tot.corp.mrex.prcn.provider.cachemanager.commons.event.EventPublisher;
import rtl.tot.corp.mrex.prcn.provider.cachemanager.commons.event.EventSubscriber;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class AzureServiceBusConfig {

    @Lazy
    @Bean
    @ConditionalOnProperty(prefix = "publisher", name = "azure-service-bus.topic")
    public EventPublisher asbPublisher() throws ServiceBusException, InterruptedException {
        return new TopicClientConfig();
    }

    @Lazy
    @Bean
    @ConditionalOnProperty(prefix = "subscriber", name = "azure-service-bus.topic")
    public EventSubscriber asbSubscriber() throws ServiceBusException, InterruptedException {
        return new SubscriptionClientConfig();
    }
}
