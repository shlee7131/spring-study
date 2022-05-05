package diy.user;

public class User {
    private final Long id;
    private int amount;

    public User(Long id, int amount){
        this.id = id;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount(){
        return this.amount;
    }
}
