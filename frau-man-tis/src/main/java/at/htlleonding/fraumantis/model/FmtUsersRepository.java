package at.htlleonding.fraumantis.model;

public class FmtUsersRepository {
    private final static FmtUser[] mUsers = new FmtUser[] {
        new FmtUser("Yanni"),
        new FmtUser("Clemens"),
        new FmtUser("Kate"),
        new FmtUser("Melanie"),
    };

    public static FmtUser[] getUsers() {
        return mUsers;
    }
}
