package it.unipd.mtss.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {
    @Test(expected = IllegalArgumentException.class)
    public void CreateEItemWithNegativeIdShouldThrowException() {
        new User(-1, 22, "Jerry", "Scotti");
    }
    @Test(expected = IllegalArgumentException.class)
    public void CreateEItemWithNegativeAgeShouldThrowException() {
        new User(2, -21, "Enzo", "Iacchetti");
    }

    @Test
    public void CreateUserWithCorrectValuesShouldPass() {
        new User(3, 21, "Giovanni", "Muciaccia");
    }

    @Test
    public void CreateValidUserShouldContainCorrectId() {
        User user = new User(1, 22, "Jerry", "Scotti");
        assertEquals(user.getId(), 1);
    }

    @Test
    public void CreateValidEItemShouldContainCorrectAge() {
        User user = new User(3, 21, "Giovanni", "Muciaccia");
        assertEquals(user.getAge(), 21);
    }

    @Test
    public void CreateValidEItemShouldContainCorrectName() {
        User user = new User(1, 22, "Jerry", "Scotti");
        assertEquals(user.getName(), "Jerry");
    }

    @Test
    public void CreateValidEItemShouldContainCorrectSurname() {
        User user = new User(2, 22, "Jerry", "Scotti");
        assertEquals(user.getSurname(), "Scotti");
    }
}
