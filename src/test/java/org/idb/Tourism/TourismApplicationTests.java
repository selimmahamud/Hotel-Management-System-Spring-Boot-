package org.idb.Tourism;

import org.idb.Tourism.entity.Hotel;
import org.idb.Tourism.service.HotelService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TourismApplicationTests {
	@Autowired
	HotelService hotelService;






	@Test
	void contextLoads() {
	}

	@Test
	void  saveHotel(){

		Hotel h = new Hotel();


				h.setHname("ABC Hotel");
				h.setHemail("abc@gmail.com");
				h.setHpassword("1234");
				h.setHphone("01677320646");

		hotelService.saveHotel(h);

	}








	@Test
	void x(){
		System.out.println(hotelService.getHotelListByLocation(2));
	}
}
