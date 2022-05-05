package diy.user;

public class UserServiceImpl implements UserService {

    @Override
    public int amountAfterPay(User user, int price) {
        int amount = user.getAmount();
        amount -= price;
        user.setAmount(amount);
        return amount;
    }
}
