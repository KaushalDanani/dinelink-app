package com.dinelink.backend;

import com.dinelink.backend.model.hotel.Hotel;
import com.dinelink.backend.model.hotel.HotelDao;
import com.dinelink.backend.model.user.User;
import com.dinelink.backend.model.user.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BackendApplicationTests {

	@Autowired
	private UserDao userDao;
	@Autowired
	private HotelDao hotelDao;

	@Test
	void add() {
//		Hotel hotel = new Hotel();
//		hotel.setHotel_id("H001");
//		hotel.setHotel_addr("near fatehgunj, Vadodara");
//		hotel.setHotel_name("khodaldham kathiyavadi hotel");
//		hotel.setHotel_rating(5);
//		hotel.setHotel_x_coords(10.10);
//		hotel.setHotel_y_coords(10.10);
//		hotel.setHote_password("kkhh001");
//		hotel.setHotel_link("www.khodaldhamhotel.com");
//		hotel.setHotel_image(null);
//		hotelDao.save(hotel);

		User user = new User();
		user.setUser_name("Soham");
		user.setUser_email("soham@gmail.com");
		userDao.save(user);

	}

}
