package diy;

import diy.booking.*;
import diy.user.User;
import diy.user.UserService;
import diy.user.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        User user = new User(1L, 10000);

        // 일반적인 제어의 흐름
        // 특정 서비스를 사용하기 위해서 사용자가 하위 모듈 생성 및 주입을 직접 제어해야 함
        BookingPolicy bookingPolicy = new DiscountBookingPolicy();  // 1000원 고정 할인
        UserService userService = new UserServiceImpl();
        BookingService bookingService = new BookingService(userService,bookingPolicy);  // 의존성 주입 => DIP
        int userAmountAfterBooking = bookingService.getUserAmountAfterBooking(user, 2, 2000);
        System.out.println(userAmountAfterBooking);

        // 객체 생성을 외부에서 관리
        // BookingService 에 어떤 구현체를 넣어줄지를 외부에서 설정 가능 => 의존 주입을 외부에서 관리
        Container container = new Container();
        BookingService bookingService1 = container.bookingService();    // 외부에서 UserServiceImpl, DiscountBookingPolicy 가 주입
        int userAmountAfterBooking1 = bookingService1.getUserAmountAfterBooking(user, 2, 2000);
        System.out.println(userAmountAfterBooking1);
    }
}
