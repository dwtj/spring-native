/*
 * Copyright 2002-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.jms;

import org.springframework.nativex.hint.JdkProxyHint;
import org.springframework.nativex.hint.NativeHint;
import org.springframework.nativex.type.NativeConfiguration;
import org.springframework.nativex.type.TypeSystem;

@NativeHint(
    // TODO(dwtj): Figure out how to include these classes as dependencies of `spring-native-configuration`. Then
    //  use `types` instead of `typeNames` and convert these strings to ".class" expressions.
    jdkProxies = {
        @JdkProxyHint(
            typeNames = {
                "javax.jms.Connection",
                "javax.jms.QueueConnection",
                "javax.jms.TopicConnection"
            }
        ),
        @JdkProxyHint(
            typeNames = {
                "org.springframework.jms.connection.SessionProxy",
                "javax.jms.QueueSession",
                "javax.jms.TopicSession"
            }
        ),
    }
)
public class JmsHints implements NativeConfiguration {
    // TODO(dwtj): Get feedback about whether this is appropriate criteria for enabling `JmsHints`.
    @Override
    public boolean isValid(TypeSystem typeSystem) {
        boolean usesSessionProxy = typeSystem.resolveName("org.springframework.jms.connection.SessionProxy", true) != null;
        return usesSessionProxy;
    }
}
