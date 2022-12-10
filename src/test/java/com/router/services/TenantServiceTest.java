package com.router.services;

import io.quarkus.test.junit.QuarkusTest;
import com.router.service.TenantService;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
public class TenantServiceTest {

    @Inject
    TenantService tenantService;

    @Test
    public void whenTenantNameIsAThenResult() throws Exception{
        String tenantHost = tenantService.getClientHost("a");
        assert tenantHost.equals("http://localhost:8080");
    }

    @Test
    public void whenTenantNameIsBThenResult() throws Exception{
        String tenantHost = tenantService.getClientHost("b");
        assert tenantHost.equals("http://localhost:8081");
    }

    @Test
    public void whenTenantNameIsCThenResult() throws Exception{
        String tenantHost = tenantService.getClientHost("c");
        assert tenantHost.equals("http://localhost:8082");
    }

    @Test
    public void whenTenantNameIsUnknowThenNull() throws Exception{
        String tenantHost = tenantService.getClientHost("teste");
        assert tenantHost == null;
    }

    @Test
    public void whenTenantNameIsNullThenException() throws Exception{
        Exception ex = null;
        try{
            String tenantHost = tenantService.getClientHost(null);
        }catch (Exception e)
        {
            ex = e;
        }

        assert  ex.getMessage().equals("Tenant Id can not be null");
    }
}
