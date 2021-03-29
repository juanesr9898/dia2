/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.restuser.web.controller;

import co.edu.utp.isc.gia.restuser.web.dto.UserDto;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author juane
 */
public class UserControllerTest {
    
    public UserControllerTest() {
    }

    @Test
    public void testSave() throws Exception {
        System.out.println("save");
        UserDto user = null;
        UserController instance = null;
        UserDto expResult = null;
        UserDto result = instance.save(user);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testListAll() throws Exception {
        System.out.println("listAll");
        UserController instance = null;
        List<UserDto> expResult = null;
        List<UserDto> result = instance.listAll();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testFindOne() throws Exception {
        System.out.println("findOne");
        Long id = null;
        UserController instance = null;
        UserDto expResult = null;
        UserDto result = instance.findOne(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testUpdateOne() throws Exception {
        System.out.println("updateOne");
        Long id = null;
        UserDto user = null;
        UserController instance = null;
        UserDto expResult = null;
        UserDto result = instance.updateOne(id, user);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRemoveOne() throws Exception {
        System.out.println("removeOne");
        Long id = null;
        UserController instance = null;
        UserDto expResult = null;
        UserDto result = instance.removeOne(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
