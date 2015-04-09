package info.fges.blablacool.services;

import info.fges.blablacool.dao.RoleDao;
import info.fges.blablacool.models.Role;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.servlet.ServletContext;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "classpath*:/spring/applicationContext*.xml")
public class RoleServiceTest {
    @InjectMocks
    private RoleService roleService;

    @Mock
    private RoleDao roleDao;

    @Mock
    private ServletContext servletContext;

    Role role1, role2;
    List<Role> roles;

    @Before
    public void setUp() throws Exception {
        role1 = new Role();
        role1.setIdRole(1);

        role2 = new Role();
        role2.setIdRole(2);

        roles = Arrays.asList(role1, role2);

        MockitoAnnotations.initMocks(this);

        Mockito.when(roleService.findById(1)).thenReturn(role1);
        Mockito.when(roleService.findAll()).thenReturn(roles);

    }

    @Test
    public void testFindById() throws Exception {
        Role foundRole = roleService.findById(1);
        assertEquals(1, foundRole.getIdRole());
    }

    @Test
    public void testFindAll() throws Exception {
        List<Role> foundRoles = roleService.findAll();
        assertEquals(2, foundRoles.size());
    }

    @Test
    public void testCreate() throws Exception {
        roleService.create(role1);
        verify(roleDao).create(role1);
    }

    @Test
    public void testUpdate() throws Exception {
        roleService.update(role1);
        verify(roleDao).update(role1);
    }

    @Test
    public void testDelete() throws Exception {
        roleService.delete(role1);
        verify(roleDao).delete(role1);
    }

    @Test
    public void testDeleteById() throws Exception {
        roleService.deleteById(1);
        verify(roleDao).deleteById(1);
    }
}