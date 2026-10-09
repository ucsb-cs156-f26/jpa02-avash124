package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test 
    public void toString_returns_correct_string(){
        assertEquals("Team(name=test-team, members=[])",team.toString());
    }

    @Test 
    public void equals_test_for_same_object(){
        assertTrue(team.equals(team));
    }

    @Test 
    public void equals_test_for_different_class(){
        assertFalse(team.equals("test-team"));
    }

    @Test 
    public void equals_same_name_and_members_test_for_true(){
        Team t1 = new Team("curr team");
        t1.addMember("Aryan");
        Team t2 = new Team("curr team");
        t2.addMember("Aryan");
        assertTrue(t1.equals(t2));
    }

    @Test 
    public void equals_same_name_and_diff_members_test_for_false(){
        Team t1 = new Team("curr team");
        t1.addMember("Aryan");
        Team t2 = new Team("fut team");
        t2.addMember("Yikers");
        assertTrue(t1.equals(t2));
    }


    @Test
    public void test_evaluates_different_instances(){
        Team t1 = new Team();
        t1.setName("Aryan's team");
        t1.addMember("Aryan");
        Team t2 = new Team();
        t2.setName("other team");
        t2.addMember("other");
        assertNotEquals(t1,t2);
    }

    @Test
    public void test_hash_code(){
        Team t1 = new Team();
        t1.setName("Aryan's team");
        t1.addMember("Aryan");
        Team t2 = new Team();
        t2.setName("Aryan's team");
        t2.addMember("Aryan");
        assertEquals(t1.hashCode(),t2.hashCode());
        Team t3 = new Team();
        t3.setName("Aryan's other team");
        int result = t3.hashCode();
        int expected = -451524979;
        assertEquals(result, expected);
    }

}
