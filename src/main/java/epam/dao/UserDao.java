package epam.dao;

public interface UserDao {

    /**
     * Method to get a certain user by his/her email
     * @return
     */
    String getUserByEmail(String userEmail);


}
