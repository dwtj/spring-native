package org.apache.activemq;

import org.springframework.nativex.hint.NativeHint;
import org.springframework.nativex.hint.TypeHint;
import org.springframework.nativex.type.NativeConfiguration;
import org.springframework.nativex.type.TypeSystem;

// TODO(dwtj): Figure out how to include the various named classes as dependencies of `spring-native-configuration`.
//  Then replace uses of `typeNames` with `types` and convert strings to `.class` expressions.
@NativeHint(
        // TODO(dwtj): I expect that we might need more reflective access when using a non-embedded ActiveMQ broker. So,
        //  such a sample should be implemented.
        types = @TypeHint(
                typeNames = {
                        "org.apache.activemq.broker.BrokerService",
                        "org.apache.activemq.broker.DefaultBrokerFactory",
                        "org.apache.activemq.transport.vm.VMTransportFactory"
                }
        )
)
public class ActiveMQHints implements NativeConfiguration {
    // TODO(dwtj): Get feedback about whether this is appropriate criteria for enabling `ActiveMQHints`. In particular,
    //  consider enabling based on something from Spring, not from ActiveMQ.
    @Override
    public boolean isValid(TypeSystem typeSystem) {
        boolean usesFactory = typeSystem.resolveName("org.apache.activemq.broker.DefaultBrokerFactory", true) != null;
        return usesFactory;
    }
}
