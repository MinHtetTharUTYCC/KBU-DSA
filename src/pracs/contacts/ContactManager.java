package pracs.contacts;

public class ContactManager {
    private int friendsCount = 0;
    private Contact[] friends;

    public ContactManager() {
        friends = new Contact[100];
    }

    public void addContact(Contact contact){
        friends[friendsCount] = contact;
        friendsCount++;
    }

    public Contact searchContact(String searchName){
        for(int i=0; i<friendsCount; i++){
            if(friends[i].name.equals(searchName)){
                return friends[i];
            };
        }
        return null;
    }

    public int getFriendsCount() {
        return friendsCount;
    }

    public void setFriendsCount(int friendsCount) {
        this.friendsCount = friendsCount;
    }

    public Contact[] getFriends() {
        return friends;
    }

    public void setFriends(Contact[] friends) {
        this.friends = friends;
    }
}
