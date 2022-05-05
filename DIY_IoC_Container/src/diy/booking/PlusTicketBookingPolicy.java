package diy.booking;

public class PlusTicketBookingPolicy implements BookingPolicy{
    private int plusAmount = 1;

    @Override
    public int priceToBook(int ticketAmount, int ticketPrice) {
        return (ticketAmount / ( 1 + plusAmount)) * ticketPrice;
    }
}
