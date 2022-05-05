package diy.booking;

import diy.user.*;

public class BookingService {
    // 추상화에 의존, 구현제 의존 X => OCP 준수
    private final BookingPolicy ticketPolicy;
    private final UserService userService;

    public BookingService(UserService userService, BookingPolicy ticketPolicy) {
        this.userService = userService;
        this.ticketPolicy = ticketPolicy;
    }

    public int getPriceToBooking(int ticketAmount, int ticketPrice){
        return ticketPolicy.priceToBook(ticketAmount, ticketPrice);
    }

    public int getUserAmountAfterBooking(User user, int ticketAmount, int ticketPrice){
        int amount = userService.amountAfterPay(user, getPriceToBooking(ticketAmount, ticketPrice));
        return amount;
    }

}
