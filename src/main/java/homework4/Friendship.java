package homework4;

import java.util.Objects;

public class Friendship {
    // implement the relevant properties, constructor and methods
    private String friend1;
    private String friend2;
    private int friendshipStrength;

    public Friendship(String friend1, String friend2, int friendshipStrength) {
        this.friend1 = friend1;
        this.friend2 = friend2;
        this.friendshipStrength = friendshipStrength;
    }

    public String getFriend1() {
        return friend1;
    }

    public String getFriend2() {
        return friend2;
    }

    public int getFriendshipStrength() {
        return friendshipStrength;
    }

    public void setFriendshipStrength(int friendshipStrength) {
        this.friendshipStrength = friendshipStrength;
    }

    @Override
    public String toString() {
        return friend1 + " - " + friend2 + " : " + friendshipStrength;
    }
}
