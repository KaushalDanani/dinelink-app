package com.dinelink.backend;

import com.dinelink.backend.model.FoodItem;
import com.dinelink.backend.repository.FoodItemRepository;
import com.dinelink.backend.repository.OrderItemRepository;
import com.dinelink.backend.repository.OrdersRepository;
import com.dinelink.backend.model.Hotel;
import com.dinelink.backend.service.HotelDao;
import com.dinelink.backend.service.UserDao;
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
		Hotel hotel = new Hotel();
		hotel.setHotel_id(1);
		hotel.setHotel_addr("near fatehgunj, Vadodara");
		hotel.setHotel_name("khodaldham kathiyavadi hotel");
		hotel.setHotel_rating(5);
		hotel.setHotel_x_coords(10.10);
		hotel.setHotel_y_coords(10.10);
		hotel.setHotel_password("kkhh001");
		hotel.setHotel_link("www.khodaldhamhotel.com");
		hotel.setHotel_image(null);
		hotelDao.save(hotel);
//
//		User user = new User();
//		user.setUser_name("Soham");
//		user.setUser_email("soham@gmail.com");
//		userDao.save(user);
//
	}

	@Autowired
	FoodItemRepository mr;

	@Test
	void addFoodItems(){
//		FoodItem f1 = new FoodItem(1,1,"Mojito",129,"Lime and mint essence","Beverages","");
//		FoodItem f2 = new FoodItem(2,1,"Chicken Caesar Salad",199,"Fresh romaine lettuce, grilled chicken, parmesan cheese, and Caesar dressing","Salads","");
//		FoodItem f3 = new FoodItem(3,2,"Margherita Pizza",299,"Fresh tomato sauce, mozzarella cheese, and basil leaves on a thin crust","Pizzas","");
//		FoodItem f4 = new FoodItem(4,2,"Penne Arrabiata",249,"Penne pasta tossed in spicy tomato sauce with garlic and chili flakes","Pasta","");
//		FoodItem f5 = new FoodItem(5,3,"Grilled Salmon",399,"Fresh Atlantic salmon grilled to perfection, served with lemon butter sauce","Seafood","");
//		FoodItem f6 = new FoodItem(6,3,"Beef Burger",279,"Juicy beef patty topped with lettuce, tomato, onion, and pickles, served with fries","Burgers","");
//		FoodItem f7 = new FoodItem(7,4,"Vegetable Biryani",229,"Fragrant basmati rice cooked with mixed vegetables and aromatic spices","Rice Dishes","");
//		FoodItem f8 = new FoodItem(8,4,"Butter Chicken",349,"Tender chicken pieces cooked in a rich and creamy tomato-based sauce","Curries","");
//		FoodItem f9 = new FoodItem(9,5,"Tiramisu",179,"Classic Italian dessert made with layers of coffee-soaked ladyfingers and mascarpone cheese","Desserts","");
//		FoodItem f10 = new FoodItem(10,5,"Sushi Platter",499,"Assorted sushi rolls including tuna, salmon, and California rolls, served with soy sauce and wasabi","Sushi","");
//		FoodItem f11 = new FoodItem(11,6,"Caprese Salad",179,"Fresh mozzarella cheese, ripe tomatoes, basil leaves, drizzled with balsamic glaze","Salads","");
//		FoodItem f12 = new FoodItem(12,6,"Pesto Pasta",249,"Spaghetti tossed in homemade basil pesto sauce with pine nuts and parmesan cheese","Pasta","");
//		FoodItem f13 = new FoodItem(13,7,"Grilled Shrimp Skewers",349,"Jumbo shrimp marinated in garlic and lemon, skewered and grilled to perfection","Seafood","");
//		FoodItem f14 = new FoodItem(14,7,"BBQ Pulled Pork Sandwich",279,"Slow-cooked pulled pork tossed in tangy barbecue sauce, served on a toasted bun with coleslaw","Sandwiches","");
//		FoodItem f15 = new FoodItem(15,8,"Vegetable Pad Thai",229,"Stir-fried rice noodles with tofu, bean sprouts, peanuts, and a tangy tamarind sauce","Noodles","");
//		FoodItem f16 = new FoodItem(16,8,"Green Curry",329,"Thai green curry with bamboo shoots, bell peppers, and your choice of chicken, beef, or tofu","Curries","");
//		FoodItem f17 = new FoodItem(17,9,"Cheesecake",199,"Creamy New York-style cheesecake with a graham cracker crust, topped with fresh berries","Desserts","");
//		FoodItem f18 = new FoodItem(18,9,"Fish Tacos",279,"Grilled fish fillets served in warm tortillas with shredded cabbage, salsa, and avocado crema","Tacos","");
//		FoodItem f19 = new FoodItem(19,10,"Mushroom Risotto",269,"Creamy risotto cooked with Arborio rice, mushrooms, onions, and white wine","Rice Dishes","");
//		FoodItem f20 = new FoodItem(20,10,"Chicken Tikka Masala",359,"Tender pieces of chicken cooked in a flavorful tomato-based curry sauce with aromatic spices","Curries","");
//		FoodItem f21 = new FoodItem(21, 1, "Chicken Tikka Masala", 249, "Tender chicken tikka cooked in a rich tomato and cream sauce with aromatic spices", "Curries", "");
//		FoodItem f22 = new FoodItem(22, 1, "Paneer Butter Masala", 229, "Soft paneer cubes cooked in a creamy tomato-based gravy with butter and spices", "Curries", "");
//		FoodItem f23 = new FoodItem(23, 1, "Dal Makhani", 199, "Black lentils and kidney beans slow-cooked with tomatoes, cream, and spices", "Curries", "");
//		FoodItem f24 = new FoodItem(24, 1, "Vegetable Korma", 219, "Assorted vegetables cooked in a rich, creamy coconut-based curry sauce with nuts and spices", "Curries", "");
//		FoodItem f25 = new FoodItem(25, 1, "Chicken Curry", 239, "Tender chicken pieces cooked in a flavorful curry sauce with onions, tomatoes, and spices", "Curries", "");
//		FoodItem f26 = new FoodItem(26, 1, "Beef Vindaloo", 259, "Tender beef chunks cooked in a spicy and tangy curry sauce with potatoes, vinegar, and spices", "Curries", "");
//		FoodItem f27 = new FoodItem(27, 1, "Egg Curry", 189, "Hard-boiled eggs cooked in a rich and aromatic tomato-based curry sauce with onions and spices", "Curries", "");
//		FoodItem f28 = new FoodItem(28, 1, "Fish Curry", 279, "Fresh fish fillets cooked in a tangy and flavorful curry sauce with coconut milk, tamarind, and spices", "Curries", "");
//		FoodItem f29 = new FoodItem(29, 1, "Mutton Rogan Josh", 299, "Tender mutton pieces cooked in a thick, aromatic gravy with yogurt, tomatoes, and spices", "Curries", "");
//		FoodItem f30 = new FoodItem(30, 1, "Vegetable Jalfrezi", 209, "Mixed vegetables stir-fried with onions, bell peppers, and tomatoes in a spicy and tangy curry sauce", "Curries", "");
//		FoodItem f31 = new FoodItem(31, 1, "Chana Masala", 199, "Chickpeas cooked in a spiced tomato-based curry sauce with onions, ginger, and garlic", "Curries", "");
//		FoodItem f32 = new FoodItem(32, 1, "Palak Paneer", 229, "Soft paneer cubes cooked in a creamy spinach gravy with garlic, onions, and spices", "Curries", "");
//		FoodItem f33 = new FoodItem(33, 1, "Goan Prawn Curry", 299, "Fresh prawns cooked in a coconut-based curry sauce with tomatoes, onions, and Goan spices", "Curries", "");
//		FoodItem f34 = new FoodItem(34, 1, "Lamb Curry", 269, "Tender lamb pieces cooked in a flavorful curry sauce with onions, tomatoes, and a blend of spices", "Curries", "");
//		FoodItem f35 = new FoodItem(35, 1, "Vegetable Biryani", 249, "Spiced rice cooked with mixed vegetables and aromatic spices", "Rice", "");
//		FoodItem f36 = new FoodItem(36, 1, "Chicken Fried Rice", 199, "Stir-fried rice with chicken, eggs, vegetables, and soy sauce", "Rice", "");
//		FoodItem f37 = new FoodItem(37, 1, "Paneer Pulao", 229, "Fragrant rice cooked with paneer cubes, spices, and herbs", "Rice", "");
//		FoodItem f38 = new FoodItem(38, 1, "Schezwan Fried Rice", 259, "Spicy fried rice with Schezwan sauce, mixed vegetables, and tofu or chicken", "Rice", "");
//		FoodItem f39 = new FoodItem(39, 1, "Lemon Rice", 179, "Tangy rice flavored with lemon juice, curry leaves, and peanuts", "Rice", "");

		FoodItem f50 = new FoodItem(1, "Classic Cheeseburger", 199, "Juicy beef patty with melted cheese, lettuce, tomato, and pickles on a sesame seed bun", "Burgers", "");
		FoodItem f51 = new FoodItem(1, "Chicken Burger", 179, "Grilled chicken breast with lettuce, tomato, and mayonnaise on a toasted bun", "Burgers", "");
		FoodItem f52 = new FoodItem(1, "Veggie Burger", 159, "Vegetarian patty made from vegetables, grains, and spices, served with lettuce, tomato, and sauce", "Burgers", "");
		FoodItem f53 = new FoodItem(1, "Double Bacon Burger", 249, "Double beef patties topped with crispy bacon, cheese, lettuce, tomato, and special sauce", "Burgers", "");
		FoodItem f54 = new FoodItem(1, "Mushroom Swiss Burger", 229, "Beef patty topped with sautéed mushrooms, Swiss cheese, lettuce, and garlic aioli", "Burgers", "");
		FoodItem f55 = new FoodItem(1, "BBQ Bacon Burger", 259, "Beef patty topped with BBQ sauce, crispy bacon, cheddar cheese, lettuce, and onion rings", "Burgers", "");
		FoodItem f56 = new FoodItem(1, "Spicy Chicken Burger", 189, "Crispy chicken patty with spicy sauce, lettuce, tomato, and jalapeños on a sesame seed bun", "Burgers", "");
		FoodItem f57 = new FoodItem(1, "Beyond Burger", 269, "Plant-based burger patty made from Beyond Meat, served with lettuce, tomato, and vegan mayonnaise", "Burgers", "");
		FoodItem f58 = new FoodItem(1, "Fish Burger", 219, "Breaded fish fillet with tartar sauce, lettuce, and tomato on a sesame seed bun", "Burgers", "");
		FoodItem f59 = new FoodItem(1, "Teriyaki Burger", 239, "Grilled beef patty glazed with teriyaki sauce, topped with grilled pineapple, lettuce, and mayonnaise", "Burgers", "");
		FoodItem f61 = new FoodItem(1, "Shrimp Scampi", 269, "Sautéed shrimp in garlic butter sauce, served with pasta and parmesan cheese", "Seafood", "");
		FoodItem f62 = new FoodItem(1, "Lobster Roll", 349, "Chilled lobster meat tossed with mayonnaise, served in a toasted split-top bun", "Seafood", "");
		FoodItem f63 = new FoodItem(1, "Fish and Chips", 239, "Battered and fried fish fillets served with French fries, tartar sauce, and lemon wedges", "Seafood", "");
		FoodItem f64 = new FoodItem(1, "Crab Cakes", 279, "Pan-fried crab cakes made with lump crab meat, breadcrumbs, and spices, served with remoulade sauce", "Seafood", "");
		FoodItem f65 = new FoodItem(1, "Sushi Platter", 359, "Assorted sushi rolls including California rolls, tuna rolls, and salmon nigiri", "Seafood", "");
		FoodItem f66 = new FoodItem(1, "Clam Chowder", 199, "Creamy soup made with clams, potatoes, onions, celery, and bacon", "Seafood", "");
		FoodItem f67 = new FoodItem(1, "Grilled Shrimp Skewers", 279, "Skewers of marinated shrimp grilled to perfection, served with a side of rice or vegetables", "Seafood", "");
		FoodItem f68 = new FoodItem(1, "Seafood Paella", 329, "Spanish rice dish cooked with a variety of seafood, saffron, and vegetables", "Seafood", "");
		FoodItem f69 = new FoodItem(1, "Scallops with Garlic Butter", 319, "Pan-seared scallops in garlic butter sauce, served with mashed potatoes or rice", "Seafood", "");
		FoodItem f71 = new FoodItem(1, "Greek Salad", 169, "Fresh lettuce, tomatoes, cucumbers, red onions, olives, and feta cheese tossed in Greek dressing", "Salads", "");
		FoodItem f72 = new FoodItem(1, "Caprese Salad", 189, "Slices of ripe tomatoes, fresh mozzarella cheese, basil leaves, drizzled with balsamic glaze", "Salads", "");
		FoodItem f73 = new FoodItem(1, "Cobb Salad", 199, "Mixed greens topped with grilled chicken, avocado, bacon, hard-boiled eggs, tomatoes, and blue cheese", "Salads", "");
		FoodItem f74 = new FoodItem(1, "Chicken Caesar Salad", 179, "Grilled chicken breast, romaine lettuce, garlic croutons, and parmesan cheese tossed in Caesar dressing", "Salads", "");
		FoodItem f75 = new FoodItem(1, "Spinach Salad", 159, "Fresh spinach leaves, sliced mushrooms, red onions, and crumbled bacon, tossed in balsamic vinaigrette", "Salads", "");
		FoodItem f76 = new FoodItem(1, "Nicoise Salad", 199, "Mixed greens with seared tuna, hard-boiled eggs, green beans, olives, and potatoes, dressed with vinaigrette", "Salads", "");
		FoodItem f77 = new FoodItem(1, "Waldorf Salad", 179, "Apples, celery, walnuts, and grapes mixed with mayonnaise, served on a bed of lettuce", "Salads", "");
		FoodItem f78 = new FoodItem(1, "Mediterranean Salad", 189, "Lettuce, tomatoes, cucumbers, red onions, olives, and feta cheese, drizzled with olive oil and lemon juice", "Salads", "");
		FoodItem f79 = new FoodItem(1, "Taco Salad", 169, "Crisp lettuce, seasoned ground beef, tomatoes, cheese, sour cream, and salsa, served in a crispy taco shell", "Salads", "");

		FoodItem pasta1 = new FoodItem(1, "Spaghetti Carbonara", 199, "Pasta tossed with bacon, eggs, parmesan cheese, and black pepper in a creamy sauce", "Pasta", "");
		mr.save(pasta1);

		FoodItem pasta2 = new FoodItem(1, "Fettuccine Alfredo", 189, "Fettuccine pasta tossed in a creamy Alfredo sauce made with butter, cream, and parmesan cheese", "Pasta", "");
		mr.save(pasta2);

		FoodItem pasta4 = new FoodItem(1, "Lasagna", 209, "Layers of pasta sheets, meat sauce, ricotta cheese, and mozzarella cheese, baked to perfection", "Pasta", "");
		mr.save(pasta4);

		FoodItem pasta5 = new FoodItem(1, "Pasta Primavera", 169, "Pasta with assorted vegetables such as broccoli, bell peppers, and carrots, tossed in a light olive oil sauce", "Pasta", "");
		mr.save(pasta5);

		FoodItem pasta6 = new FoodItem(1, "Ravioli with Marinara Sauce", 179, "Ravioli stuffed with cheese or meat, served with marinara sauce and grated parmesan cheese", "Pasta", "");
		mr.save(pasta6);

		FoodItem pasta7 = new FoodItem(1, "Pesto Pasta", 179, "Pasta coated in a sauce made from fresh basil leaves, garlic, pine nuts, parmesan cheese, and olive oil", "Pasta", "");
		mr.save(pasta7);

		FoodItem pasta8 = new FoodItem(1, "Baked Ziti", 189, "Ziti pasta baked with marinara sauce, ricotta cheese, and mozzarella cheese until bubbly and golden", "Pasta", "");
		mr.save(pasta8);

		FoodItem pasta9 = new FoodItem(1, "Macaroni and Cheese", 159, "Elbow macaroni pasta mixed with a creamy cheese sauce, baked until golden and bubbly", "Pasta", "");
		mr.save(pasta9);

		FoodItem pasta10 = new FoodItem(1, "Chicken Pesto Pasta", 209, "Pasta with grilled chicken, cherry tomatoes, and spinach, tossed in a creamy pesto sauce", "Pasta", "");
		mr.save(pasta10);

		FoodItem beverage1 = new FoodItem(1, "Iced Coffee", 99, "Chilled coffee served over ice cubes, optionally sweetened and topped with milk or cream", "Beverages", "");
		mr.save(beverage1);

		FoodItem beverage2 = new FoodItem(1, "Fresh Orange Juice", 79, "Freshly squeezed orange juice served cold, rich in vitamin C and refreshing", "Beverages", "");
		mr.save(beverage2);

		FoodItem beverage3 = new FoodItem(1, "Classic Lemonade", 89, "Homemade lemonade made with freshly squeezed lemons, sugar, and water, served over ice", "Beverages", "");
		mr.save(beverage3);

		FoodItem beverage4 = new FoodItem(1, "Iced Tea", 79, "Chilled black tea served over ice cubes, optionally sweetened with sugar or flavored with lemon", "Beverages", "");
		mr.save(beverage4);

		FoodItem beverage5 = new FoodItem(1, "Mango Lassi", 109, "Refreshing Indian drink made from yogurt, mango pulp, milk, sugar, and flavored with cardamom", "Beverages", "");
		mr.save(beverage5);

		FoodItem beverage6 = new FoodItem(1, "Green Smoothie", 119, "Healthy smoothie made from spinach, banana, pineapple, and coconut water, blended until smooth", "Beverages", "");
		mr.save(beverage6);

		FoodItem beverage7 = new FoodItem(1, "Hot Chocolate", 99, "Rich and creamy hot chocolate made from melted chocolate or cocoa powder, milk, and sugar", "Beverages", "");
		mr.save(beverage7);

		FoodItem beverage8 = new FoodItem(1, "Fresh Coconut Water", 69, "Natural and refreshing coconut water served straight from the coconut, rich in electrolytes", "Beverages", "");
		mr.save(beverage8);

		FoodItem beverage9 = new FoodItem(1, "Strawberry Milkshake", 129, "Creamy milkshake made with fresh strawberries, vanilla ice cream, and milk, blended until smooth", "Beverages", "");
		mr.save(beverage9);

		FoodItem beverage10 = new FoodItem(1, "Herbal Tea", 69, "Hot or cold infusion made from dried herbs, flowers, or fruits, known for their medicinal properties and aromatic flavors", "Beverages", "");
		mr.save(beverage10);

		FoodItem pizza2 = new FoodItem(1, "Pepperoni Pizza", 219, "Pizza topped with tomato sauce, mozzarella cheese, and slices of spicy pepperoni", "Pizzas", "");
		mr.save(pizza2);

		FoodItem pizza3 = new FoodItem(1, "Vegetarian Pizza", 209, "Pizza loaded with tomato sauce, mozzarella cheese, bell peppers, onions, olives, mushrooms, and tomatoes", "Pizzas", "");
		mr.save(pizza3);

		FoodItem pizza4 = new FoodItem(1, "BBQ Chicken Pizza", 229, "Pizza topped with BBQ sauce, mozzarella cheese, grilled chicken, red onions, and cilantro", "Pizzas", "");
		mr.save(pizza4);

		FoodItem pizza5 = new FoodItem(1, "Hawaiian Pizza", 219, "Pizza topped with tomato sauce, mozzarella cheese, ham, pineapple chunks, and sometimes bacon", "Pizzas", "");
		mr.save(pizza5);

		FoodItem pizza6 = new FoodItem(1, "Meat Lovers Pizza", 239, "Pizza loaded with tomato sauce, mozzarella cheese, pepperoni, sausage, bacon, and ham", "Pizzas", "");
		mr.save(pizza6);

		FoodItem pizza7 = new FoodItem(1, "Mushroom Pizza", 209, "Pizza topped with tomato sauce, mozzarella cheese, and slices of fresh mushrooms", "Pizzas", "");
		mr.save(pizza7);

		FoodItem pizza8 = new FoodItem(1, "Four Cheese Pizza", 229, "Pizza topped with tomato sauce and a blend of four cheeses such as mozzarella, cheddar, parmesan, and provolone", "Pizzas", "");
		mr.save(pizza8);

		FoodItem pizza9 = new FoodItem(1, "Buffalo Chicken Pizza", 229, "Pizza topped with buffalo sauce, mozzarella cheese, grilled chicken, red onions, and ranch dressing", "Pizzas", "");
		mr.save(pizza9);

		FoodItem pizza10 = new FoodItem(1, "Spinach and Feta Pizza", 209, "Pizza topped with tomato sauce, mozzarella cheese, spinach, feta cheese, and sometimes olives", "Pizzas", "");
		mr.save(pizza10);

//		mr.save(f1);
//		mr.save(f2);
//		mr.save(f3);
//		mr.save(f4);
//		mr.save(f5);
//		mr.save(f6);
//		mr.save(f7);
//		mr.save(f8);
//		mr.save(f9);
//		mr.save(f10);
//		mr.save(f11);
//		mr.save(f12);
//		mr.save(f13);
//		mr.save(f14);
//		mr.save(f15);
//		mr.save(f16);
//		mr.save(f17);
//		mr.save(f18);
//		mr.save(f19);
//		mr.save(f20);
//		mr.save(f21);
//		mr.save(f22);
//		mr.save(f23);
//		mr.save(f24);
//		mr.save(f25);
//		mr.save(f26);
//		mr.save(f27);
//		mr.save(f28);
//		mr.save(f29);
//		mr.save(f30);
//		mr.save(f31);
//		mr.save(f32);
//		mr.save(f33);
//		mr.save(f34);
//		mr.save(f35);
//		mr.save(f36);
//		mr.save(f37);
//		mr.save(f38);
//		mr.save(f39);
		mr.save(f50);
		mr.save(f51);
		mr.save(f52);
		mr.save(f53);
		mr.save(f54);
		mr.save(f55);
		mr.save(f56);
		mr.save(f57);
		mr.save(f58);
		mr.save(f59);


		mr.save(f61);
		mr.save(f62);
		mr.save(f63);
		mr.save(f64);
		mr.save(f65);
		mr.save(f66);
		mr.save(f67);
		mr.save(f68);
		mr.save(f69);

		mr.save(f71);
		mr.save(f72);
		mr.save(f73);
		mr.save(f74);
		mr.save(f75);
		mr.save(f76);
		mr.save(f77);
		mr.save(f78);
		mr.save(f79);


	}

	@Autowired
	OrdersRepository or;
//	@Test
//	void addOrders(){
//		Orders o1 = new Orders(1,1,"abc123@gmail.com",new Date(),1,1000);
//		Orders o2 = new Orders(2, 27, "user2@example.com", new Date(), 7, 2000);
//		Orders o3 = new Orders(3, 1, "user3@example.com", new Date(), 8, 2000);
//		Orders o4 = new Orders(4, 92, "user4@example.com", new Date(), 4, 2000);
//		Orders o5 = new Orders(5, 1, "user5@example.com", new Date(), 3, 4000);
//		Orders o6 = new Orders(6, 34, "user6@example.com", new Date(), 5, 4000);
//		Orders o7 = new Orders(7, 73, "user7@example.com", new Date(), 7, 2000);
//		Orders o8 = new Orders(8, 80, "user8@example.com", new Date(), 2, 1000);
//		Orders o9 = new Orders(9, 38, "user9@example.com", new Date(), 9, 1000);
//		Orders o10 = new Orders(10, 1, "user10@example.com", new Date(), 10, 4000);
//		Orders o11 = new Orders(11, 96, "user11@example.com", new Date(), 5, 4000);
//		Orders o12 = new Orders(12, 22, "user12@example.com", new Date(), 4, 2000);
//		Orders o13 = new Orders(13, 1, "user13@example.com", new Date(), 2, 1000);
//		Orders o14 = new Orders(14, 4, "user14@example.com", new Date(), 3, 1000);
//		Orders o15 = new Orders(15, 1, "user15@example.com", new Date(), 6, 4000);
//		Orders o16 = new Orders(16, 49, "user16@example.com", new Date(), 1, 2000);
//		Orders o17 = new Orders(17, 5, "user17@example.com", new Date(), 8, 2000);
//		Orders o18 = new Orders(18, 75, "user18@example.com", new Date(), 9, 4000);
//		Orders o19 = new Orders(19, 82, "user19@example.com", new Date(), 6, 1000);
//		Orders o20 = new Orders(20, 1, "user20@example.com", new Date(), 10, 1000);
//
//		or.save(o1);
//		or.save(o2);
//		or.save(o3);
//		or.save(o4);
//		or.save(o5);
//		or.save(o6);
//		or.save(o7);
//		or.save(o8);
//		or.save(o9);
//		or.save(o10);
//		or.save(o11);
//		or.save(o12);
//		or.save(o13);
//		or.save(o14);
//		or.save(o15);
//		or.save(o16);
//		or.save(o17);
//		or.save(o18);
//		or.save(o19);
//		or.save(o20);
//	}

	@Autowired
	OrderItemRepository oir;

//	@Test
//	void addOrderItems(){
//		OrderItem oi1 = new OrderItem(1,1,1,2);
//		OrderItem oi2 = new OrderItem(2,1,2,3);
//		OrderItem oi3 = new OrderItem(3,1,3,1);
//		OrderItem oi4 = new OrderItem(4,3,4,2);
//		OrderItem oi5 = new OrderItem(5,3,5,2);
//		OrderItem oi6 = new OrderItem(6,3,6,3);
//		OrderItem oi7 = new OrderItem(7,2,1,3);
//		OrderItem oi8 = new OrderItem(8,2,2,2);
//		OrderItem oi9 = new OrderItem(9,2,3,2);
//		OrderItem oi10 = new OrderItem(10,4,10,1);
//
//		oir.save(oi1);
//		oir.save(oi2);
//		oir.save(oi3);
//		oir.save(oi4);
//		oir.save(oi5);
//		oir.save(oi6);
//		oir.save(oi7);
//		oir.save(oi8);
//		oir.save(oi9);
//		oir.save(oi10);
//	}
}
