package lesson18;

public class Definition {

    private void notifyUsers(String[] usersEmails) {

        for (String email : usersEmails) {
            //send email to user - error
            try {
                //send email to user - error
                System.out.println("Email " + email + "was sent");

            } catch (Exception e) {
                System.err.println("Email " + email + "was not sent");
                // how should I handle exception

            }
            finally {

            }
        }
    }
}
