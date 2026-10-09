package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Aryan", Developer.getName());
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void getGitHubID_returns_correct_ID(){
        assertEquals("avash124", Developer.getGithubId());
    } 

    @Test 
    public void getTeam_returns_correct_Team_with_correct_name(){
        Team t = Developer.getTeam();
        assertEquals("f26-09",t.getTeam());  
    }

    @Test 
    public void getTeam_returns_correct_members(){
        Team t = Developer.getTeam();
        assertEquals(t.getMembers().contains("Aryan"), "Team should contain Aryan");
        assertEquals(t.getMembers().contains("Tom"), "Team should contain Tom");
        assertEquals(t.getMembers().contains("Jerry"), "Team should contain Jerry");
        assertEquals(t.getMembers().contains("Bogdan"), "Team should contain Bodgan");
        assertEquals(t.getMembers().contains("Amaya"), "Team should contain Amaya");
    }
}
