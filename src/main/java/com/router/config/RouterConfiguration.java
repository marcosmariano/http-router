
package com.router.config;

import io.quarkus.runtime.annotations.StaticInitSafe;
import io.smallrye.config.ConfigMapping;

@StaticInitSafe
@ConfigMapping(prefix = "router", namingStrategy = ConfigMapping.NamingStrategy.VERBATIM)
public interface RouterConfiguration {
    String clientList();
    String routerHeaderName();
}