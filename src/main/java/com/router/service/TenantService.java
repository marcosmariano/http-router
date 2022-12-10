    package com.router.service;

    import com.router.config.RouterConfiguration;

    import javax.inject.Inject;
    import javax.inject.Singleton;
    import java.util.Arrays;
    import java.util.HashMap;
    import java.util.stream.Collectors;

    @Singleton
    public class TenantService {
        @Inject
        RouterConfiguration routerConfiguration;

        private HashMap<String,String> tenants;

        public String getRouterHeaderName(){return routerConfiguration.routerHeaderName();}

        public String getClientHost(String tenantId) throws Exception
        {
            if(tenantId==null)
                throw new Exception("Tenant Id can not be null");

            splitClientList(routerConfiguration.clientList());
            return this.tenants.get(tenantId);
        }

        private  void splitClientList(String tenantList) throws Exception
        {
            if(tenantList==null)
                throw new Exception("Tenant List can not be null");

            this.tenants = (HashMap<String, String>) Arrays.asList(tenantList.split(";"))
                    .stream()
                    .map(s->s.split("\\|"))
                    .collect(Collectors.toMap(e->e[0],e->(e[1])));
        }
    }
