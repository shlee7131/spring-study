package diy;

import diy.booking.*;
import diy.user.*;

public class Container {

    public BookingPolicy bookingPolicy(){
        return new DiscountBookingPolicy();
    }

    public UserService userService(){
        return new UserServiceImpl();
    }

    public BookingService bookingService(){
        return new BookingService(userService() ,bookingPolicy());
    }
}
