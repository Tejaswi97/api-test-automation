package endpoints;

public class Routes {

    public static String getProduct = "/products/{id}";
    public static String getAllProducts = "/products";
    public static String createProduct = "/products";        // POST
    public static String updateProduct = "/products/{id}";   // PUT
    public static String deleteProduct = "/products/{id}";   // DELETE
    public static String getAllCart = "/carts";
    public static String createCart = "/carts";
    public static String getCart = "/carts/{id}";
    public static String updateCart = "/carts/{id}";
    public static String deleteCart = "/carts/{id}";
    public static String getAllUsers = "/users";
    public static String createUser = "/users";
    public static String getSingleUser = "/users/{id}";
    public static String updateUser = "/users/{id}";
    public static String deleteUser = "/users/{id}";
    public static String loginUser = "/auth/login";
}
