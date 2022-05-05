package diy.booking;

public interface BookingPolicy {
    // user 가 price 만큼 ticket 을 예매할 때
    public int priceToBook(int ticketAmount,int ticketPrice);
}
