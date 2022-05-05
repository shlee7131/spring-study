package diy.booking;

public class DiscountBookingPolicy implements BookingPolicy{
    private int discountPrice = 1000;

    @Override
    public int priceToBook(int ticketAmount, int ticketPrice) {
        return ticketAmount * (ticketPrice - discountPrice);
    }
}
