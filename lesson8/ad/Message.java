package lesson8.ad;

import java.util.Date;

public class Message extends BaseEntity{


    User userFrom;
    User userTo;
    String message;
    Date dateSent;
    Date dateRead;

    public Message(long id, User userFrom, User userTo, String message, Date dateSent, Date dateRead) {
        super(id);
        this.userFrom = userFrom;
        this.userTo = userTo;
        this.message = message;
        this.dateSent = new Date();
    }

    void setDateRead(){
        dateRead = new Date();
    }

    boolean isRead(){
       // if (dateRead == null){
       //     return false;
       // }
       // else true;
       return dateRead == null;
    }


}
