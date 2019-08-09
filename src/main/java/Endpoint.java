public class Endpoint {

    private static String LISTRESOURCES = "/api/unknown";
    private static String SINGLEUSER = "/api/users";
    private static String POSTUSER = "/students";


    public static String getListUsers() {
        return LISTRESOURCES;
    }

    public static String getSingleUser() {
        return SINGLEUSER;
    }

    public static String getPostUser() { return POSTUSER; }
}
